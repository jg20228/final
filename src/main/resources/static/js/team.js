
function teamSave(){
	let data = $("#frm").serialize();
	console.log(data);
	$.ajax({
		type: "POST",
		url: "/team",
		data: data,
		contentType: "application/x-www-form-urlencoded; charset=utf-8",
		dataType: "text"
	}).done(function(resp){
		console.log(resp);
		alert("성공");
		$("input[name=name]").val("");
	}).fail(function(error){
		console.log(error);
		alert("실패");
	});
}

function teamUpdate(){
	let data = $("#frm").serialize();
	console.log(data);
	
	$.ajax({
		type: "PUT",
		url: "/team",
		data: data,
		contentType: "application/x-www-form-urlencoded; charset=utf-8",
		dataType: "text"
	}).done(function(resp){
		console.log(resp);
		alert("성공");
		location.href="/team";
	}).fail(function(error){
		console.log(error);
		alert("실패");
	});
}

function teamDelete(id,obj){
	//해당 행 삭제
	var tr = $(obj).parent().parent();
	
	let data = {
			id : id
	}
	console.log(data);
	$.ajax({
		type: "DELETE",
		url: "/team",
		data: data,
		contentType: "application/x-www-form-urlencoded; charset=utf-8",
	       // enctype: 'multipart/form-data',// body데이터가 어떤 타입인지(MIME)
		dataType: "text" // 요청을 서버로해서 응답이 왔을 때 기본적으로 모든 것이 문자열 (생긴게
							// json이라면) => javascript오브젝트로 변경
	}).done(function(resp){
		console.log(resp);
		tr.remove();
		alert("성공");
	}).fail(function(error){
		console.log(error);
		alert("실패");
	});
}