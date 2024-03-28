/**
 * 
 */
document.addEventListener("DOMContentLoaded", ()=>{
	fetch("", {
		headers:{
			accept : "application/json"
		}
	}).then(resp=>resp.json())
	.then(({headers,propsName,resultList})=>{
		console.log(headers,propsName,resultList);
		let trTag = `<tr>${headers.map(cn=>`<th>${cn }</th>`).join("")}</tr>`
		window['head-area'].innerHTML = trTag;
		let trTags = "";
		for(let propsMap of resultList){
			trTags += `<tr>${propsName.map(pn=>`<td>${propsMap[pn] }</td>`).join("")}</tr>`;
		}
		window['data-area'].innerHTML = trTags;
	})
	.catch(err=>console.error(err));
});


/*		let trTag =`<tr>`;
		for(let colName of headers){
			trTag =+ `<th>${colName }</th>`
		}
		trTag += "</tr>";*/
		
		
		/*<c:forEach items="${headers }" var="colName">
			<th>${colName }</th>
		</c:forEach>*/
		
//------------------------------------------------------------		
		
		
		
/*			trTags += "<tr>";
			for(let propName of propsName){
				trTags += `<td>${propsMap[propName] }</td>`;
			}
			trTags += "</tr>";*/		

		
/*		<c:forEach items="${resultList }" var="propsMap"> 
			<tr> 
				<c:forEach items="${propsName }" var="propName"> 
					<td>${propsMap[propName] }</td> 
 				</c:forEach> 
 			</tr> 
		</c:forEach> */