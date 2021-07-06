package CodeTest.objectover;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;

public class onjectoverride {
	
	public static void main(String[] args) {
		
		busanVO busan = new busanVO();
		seoulVO seoul = new seoulVO();
		KoreaVO koreaa = new KoreaVO();
		
		koreaa.setBus("koreaabus");
		koreaa.setDosi("koreaabus");	
		
		System.out.println(koreaa.getBus());
		System.out.println(koreaa.getDosi());
		
		busan.setBus("123");
		busan.setDosi("부산");
		selectA(busan);
		seoul.setBus("234");
		seoul.setDosi("서울");
		selectA(seoul);
		
		System.out.println(koreaa.getBus());
		System.out.println(koreaa.getDosi());
	
		
	}
	
	public static KoreaVO selectA(busanVO busan) {
		KoreaVO rese = new KoreaVO();
		rese.setDosi(busan.getDosi());
		rese.setBus(busan.getBus());
		
		return selectAA(rese);	
	}
	
	public static KoreaVO selectA(seoulVO seoul) {
		KoreaVO rese = new KoreaVO();
		rese.setDosi(seoul.getDosi());
		rese.setBus(seoul.getBus());
		return selectAA(rese);	
	}
	
	public static KoreaVO selectAA(KoreaVO korea) {
		
	
		System.out.println("버스: "+korea.getBus());
		System.out.println("도시: "+korea.getDosi());
		
		return korea;
		
	}
	
}
