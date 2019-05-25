<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
</table>
<a href="./app/article/articles"><button type="submit">글목록</button></a>
<a href="./app/article/updateArticle?articleId=${article.articleId}"><button type="submit">글수정</button></a>
<a href="./app/article/deleteArticle?articleId=${article.articleId}"><button type="submit">글삭제</button></a>
</body> 
</head> 
</html>

