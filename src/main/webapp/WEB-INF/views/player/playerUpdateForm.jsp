<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../layout/header.jsp"%>
<div class="container">
<h1>선수 수정 페이지입니다.</h1>
</div>
<form id="frm">
<input type="hidden" name="id" value="${respDto.playerRespDto.id}"/>

현재 팀 : <input type="text" value="${respDto.playerRespDto.teamName}" readOnly/>

<input type="hidden" name="createDate" value="${respDto.playerRespDto.createDate}"/>

<hr/>
<select name="teamId">
	<c:forEach var="team" items="${respDto.teams}">
		<option value="${team.id}">${team.name}</option>
	</c:forEach>
</select>

포지션 : <input type="text" name="position" value="${respDto.playerRespDto.position}"/>
선수 이름 : <input type="text" name="name" value="${respDto.playerRespDto.playerName}"/>

<button type="button" onclick="playerUpdate()">수정</button>
</form>


<script src="/js/player.js"></script>
<%@include file="../layout/footer.jsp"%>