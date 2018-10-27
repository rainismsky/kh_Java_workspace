package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import teacher.WeeklyScheduleDBBean;
import teacher.WeeklyScheduleDataBean;

public class WeeklyScheduleDeleteAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		System.out.println("==================================================");
		System.out.println("[����������׼�]����!");
		
		int ws_num = Integer.parseInt(request.getParameter("ws_num"));
		
		WeeklyScheduleDBBean dbPro = WeeklyScheduleDBBean.getInstance();
		dbPro.deleteWeeklySchedule(ws_num);
			
		
		return "/Sunghee/Teacher/t_mypagePro.jsp";
	}
}
