package cn.mldn.servcice.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mldn.dao.INewsDAO;
import cn.mldn.servcice.INewsService;
import cn.mldn.vo.News;

@Service
public class NewsServiceImpl implements INewsService {
	
	@Resource
	private INewsDAO newsDAO ;
	
	@Override
	public boolean add(News vo) {
		return this.newsDAO.doCreate(vo);
	}
	
	@Override
	public List<News> list(long currentPage, int lineSize, String column, String keyWord) {
		Map<String ,Object> map=new HashMap<>() ;
		map.put("start", (currentPage-1)*lineSize) ;
		map.put("lineSize", lineSize) ;
		map.put("column", column) ;
		map.put("keyWord", "%"+keyWord+"%" );
		return this.newsDAO.findAllSplit(map);
	}
}
