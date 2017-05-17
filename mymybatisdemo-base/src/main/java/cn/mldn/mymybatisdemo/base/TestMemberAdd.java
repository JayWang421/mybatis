package cn.mldn.mymybatisdemo.base;

import java.util.Date;
import java.util.Random;

import org.junit.Test;

import cn.mldn.mymybatisdemo.vo.Member;
import cn.mldn.util.MyBatisSessionFactory;


public class TestMemberAdd {
	@Test
	public void testInsert() {

		/*
		 * // 1、获取mybatis的核心配置文件，取得了此文件就表示可以取得连接和映射文件信息 InputStream
		 * inputStream=Resources.getResourceAsStream("mybatis/mybatis.cfg.xml")
		 * ; // 2、获取SqlSessionFactory程序类对象，通过此类对象可以取得MyBatis的Session对象 //
		 * 3、需要根据mybatis.cfg.xml文件的内容才可以创建SqlSessionFactory工厂类 SqlSessionFactory
		 * factory = new SqlSessionFactoryBuilder() .build(inputStream); //
		 * 4、创建Session对象 SqlSession session = factory.openSession(); //
		 * 有了此对象后才可以进行数据操作
		 */ 
		// 5、实现数据保存
		Member vo = new Member();
		vo.setMid("mldn=" + new Random().nextInt(1000));
		vo.setName("测试名字");
		vo.setAge(19);
		vo.setBirthday(new Date());
		vo.setSalary(1.1);
		vo.setNote("是个好人。");
		System.out.println(MyBatisSessionFactory.getSession().insert("cn.mldn.mymybatisdemo.mapping.MemberNS.doCreate", vo));
		MyBatisSessionFactory.getSession().commit();
		MyBatisSessionFactory.close();
	}
}
