package CodeTest.objectmappertest;

import java.util.Map;

public class UserVO {

		private String id;
		private String name;
		private Map<String, Object> mobile;
		private Map<String, Object> tel;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Map<String, Object> getMobile() {
			return mobile;
		}
		public void setMobile(Map<String, Object> mobile) {
			this.mobile = mobile;
		}
		public Map<String, Object> getTel() {
			return tel;
		}
		public void setTel(Map<String, Object> tel) {
			this.tel = tel;
		}
	
		
}
