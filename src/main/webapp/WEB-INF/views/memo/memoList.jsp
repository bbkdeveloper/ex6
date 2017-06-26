<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="../resources/js/memo.js"></script>
<script type="text/javascript">

	$(function() {
		getList(1,"%","%");
		
		$("#btn").click(function() {
			var writer = $("#writer").val();
			var contents = $("#contents").val();
			alert(writer);
			alert(contents);
			memoWrite(writer, contents);
		});
		
		$("#btnview").click(function() {
			memoView(1);
		});
	});

</script>
</head>
<body>



<form action="">
	<p>WRITER<input type="text" id="writer"></p>
	<p>CONTENTS</p>
	<p><textarea rows="10" cols="30" id="contents"></textarea></p>
	<input type="button" id="btn" value="CLICK">
</form>

	<div id="result"></div>
	<button id="btnview">VIEW</button>
</body>
</html>