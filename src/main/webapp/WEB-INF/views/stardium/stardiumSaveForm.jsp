<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@include file="../layout/header.jsp"%>
<div class="container">
<h1>경기장 등록 페이지입니다.</h1>

<form id="frm">
경기장 이름 : <input type="text" name="name" value=""/>
<button type="button" onclick="stardiumSave()">등록</button>
</form>
</div>

<script src="/js/stardium.js"></script>
<%@include file="../layout/footer.jsp"%>