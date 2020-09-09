function stardiumSave(){
	$("#name").val("");
	
	let data = $("#frm").serialize();
	alert(data);
	
	console.log(data);
	$.ajax({
		type: "POST",
		url: "/stardium",
		data: data,
		contentType: "application/x-www-form-urlencoded; charset=utf-8",
	       // enctype: 'multipart/form-data',// body데이터가 어떤 타입인지(MIME)
		dataType: "text" // 요청을 서버로해서 응답이 왔을 때 기본적으로 모든 것이 문자열 (생긴게
							// json이라면) => javascript오브젝트로 변경
	}).done(function(resp){
		console.log(resp);
		alert("성공");
	}).fail(function(error){
		console.log(error);
		alert("실패");
	});
}