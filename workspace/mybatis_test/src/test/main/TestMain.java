package test.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import test.vo.MembersVo;

//mem - select

public class TestMain {
public static void main(String[] args) {
		
		//마이바티스 환경설정 파일 경로
		String res = "config.xml";
		
		try {
			//mybatis 환경설정 파일을 읽어오기 위한 스트림 객체
			InputStream is = Resources.getResourceAsStream(res);
			//sqlsessionfactory객체 얻어오기
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
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
			
			session.close();
		} catch (IOException ie) {
			System.out.println(ie.getMessage());
		}
	}
}