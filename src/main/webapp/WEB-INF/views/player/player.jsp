<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>

 <div class="container">
 <h1>선수 목록 페이지입니다.</h1>
	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>팀 이름</th>
				<th>포지션</th>
				<th>선수 이름</th>
				<th>등록일</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="player" items="${players}">
				<tr class="player-${player.id}">
					<td>${player.id}</td>
					<td>${player.teamName}</td>
					<td>${player.position}</td>
					<td>${player.playerName}</td>
					<td><fmt:formatDate value="${player.createDate}" pattern="yyyy-MM-dd" /></td>
					<td><a href="/playerUpdateForm/${player.id}/${player.playerName}"><i class="fa fa-wrench"></i></a></td>
					<td><i onclick="playerDelete(${player.id},this);" class="fa fa-minus"></i></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<script src="/js/player.js"></script>
<%@include file="../layout/footer.jsp"%>