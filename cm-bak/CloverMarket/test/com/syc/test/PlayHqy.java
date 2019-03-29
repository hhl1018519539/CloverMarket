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
		// 使用日志对象来输出信息
		Logger lg = Logger.getLogger(PlayHqy.class);
		SqlSessionFactory sf = null;
		SqlSession ss = null;
		try {
			//// 生成字符输入对象,传入sessionFactory中
			Reader rd = Resources.getResourceAsReader("my.xml");
			// 创建一个sessionFactory的实现类的对象
			SqlSessionFactoryBuilder ssf = new SqlSessionFactoryBuilder();
			// sf指向它的子类
			sf = ssf.build(rd);
			// 生成数据库操作对象
			ss = sf.openSession();
			lg.info("连接成功!");
			//System.out.println("连接成功");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			lg.error("--------oh,my god-----------");
			e.printStackTrace();
		}
	}// getSession
}
