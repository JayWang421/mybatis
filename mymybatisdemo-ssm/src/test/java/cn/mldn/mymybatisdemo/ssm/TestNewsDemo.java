package cn.mldn.mymybatisdemo.ssm;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.mldn.servcice.INewsService;
import cn.mldn.vo.News;
import junit.framework.TestCase;

@ContextConfiguration(locations={"classpath:spring/spring-common.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestNewsDemo {
	@Resource
	private INewsService newsService ;
	@Test
	public void testAdd(){
		News vo=new News() ;
		vo.setTitle("nihao");
		vo.setNote("shijie");
		TestCase.assertTrue(this.newsService.add(vo));
	}
}
