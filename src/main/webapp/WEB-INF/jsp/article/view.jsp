<!doctype html>
<html> 
<head> 
<base href="${pageContext.request.contextPath }/" /> 
<title>조회</title> 
</head> 
<body> 
<%@ include file="/WEB-INF/jsp/header.jsp"%>
<table border="1">
<tr>
<td>글번호</td><td> ${article.articleId}
</td>
</tr>

<tr>
<td>글제목 </td><td> ${article.title}
</td>
</tr>

<tr>
<td>글쓴이 </td><td> ${article.name}
</td>
</tr>
<tr>
<td>내용 </td><td> ${article.contentHtml}
</td>
</tr>
<tr>
<td>작설일자 </td><td> ${article.cdate}
</td>
</tr>
<tr>
<td>
<a href="./app/article/articles">[글 목록 이동]</a>
</td>
<td>
<a href="./app/article/articles">[글 수정]</a>
<a href="./app/article/deleteArticle">[글 삭제]</a>
</td>
</tr>
</table>
</body> 
</head> 
</html>

