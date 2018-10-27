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

	//2�ܰ�,��û �ľ�
	//request ��ü�κ��� ����� ��û�� �ľ��ϴ� �ڵ� - ����Ÿ������ ����
String type = request.getParameter("type");


Object resultObject = null;
if(type==null||type.equals("greeting")) {
	resultObject = "����?";
}else if (type.equals("date")) {
	resultObject = new java.util.Date();
}else {
	resultObject = "Invalid Type";
}

request.setAttribute("result",resultObject);

RequestDispatcher dispatcher = request.getRequestDispatcher("s.v/simpleView.jsp"); // <= ��� �������ٶ� webcont ������κ��� �ۼ��Ѵ�!
dispatcher.forward(request,response);

}
}