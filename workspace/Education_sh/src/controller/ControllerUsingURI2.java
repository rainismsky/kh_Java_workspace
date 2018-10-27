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
  
    private Map commandMap = new HashMap();//��ɾ�� ��ɾ� ó�� Ŭ������ ������ ����
    
    //��ɾ�� ó��Ŭ������ ���εǾ� �ִ� properties ������ �о Map��ü�� commandMap�� ����
    //��ɾ�� ó��Ŭ������ ���εǾ� �ִ� properties ������ Command.properties����
    
    public void init(ServletConfig config) throws ServletException {
    	System.out.println("ControllerUsingURI2 init() ����");
        String props = config.getInitParameter("configFile2");//web.xml���� propertyConfig�� �ش��ϴ� init-param �� ���� �о��
        //props = "WEB-INF/commandHandlerURI.properties"
        Properties pr = new Properties();//��ɾ�� ó��Ŭ������ ���������� ������ Properties��ü ����
        FileInputStream f = null;
        try {
            String configFilePath = config.getServletContext().getRealPath(props);	
            System.out.println(configFilePath);
            f = new FileInputStream(configFilePath); //Command.properties������ ������ �о��
            pr.load(f);//Command.properties������ ������  Properties��ü�� ����
        } catch (IOException e) {
            throw new ServletException(e);
        } finally {
            if (f != null) try { f.close(); } catch(IOException ex) {}
        }
        Iterator keyIter = pr.keySet().iterator();//Iterator��ü�� Enumeration��ü�� Ȯ���Ų ������ ��ü
        while( keyIter.hasNext() ) {//��ü�� �ϳ��� ������ �� ��ü������ Properties��ü�� ����� ��ü�� ����
            String command = (String)keyIter.next();
            System.out.println(command);
            String className = pr.getProperty(command);
            System.out.println(className+"�Դϴ�.");

            try {
                Class commandClass = Class.forName(className);//�ش� ���ڿ��� Ŭ������ �����.
                Object commandInstance = commandClass.newInstance();//�ش�Ŭ������ ��ü�� ����
                commandMap.put(command, commandInstance);// Map��ü�� commandMap�� ��ü ����
            } catch (ClassNotFoundException e) {
                throw new ServletException(e);
            } catch (InstantiationException e) {
                throw new ServletException(e);
            } catch (IllegalAccessException e) {
                throw new ServletException(e);
            }
        }
        System.out.println("ControllerUsingURI2 init() ����");
    }

    
    public void doGet(//get����� ���� �޼ҵ�
        HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        requestPro(request, response);
    }

    protected void doPost(//post����� ���� �޼ҵ� // ����Ʈ�Ϸ��� �����ٰ� post�� �����ѹ�Ĺۿ� ����, �������� ���� get��
        HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        requestPro(request, response);
    }

    //�ÿ����� ��û�� �м��ؼ� �ش� �۾��� ó��
    private void requestPro(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
  	System.out.println("control requestpro ����");
	String view = null;
    CommandAction com=null;
	try {
            String command = request.getRequestURI();
            System.out.println("getRequestURI-"+command);
            if (command.indexOf(request.getContextPath()) == 0) {
               command = command.substring(request.getContextPath().length());
            }
            System.out.println("uri�� ���-"+command);
            com = (CommandAction)commandMap.get(command); 
	    if (com == null) {
		com = new NullAction();
	    }
            view = com.requestPro(request, response);
            System.out.println(view+"�Դϴ�");
            
        } catch(Throwable e) {
            throw new ServletException(e);
        }  
        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);
        
        System.out.println("control requestpro ����");
        System.out.println("==================================================");
    }
}