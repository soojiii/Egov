<%@page import="java.io.FilenameFilter"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
	<head>
		<style type="text/css">
			form{
				background-color : yellow;
			}
		</style>
	</head>
    <body>
    	<%
    	File folder = new File("F:/00.medias/images");
		String[] fileList = folder.list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				String mime = application.getMimeType(name);
				return mime!=null && mime.startsWith("image/");
			}
		});
		StringBuffer options = new StringBuffer("");
		String optptrn = "\n<option>%s</option>";
		for(String name : fileList) {
			options.append(String.format(optptrn,name));
		}
		String cPath = request.getContextPath();
   		 %>
            <select id="mySelect" name="name">
            <%=options %>
            </select>
            <button type="button" id="btn">이미지 랜더링</button>
           <div id="dimage"></div>
        <script type="text/javascript" src="<%=cPath %>/resources/js/app/04/imageForm2.js"></script>
    </body>
</html>
