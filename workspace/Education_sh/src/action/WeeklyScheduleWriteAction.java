package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import teacher.WeeklyScheduleDBBean;
import teacher.WeeklyScheduleDataBean;

public class WeeklyScheduleWriteAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {

		System.out.println("==================================================");
		System.out.println("[�������߰��׼�]����!"+request.getParameter("starttime"));
		
		request.setCharacterEncoding("utf-8");
		
		WeeklyScheduleDataBean ws = new WeeklyScheduleDataBean();
			ws.setWs_day(request.getParameter("ws_day"));
			ws.setSchedule(request.getParameter("schedule"));
			ws.setStarttime(request.getParameter("starttime"));
			ws.setEndtime(request.getParameter("endtime"));
			ws.setT_id(request.getSession().getAttribute("id").toString());
		
		WeeklyScheduleDBBean dbPro = WeeklyScheduleDBBean.getInstance();
		dbPro.insertWeeklySchedule(ws);
			
		
		return "/Sunghee/Teacher/t_mypagePro.jsp";
	}

}
