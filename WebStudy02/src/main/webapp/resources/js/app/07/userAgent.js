/**
 * 
 */
window['ua-btn'].addEventListener("click", (e)=>{
	let agent = window.navigator.userAgent;
	const BrowserInfo = {
		EDG:"엣지",
   		CHROME:"크롬",
    	WHALE:"웨일",
    	OTHERS:"기타",
		findBrowserName:function(agent){
			agent = agent.toUpperCase();
			let browserName = this.OTHERS;
			for(let prop in this){
				if(agent.indexOf(prop)>=0){
					browserName = this[prop];
					break;
				}
			}
			return browserName;
		}
	}
	BrowserInfo['SAFARI'] = "사파리";
	
	let brName = BrowserInfo.findBrowserName(agent);
	msgArea.innerHTML = brName;
});


/*document.querySelectorAll("a.asyncA");*/
document.addEventListener("click", (e)=>{
	if(!e.target.classList.contains("asyncA")) return false;
	e.preventDefault();
	let aTag = e.target;
	let url = aTag.href;
	/*let method = aTag.dataset.method ? aTag.gataset.method : "get";*/
	let method = aTag.dataset.method ?? "get";   /* method값 있으면 method값 없으면 "get"*/
	let headers = {
		"accept" : "text/html"
	}
	let options = {
		method : method,
		headers:headers
	}
	
	fetch(url, options)
		.then(resp=>{
			if(resp.ok){
				return resp.text();
			}else{
				throw new Error(`처리 실패 상태코드 : ${resp.status}`);
			}		
		}).then(html=>{
			 msgArea.innerHTML = html;
		})
		.catch()
})



/*let aTag = document.querySelector("a");
console.log(aTag);
aTag.addEventListener("click", e=>{
		e.preventDefault();
		let url = e.target.href;
		let options = {
			 method : "post",
		};
		fetch(url, options)
			.then(resp=>{
				if(resp.ok){
					return resp.text();
				}else{
					throw new Error(`요청 처리 실패, 상태코드 : ${resp.status}`);
				}
			}).then(obj=>console.log(obj))
			.catch(err=>console.log(err));
});*/

/*btn.addEventListener("click", (e)=>{
	let agent = window.navigator.userAgent.toUpperCase();
	let browserName = "";
		if(agent.includes("EDG")) {
			browserName ="엣지";
		}else if(agent.includes("WHALE")) {
			browserName ="웨일";
		}else if(agent.includes("CHROME")) {
			browserName ="크롬";
		}else if(agent.includes("SAFARI")) {
			browserName ="사파리";
		}else {
			browserName ="기타";
		}		
		msgArea.innerHTML = `당신의 브라우저는 ${browserName}입니다.`
})*/


