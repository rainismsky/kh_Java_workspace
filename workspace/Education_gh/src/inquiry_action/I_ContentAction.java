package inquiry_action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import inquiry.InQuiryDBBean;
import inquiry.InQuiryDataBean;
import notice_action.CommandAction;

public class I_ContentAction implements CommandAction {//�۳��� ó��
public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable {
    	
        int I_num = Integer.parseInt("i_num");//�ش� �۹�ȣ
        
        System.out.println("�̰�:::::"+Integer.parseInt(request.getParameter("i_num")));
        System.out.println(request.getParameter("i_subject"));
        System.out.println(request.getParameter("i_content"));
        System.out.println(request.getParameter("pageNum"));
        
/*        String N_subject = request.getParameter("n_subject");//�ش� �� ����
        String N_content = request.getParameter("n_content");//�ش� �� ����
        String pageNum = request.getParameter("pageNum");//�ش� ������ ��ȣ
*/        
        InQuiryDBBean dbPro = InQuiryDBBean.getInstance();//DBó��
        InQuiryDataBean article =  dbPro.updateGetArticle(I_num);//�ش� �۹�ȣ�� ���� �ش� ���ڵ�
        
        //�ش� �信�� ����� �Ӽ�
        request.setAttribute("n_num", new Integer(I_num));//�޾ƿ� �ش� �� ��ȣ
     /*   request.setAttribute("n_subject", new Integer(N_subject)); // �޾ƿ� �ش� �� ����
        request.setAttribute("n_content",new Integer(N_content)); // �޾ƿ� �ش� �� ����
        request.setAttribute("pageNum", new Integer(pageNum)); // �޾ƿ� �ش� ������ ��ȣ
        request.setAttribute("article", article); // �޾ƿ� ��ƼŬ ��ü��?
*/       
        return "/geunho/inquiry/i_content.jsp";//�ش� ��
    
}
}
