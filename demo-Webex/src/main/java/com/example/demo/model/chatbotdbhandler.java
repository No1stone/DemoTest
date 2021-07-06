package com.example.demo.model;

public class chatbotdbhandler {

	private String sitetype;
	private String searchkey;
	private String searchtitle;
	private String returnkey;
	private String returnbot;
	
	
	public chatbotdbhandler() {};
	public chatbotdbhandler(String sitetype, String searchkey, String searchtitle, String returnkey, String returnbot) {
		super();
		this.sitetype = sitetype;
		this.searchkey = searchkey;
		this.searchtitle = searchtitle;
		this.returnkey = returnkey;
		this.returnbot = returnbot;
	}
	public String getSitetype() {
		return sitetype;
	}
	public void setSitetype(String sitetype) {
		this.sitetype = sitetype;
	}
	public String getSearchkey() {
		return searchkey;
	}
	public void setSearchkey(String searchkey) {
		this.searchkey = searchkey;
	}
	public String getSearchtitle() {
		return searchtitle;
	}
	public void setSearchtitle(String searchtitle) {
		this.searchtitle = searchtitle;
	}
	public String getReturnkey() {
		return returnkey;
	}
	public void setReturnkey(String returnkey) {
		this.returnkey = returnkey;
	}
	public String getReturnbot() {
		return returnbot;
	}
	public void setReturnbot(String returnbot) {
		this.returnbot = returnbot;
	}
	@Override
	public String toString() {
		return "chatbotdbhandler [sitetype=" + sitetype + ", searchkey=" + searchkey + ", searchtitle=" + searchtitle
				+ ", returnkey=" + returnkey + ", returnbot=" + returnbot + "]";
	}
	
	
	
}
