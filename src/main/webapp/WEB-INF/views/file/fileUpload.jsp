<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>Insert title here</title>

<script type="text/javascript">
	$(function() {
			
		var count=0;
		var data='';
		
		$("#add").click(function() {
			count++;
			if(count<6){
				data = '<p><input type="file" name="f1"><span class="sp">X</span> </p>';
				$("#file").append(data);
			}else{
				alert("5개가 최대");
			}
		});
			
		
		
	});
	
	</script>
	
	<style type="text/css">
	span{
		color: red;
		cursor: pointer;
	}
	</style>

</head>
<body>


	<h2>단일 파일 업로드</h2>
	<!-- ****************************단일 파일 업로드**************************** -->
	<form action="fileUpload" method="post" enctype="multipart/form-data">
		<input type="text" name="name">
		<input type="file" name="f1">
		<button>UPLOAD</button>
	</form>
	
	<h2>다중 파일 업로드 - 파라미터이름이 다름</h2>
	<!-- ****************************다중 파일 업로드 - 파라미터 이름이 다를 때**************************** -->
	<form action="multiFileUpload" method="post" enctype="multipart/form-data">
		<input type="text" name="name">
		<input type="file" name="f1">
		<input type="file" name="f2">
		<button>UPLOAD</button>
	</form>


	<h2>다중 파일 업로드 - 파라미터이름이 같음</h2>
	<!-- ****************************다중 파일 업로드 - 파라미터 이름이 같을 때**************************** -->
	<form action="sameMultiFileUpload" method="post" enctype="multipart/form-data">
		<input type="text" name="name">
		<input type="file" name="f1">
		<input type="file" name="f1">
		<button>UPLOAD</button>
	</form>
	
	
	<h2>name은 같고 갯수를 모를 때</h2>
	<form action="upload" method="post" enctype="multipart/form-data">
		<input type="text" name="name">
		<div id="file">
		
		</div>
		<input type="button" id="add" value="FILE ADD">
		<button>UPLOAD</button>
	</form>
	
	

</body>
</html>