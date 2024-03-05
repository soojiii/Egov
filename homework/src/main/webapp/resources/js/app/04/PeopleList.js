/**
 * 
 */
fetch("../peopleList.do")
		.then((resp)=>{
			if(resp.ok){
				return resp.text();
			}else{
				throw new Error("처리 실패");
			}
		}).then((text)=>idUl.innerHTML=text)
		.catch((err)=>console.log(err));


function pclick(event){
	let id = event.target.id;
	fetch("../people.do?id="+id)
		.then((resp)=>{
			if(resp.ok){
				return resp.text();
			}else{
				throw new Error("처리 실패");
			}
		}).then((text)=>{
			pl.innerHTML=text;
		})
		.catch((err)=>console.log(err));
	document.getElementById('myModal').style.display = 'block';
}		

function closeModal() {
    document.getElementById('myModal').style.display = 'none';
 }
		
