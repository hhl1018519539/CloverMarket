package com.syc.test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;


public class PlayHqy {
	@Test
	public  void getSession() {
		// ʹ����־�����������Ϣ
		Logger lg = Logger.getLogger(PlayHqy.class);
		SqlSessionFactory sf = null;
		SqlSession ss = null;
		try {
			//// �����ַ��������,����sessionFactory��
			Reader rd = Resources.getResourceAsReader("my.xml");
			// ����һ��sessionFactory��ʵ����Ķ���
			SqlSessionFactoryBuilder ssf = new SqlSessionFactoryBuilder();
			// sfָ����������
			sf = ssf.build(rd);
			// �������ݿ��������
			ss = sf.openSession();
			lg.info("���ӳɹ�!");
			//System.out.println("���ӳɹ�");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			lg.error("--------oh,my god-----------");
			e.printStackTrace();
		}
	}// getSession
}
