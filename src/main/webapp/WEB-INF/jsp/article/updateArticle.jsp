<!doctype html>
<html>
<head>
<base href="${pageContext.request.contextPath }/" />
<title>글수정</title>
</head>
<body>
<%@ include file="/WEB-INF/jsp/header.jsp"%>
	<h1>글수정</h1>
	<form action="./app/article/update?articleId=${article.articleId}" method="post">
			글제목:<br> <input type="text" name="title" value="${article.title}">
			
		<p>
			글내용:<br><textarea name="content">${article.content}</textarea>
		</p>
		<button type="submit">수정</button>
	</form>
</body>
</html>