<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>ERROR</h1>
<h3>${e}</h3>
<a href="../">HOME</a>
<form action="">
<fieldset>
<legend>납품자정보</legend>
<p>1.납품자명 : <input type="text" placeholder="name"></p>
<p>2.email : <input type="email" placeholder="answs@naver.com"></p>
<p>3. 홈페이지 : <input type="url" placeholder="http://">
</fieldset>


<fieldset>
<legend>납품정보</legend>
<ul>
<li>상품명 : <input list="productName" name="productName">
        <datalist id="productName">
       <option value="dog1004" label="도그1004">
       <option value="catchicken" label="고양이치킨">
       <option value="milk" label="우유">
        </datalist>
		</li>
<li>납품수량 : <input type="number" placeholder="최소 10이상" min="10" max="100" step="10"></li>
<li>납품등급 : <input type="range" min="0" max="10" step="2"></li>
<li>기타사항 : <textarea rows="" cols=""></textarea></li>
</ul>
</fieldset>
<input type="button" value="send message">
</form>
</body>
</html>