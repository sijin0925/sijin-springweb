<!doctype html>
<html>
<head>
<base href="${pageContext.request.contextPath }/" />
<title>글쓰기</title>
</head>
<body>
<%@ include file="/WEB-INF/jsp/header.jsp"%>
	<h1>글쓰기</h1>
	<form action="./app/article/EndAddAticle" method="post">
			글제목:<br> <input type="text" name="title" value="${param.title }">
			
		<p>
			글내용:<br><textarea name="content"></textarea>
		</p>
		<button type="submit">등록</button>
	</form>
</body>
</html>