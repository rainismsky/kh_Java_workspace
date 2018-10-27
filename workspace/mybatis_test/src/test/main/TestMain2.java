package test.main;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import test.vo.MembersVo;

//mem - update
public class TestMain2 {
public static void main(String[] args) {
		
	//mybatis ȯ�漳�� ���� ���
	String res = "config.xml";

		try {
			//mybatis ȯ�漳�� ������ �о���� ���� ��Ʈ�� ��ü
			InputStream is = Resources.getResourceAsStream(res);
			
			//sqlsessionfactory ��ü ������
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
			
			//sql ����� �����ϱ� ���� sqlsession��ü ������
			SqlSession session = factory.openSession();
			List<MembersVo> list = session.selectList("member.getlist");

			for (MembersVo vo : list) {

				System.out.println("id:" + vo.getId());
				System.out.println("pwd:" + vo.getPwd());
				System.out.println("email:" + vo.getEmail());
				System.out.println("phone:" + vo.getPhone());
				System.out.println("regdate:" + vo.getRegdate());
				System.out.println();
			}		
			//update��� ����
			MembersVo vo = new MembersVo("ȿ��ȿ��","1234","silver1@naver.com","01012345677",
					new Timestamp(System.currentTimeMillis()));
			
			session.update("member.updateMem",vo);
			
			session.commit();
			
			session.close(); //���� ����
			
		}catch(IOException ie) {
			System.out.println(ie.getMessage());
		}
	}
}