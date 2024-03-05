/**
 * 
	1. 타겟 셀렉팅. $("selector"), document.getElementById, querySelector(selector)
	2. 이벤트 종류 결정. click, mouseover, dbclick...
	3. 이벤트 핸들러 구현. function(){}...
	4. 타겟에 이벤트 핸들러 바인드. on, 타겟.addEventListener(이벤트종류, 핸들러)
	
 */

//let LyricBtn = document.querySelector("#LyricBtn");
LyricBtn.addEventListener("click", (event)=>{
	let target = event.target;
	let url = "../eta";
	fetch(url)
		.then((resp)=>{
			if(resp.ok){
				return resp.text();
			}else{
				throw new Error("처리 실패");
			}
		}).then((text)=>LyricArea.innerHTML=text)
		.catch((err)=>console.log(err));
});

