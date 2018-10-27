package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.CommandAction;
import action.NullAction;

public class ControllerUsingURI2 extends HttpServlet {
  
    private Map commandMap = new HashMap();//명령어와 명령어 처리 클래스를 쌍으로 저장
    
    //명령어와 처리클래스가 매핑되어 있는 properties 파일을 읽어서 Map객체인 commandMap에 저장
    //명령어와 처리클래스가 매핑되어 있는 properties 파일은 Command.properties파일
    
    public void init(ServletConfig config) throws ServletException {
    	System.out.println("ControllerUsingURI2 init() 들어옴");
        String props = config.getInitParameter("configFile2");//web.xml에서 propertyConfig에 해당하는 init-param 의 값을 읽어옴
        //props = "WEB-INF/commandHandlerURI.properties"
        Properties pr = new Properties();//명령어와 처리클래스의 매핑정보를 저장할 Properties객체 생성
        FileInputStream f = null;
        try {
            String configFilePath = config.getServletContext().getRealPath(props);	
            System.out.println(configFilePath);
            f = new FileInputStream(configFilePath); //Command.properties파일의 내용을 읽어옴
            pr.load(f);//Command.properties파일의 정보를  Properties객체에 저장
        } catch (IOException e) {
            throw new ServletException(e);
        } finally {
            if (f != null) try { f.close(); } catch(IOException ex) {}
        }
        Iterator keyIter = pr.keySet().iterator();//Iterator객체는 Enumeration객체를 확장시킨 개념의 객체
        while( keyIter.hasNext() ) {//객체를 하나씩 꺼내서 그 객체명으로 Properties객체에 저장된 객체에 접근
            String command = (String)keyIter.next();
            System.out.println(command);
            String className = pr.getProperty(command);
            System.out.println(className+"입니다.");

            try {
                Class commandClass = Class.forName(className);//해당 문자열을 클래스로 만든다.
                Object commandInstance = commandClass.newInstance();//해당클래스의 객체를 생성
                commandMap.put(command, commandInstance);// Map객체인 commandMap에 객체 저장
            } catch (ClassNotFoundException e) {
                throw new ServletException(e);
            } catch (InstantiationException e) {
                throw new ServletException(e);
            } catch (IllegalAccessException e) {
                throw new ServletException(e);
            }
        }
        System.out.println("ControllerUsingURI2 init() 나감");
    }

    
    public void doGet(//get방식의 서비스 메소드
        HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        requestPro(request, response);
    }

    protected void doPost(//post방식의 서비스 메소드 // 포스트일려면 폼에다가 post로 지정한방식밖에 없음, 나머지는 전부 get임
        HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        requestPro(request, response);
    }

    //시용자의 요청을 분석해서 해당 작업을 처리
    private void requestPro(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
  	System.out.println("control requestpro 들어옴");
	String view = null;
    CommandAction com=null;
	try {
            String command = request.getRequestURI();
            System.out.println("getRequestURI-"+command);
            if (command.indexOf(request.getContextPath()) == 0) {
               command = command.substring(request.getContextPath().length());
            }
            System.out.println("uri뺀 경로-"+command);
            com = (CommandAction)commandMap.get(command); 
	    if (com == null) {
		com = new NullAction();
	    }
            view = com.requestPro(request, response);
            System.out.println(view+"입니다");
            
        } catch(Throwable e) {
            throw new ServletException(e);
        }  
        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);
        
        System.out.println("control requestpro 나감");
        System.out.println("==================================================");
    }
}