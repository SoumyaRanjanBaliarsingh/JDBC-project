package Com.proj.dto;

public class Teacher {
	private int ID;
	private String Name;
	private String Sub;
	private String Gender;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getSub() {
		return Sub;
	}
	public void setSub(String sub) {
		Sub = sub;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	@Override
	public String toString() {
		return "Teacher [ID=" + ID + ", Name=" + Name + ", Sub=" + Sub + ", Gender=" + Gender + "]";
	}
	
	

}
