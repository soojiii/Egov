<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>MHDP Full Calendar</title>
<style type="text/css">
* {
  margin: 0;
  padding: 0;
  font-family: sans-serif;
  box-sizing: border-box;
}
  
body {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
}

.calendar {
  width: 600px;
  margin: 50px;
}

.header {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.year-month {
  font-size: 35px;
}

.nav {
  display: flex;
  border: 1px solid #333333;
  border-radius: 5px;
}

.nav-btn {
  width: 28px;
  height: 30px;
  border: none;
  font-size: 16px;
  line-height: 34px;
  background-color: transparent;
  cursor: pointer;
}

.go-today {
  width: 75px;
  border-left: 1px solid #333333;
  border-right: 1px solid #333333;
}

.weekData {
  display: flex;
  margin: 25px 0 10px;
}

.week {
  width: calc(100% / 7);
  text-align: center;
}

.dayData {
  display: flex;
  flex-flow: row wrap;
  height: 500px;
  border-top: 1px solid #333333;
  border-right: 1px solid #333333;
}

.day {
  width: calc(100% / 7);
  padding: 15px;
  text-align: right;
  border-bottom: 1px solid #333333;
  border-left: 1px solid #333333;
}

.dayData:nth-child(7n + 1),
.day:nth-child(7n + 1) {
  color: #D13E3E;
}

.dayData:nth-child(7n),
.day:nth-child(7n) {
  color: #396EE2;
}
.other {
  opacity: .3;
}
.today {
  position: relative;
  color: #FFFFFF;
}

.today::before {
  position: absolute;
  top: 50%;
  left: 50%;
  z-index: -1;
  display: block;
  width: 30px;
  height: 30px;
  background-color: #FF0000;
  border-radius: 50%;
  transform: translate(-50%, -50%);
  content: '';
}

</style>
</head>
<body>
    <div class="calendar">
        <div class="header">
            <div class="year-month"></div>
            <div class="nav">
                <button class="nav-btn go-prev">&lt;</button>
                <button class="nav-btn go-today" id="todayBtn"></button>
                <button class="nav-btn go-next">&gt;</button>
            </div>
        </div>
		<div>
			<input type="number" name="yearData" id="yearData">
	        <select name="monthData" id="monthData">
				<option value="01">1월</option>
				<option value="02">2월</option>
				<option value="03">3월</option>
				<option value="04">4월</option>
				<option value="05">5월</option>
				<option value="06">6월</option>
				<option value="07">7월</option>
				<option value="08">8월</option>
				<option value="09">9월</option>
				<option value="10">10월</option>
				<option value="11">11월</option>
				<option value="12">12월</option>
			</select>
	        <select name="localeData" id="localeData">
			</select>
	        <select name="tzoneData" id="tzoneData">
			</select>
        </div>
        <div class="main">
            <div class="weekData">
                <div class="week">일</div>
                <div class="week">월</div>
                <div class="week">화</div>
                <div class="week">수</div>
                <div class="week">목</div>
                <div class="week">금</div>
                <div class="week">토</div>
            </div>
            <div class="dayData">
            	<%for(int i=0; i<42; i++){%>
            	<div class="day"><span class="myspan"></span></div>
            	<%}%>
            	
            </div>
        </div>
    </div>
<script type="text/javascript">
	
	//날짜 값이 저장되는 공간
	let now = new Date();
	let year = now.getFullYear();
	let month = now.getMonth()+1;
	let timezone = "UTC+9";
	
	document.getElementById('yearData').value = year;
	let monthSelectElement = document.getElementById('monthData');
	monthSelectElement.options[month-1].selected = true;
	
	
	const params = "year="+year+"&month="+month+"&tzone="+timezone;
	let url = "<%=request.getContextPath()%>/day.do";
	let options = {
		method : "post",
		headers : {"Content-type":"application/x-www-form-urlencoded"},
		body : params
	};
	fetch(url,options)
		.then(resp=>{
			if(resp.ok){
				return resp.json()
			}else{
				throw new Error(`요청 처리 실패, 상태코드 : ${resp.status}`)
			}
		}).then(obj=>{
			insertDay(obj.today,obj.week,obj.lastDay,obj.exLastDay);
			todayBtn.innerText = year+"."+month
			
		})  
		.catch(err=>console.log(err))
	
	
	let prevBtn = document.getElementsByClassName("go-prev");
	let nextBtn = document.getElementsByClassName("go-next");
	
	prevBtn[0].addEventListener('click', (event) => {
		let yearValue = document.getElementById('yearData').value;
		let monthSelectElement = document.getElementById('monthData');
		let monthValue = monthSelectElement.options[monthSelectElement.selectedIndex].value;
		
		if(parseInt(monthValue)==1){
			document.getElementById('yearData').value = parseInt(yearValue) -1;
			monthSelectElement.options[parseInt(monthValue)-1].selected = false;
			monthSelectElement.options[11].selected = true;
		}else{
			monthSelectElement.options[parseInt(monthValue)-1].selected = false;
			monthSelectElement.options[parseInt(monthValue)-2].selected = true;
		}
		requestNewCalendar();
	});

	nextBtn[0].addEventListener('click', (event) => {
		let yearValue = document.getElementById('yearData').value;
		let monthSelectElement = document.getElementById('monthData');
		let monthValue = monthSelectElement.options[monthSelectElement.selectedIndex].value;
		
		if(parseInt(monthValue)==12){
			document.getElementById('yearData').value = parseInt(yearValue) +1;
			monthSelectElement.options[parseInt(monthValue)-1].selected = false;
			monthSelectElement.options[0].selected = true;
		}else{
			monthSelectElement.options[parseInt(monthValue)-1].selected = false;
			monthSelectElement.options[parseInt(monthValue)].selected = true;
		}
		requestNewCalendar();
	});
	
	function insertToday(today,result){
		let yearValue = document.getElementById('yearData').value;
		let monthSelectElement = document.getElementById('monthData');
		let monthValue = monthSelectElement.options[monthSelectElement.selectedIndex].value;
		if(today.startsWith(yearValue+"-"+monthValue)){
			let myspan = document.querySelectorAll('.myspan');
			myspan[parseInt(today.slice(-2))+result-1].classList.add('today');
		}
	}
	
	
	//날짜
	function insertDay(today,week,lastDay,exLastDay){
		let myspan = document.querySelectorAll('.myspan');
		for(let i=0; i<myspan.length;i++){
			myspan[i].innerText = "";
			myspan[i].classList.remove('other');
			myspan[i].classList.remove('today');
			
		}
		let result = 0;
		switch (week) {
	    case "SUNDAY":
	    	result = 0;
	    	break;
	    case "MONDAY":
	    	result = 1;
	    	break;
	    case "TUESDAY":
	    	result = 2;
	    	break;
	    case "WEDNESDAY":
	    	result = 3;
	    	break;
	    case "THURSDAY":
	    	result = 4;
	    	break;
	    case "FRIDAY":
	    	result = 5;
	    	break;
	    case "SATURDAY":
	    	result = 6;
	    	break;
	    default:
	    	result = -1; // 일요일부터 토요일까지 아닌 경우
	  }
		
		for(let i=0; i<lastDay; i++){
			myspan[result+i].innerText = i+1 ;
		}
		
		for(let i=0; i<result; i++ ){
			myspan[i].innerText = exLastDay-result+i+1;
			myspan[i].classList.add('other');
			
		}
		
		for(let i=0; i<42-lastDay-result; i++ ){
			myspan[lastDay+result+i].innerText = i+1;
			myspan[lastDay+result+i].classList.add('other');
			
		}
		insertToday(today,result);
	}
	
	makeLacaleOption();
	makeTime_zoneOption();
	
	
	
	//input태그에서 엔터키 입력시 이벤트 발생 코드 추가
	document.getElementById('yearData').addEventListener('keydown', (event) => {
		  if (event.keyCode === 13) {
			  requestNewCalendar();
		  }
		});
	
	//select가 변경시 발생하는 이벤트 추가
	const selectElements = document.querySelectorAll('select[name="monthData"], select[name="tzoneData"]');
    for (const selectElement of selectElements) {
      selectElement.addEventListener('change', requestNewCalendar);
    }
	
  	//서블릿으로 파라미터를 가져가서 새로운 달력을 요청하는 함수
	function requestNewCalendar(){
		let yearValue = document.getElementById('yearData').value;
		if(yearValue==null || yearValue=="") {
			alert("올바른 년도값을 입력해주세요");
			return;
		}else if(yearValue<1000 || yearValue>9999){
			alert("네자리수의 년도값을 입력해주세요");
			return;
		}
		
		let monthSelectElement = document.getElementById('monthData');
		let monthValue = monthSelectElement.options[monthSelectElement.selectedIndex].value;

		let timezoneSelectElement = document.getElementById('tzoneData');
		let timezoneValue = timezoneSelectElement.options[timezoneSelectElement.selectedIndex].value;
		
		const params = "year="+yearValue+"&month="+monthValue+"&tzone="+timezoneValue;
		
		let url = "<%=request.getContextPath()%>/day.do";
		
		let options = {
			method : "post",
			headers : {"Content-type":"application/x-www-form-urlencoded"},
			body : params
		};
		
		fetch(url,options)
			.then(resp=>{
				if(resp.ok){
					return resp.json()
				}else{
					throw new Error(`요청 처리 실패, 상태코드 : ${resp.status}`)
				}
			}).then(obj=>{
				insertDay(obj.today,obj.week,obj.lastDay,obj.exLastDay);
				todayBtn.innerText = yearValue+"."+monthValue
				
				
			})  
			.catch(err=>console.log(err))
		
		
	}
    
    
	//나라 옵션태그 추가하기
	function makeLacaleOption(){
    	fetch("<%=request.getContextPath()%>/nationList.do")
		.then(resp=>{
			if(resp.ok){
				return resp.text();
			}else{
				throw new Error(`에러 발생, 상태코드 ${resp.status}`);
			}
		}).then(html=>{
			localeData.innerHTML= localeData.innerHTML+html;
		})
		.catch(err=>console.log(err));
    }
    

	//타임존 옵션태그 추가하기
	function makeTime_zoneOption(){
    	fetch("<%=request.getContextPath()%>/tzone.do")
		.then(resp=>{
			if(resp.ok){
				return resp.text();
			}else{
				throw new Error(`에러 발생, 상태코드 ${resp.status}`);
			}
		}).then(html=>{
			tzoneData.innerHTML= tzoneData.innerHTML+html;
		})
		.catch(err=>console.log(err));
    }
	
	
	//나라별 언어로 요일정보 가져와서 추가하기
	const selectElement = document.getElementById("localeData");
	selectElement.addEventListener("change", (event) => {
	  const selectedValue = event.target.value;
	  let arr = selectedValue.split(",");
	  let week = document.getElementsByClassName("week");
	  for(let i=0; i<week.length; i++){
		  week[i].innerText = arr[i];
	  }
	 
});
</script>

</body>
</html>