<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>

<%@ include file="/WEB-INF/subModules/bootstrapHeader.jsp" %>

<title>Insert title here</title>
</head>
<body>
<div class="container">	
   
   <script>
    $(function() {
    	$("#btn1").click(function() {
    		$.ajax({
    			url : "${appRoot}/rest09/sub01",
    			type : "post", // 포스트 방식으로 아이디 나이값 넘어감
    			data : {
    				id : "korea" //data는 client -> server
    				age : 55
    			},
    			sucess : function(data) {
    				console.log("btn1",data);  //server ->data
    			},
    			dataType : "json"
    		});
    	});
    	
    	$("#btn2").click(function() {
    		$.post({
    			url : "${appRoot}/rest09/sub01",
    			data : {
    				id : "korea" //data는 client -> server
    				age : 55
    			},
    			sucess : function(data) {
    				console.log("btn2",data);  //server ->data
    			},
    			dataType : "json"
    		});
    	})
    	
    	$("#btn3").click(function() {
    		$.post("${appRoot}/rest/sub01", {id: "korea", age:77} 
    		, function (d) {
    			console.log("btn3", d);
    		}, "json"
    	});
     })
  })
   </script>
   <button id="btn1">BTN1</button>
   <button id="btn1">BTN2</button>
   <button id="btn3">BTN3</button>
</div>
</body>
</html>


















