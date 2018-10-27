package k.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import j.action.CommandAction;

public class FbWriteFormAction implements CommandAction {//글 입력 폼 처리

    public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable {
       //제목글과 답변글의 구분
    	
    	String user_id = request.getParameter("user_id");
        int b_no=0; 
        try{ 
          if(request.getParameter("b_no")!=null){
		 b_no=Integer.parseInt(request.getParameter("b_no"));
	   }
	}catch(Exception e){
		e.printStackTrace();
	}
		//해당 뷰에서 사용할 속성
		request.setAttribute("b_no", new Integer(b_no));
		request.setAttribute("user_id", user_id);
		System.out.println("라이트폼 액션");
		System.out.println(b_no);
		return "/K/fbwriteForm.jsp";//해당 뷰
	}
}