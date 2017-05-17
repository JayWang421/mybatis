package cn.mldn.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Role implements Serializable {
	private Long rid ;
	private String title ;
	private String flag ;
	public Long getRid() {
		return rid;
	}
	public void setRid(Long rid) {
		this.rid = rid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	@Override
	public String toString() {
		return "Role [rid=" + rid + ", title=" + title + ", flag=" + flag + "]";
	}
	
}
