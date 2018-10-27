package k.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import j.action.CommandAction;
import logon.LogonDBBean;
import logon.LogonDataBean;

public class MyFollowingFormAction implements CommandAction {//ȸ������ ���� ������ ó��

    public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable {

    	String user_id = request.getParameter("user_id");
        LogonDBBean dbPro = LogonDBBean.getInstance();
        List<Map<String,Object>> fwnlist = dbPro.Myfollowing(user_id);
        List<Map<String,Object>> count = dbPro.Myfeedcount(user_id);
    	List<Map<String,Object>> fowcount = dbPro.Myfollowercount(user_id);
    	List<Map<String,Object>> fowicount = dbPro.Myfollowingcount(user_id);
    	LogonDataBean member =  dbPro.Myfeedmain2(user_id);
        
        
        
		//�ش� �信�� ����� �Ӽ�
        request.setAttribute("fwnlist", fwnlist);
        System.out.println("fwnlist ��� ���");
        System.out.println(fwnlist);
        
        
    	request.setAttribute("count", count);
    	request.setAttribute("fowcount", fowcount);
    	request.setAttribute("fowicount", fowicount);
    	request.setAttribute("member", member);
        return "/K/myfollowing.jsp";//�ش��
        
        
        
    }
}