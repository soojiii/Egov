/**
 * 
 */
/*document.addEventListener("DOMContentLoaded")*/
/*$(document).ready(function(){})*/
const cPath = document.body.dataset.contextPath;
$(function(){
/*	document.querySelectorAll("tr[data-mem-id]")
	document.addEventListener("click", function(){})*/
	/*1번방법: $("tr[data-mem-id]").on("click", function(){});*/
	
// /*2번방법(강추!):*/$(document).on("click", "tr[data-mem-id]", function(){
		/*this.dataset.memId*/
		/*this.dataset.newKey="value";
		$(this).data("newKey", {});*/
	const $modal = $("#exampleModal").on("show.bs.modal", function(event){
		let tr = event.relatedTarget;
		let memId = $(tr).data("memId");
		let url = `${cPath}/member/memberDetail.do`;
		let method = "get";
		$.ajax({
			url : url,
			method : method,
			dataType : "json",
			data : {
				who:memId
			}, success:function({member}, status, jqXHR){
				console.log(member?.memId);
				$modal.find("td[id]").each(function(index, td){
					let propName =  td.id;
					td.innerHTML = member[propName];
				});
			}, error:function(jqXHR, status, errorText){
				console.log(jqXHR, status, errorText);
			}
		});
	}).on("hidden.bs.modal", function(){
		$modal.find("td[id]").html("");
	})
	
});