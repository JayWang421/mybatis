package cn.mldn.test.crud;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import cn.mldn.util.MyBatisSessionFactory;
import cn.mldn.vo.News;
import junit.framework.TestCase;

public class TestDemo {
	@Test
	public void testAdd(){
		News vo=new News() ;
		vo.setTitle("你好");
		vo.setNote("WORLD!!");
		int count=MyBatisSessionFactory.getSession().insert("cn.mldn.mapping.NewsNS.doCreate", vo) ;
		MyBatisSessionFactory.getSession().commit();
		MyBatisSessionFactory.close();
		System.out.println(vo);
		TestCase.assertEquals(count, 1);
	}
	
	@Test
	public void testUpdate(){
		News vo=new News() ;
		vo.setNid(10L);
		vo.setTitle("nihao");
		vo.setNote("WORLD!!");
		int count=MyBatisSessionFactory.getSession().update("cn.mldn.mapping.NewsNS.doUpdate", vo) ;
		MyBatisSessionFactory.getSession().commit();
		MyBatisSessionFactory.close();
		System.out.println(vo);
		TestCase.assertEquals(count, 1);
	}
	
	@Test
	public void testDelete(){
		int count=MyBatisSessionFactory.getSession().delete("cn.mldn.mapping.NewsNS.doDelete", 11L) ;
		MyBatisSessionFactory.getSession().commit();
		MyBatisSessionFactory.close();
		System.out.println(count);
		TestCase.assertEquals(count, 1);
	}
	
	@Test
	public void testGet(){
		News vo=MyBatisSessionFactory.getSession().selectOne("cn.mldn.mapping.NewsNS.findById", 12L) ;
		System.out.println(vo);
		TestCase.assertNotNull(vo);;
	}
	
	@Test
	public void testGetAll(){
		List<News> all=new ArrayList<>() ;
		all=MyBatisSessionFactory.getSession().selectList("cn.mldn.mapping.NewsNS.findAll") ;
		System.out.println(all);
		TestCase.assertNotNull(all);
	}
	
	@Test
	public void testMap(){
		Map<Long,HashMap<Long,Object>> map=MyBatisSessionFactory.getSession().selectMap("cn.mldn.mapping.NewsNS.findAllMap","nid") ;
		Iterator<Map.Entry<Long, HashMap<Long,Object>>> iter=map.entrySet().iterator() ;
		while(iter.hasNext()){
			Map.Entry<Long, HashMap<Long,Object>> me=iter.next() ;
			System.out.println(me.getKey()+"="+me.getValue());
			Iterator<Map.Entry<Long,Object>> meIter=me.getValue().entrySet().iterator() ;
			while(meIter.hasNext()){
				Map.Entry<Long, Object> me2=meIter.next() ;
				System.out.println("\t|-"+me2.getKey()+"="+me2.getValue());
			}
		}
	}
	
	@Test
	public void testFindAllSplit(){
		long currentPage=3 ;
		int lineSize=2 ;
		String keyWord="s" ;
		Map<String ,Object> map=new HashMap<>() ;
		map.put("column", "title") ;
		map.put("keyWord", "%"+keyWord+"%") ;
		map.put("start", (currentPage-1)*lineSize) ;
		map.put("lineSize", lineSize) ;
		List<News> all=MyBatisSessionFactory.getSession().selectList("cn.mldn.mapping.NewsNS.findAllSplit", map) ;
		System.out.println(all);
		TestCase.assertNotNull(all);
	}
	
	@Test
	public void testGetAllCount(){
		String keyWord="s" ;
		Map<String ,Object> map=new HashMap<>() ;
		map.put("column", "title") ;
		map.put("keyWord", "%"+keyWord+"%") ;
		long count=MyBatisSessionFactory.getSession().selectOne("cn.mldn.mapping.NewsNS.getAllCount",map) ;
		System.out.println(count);
	}
	
	//以下为测试动态SQL
	@Test
	public void testFindAllbyTitle(){
		/*//无参数
		List<News> all=MyBatisSessionFactory.getSession().selectList("cn.mldn.mapping.NewsNS.findAllByTitle") ;
		System.out.println(all);*/
		Map<String,Object> param=new HashMap<String,Object> () ;
		param.put("title", "") ;
		List<News> all=MyBatisSessionFactory.getSession().selectList("cn.mldn.mapping.NewsNS.findAllByTitle",param) ;
		System.out.println(all);
	}
	
	@Test
	public void testfindAllByNidAndTitle(){
		/*//无参数
		List<News> all=MyBatisSessionFactory.getSession().selectList("cn.mldn.mapping.NewsNS.findAllByTitle") ;
		System.out.println(all);*/
		Map<String,Object> param=new HashMap<String,Object> () ;
		//param.put("nid", 10L) ;
		param.put("title", "nihao") ;
		List<News> all=MyBatisSessionFactory.getSession().selectList("cn.mldn.mapping.NewsNS.findAllByNidAndTitle",param) ;
		System.out.println(all);
	}
	
	@Test
	public void testfindAllTitle(){
		Map<String,Object> param=new HashMap<String,Object> () ;
		param.put("column", "title") ;
		param.put("data", "nihao") ;
		List<News> all=MyBatisSessionFactory.getSession().selectList("cn.mldn.mapping.NewsNS.findAllTitle",param) ;
		System.out.println(all);
	}
	
	@Test
	public void testDoUpdate2(){
		News vo=new News() ;
		vo.setNid(3L);
		vo.setTitle("世界");
		vo.setNote("hinihao");
		int count=MyBatisSessionFactory.getSession().update("cn.mldn.mapping.NewsNS.doUpdate2", vo) ;
		MyBatisSessionFactory.getSession().commit();
		MyBatisSessionFactory.close();
		System.out.println(count);
	}
	
	@Test
	public void testFindByIds(){
		Set<Long> allIds=new HashSet<Long>() ;
		allIds.add(2L) ;
		allIds.add(4L) ;
		allIds.add(13L) ;
		List<News> all=MyBatisSessionFactory.getSession().selectList("cn.mldn.mapping.NewsNS.findByIds",allIds.toArray()) ;
		System.out.println(all);
	}
}
