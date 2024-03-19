/**
 * 
 */
window['bts-form'].addEventListener("submit", (e)=>{
	e.preventDefault();
	let url = e.target.action;
	let btsName = e.target.name.value;
	btsn = `${url}?name=${btsName}`;
	window['bts-area'].innerHTML = a;
	
});
