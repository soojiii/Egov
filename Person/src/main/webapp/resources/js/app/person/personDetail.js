/**
 * 
 */
const cPath = document.body.dataset.contextPath;
function clickHandler(event){
	let aTag = event.target.dataset.personId;
	fetch(`${cPath}/person/personDetail.do`,{
		method : 'post',
		headers: {
  	  		"Content-Type": "application/x-www-form-urlencoded",
  		},
		body : "who="+aTag
	})
	.then((resp)=>{
		if(resp.ok){
			return resp.text();
		}else{
			throw new Error("처리 실패");
		}
	}).then((text)=>{
		dright.innerHTML=text;
	}).catch((err)=>console.log(err));
}

