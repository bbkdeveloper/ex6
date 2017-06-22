<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="fileUpload" method="post" enctype="multipart/form-data">
		<input type="text" name="name">
		<input type="file" name="f1">
		<button>UPLOAD</button>
	</form>
	
	
	<form action="multiFileUpload" method="post" enctype="multipart/form-data">
		<input type="text" name="name">
		<input type="file" name="f1">
		<input type="file" name="f2">
		<button>UPLOAD</button>
	</form>


	<form action="sameMultiFileUpload" method="post" enctype="multipart/form-data">
		<input type="text" name="name">
		<input type="file" name="f1">
		<input type="file" name="f1">
		<button>UPLOAD</button>
	</form>
</body>
</html>