package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomepageManageAction implements CommandAction{
    public String requestPro(HttpServletRequest request,HttpServletResponse response)  throws Throwable {
    	
        request.setCharacterEncoding("utf-8");//한글 인코딩
        
        request.getSession().setAttribute("real_user", "teacherid3");
        
        int mainImg_filecounter = 0;
        int introImg_filecounter = 0;
        int serviceImg_filecounter = 0;
        
    	if(request.getParameter("addcnt1")!=null){
    		mainImg_filecounter = Integer.parseInt(request.getParameter("addcnt1"));
    	}
    	
    	if(request.getParameter("addcnt2")!=null){
    		introImg_filecounter = Integer.parseInt(request.getParameter("addcnt2"));
    	}
    	
    	if(request.getParameter("addcnt3")!=null){
    		serviceImg_filecounter = Integer.parseInt(request.getParameter("addcnt3"));
    	}
    	
        request.setAttribute("filecounter1", mainImg_filecounter);
        request.setAttribute("filecounter2", introImg_filecounter);
        request.setAttribute("filecounter3", serviceImg_filecounter);
        
        return "/administer/HomepageManage.jsp";//해당 뷰
    }
}
