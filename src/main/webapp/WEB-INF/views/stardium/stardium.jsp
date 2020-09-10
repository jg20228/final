<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp"%>

 <div class="container">
 <h1>경기장 목록 페이지입니다.</h1>
 
	<table border="1" class="table">
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>개장일</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="stardium" items="${stardiums}">
				<tr class="stardium-${stardium.id}">
					<td>${stardium.no}</td>
					<td>${stardium.name}</td>
					<td><fmt:formatDate value="${stardium.createDate}" pattern="yyyy-MM-dd" /></td>
					<td><a href="/stardiumUpdateForm/${stardium.id}/${stardium.name}"><i class="fa fa-wrench"></i></a></td>
					<td><i onclick="stardiumDelete(${stardium.id},this);" class="fa fa-minus"></i></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<script src="/js/stardium.js"></script>
<%@include file="../layout/footer.jsp"%>