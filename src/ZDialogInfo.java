
public class ZDialogInfo {
	
	private String name, gender, age, hair, height;
	
	public ZDialogInfo() {}
	
	public ZDialogInfo(String name, String gender, String age, String hair, String height) {
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.hair = hair;
		this.height = height;
	}

	@Override
	public String toString() {
		String str;
		
		if(this.name != null 
				&& this.gender != null 
					&& this.age != null 
						&& this.hair != null 
							&& this.height != null) {
			
			str = "Description of our Caracter\n";
			str += "Name : "   + this.name   + "\n";
			str += "Gender : " + this.gender + "\n";
			str += "Age : "    + this.age    + "\n";
			str += "Hair : "   + this.hair   + "\n";
			str += "Height : " + this.height + "\n";
		}
		else {
			str = "No information available.";
		}
		return str;
	}
}
