package mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleController extends HttpServlet{

public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
processRequest(request,response);

}

public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
processRequest(request,response);
}

private void processRequest(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{

	//2단계,요청 파악
	//request 객체로부터 사용자 요청을 파악하는 코드 - 무슨타입인지 받음
String type = request.getParameter("type");


Object resultObject = null;
if(type==null||type.equals("greeting")) {
	resultObject = "ㅎㅇ?";
}else if (type.equals("date")) {
	resultObject = new java.util.Date();
}else {
	resultObject = "Invalid Type";
}

request.setAttribute("result",resultObject);

RequestDispatcher dispatcher = request.getRequestDispatcher("s.v/simpleView.jsp"); // <= 경로 지정해줄때 webcont 다음경로부터 작성한다!
dispatcher.forward(request,response);

}
}