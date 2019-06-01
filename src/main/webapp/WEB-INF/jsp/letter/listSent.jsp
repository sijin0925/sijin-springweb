<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
<head>
<base href="${pageContext.request.contextPath }/" />
<title>게시판 목록</title>
</head>
<body>
	<%@ include file="/WEB-INF/jsp/header.jsp"%>
	<h2>게시글 목록</h2>
	<p>전체 ${totalCount }건</p>
	<form action="./app/letter/listSent">
		<input type="number" name="page" value="${param.page }" placeholder="페이지"
			min="1" max="${totalCount / 100 + 1 }" step="1" style="width: 50px;">
		<button type="submit">조회</button>
	</form>
	
	<table>
		<thead>
			<tr>
				<td>편지번호</td>
				<td>편지제목</td>
				<td>받은이</td>
				<td>등록일시</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="letter" items="${letters}">
				<tr>
					<td>${letter.letterId}</td>
					<td><a href="./app/letter/view?letterId=${letter.letterId}">${letter.title}</a></td>
					<td>${letter.receiverName}</td>
					<td>${letter.cdate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</head>
</html>