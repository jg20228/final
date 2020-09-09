<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../layout/header.jsp"%>
<div class="container">
<h1>팀 수정 페이지입니다.</h1>
</div>
<form id="frm">
<input type="text" name="id" value="${respDto.teamRespDto.id}"/>

현재 야구장 : <input type="text" value="${respDto.teamRespDto.stadiumName}"/>

<input type="text" name="createDate" value="${respDto.teamRespDto.createDate}"/>

<hr/>
<select name="stadiumId">
	<c:forEach var="stardium" items="${respDto.stadiums}">
		<option value="${stardium.id}">${stardium.name}</option>
	</c:forEach>
</select>

팀 이름 : <input type="text" name="name" value="${respDto.teamRespDto.teamName}"/>

<button type="button" onclick="teamUpdate()">수정</button>
</form>


<script src="/js/team.js"></script>
<%@include file="../layout/footer.jsp"%>