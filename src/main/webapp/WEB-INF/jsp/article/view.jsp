<!doctype html>
<html> 
<head> 
<base href="${pageContext.request.contextPath }/" /> 
<title>조회</title> 
</head> 
<body> 
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

</table>
</body> 
</head> 
</html>
