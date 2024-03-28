/**
 * 
 */
let forms = document.forms;
forms[0].addEventListener("submit", e=>{
	e.preventDefault();
	
/*	setTimeout(function(){*/
		let opl = paramoperator();
		let calculateEnum = "";
		if(opl.includes("PLUS")) {
			calculateEnum = "+";
		}else if(opl.includes("MINUS")) {
			calculateEnum ="-";
		}else if(opl.includes("MULTIPLY")) {
			calculateEnum ="*";
		}else if(opl.includes("DIVIDE")) {
			calculateEnum ="/";
		}
		
		resultArea.innerHTML = calculateEnum;
		
/*	},2000);*/
	
	
/*	let form = e.target;
	let url = form.action;
	let method = aTag.dataset.method ?? "get";
	let headers = {
		"addept" : "text/html"
	};
	let options = {
		method : method,
		headers : headers
	}
	fetch(url, options)
		.then(resp=>{
			if(resp.ok){
				return resp.text();
			}else{
				throw new Error(`에러 발생, 상태코드 : ${resp.status}`);
			}
		}).then(html=>{
			resultArea.innerHTML = html; 
		})
		.catch();*/
});
	
	
	
	