<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    body {
      font-family: Arial, sans-serif;
    }

    #myModal {
      display: none;
      position: fixed;
      top: 50%;
      left: 50%;
      transform: translate(-50%, -50%);
      padding: 20px;
      background-color: #fff;
      border: 1px solid #ccc;
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }

    #myModal h2 {
      margin-top: 0;
    }

    #overlay {
      display: none;
      position: fixed;
      top: 0;
      left: 0;
      width: 100%;
      height: 100%;
      background: rgba(0, 0, 0, 0.5);
    }
  </style>
</head>
<body>
<html>
    <body>
        <ul id="idUl">
        </ul>
        
        <div id="myModal">
          <div id="pl"></div>
 		  <button onclick="closeModal()">닫기</button>
		</div>
        
        <script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/app/04/PeopleList.js"></script>
    </body>
</html>

</body>
</html>

