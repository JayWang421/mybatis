package cn.mldn.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import cn.mldn.util.MyBatisSessionFactory;
import cn.mldn.vo.Member;
import cn.mldn.vo.Role;

public class TestDemo {
	@Test
	public void testDoCreate(){
		Member vo=new Member() ;
		vo.setMid("hello");
		vo.setName("world");
		Long rid[]=new Long[]{1L,2L,3L,4L,5L,6L} ;
		if(MyBatisSessionFactory.getSession().insert("cn.mldn.mapping.MemberNS.doCreate", vo)>0){
			for(int x=0 ; x<rid.length ; x++){
				Map<String,Object> map=new HashMap<>() ;
				map.put("mid", vo.getMid()) ;
				map.put("rid", rid[x]) ;
				MyBatisSessionFactory.getSession().insert("cn.mldn.mapping.RoleNS.doCreateMemberRole",map) ;
			}
		}
		MyBatisSessionFactory.getSession().commit();
		System.out.println(vo);
	}
	
	@Test
	public void testFindById(){
		Member member=MyBatisSessionFactory.getSession().selectOne("cn.mldn.mapping.MemberNS.findById", "hello") ;
		List<String> allFlags=MyBatisSessionFactory.getSession().selectList("cn.mldn.mapping.RoleNS.findAllFlagByMid", member.getMid()) ;
		Set<String> set=new HashSet<>() ;
		set.addAll(allFlags) ;
		System.out.println(set);
		List<Role> allRoles=MyBatisSessionFactory.getSession().selectList("cn.mldn.mapping.RoleNS.findAllByMid", member.getMid()) ;
		System.out.println(member);
		System.out.println(allRoles);
	}
	/*@Test
	public void testDoUpdate(){
		Member vo=new Member() ;
		vo.setMid("hello");
		vo.setName("世界") ;
		MyBatisSessionFactory.getSession().update("cn.mldn.mapping.MemberNS.doUpdate",vo) ;
		MyBatisSessionFactory.getSession().commit(); 
		MyBatisSessionFactory.close();
	}*/
	
	@Test
	public void testDoUpdate(){
		Member vo=new Member() ;
		vo.setMid("hello");
		vo.setName("世界好") ;
		Long rid[] =new Long[]{1L,3L,5L,9L,2L} ;
		if(MyBatisSessionFactory.getSession().update("cn.mldn.mapping.MemberNS.doUpdate", vo)>0){
			if(MyBatisSessionFactory.getSession().delete("cn.mldn.mapping.RoleNS.doRemoveRoleByMid",vo.getMid())>0){
				for(int x=0 ; x<rid.length ; x++){
					Map<String ,Object> map=new HashMap<>() ;
					map.put("mid", vo.getMid()) ;
					map.put("rid", rid[x]) ;
					MyBatisSessionFactory.getSession().insert("cn.mldn.mapping.RoleNS.doCreateMemberRole",map) ;
				}
			}
		}
		MyBatisSessionFactory.getSession().commit(); 
		MyBatisSessionFactory.close();
	}
}
