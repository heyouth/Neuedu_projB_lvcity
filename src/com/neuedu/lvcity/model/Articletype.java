package com.neuedu.lvcity.model;

public class Articletype {
	private int atid;
	private String atype;
	public Articletype() {
		super();
	}
	public Articletype(int atid, String atype) {
		super();
		this.atid = atid;
		this.atype = atype;
	}
	public int getAtid() {
		return atid;
	}
	public void setAtid(int atid) {
		this.atid = atid;
	}
	public String getAtpe() {
		return atype;
	}
	public void setAt(String atype) {
		this.atype = atype;
	}
}
