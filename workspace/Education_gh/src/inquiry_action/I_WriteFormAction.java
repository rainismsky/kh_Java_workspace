package inquiry_action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice_action.CommandAction;

public class I_WriteFormAction implements CommandAction {//글 입력 폼 처리
public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
       
//글 번호와  제목,내용의 구분
     int I_num=0;
/*     String N_subject = request.getParameter("n_subject"); 
     String N_content = request.getParameter("n_content");
 */
     try{ 
     
    	 if(request.getParameter("i_num")!=null){
		 
         I_num=Integer.parseInt(request.getParameter("i_num")); //글번호
 /*        N_subject=(request.getParameter("n_subject")); //글 제목
		 N_content=(request.getParameter("n_content")); //글 내용 			 
      */    
          }
	}catch(Exception e){
		e.printStackTrace();
	}
		//해당 뷰에서 사용할 속성
		request.setAttribute("i_num", new Integer(I_num));
	/*	request.setAttribute("n_subject", new String(N_subject));
		request.setAttribute("n_content", new String(N_content));
*/
		return "/geunho/inquiry/i_writeForm.jsp"; //해당 뷰
	}
}