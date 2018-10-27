package notice.inquiry_action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WriteFormAction implements CommandAction {//글 입력 폼 처리
public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
       
//글 번호와  제목,내용의 구분
     int N_num=1;

     try{ 
     
    	 if(request.getParameter("n_num")!=null){
		 
         N_num=Integer.parseInt(request.getParameter("n_num")); //글번호
    
          }
	}catch(Exception e){
		e.printStackTrace();
	}
		//해당 뷰에서 사용할 속성
		request.setAttribute("n_num", new Integer(N_num));

		return "/geunho/notice/writeForm.jsp"; //해당 뷰
	}
}