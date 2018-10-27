package holiday;

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

/*
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
               x= rs.getInt(1); // �ε��� �� 1��?�� �ִ³� �������°�, count(*)�� �÷����� �ƴ϶�
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
               x= rs.getInt(1); // �ε��� �� 1��?�� �ִ³� �������°�, count(*)�� �÷����� �ƴ϶�
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
	
	// �� �����ϱ� ���� �ۿ� �ش��ϴ� �ڷ� ����
	public void delete_FileBoardLoadArticle(int f_num) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String dbpass = "";
		
		try {
			conn =  getConnection();
			pstmt = conn.prepareStatement(
					"delete from File_load where f_num=?");
			pstmt.setInt(1, f_num);
			rs = pstmt.executeQuery();
			conn.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) try { rs.close(); } catch (Exception ex) {}
			if (pstmt != null) try { pstmt.close(); } catch (Exception ex) {}
			if (conn != null) try { conn.close(); } catch (Exception ex) {}
		}
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
				System.out.println("������ ����Ƥ�:::"+rs.getString("fl_path"));
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
*/	
	
	
	

/*	// ������ ������ ����
	
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
	public ArrayList getTeacherProfile() throws Exception {
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

*/
}
