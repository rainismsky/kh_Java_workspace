package manage;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManageDBBean {
	private static ManageDBBean instance = new ManageDBBean();

	public static ManageDBBean getInstance() {
		return instance;
	}

	private ManageDBBean() {
	}

	private Connection getConnection() throws Exception {
		String jdbcDriver = "jdbc:apache:commons:dbcp:pool";
		return DriverManager.getConnection(jdbcDriver);
	}
	
    // ���������� �̹��� ����
    public void updateMainImg(ArrayList list) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        PreparedStatement pstmt1 = null;
        MainImageDataBean img = (MainImageDataBean)list.get(0);
        
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(
                    "delete from MAIN_IMG where m_type = ?");
            pstmt.setString(1, img.getType());
            pstmt.executeUpdate();
            conn.commit();
            
            for(int i=0; i<list.size(); i++) {
                pstmt1 = conn.prepareStatement( "insert into MAIN_IMG values (?,?)");
            	MainImageDataBean img1 = (MainImageDataBean)list.get(i);
            	pstmt1.setString(1,img1.getType());
                pstmt1.setString(2, img1.getMain_img());
                System.out.println(img1.getMain_img());
                pstmt1.executeUpdate();
            }

        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
    }

    // �����Ұ� �̹��� ����
    public void updateIntroduceImg(ArrayList list) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        PreparedStatement pstmt1 = null;
        MainImageDataBean img = (MainImageDataBean)list.get(0);
        
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(
                    "delete from MAIN_IMG where m_type = ?");
            pstmt.setString(1, img.getType());
            pstmt.executeUpdate();
            conn.commit();
            
            for(int i=0; i<list.size(); i++) {
                pstmt1 = conn.prepareStatement( "insert into MAIN_IMG values (?,?)");
            	MainImageDataBean img1 = (MainImageDataBean)list.get(i);
            	pstmt1.setString(1,img1.getType());
                pstmt1.setString(2, img1.getMain_img());
                System.out.println(img1.getMain_img());
                pstmt1.executeUpdate();
            }

        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
    }
    
    // ���񽺾ȳ� �̹��� ����
    public void updateServiceImg(ArrayList list) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        PreparedStatement pstmt1 = null;
        MainImageDataBean img = (MainImageDataBean)list.get(0);
        
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(
                    "delete from MAIN_IMG where m_type = ?");
            pstmt.setString(1, img.getType());
            pstmt.executeUpdate();
            conn.commit();
            
            for(int i=0; i<list.size(); i++) {
                pstmt1 = conn.prepareStatement( "insert into MAIN_IMG values (?,?)");
            	MainImageDataBean img1 = (MainImageDataBean)list.get(i);
            	pstmt1.setString(1,img1.getType());
                pstmt1.setString(2, img1.getMain_img());
                System.out.println(img1.getMain_img());
                pstmt1.executeUpdate();
            }

        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
    }
  
    // ---------------------------------------------- ���ս����� ---------------------------------
    
    public ArrayList<ScheduleDataBean> Vacation() throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ScheduleDataBean schedule=null;
        ArrayList<ScheduleDataBean> list = new ArrayList<ScheduleDataBean>();
       
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(
            "select * from schedule natural join teacher");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                schedule = new ScheduleDataBean();
                schedule.setName(rs.getString("t_name"));
                schedule.setSc_date(rs.getString("sc_date").substring(0,10));
                list.add(schedule);
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
        return list;
    }
    
    public ArrayList<ScheduleDataBean> Holiday() throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ScheduleDataBean schedule=null;
        ArrayList<ScheduleDataBean> list = new ArrayList<ScheduleDataBean>();
       
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(
            "select*from schedule natural join holiday");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                schedule = new ScheduleDataBean();
                schedule.setName(rs.getString("h_name"));
                schedule.setSc_date(rs.getString("sc_date").substring(0,10));
                list.add(schedule);
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
        return list;
    }
    
    public ArrayList<VacationDataBean> Vacation_submit() throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        VacationDataBean vacation=null;
        ArrayList<VacationDataBean> list = new ArrayList<VacationDataBean>();
       
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(
            "select * from vacation,teacher where vacation.t_id = teacher.t_id");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                vacation = new VacationDataBean();
                vacation.setVc_num(rs.getInt("vc_num"));
                vacation.setT_name(rs.getString("t_name"));
                vacation.setVc_start(rs.getString("vc_start").substring(0,10));
                vacation.setVc_end(rs.getString("vc_end").substring(0,10));
                vacation.setVc_reason(rs.getString("vc_reason"));
                list.add(vacation);
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
        return list;
    }
    
    public void deleteVacation(int num) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        PreparedStatement pstmt1 = null;
        ResultSet rs= null;

        try {
        	conn = getConnection();

            pstmt = conn.prepareStatement("select*from vacation where vc_num = ?");
            pstmt.setInt(1, num);
            rs = pstmt.executeQuery();
           
            if(rs.next()){
            		pstmt1 = conn.prepareStatement("delete from vacation where vc_num = ?");
                    pstmt1.setInt(1, num);
                    pstmt1.executeUpdate();
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (pstmt1 != null) try { pstmt1.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
    }
    
    
    public Date[] get_vc_start_end(int num) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs= null;
        Date start = null;
        Date end = null;
        Date a[] = new Date[2];
        
        try {
        	conn = getConnection();

            pstmt = conn.prepareStatement(
            "select * from vacation where vc_num = ?");
            pstmt.setInt(1, num);
            rs = pstmt.executeQuery();
           
            if(rs.next()){
            	start = rs.getDate("vc_start");
            	end = rs.getDate("vc_end");
            	System.out.println(start);
            }
            a[0] = start;
            a[1] = end;
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
        return a;
    }
    
    public void insert_schedule(String date2, int num, String t_id) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
        	conn = getConnection();

            pstmt = conn.prepareStatement(
            "insert into schedule values(?,?,?)");
            pstmt.setString(1, date2);
            pstmt.setInt(2, num);
            pstmt.setString(3, t_id);
            pstmt.executeUpdate();
            
            conn.commit();
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
    }
    
    public void insert_schedule2(String date2, int num) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
        	conn = getConnection();

            pstmt = conn.prepareStatement(
            "insert into schedule(sc_date, vc_num) values(?,?)");
            pstmt.setString(1, date2);
            pstmt.setInt(2, num);
            pstmt.executeUpdate();
            
            conn.commit();
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
    }

    public void insert_holiday(int num, String name, String start, String end) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
        	conn = getConnection();

            pstmt = conn.prepareStatement(
            "insert into holiday values(?,?,?,?)");
            pstmt.setInt(1, num);
            pstmt.setString(2, name);
            pstmt.setString(3, start);
            pstmt.setString(4, end);
            pstmt.executeUpdate();
            
            conn.commit();
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
    }
    
    
    // ���� ������ �ѹ� Ȯ���ϱ� 1000���� ����
    public int get_seq_vc_num() throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs= null;
        int x = 1001;
        
        try {
        	conn = getConnection();

            pstmt = conn.prepareStatement(
            "select * from schedule where vc_num >= 1001 order by vc_num");
            rs = pstmt.executeQuery();
           
            while(rs.next()){
            	x = rs.getInt("vc_num");
            	x = x+1;
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
        System.out.println("x��: "+x);
        return x;
    }
    
    
    public String get_t_id(int num) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs= null;
        String t_id = null;
        
        try {
        	conn = getConnection();

            pstmt = conn.prepareStatement(
            "select * from vacation where vc_num = ?");
            pstmt.setInt(1, num);
            rs = pstmt.executeQuery();
           
            if(rs.next()){
            	t_id = rs.getString("t_id");
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
        return t_id;
    }
    
    // ------------------------------ �ڷ�Խ��� ------------------------------
    
    // �ڷ�Խ��� ��ü �� ���� ����
    public int getFileBoardCount() throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int x=0;

        try {
            conn = getConnection();
           
            pstmt = conn.prepareStatement("select count(*) from FileBoard");
            rs = pstmt.executeQuery();

            if (rs.next()) {
               x= rs.getInt(1); // �ε��� �� 1������ �ִ³� �������°�, count(*)�� �÷����� �ƴ϶�
            	}
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
        return x;
    }
    
    // �ڷ�Խ��� ������ ������ �۸� ����
    public List getFileBoardlist(int start, int end) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List articleList=null;
        try {
            conn = getConnection();
           
            pstmt = conn.prepareStatement("select f_num,f_subject,f_pass,f_content,f_date,t_name, r "
            		+ "from (select f_num,f_subject,f_pass,f_content,f_date,t_name, rownum r "
            		+ "from (select * from FileBoard natural join teacher order by f_num desc)) where r>=? and r<=?");
            pstmt.setInt(1, start);
            pstmt.setInt(2, end);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                articleList = new ArrayList(end);
                do{
                  FileBoardDataBean article= new FileBoardDataBean();
                  article.setF_num(rs.getInt("f_num"));
                  article.setF_subject(rs.getString("f_subject"));
                  article.setF_pass(rs.getString("f_pass"));
                  article.setF_content(rs.getString("f_content"));
                  article.setF_date(rs.getTimestamp("f_date"));
                  article.setT_name(rs.getString("t_name"));
                 
                  articleList.add(article);
                }while(rs.next());
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
        return articleList;
    }
    
    // ��ġ ���� �ش� �� ����
    public int getFileBoardCount(String search, String string) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
     	if(search.equals("����")){
    		search = "f_subject";
    	} else if(search.equals("�ۼ���")){
    		search = "t_name";
    	} else{
    		search = "f_content";
    	} 
        int x=0;

        try {
            conn = getConnection();
           
            String strQuery = "select count(*) from FileBoard natural join teacher where "+search+" like '%"+string+"%'";
            pstmt = conn.prepareStatement(strQuery);
            rs = pstmt.executeQuery();
            if (rs.next()) {
               x= rs.getInt(1); // �ε��� �� 1������ �ִ³� �������°�, count(*)�� �÷����� �ƴ϶�
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
        return x;
    }
    
    // ��ġ ���� �ش� �� ����Ʈ
    public List getFileBoardlist(int start, int end, String search, String string) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List articleList=null;
        
     	if(search.equals("����")){
    		search = "f_subject";
    	} else if(search.equals("�ۼ���")){
    		search = "t_name";
    	} else{
    		search = "f_content";
    	} 
     	
        try {
            conn = getConnection();
           
            pstmt = conn.prepareStatement(
            "select f_num,f_subject,f_pass,f_content,f_date,t_name, r "
            + "from (select f_num,f_subject,f_pass,f_content,f_date,t_name, rownum r "
            + "from (select * from FileBoard natural join teacher where "+search+" like '%"+string+"%' order by f_num desc)) where r>=? and r<=?");
            pstmt.setInt(1, start);
            pstmt.setInt(2, end);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                articleList = new ArrayList(end);
                do{
                  FileBoardDataBean article= new FileBoardDataBean();
                  article.setF_num(rs.getInt("f_num"));
                  article.setF_pass(rs.getString("f_pass"));
                  article.setF_subject(rs.getString("f_subject"));
                  article.setF_content(rs.getString("f_content"));
                  article.setF_date(rs.getTimestamp("f_date"));
                  article.setT_name(rs.getString("t_name")); 
                  articleList.add(article);
                }while(rs.next());
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
        return articleList;
    }
    
    
    // ���������� �� �Ѱ� �����ؼ� ����
	public FileBoardDataBean getArticle(int f_num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		FileBoardDataBean article = null;
		
		try {
			conn =  getConnection();
					
			pstmt = conn.prepareStatement(
					"select * from FileBoard natural join teacher where f_num = ?");
			pstmt.setInt(1, f_num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				article = new FileBoardDataBean();
				article.setF_content(rs.getString("f_content"));
				article.setF_date(rs.getTimestamp("f_date"));
				article.setF_num(rs.getInt("f_num"));
				article.setF_pass(rs.getString("f_pass"));
				article.setF_subject(rs.getString("f_subject"));
				article.setT_name(rs.getString("t_name"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch (Exception ex) {}
			if (pstmt != null) try { pstmt.close(); } catch (Exception ex) {}
			if (conn != null) try { conn.close(); } catch (Exception ex) {}
		}
		return article;
	}
    
    
	// �ڷ�Խ��� �� ������ ������ ��ȣ Ȯ��
    public int get_seq_f_num() throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs= null;
        int x = 1;
        
        try {
        	conn = getConnection();

            pstmt = conn.prepareStatement(
            "select * from fileboard order by f_num");
            rs = pstmt.executeQuery();
           
            while(rs.next()){
            	x = rs.getInt("f_num");
            	x = x+1;
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
        System.out.println("x��: "+x);
        return x;
    }
	
	// �ڷ�Խ��� �� �߰�
	public void insert_FileBoardArticle(FileBoardDataBean article) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			String t_id = get_t_id(article.getT_name());
			
			System.out.println(article.getF_num());
			System.out.println(article.getF_subject());
			System.out.println(article.getF_pass());
			System.out.println(article.getF_content());
			System.out.println(article.getF_date());
			System.out.println(t_id);
			
            pstmt = conn.prepareStatement(
            "insert into fileboard values(?,?,?,?,?,?)");
			pstmt.setInt(1, article.getF_num());
			pstmt.setString(2, article.getF_subject());
			pstmt.setString(3, article.getF_pass());
			pstmt.setString(4, article.getF_content());
			pstmt.setTimestamp(5, article.getF_date());
			pstmt.setString(6, t_id);
			
			pstmt.executeUpdate();
			conn.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch (Exception ex) {}
			if (pstmt != null) try { pstmt.close(); } catch (Exception ex) {}
			if (conn != null) try { conn.close(); } catch (Exception ex) {}
		}
	}
    
    // �̸����� �׻�� ������ ���̵� ã��
	public String get_t_id(String t_name) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String t_id = null;
		
		try {
			conn = getConnection();
								
            pstmt = conn.prepareStatement(
            "select t_id from teacher where t_name = ?");
			pstmt.setString(1, t_name);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				t_id = rs.getString("t_id");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch (Exception ex) {}
			if (pstmt != null) try { pstmt.close(); } catch (Exception ex) {}
			if (conn != null) try { conn.close(); } catch (Exception ex) {}
		}
		return t_id;
	}
	
	// �� ����
	public int delete_FileBoardArticle(int f_num, String f_pass) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String dbpass = "";
		int x = -1;
		
		try {
			conn =  getConnection();
			pstmt = conn.prepareStatement(
					"select * from FileBoard where f_num = ?");
			pstmt.setInt(1, f_num);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				dbpass = rs.getString("f_pass");
				
				if (dbpass.equals(f_pass)) {
					pstmt = conn.prepareStatement("delete from FileBoard where f_num=?");
					pstmt.setInt(1, f_num);
					pstmt.executeUpdate();
					x = 1;
				} else x = 0; 
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch (Exception ex) {}
			if (pstmt != null) try { pstmt.close(); } catch (Exception ex) {}
			if (conn != null) try { conn.close(); } catch (Exception ex) {}
		}
		return x;
	}
	
	// �ڷ�Խ��� �� ����
	public int modify_FileBoardArticle(FileBoardDataBean article) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String dbpasswd = "";
		String sql = "";
		int x = -1;

		try {
			conn =  getConnection();
			pstmt = conn.prepareStatement(
					"select f_pass from FileBoard where f_num = ?");
			pstmt.setInt(1, article.getF_num());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				dbpasswd = rs.getString("f_pass");
				if (dbpasswd.equals(article.getF_pass())) {
					sql = "update FileBoard set f_subject=?, f_content=? where f_num=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, article.getF_subject());
					pstmt.setString(2, article.getF_content());
					pstmt.setInt(3, article.getF_num());

					pstmt.executeUpdate();
					conn.commit();
					x = 1;
				} else x = 0; 
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch (Exception ex) {}
			if (pstmt != null) try { pstmt.close(); } catch (Exception ex) {}
			if (conn != null) try { conn.close(); } catch (Exception ex) {}
		}
		return x;
	}
	
	// �ڷ�Խ��� �� �߰� �Ҷ� ���� �߰�
	public void insert_FileBoardLoadArticle(int f_num, ArrayList list) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
            for(int i=0; i<list.size(); i++) {
                pstmt = conn.prepareStatement( "insert into file_load values(?,?,?)");
            	FileBoardLoadDataBean img1 = (FileBoardLoadDataBean)list.get(i);
    			pstmt.setInt(1, f_num);
    			pstmt.setString(2, img1.getFl_subject());
    			pstmt.setString(3, img1.getFl_path());
                pstmt.executeUpdate();
                
    			conn.commit();
            }
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch (Exception ex) {}
			if (pstmt != null) try { pstmt.close(); } catch (Exception ex) {}
			if (conn != null) try { conn.close(); } catch (Exception ex) {}
		}
	}
	
	// �� �Ѱ��� �ش��ϴ� �ڷ�� ������ ����
	public ArrayList<FileBoardLoadDataBean> getArticles_load(int f_num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		FileBoardLoadDataBean article = null;
		ArrayList<FileBoardLoadDataBean> list = new ArrayList<FileBoardLoadDataBean>();
		
		try {
			conn =  getConnection();
					
			pstmt = conn.prepareStatement(
					"select*from file_load natural join fileboard where f_num = ?");
			pstmt.setInt(1, f_num);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				article = new FileBoardLoadDataBean();
				article.setF_num(rs.getInt("f_num"));
				article.setFl_subject(rs.getString("fl_subject"));
				article.setFl_path(rs.getString("fl_path"));
				list.add(article);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch (Exception ex) {}
			if (pstmt != null) try { pstmt.close(); } catch (Exception ex) {}
			if (conn != null) try { conn.close(); } catch (Exception ex) {}
		}
		return list;
	}
	
	// ��ǰ ���� �߰�
	public void insert_ItemArticle(ItemDataBean article) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
            pstmt = conn.prepareStatement( "insert into item values(?,?,?)");
			pstmt.setString(1, article.getItem_name());
			pstmt.setInt(2, article.getItem_count());
			pstmt.setString(3, article.getItem_img());
            pstmt.executeUpdate();
            
			conn.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch (Exception ex) {}
			if (pstmt != null) try { pstmt.close(); } catch (Exception ex) {}
			if (conn != null) try { conn.close(); } catch (Exception ex) {}
		}
	}
	
	// ��ǰ ����
	public void modify_ItemArticle(ItemDataBean article) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		System.out.println("1111");
		try {
			conn = getConnection();
            pstmt = conn.prepareStatement( "update item set item_name=?, item_count=?, item_img=? where item_name=?");
            pstmt.setString(1, article.getItem_name());
            pstmt.setInt(2, article.getItem_count());
			pstmt.setString(3, article.getItem_img());
			pstmt.setString(4, article.getItem_name());
			System.out.println("������");
            pstmt.executeUpdate();
            System.out.println("2222");
			conn.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch (Exception ex) {}
			if (pstmt != null) try { pstmt.close(); } catch (Exception ex) {}
			if (conn != null) try { conn.close(); } catch (Exception ex) {}
		}
	}
	
	// ��ǰ ����
	public void delete_ItemArticle(ItemDataBean article) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
            pstmt = conn.prepareStatement( "delete from item where item_name=?");
            pstmt.setString(1, article.getItem_name());
            System.out.println(article.getItem_name());
            pstmt.executeUpdate();
            
			conn.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch (Exception ex) {}
			if (pstmt != null) try { pstmt.close(); } catch (Exception ex) {}
			if (conn != null) try { conn.close(); } catch (Exception ex) {}
		}
	}
	
	// ��ǰ ��ü �̱�
	public ArrayList<ItemDataBean> get_ItemArticle() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ItemDataBean article = null;
		ArrayList<ItemDataBean> list = new ArrayList<ItemDataBean>();
		
		try {
			conn =  getConnection();
					
			pstmt = conn.prepareStatement("select * from item");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				article = new ItemDataBean();
				article.setItem_name(rs.getString("item_name"));
				article.setItem_count(rs.getInt("item_count"));
				article.setItem_img(rs.getString("item_img"));
				list.add(article);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch (Exception ex) {}
			if (pstmt != null) try { pstmt.close(); } catch (Exception ex) {}
			if (conn != null) try { conn.close(); } catch (Exception ex) {}
		}
		return list;
	}
	
	// ��ǰ �� ���� �̱�
	public int get_ItemArticleCount() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ItemDataBean> list = new ArrayList<ItemDataBean>();
		int x = 0;
		
		try {
			conn =  getConnection();
					
			pstmt = conn.prepareStatement("select count(*) from item");
			rs = pstmt.executeQuery();
						
            if (rs.next()) {
                x= rs.getInt(1); // �ε��� �� 1������ �ִ³� �������°�, count(*)�� �÷����� �ƴ϶�
             }
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch (Exception ex) {}
			if (pstmt != null) try { pstmt.close(); } catch (Exception ex) {}
			if (conn != null) try { conn.close(); } catch (Exception ex) {}
		}
		return x;
	}
	
	
	// ��ǰ �뿩��� �̱�
	public ArrayList<ItemReqDataBean> get_ItemArticleReq() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ItemReqDataBean article = null;
		ArrayList<ItemReqDataBean> list = new ArrayList<ItemReqDataBean>();
		
		try {
			conn =  getConnection();
					
			pstmt = conn.prepareStatement("select * from item_req natural join teacher");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				article = new ItemReqDataBean();
				article.setItem_name(rs.getString("item_name"));
				article.setItem_req_count(rs.getInt("item_req_count"));
				article.setItem_start(rs.getString("item_start").substring(0,10));
				article.setItem_end(rs.getString("item_end").substring(0,10));
				article.setT_name(rs.getString("t_name"));
				list.add(article);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch (Exception ex) {}
			if (pstmt != null) try { pstmt.close(); } catch (Exception ex) {}
			if (conn != null) try { conn.close(); } catch (Exception ex) {}
		}
		return list;
	}
	
	// ���� ��ǰ�뿩��ϸ� �̱�
	public ArrayList<ItemReqDataBean> get_MyItemArticleReq(String t_id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ItemReqDataBean article = null;
		ArrayList<ItemReqDataBean> list = new ArrayList<ItemReqDataBean>();
		
		try {
			conn =  getConnection();
					
			pstmt = conn.prepareStatement("select * from item_req natural join teacher where t_id = ?");
			pstmt.setString(1, t_id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				article = new ItemReqDataBean();
				article.setItem_name(rs.getString("item_name"));
				article.setItem_req_count(rs.getInt("item_req_count"));
				article.setItem_start(rs.getString("item_start").substring(0,10));
				article.setItem_end(rs.getString("item_end").substring(0,10));
				article.setT_name(rs.getString("t_name"));
				article.setT_id(rs.getString("t_id"));
				list.add(article);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch (Exception ex) {}
			if (pstmt != null) try { pstmt.close(); } catch (Exception ex) {}
			if (conn != null) try { conn.close(); } catch (Exception ex) {}
		}
		return list;
	}
	
	// ��ǰ �뿩 �� ��ǰ ���� ����
	public void modify_ItemReqArticle_minus(String item_name, int count) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
            pstmt = conn.prepareStatement("update item set item_count=item_count-"+count+" where item_name=?");
            pstmt.setString(1, item_name);
            pstmt.executeUpdate();
			conn.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch (Exception ex) {}
			if (pstmt != null) try { pstmt.close(); } catch (Exception ex) {}
			if (conn != null) try { conn.close(); } catch (Exception ex) {}
		}
	}
	
	// ��ǰ �뿩 �� �̸� �ø���
	public void insert_ItemReqArticle(ItemReqDataBean article) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
            pstmt = conn.prepareStatement("insert into item_req values(?,?,?,?,?) ");
            pstmt.setString(1, article.getItem_name());
            pstmt.setInt(2, article.getItem_req_count());
            pstmt.setString(3, article.getItem_start().substring(0,10));
            pstmt.setString(4, article.getItem_end().substring(0,10));
            pstmt.setString(5, article.getT_id());
            pstmt.executeUpdate();
			conn.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch (Exception ex) {}
			if (pstmt != null) try { pstmt.close(); } catch (Exception ex) {}
			if (conn != null) try { conn.close(); } catch (Exception ex) {}
		}
	}
	
	public void insert_ItemReqArticle1(ItemReqDataBean article) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
            pstmt = conn.prepareStatement("insert into item_req_save values(?,?,?,?,?) ");
            pstmt.setString(1, article.getItem_name());
            pstmt.setInt(2, article.getItem_req_count());
            pstmt.setString(3, article.getItem_start().substring(0,10));
            pstmt.setString(4, article.getItem_end().substring(0,10));
            pstmt.setString(5, article.getT_id());
            pstmt.executeUpdate();
			conn.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch (Exception ex) {}
			if (pstmt != null) try { pstmt.close(); } catch (Exception ex) {}
			if (conn != null) try { conn.close(); } catch (Exception ex) {}
		}
	}
	
	// ���̵�� ������ �̸� ã��
	public String get_t_name(String t_id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String t_name = null;
		
		try {
			conn = getConnection();
								
            pstmt = conn.prepareStatement(
            "select t_name from teacher where t_id = ?");
			pstmt.setString(1, t_id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				t_name = rs.getString("t_name");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch (Exception ex) {}
			if (pstmt != null) try { pstmt.close(); } catch (Exception ex) {}
			if (conn != null) try { conn.close(); } catch (Exception ex) {}
		}
		return t_name;
	}
	

	// ��ǰ �ݳ� �� ��ǰ ���� ����
	public void modify_ItemReqArticle_plus(String item_name, int count) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
            pstmt = conn.prepareStatement("update item set item_count=item_count+"+count+" where item_name=?");
            pstmt.setString(1, item_name);
            pstmt.executeUpdate();
			conn.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch (Exception ex) {}
			if (pstmt != null) try { pstmt.close(); } catch (Exception ex) {}
			if (conn != null) try { conn.close(); } catch (Exception ex) {}
		}
	}
	
	// ��ǰ �ݳ� �� �̸� ������
	public void delete_ItemReqArticle(String item_name) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
            pstmt = conn.prepareStatement("delete from item_req where item_name = ?");
            pstmt.setString(1, item_name);
            pstmt.executeUpdate();
			conn.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch (Exception ex) {}
			if (pstmt != null) try { pstmt.close(); } catch (Exception ex) {}
			if (conn != null) try { conn.close(); } catch (Exception ex) {}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// ������ ������ ����
	
	//select�� (������ ������ ����)
	//modifyTeacherProfileAction.java
	public TeacherProfileDataBean getTeacherProfileList(String t_id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		TeacherProfileDataBean profile = null;
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select * from T_PROFILE where t_id = ?");
			pstmt.setString(1, t_id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				profile = new TeacherProfileDataBean();
				profile.setT_id(rs.getString("t_id"));

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return profile;
	}
	
	//update�� (������ ������ ����)
	//modifyTeacherProfileAction.java
	public void updateTeacherProfile(String t_id, String t_intro, String t_career, String t_img) throws Exception {
		Connection conn = null;
        PreparedStatement pstmt = null;
       
        try {
            conn = getConnection();
            pstmt = conn.prepareStatement("update T_PROFILE "
            		+ "set t_intro=?, t_career=?, t_img=?"
            		+ " where t_id=?");
            pstmt.setString(1, t_intro);
            pstmt.setString(2, t_career);
            pstmt.setString(3, t_img);
            pstmt.setString(4, t_id);

            pstmt.executeUpdate();
            conn.commit();
        } catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
	}

	//������ ������ �߰��ϱ�
	//CreateT_ProfileAction.java
	public void insert_teacherProfile
	(String t_id, String t_img, String t_intro, String t_career) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("insert into T_PROFILE values(?, ?, ?, ?)");
			pstmt.setString(1, t_id);
			pstmt.setString(2, t_intro);
			pstmt.setString(3, t_career);
			pstmt.setString(4, t_img);

			pstmt.executeUpdate();
            conn.commit();
            	
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
	}
	
	//������ ������ �����ϱ�
	//DeleteT_ProfileAction.java
	public void delete_teacherProfile(String teacherid) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		
		try {
        	conn = getConnection();
        	        	
           pstmt = conn.prepareStatement("select * from T_PROFILE where t_id = ?");
            pstmt.setString(1, teacherid);
            rs = pstmt.executeQuery();
           
            if(rs.next()){
            		pstmt1 = conn.prepareStatement("delete from T_PROFILE where t_id = ?");
                    pstmt1.setString(1, teacherid);
                    pstmt1.executeUpdate();
            }
        } catch(Exception ex) {
        	ex.printStackTrace();
            
        } finally {
            if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (pstmt1 != null) try { pstmt1.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
    }
	
	// ������ ������ �ҷ�����
	//TeacherProfileManage.java
	public ArrayList getTeacherProfile(String t_id) throws Exception {
		// DB�ʱ�ȭ
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// ManageDataBean users = null;
		ArrayList profileList = new ArrayList();
		String sql = "";

		try {
			conn = getConnection();
			sql = "select * from t_profile,teacher where t_profile.t_id=teacher.t_id";
			pstmt = conn.prepareStatement(sql);
						
			rs = pstmt.executeQuery();

			while (rs.next()) {
				TeacherProfileDataBean profile = new TeacherProfileDataBean();
				profile.setT_id(rs.getString("t_id"));
				profile.setT_intro(rs.getString("t_intro"));
				profile.setT_career(rs.getString("t_career"));
				profile.setT_img(rs.getString("t_img"));
				profile.setT_name(rs.getString("t_name"));
				profile.setT_tel(rs.getString("t_tel"));

				profileList.add(profile);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return profileList;
	}

	// ȸ�� ��� ����
	public ArrayList getUsersList() throws Exception {

		// DB�ʱ�ȭ
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ManageDataBean users = null;
		ArrayList vecList = new ArrayList();
		String sql = "";

		try {
			conn = getConnection();
			sql = "select * from USERS order by u_grade asc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ManageDataBean usersList = new ManageDataBean();
				usersList.setU_id(rs.getString("u_id"));
				usersList.setU_name(rs.getString("u_name"));
				usersList.setU_tel(rs.getString("u_tel"));
				usersList.setU_addr(rs.getString("u_addr"));
				usersList.setU_grade(rs.getString("u_grade"));
				usersList.setU_birth(rs.getString("u_birth"));

				vecList.add(usersList);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return vecList;
	}

	// ȸ���������� (������ select)
	public ArrayList getTeacherList() throws Exception {

		// DB�ʱ�ȭ
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ManageDataBean users = null;
		ArrayList vecList = new ArrayList();
		String sql = "";

		try {
			conn = getConnection();
			sql = "select * from TEACHER";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ManageDataBean teacherList = new ManageDataBean();

				teacherList.setT_id(rs.getString("t_id"));
				teacherList.setT_pass(rs.getString("t_pass"));
				teacherList.setT_name(rs.getString("t_name"));
				teacherList.setT_tel(rs.getString("t_tel"));
				teacherList.setT_addr(rs.getString("t_addr"));
				teacherList.setT_birth(rs.getString("t_birth"));

				vecList.add(teacherList);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return vecList;
	}

	// ȸ������ ����
	// ModifyUsersAction.java - �ؿ� �Ȱ��� �޼��� �ϳ� �� ���� (�̿�)
	public ManageDataBean getMemberUsers(String u_id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ManageDataBean member = null;
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select * from USERS where u_id = ?");
			pstmt.setString(1, u_id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				member = new ManageDataBean();
				member.setU_id(rs.getString("u_id"));
				member.setU_pass(rs.getString("u_pass"));
				member.setU_name(rs.getString("u_name"));
				member.setU_tel(rs.getString("u_tel"));
				member.setU_birth(rs.getString("u_birth"));
				member.setU_addr(rs.getString("u_addr"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return member;
	}
	


	// modifyForm (������)
	//������ ������ �ҷ�����!
	// ModifyTeacherAction.java
	public ManageDataBean getMemberTeacher(String t_id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ManageDataBean member = null;
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select * from TEACHER where t_id = ?");
			pstmt.setString(1, t_id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				member = new ManageDataBean();
				member.setT_id(rs.getString("t_id"));
				member.setT_pass(rs.getString("t_pass"));
				member.setT_name(rs.getString("t_name"));
				member.setT_tel(rs.getString("t_tel"));
				member.setT_birth(rs.getString("t_birth"));
				member.setT_addr(rs.getString("t_addr"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return member;
	}
	
	//������ ���� �����ϱ�!
	//update��
	public void updateTeacher
	 (String t_id, String t_pass, String t_name, String t_tel, String t_birth, String t_addr) throws Exception {
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	       
	        try {
	            conn = getConnection();
	           System.out.println("*****************");
	            pstmt = conn.prepareStatement("update TEACHER "
	            		+ "set t_pass=?, t_name=?, t_tel=?, t_birth=?, t_addr=?"
	            		+ " where t_id=?");
	            pstmt.setString(1, t_pass);
	            pstmt.setString(2, t_name);
	            pstmt.setString(3, t_tel);
	            pstmt.setString(4, t_birth);
	            pstmt.setString(5, t_addr);
	            pstmt.setString(6, t_id);
 
	            pstmt.executeUpdate();
	            conn.commit();
	            System.out.println("hhhhhfsdfhuehwuihifuh");
	        } catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				if (pstmt != null)
					try {
						pstmt.close();
					} catch (SQLException ex) {
					}
				if (conn != null)
					try {
						conn.close();
					} catch (SQLException ex) {
					}
			}
		}

	// ȸ�� ���� �����ϱ� update��
	//ModifyUsersAction.java
	public void updateUsers
	 (String u_id, String u_pass, String u_name, String u_tel, String u_birth, String u_addr, String u_grade) throws Exception {
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	       
	        try {
	            conn = getConnection();
	           System.out.println("***************");
	            pstmt = conn.prepareStatement(
	"update USERS set u_id=?, u_pass=?, u_name=?, u_tel=?, u_birth=?, u_addr=?, u_grade=?" +
	" where u_id=?");
	            pstmt.setString(1, u_id);
	            pstmt.setString(2, u_pass);
	            pstmt.setString(3, u_name);
	            pstmt.setString(4, u_tel);
	            pstmt.setString(5, u_birth);
	            pstmt.setString(6, u_addr);
	            pstmt.setString(7, u_grade);
	            pstmt.setString(8, u_id);
	           
	            pstmt.executeUpdate();
	            conn.commit();
	            System.out.println("****************");
	        } catch(Exception ex) {
	            ex.printStackTrace();
	        } finally {
	            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
	            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
	        }
	    }
	
	//������ ���� insert
	//CreateTeacherAction.java
	public void insert_teacher
	(String id, String pass, String name, String tel, String birth, String addr, String zipcode) throws Exception {
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
        	conn = getConnection();

            pstmt = conn.prepareStatement(
            "insert into TEACHER values(?,?,?,?,?,?,?)");
            pstmt.setString(1, id);
            pstmt.setString(2, pass);
            pstmt.setString(3, name);
            pstmt.setString(4, tel);
            pstmt.setString(5, birth);
            pstmt.setString(6, zipcode);
            pstmt.setString(7, addr);
            pstmt.executeUpdate();
            
            conn.commit();
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
    }
    

	// ȸ�� ����
	//DeleteUserAction.java
	public void deleteUsers(String userid) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		
		try {
        	conn = getConnection();

            pstmt = conn.prepareStatement("select * from USERS where u_id = ?");
            pstmt.setString(1, userid);
            rs = pstmt.executeQuery();
           
            if(rs.next()){
            		pstmt1 = conn.prepareStatement("delete from USERS where u_id = ?");
                    pstmt1.setString(1, userid);
                    pstmt1.executeUpdate();
            }
        } catch(Exception ex) {
        	ex.printStackTrace();
            
        } finally {
            if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (pstmt1 != null) try { pstmt1.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
    }

	// ������ ���� ����
	//DeleteTeacherAction.java
	public void deleteTeacher(String teacherid) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		
		try {
        	conn = getConnection();

            pstmt = conn.prepareStatement("select * from TEACHER where t_id = ?");
            pstmt.setString(1, teacherid);
            rs = pstmt.executeQuery();
           
            if(rs.next()){
            		pstmt1 = conn.prepareStatement("delete from TEACHER where t_id = ?");
                    pstmt1.setString(1, teacherid);
                    pstmt1.executeUpdate();
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (pstmt1 != null) try { pstmt1.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
    }


	// �л�����
	
	//�л� ���� �ҷ�����
	//StudentManageAction.java
	public ArrayList getStudentList() throws Exception {

		// DB�ʱ�ȭ
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ManageStudentDataBean student = null;

		ArrayList vecList = new ArrayList();
		String sql = "";

		try {
			conn = getConnection();
			sql = "select * from student, users, teacher where student.u_id=users.u_id and student.t_id=teacher.t_id";

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println("�������");
			while (rs.next()) {
				student = new ManageStudentDataBean();

				student.setS_no(rs.getInt("s_no"));
				student.setS_name(rs.getString("s_name"));
				student.setS_birth(rs.getString("s_birth"));
				student.setS_tel(rs.getString("s_tel"));
				student.setT_id(rs.getString("t_id"));
				student.setU_id(rs.getString("u_id"));
				student.setU_grade(rs.getString("u_grade"));
				student.setU_addr(rs.getString("u_addr"));
				student.setT_name(rs.getString("t_name"));
				student.setU_name(rs.getString("u_name"));

				vecList.add(student);
			}
			System.out.println("�Ϸ�");
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return vecList;
	}
	
	//�л� �߰�
	//CreateStudentAction.java
	public void insert_student
	(String s_name, String birth,String tel,String t_id,String u_id,String img) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement("insert into STUDENT values(seq_s_num.nextval, ?, ?, ?, ?, ?, '�кθ�', ?)");
			pstmt.setString(1, s_name);
			pstmt.setString(2, birth);
			pstmt.setString(3, tel);
			pstmt.setString(4, t_id);
			pstmt.setString(5, u_id);
			pstmt.setString(6, img);

			pstmt.executeUpdate();
            conn.commit();
            	
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
	}
	
	//�л� ����
	//ModifyStudentAction.java
	//select��
	public ManageStudentDataBean getMemberStudent(int s_no) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ManageStudentDataBean member = null;
		try {
			conn = getConnection();

			pstmt = conn.prepareStatement("select * from STUDENT where s_no = ?");
			pstmt.setInt(1, s_no);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				member = new ManageStudentDataBean();
				member.setS_no(rs.getInt("s_no"));
				member.setS_name(rs.getString("s_name"));
				member.setS_tel(rs.getString("s_tel"));
				member.setS_birth(rs.getString("s_birth"));
				member.setS_img(rs.getString("s_img"));
				member.setU_id(rs.getString("u_id"));
				member.setT_id(rs.getString("t_id"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return member;
	}
	
	
	//update��
	 public void updateStudent
	 (int s_no, String s_name, String s_tel, String s_birth, String s_img, String u_id, String t_id) throws Exception {
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	       
	        try {
	            conn = getConnection();
	           System.out.println("***************");
	            pstmt = conn.prepareStatement(
	"update STUDENT set s_name=?, s_birth=?, s_tel=?, t_id=?, u_id=?, s_img=?" +
	" where s_no=?");
	            pstmt.setString(1, s_name);
	            pstmt.setString(2, s_birth);
	            pstmt.setString(3, s_tel);
	            pstmt.setString(4, t_id);
	            pstmt.setString(5, u_id);
	            pstmt.setString(6, s_img);
	            pstmt.setInt(7, s_no);
	           
	            pstmt.executeUpdate();
	            conn.commit();
	            System.out.println("****************");
	        } catch(Exception ex) {
	            ex.printStackTrace();
	        } finally {
	            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
	            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
	        }
	    }
	
	//�л� ����
	//DeleteStudentAction.java
	public void deleteStudent(int num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		
		try {
        	conn = getConnection();

            pstmt = conn.prepareStatement("select*from STUDENT where s_no = ?");
            pstmt.setInt(1, num);
            rs = pstmt.executeQuery();
           
            if(rs.next()){
            		pstmt1 = conn.prepareStatement("delete from STUDENT where s_no = ?");
                    pstmt1.setInt(1, num);
                    pstmt1.executeUpdate();
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (pstmt1 != null) try { pstmt1.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
    }
	

	// ����û
	//ConsultManageAction.java
	public ArrayList getConsultList() throws Exception {

		// DB�ʱ�ȭ
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ConsultDataBean consult = null;
		ArrayList vecList = new ArrayList();
		String sql = "";

		try {
			conn = getConnection();
			sql = "select * from CONSULT";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				ConsultDataBean consultList = new ConsultDataBean();

				consultList.setC_num(rs.getInt("c_num"));
				consultList.setC_name(rs.getString("c_name"));
				consultList.setC_date(rs.getDate("c_date"));
				consultList.setC_tel(rs.getString("c_tel"));
				consultList.setC_time(rs.getString("c_time"));
				consultList.setC_service(rs.getString("c_service"));
				consultList.setT_id(rs.getString("t_id"));

				vecList.add(consultList);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException ex) {
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return vecList;
	}
	
	//����û���� ����
	//DeleteConsultAction.java
	public void deleteConsult(int num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		
		try {
        	conn = getConnection();

            pstmt = conn.prepareStatement("select*from CONSULT where c_num = ?");
            pstmt.setInt(1, num);
            rs = pstmt.executeQuery();
           
            if(rs.next()){
            		pstmt1 = conn.prepareStatement("delete from CONSULT where c_num = ?");
                    pstmt1.setInt(1, num);
                    pstmt1.executeUpdate();
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if (rs != null) try { rs.close(); } catch(SQLException ex) {}
            if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
            if (pstmt1 != null) try { pstmt1.close(); } catch(SQLException ex) {}
            if (conn != null) try { conn.close(); } catch(SQLException ex) {}
        }
    }

}
