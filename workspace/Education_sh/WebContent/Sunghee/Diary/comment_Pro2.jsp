<%@ page contentType = "text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.json.JSONObject"%>
<%@ page import="java.util.*"%>
<%

	System.out.println("제이슨"+request.getAttribute("result"));

	HashMap<String, Object> result = (HashMap<String, Object>)request.getAttribute("result");
	
	
	
	JSONObject jobj = new JSONObject(result);
	out.print(jobj);		
	System.out.println("본문에 보낸다."+jobj);

%>