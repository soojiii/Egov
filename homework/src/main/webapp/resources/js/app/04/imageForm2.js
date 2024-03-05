/**
 * 폼을 전송할때 페이지가 전환되는 걸 중단하고,
선택한 이미지를 페이지의 하단에 (body append구조)에 출력.
1. submit 이벤트 중단
2. 선택한 option value 확보
3. 새로운 img 태그 생성
4. img 태그의 src 속성을 선택한 이미지로 대체.
5. body 에 new img 를 추가(append)
 */


let btn = document.querySelector("#btn");
btn.addEventListener("click", (event)=>{
	let selectElement = document.getElementById("mySelect");
	let selectedValue = selectElement.value;
	let url = "../image.do?name="+selectedValue;
	fetch(url)
		.then((resp)=>{
			if(resp.ok){
				return resp.blob();
			}else{
				throw new Error("처리 실패");
			}
		}).then((imageBlob)=>{
			let imageUrl = URL.createObjectURL(imageBlob);
            dimage.innerHTML = `<img src="${imageUrl}" alt="Fetched Image">`;
		})
		.catch((err)=>console.log(err));
});