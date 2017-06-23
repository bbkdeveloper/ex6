<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
<title>Insert title here</title>
<script type="text/javascript">
	$(function() {
		
		
		$("#preview").click(function() {
			alert("preview");
			location.href="${board}List?curPage=${listInfo.startNum-listInfo.perBlock}&search=${listInfo.search}&find=${listInfo.find}";
		});
		$(".num").click(function() {
			
			//form을 사용하는 방법
			/* document.frm.curPage.value=$(this).attr("id");
			document.frm.search.value='${listInfo.search}';
			document.frm.find.value='${listInfo.find}';
			document.frm.submit; */
			//
			
			//location을 이용하는 방법
			 var num = $(this).prop("id");
			alert(num);
			location.href="${board}List?curPage="+num+"&search=${listInfo.search}&find=${listInfo.find}"; 
		});
		$("#nextview").click(function() {
			alert("nextview")
			location.href="${board}List?curPage=${listInfo.lastNum+1}&search=${listInfo.search}&find=${listInfo.find}";
		});
	});

</script>
<style type="text/css">
	span{
	cursor: pointer;
	}
</style>

</head>
<body>
<!-- LIST 제목 -->
<h2>${board}</h2>

<div style="margin: 0 auto;">
	<form action="${board}List" name="frm">
	<input type="hidden" name="curPage"> 
		<select name="search">
			<option value="title">TITLE</option>
			<option value="writer">WRITER</option>
			<option value="contents">CONTENTS</option>
		</select>
		<input type="text" name="find">
		<input type="submit" value="SEARCH">
	</form>
</div>

<div class="container">
	  <table class="table table-striped">
		<tr><td>num</td><td>writer</td><td>title</td><td>reg_date</td><td>hit</td></tr>
		
		<c:forEach items="${list}" var="dto" >
			<tr><td>${dto.num}</td><td>${dto.writer}</td>
			<c:catch>
			<c:forEach begin="1" end="${dto.depth }">--</c:forEach>
			</c:catch>
			<td><a href="noticeView?num=${dto.num}"> ${dto.title}</a> </td><td>${dto.reg_date}</td><td>${dto.hit}</td></tr>
		</c:forEach>
	</table>
	
	<c:if test="${listInfo.curBlock>1 }">
		<span id="preview">[이전]</span>
		<%-- <a href="${board}List?curPage=${listInfo.startNum-listInfo.perBlock}&search=${listInfo.search}&find=${listInfo.find}">[이전]</a> --%>
	</c:if>
	
	<c:forEach begin="${listInfo.startNum}" end="${listInfo.lastNum}" var="i">
		<span class="num" id="${i}" >${i}</span>
		<%-- <a href="${board}List?curPage=${i}&search=${listInfo.search}&find=${listInfo.find}">${i}</a> --%>		
	</c:forEach>
	
	<c:if test="${listInfo.curBlock<listInfo.totalBlock }">
		<span id="nextview">[다음]</span>
		<%-- <a href="${board}List?curPage=${listInfo.lastNum+1}&search=${listInfo.search}&find=${listInfo.find}">[다음]</a> --%>
	</c:if>
	
<a href="${board}Write" class="btn btn-default" style="margin: 0 auto;">NoticeWrite</a>

<div>
	<p>curPage : ${listInfo.curPage }</p>
	<p>search : ${listInfo.search}</p>
	<p>find : ${listInfo.find }</p>
</div>

</div>


</body>
</html>