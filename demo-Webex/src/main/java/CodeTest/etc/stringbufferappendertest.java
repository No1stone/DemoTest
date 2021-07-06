package CodeTest.etc;

public class stringbufferappendertest {
	
	public StringBuffer ex = new StringBuffer();
	// 접근가능한 인스턴스로 생성해버림.
	StringBuffer xml;
	
	public StringBuffer getEx() {
		return ex;
	}

	public void setEx(StringBuffer ex) {
		this.ex = ex;
	}

	public String xmlinsert(int a) {
		xml = new StringBuffer();
		xml.append("test String insert 부모객체\n");

		System.out.println(xml);
		System.out.println("=============\n");
		//자식객체 주입
		System.out.println(xml.append(this.ex));

		return this.xml.toString(); 
	}


	
}

