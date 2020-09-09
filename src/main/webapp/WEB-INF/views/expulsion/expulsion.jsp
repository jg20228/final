<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>

 <div class="container">
 <h1>퇴출 선수 목록 페이지입니다.</h1>
 <c:forEach var="team" items="${respDto.teams}">
 	<button onclick="changeTeam(${team.id})">${team.name}</button>
</c:forEach>
<br/>
	<table border="1" class="table">
		<thead>
			<tr>
				<th>번호</th>
				<th>팀 이름</th>
				<th>포지션</th>
				<th>선수 이름</th>
				<th>사유</th>
				<th>퇴출일</th>
			</tr>
		</thead>
		<tbody id="team__list">
			<c:set var="su" value="0"/>
			<c:forEach var="dto" items="${respDto.expulsionDtos}">
				<tr class="dto-${dto.id}">
					<c:set var ="sum" value="${sum+1}"/>
					<td>${sum}</td>
					<td>${dto.teamName}</td>
					<td>${dto.position}</td>
					<td>${dto.playerName}</td>
					<td>${dto.reason}</td>
					<td><fmt:formatDate value="${player.createDate}" pattern="yyyy-MM-dd" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<script src="/js/expulsion.js"></script>
<%@include file="../layout/footer.jsp"%>