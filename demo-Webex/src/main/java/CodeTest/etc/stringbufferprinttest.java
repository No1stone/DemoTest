package CodeTest.etc;

public class stringbufferprinttest {

	public static void main(String[] args) {
		
		stringbufferappendertest stf = new stringbufferappendertest();
		stringbufferappenderextends0 se0 = new stringbufferappenderextends0();
		stringbufferappenderextends1 se1 = new stringbufferappenderextends1();

		//자식객체에 값을 주고 생성을 시킴.
		se0.testaaa(5);
		se1.testbbb(5);
	//	se0.testaaa(5);
		
		
		//System.out.println(se0.xmlinsert(10));
		//System.out.println(se1.xmlinsert(10));
		
		//그럼 부모객체에 값이들어감(어펜더스트링버퍼) 이값을 
		//자식객체가 부모 클래스를 사용해서 호출해버리면 xml에 출력가능.
		//부모객체는 해더부분을 작성하는게 용의 || 반복되는부분
		//변경되는 부분을 자식객체사용
		//헤더, 바디, 푸터, 스트링버퍼 출력위치만 조절하면될듯.
		//이것을 웹엑스미팅 코드로 구현하기.
		//xml, json 2가지로 구현!
		//상속을통해사용하면 일회용으로 사용가능.
		se0.xmlinsert(5);
		//se1.xmlinsert(5);
		se0.xmlinsert(5);
		//se1.xmlinsert(5);	

		
	
	}
}
