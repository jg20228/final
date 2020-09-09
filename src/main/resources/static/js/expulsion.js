function expulsionSave(){
	let data = $("#frm").serialize();
	console.log(data);
	$.ajax({
		type: "POST",
		url: "/expulsion",
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

function changeTeam(id){
	$.ajax({
		type: "GET",
		url: "/expulsion/"+id,
		contentType: "application/json; charset=utf-8",
		dataType: "json"
	}).done(function(resp){
		console.log(resp.data.expulsionDtos);
		$("#team__list").empty();
		renderTeamList(resp.data.expulsionDtos);
	}).fail(function(error){
		console.log(error);
		alert("실패");
	});
}

function renderTeamList(teams){
	var sum = 0;
	for(var team of teams){
		sum++;
		$("#team__list").append(makeTeamItem(team,sum));
	}
}
function makeTeamItem(team,sum){
	var item = `<tr class="dto-${team.id}">`;
	item += "<td>"+sum+"</td>";
	item += `<td>${team.teamName}</td>`;
	item += `<td>${team.position}</td>`;
	item += `<td>${team.playerName}</td>`;
	item += `<td>${team.reason}</td>`;
	item += `<td>${team.createDate}</td>`;
	item += `</tr>`;
	return item;
}