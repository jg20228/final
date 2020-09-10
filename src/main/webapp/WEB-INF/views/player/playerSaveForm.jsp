<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../layout/header.jsp"%>
<div class="container">
<h1>선수 등록 페이지입니다.</h1>

<form id="frm">
팀 이름 : 
<select name=teamId>
	<c:forEach var="team" items="${teams}">
		<option value="${team.id}">${team.name}</option>
	</c:forEach>
</select>
선수 이름 : <input type="text" name="name" value=""/>
포지션 이름 : <input type="text" name="position" value=""/>
<button type="button" onclick="playerSave()">등록</button>
</form>
</div>

<script src="/js/player.js"></script>
<%@include file="../layout/footer.jsp"%>