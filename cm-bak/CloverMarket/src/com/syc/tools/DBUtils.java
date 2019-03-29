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
 * @detail 实现mybatis数据库连接操作
 *
 */
public class DBUtils {
	public static SqlSession getSession() {
		// 使用日志对象来输出信息
		Logger lg = Logger.getLogger(DBUtils.class);
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
		return ss;
	}// getSession

	// 关闭数据库操作对象的方法
	public static void closeDB(SqlSession ss) {
		if (ss != null) {
			ss.close();
		} // if
	}// closeDB
}
