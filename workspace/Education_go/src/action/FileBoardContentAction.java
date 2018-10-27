package action;

import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manage.FileBoardDataBean;
import manage.FileBoardLoadDataBean;
import manage.ManageDBBean;


public class FileBoardContentAction implements CommandAction  {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
        request.setCharacterEncoding("utf-8");//�ѱ� ���ڵ�
        
        String pageNum = request.getParameter("pageNum");//������ ��ȣ
    	String f_nums =  request.getParameter("f_num");
    	int f_num = Integer.parseInt(f_nums);
    	
		ManageDBBean dbPro = ManageDBBean.getInstance();
		FileBoardDataBean article = dbPro.getArticle(f_num); //�� ��ȣ�� �ش� �Ǵ� ����
		ArrayList<FileBoardLoadDataBean> list_load = dbPro.getArticles_load(f_num);
		
		for(int i=0;i<list_load.size();i++) {
			String fl_subject = list_load.get(i).getFl_subject();
			String x=request.getContextPath()+"/fileSave/"+URLEncoder.encode(fl_subject,"UTF-8");
			list_load.get(i).setFl_realPath(x);
		}
		request.setAttribute("article", article);
		request.setAttribute("list_load", list_load);
		request.setAttribute("pageNum", pageNum);
		
        return "/administer/FileBoardContent.jsp";
	}

}
