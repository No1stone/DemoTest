package enumTestCode;

import enumTestCode.DefineCode.CommonService;
import enumTestCode.DefineCode.ProfessorService;

public class enumPrintTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String DefineDFG = DefineCode.GDFEntity.ASSIGNMENT;
		CommonService DefineComm = DefineCode.CommonService.FUNCTION_SEARCH;
		
		System.out.println(enumTestCode.DefineCode.GDFEntity.END);
		System.out.println(enumTestCode.DefineCode.GDFEntity.class);
		
		
		System.out.println(DefineDFG);
		System.out.println(DefineCode.GDFEntity.START);
		
		
		System.out.println("그냥출력: "+DefineComm);
		System.out.println("서비스출력: "+DefineComm.service());
		System.out.println("서비스네임출력: "+DefineComm.serviceName());
		
		
		ProfessorService pfs = enumTestCode.DefineCode.ProfessorService.ASSIGNMENT_CONTINUE_END_SCHEDULE_SERVICE;
		
		System.out.println("그냥출력: "+ pfs);
		System.out.println("서비스출력: "+pfs.service());
		System.out.println("서비스네임출력: "+pfs.serviceName());
		
		if(DefineComm.service().equals("function-search")) {
			System.out.println("검색됨");
		}
		else {
			System.out.println("안됨");
		}
		
		System.out.println(DefineComm.service().substring(0,8));
		if(DefineComm.service().substring(0,8).equals("function")) {
			System.out.println("서브스트링 검색됨");
		}
		
		
		
	}

}
