<!doctype html>
<html>
<head>
<base href="${pageContext.request.contextPath }/" />
<title>글삭제</title>
</head>
<body>
<%@ include file="/WEB-INF/jsp/header.jsp"%>
	<p> ${param.title}글</p>
	<p> 해당 글을 삭제했습니다.</p>
	<p>
		<a href="./app/article/articles">[글 목록 이동]</a>
	</p>
</body>
</html>