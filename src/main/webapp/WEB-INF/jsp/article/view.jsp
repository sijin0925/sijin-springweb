<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html> 
<head> 
<base href="${pageContext.request.contextPath }/" /> 
<title>조회</title> 
<script type="text/javascript">
	function confirmDelete() {
		if (confirm("삭제하시겠습니까?"))
			return true;
		else
			return false;
	}
</script>
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
<a href="./app/article/articles">글목록</a>
<c:if test="${article.userId == sessionScope.MEMBER.memberId }">
			<a href="./app/article/updateArticle?articleId=${article.articleId}">글수정</a>
			<a href="./app/article/deleteArticle?articleId=${article.articleId}"onclick="return confirmDelete();">글삭제</a>
</c:if>
</body>
</html>

