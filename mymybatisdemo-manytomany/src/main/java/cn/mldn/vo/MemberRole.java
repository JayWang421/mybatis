package cn.mldn.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class MemberRole implements Serializable {
	private String mid ;
	private Long rid ;
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public Long getRid() {
		return rid;
	}
	public void setRid(Long rid) {
		this.rid = rid;
	}
	@Override
	public String toString() {
		return "MemberRole [mid=" + mid + ", rid=" + rid + "]";
	}
	
}
