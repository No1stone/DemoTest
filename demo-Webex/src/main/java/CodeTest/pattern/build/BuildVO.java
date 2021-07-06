package CodeTest.pattern.build;

public class BuildVO {

	private String Honam;
	private String Chatbot;
	private String Webex;
	private String Json;
	private String Action;
	private String SelectAction;
	private String build;
	
	public BuildVO setHonam(String honam) {
		this.Honam = honam;
		return this;
	}
	public BuildVO setChatbot(String chatbot) {
		this.Chatbot = chatbot;
		return this;
	}
	public BuildVO setWebex(String webex) {
		this.Webex = webex;
		return this;
	}
	public BuildVO setJson(String json) {
		this.Json = json;
		return this;
	}
	public BuildVO setAction(String action) {
		this.Action = action;
		return this;
	}
	public BuildVO setSelectAction(String selectAction) {
		this.SelectAction = selectAction;
		return this;
	}
	
	public void BuildPattern (String honam,String chatbot,String webex,String json,String action,String selectAction) {
		this.Honam = honam;
		this.Chatbot = chatbot;
		this.Webex = webex;
		this.Json = json;
		this.Action = action;
		this.SelectAction = selectAction;
	}
	
	
	

}
