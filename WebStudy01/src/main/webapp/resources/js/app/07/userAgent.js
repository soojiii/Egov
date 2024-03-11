/**
 * 
 */
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