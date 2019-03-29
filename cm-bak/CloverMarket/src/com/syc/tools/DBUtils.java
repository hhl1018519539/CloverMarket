package com.syc.tools;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

/**
 * 
 * @author hhl
 * @data 2019-3-26 15:45
 * @detail ʵ��mybatis���ݿ����Ӳ���
 *
 */
public class DBUtils {
	public static SqlSession getSession() {
		// ʹ����־�����������Ϣ
		Logger lg = Logger.getLogger(DBUtils.class);
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
		return ss;
	}// getSession

	// �ر����ݿ��������ķ���
	public static void closeDB(SqlSession ss) {
		if (ss != null) {
			ss.close();
		} // if
	}// closeDB
}
