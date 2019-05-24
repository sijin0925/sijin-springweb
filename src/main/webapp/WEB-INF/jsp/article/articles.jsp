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
	<form action="./app/article/articles">
		<input type="number" name="page" value="${param.page }" placeholder="페이지"
			min="1" max="${totalCount / 100 + 1 }" step="1" style="width: 50px;">
		<button type="submit">조회</button>
	</form>
	<a href="./app/article/AddArticle"><button type="submit">글쓰기</button></a>
	
	<table>
		<thead>
			<tr>
				<td>글번호</td>
				<td>글이름</td>
				<td>이름</td>
				<td>등록일시</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="article" items="${articles}">
				<tr>
					<td>${article.articleId}</td>
					<td><a href="./app/article/view?articleId=${article.articleId}">${article.title}</a></td>
					<td>${article.name}</td>
					<td>${article.cdate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</head>
</html>