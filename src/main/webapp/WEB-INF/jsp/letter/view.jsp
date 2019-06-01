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
<td>편지번호</td><td> ${letter.letterId}
</td>
</tr>
<tr>
<td>편지제목 </td><td> ${letter.title}
</td>
</tr>
<tr>
<td>보낸이 </td><td> ${letter.senderName}
</td>
</tr>
<tr>
<td>받은이 </td><td> ${letter.receiverName}
</td>
</tr>
<tr>
<td>내용 </td><td> ${letter.contentHtml}
</td>
</tr>
<tr>
<td>작설일자 </td><td> ${letter.cdate}
</td>
</tr>
</table>
<a href="./app/members">회원목록</a>
<a href="./app/letter/delete?letterId=${letter.letterId}"onclick="return confirmDelete();">편지삭제</a>
<input type="hidden" name="mode" value="${param.mode}" />
</body>
</html>

