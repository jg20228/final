<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>
<div class="container">
<h1>(7)포지션별 팀의 야구 선수 페이지</h1>
	<table border="1">
		<thead>
			<tr>
				<th>포지션</th>
				<th>두산</th>
				<th>NC</th>
				<th>롯데</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="stat" items="${stats}">
				<tr>
					<td>${stat.position}</td>
					<td>${stat.doosan}</td>
					<td>${stat.nc}</td>
					<td>${stat.lotte}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<%@include file="../layout/footer.jsp"%>