package huong_doi_tuong;

import java.util.Calendar;

public class student {
	
//	khai báo các thuộc tính
	public String name;
	public int MSSV;
	public int birthday;
	
////	SETTER
//	public void setName(String vName) {
//		this.name = vName;
//	}
//	public void setMSSV(int vMSSV) {
//		this.MSSV = vMSSV;
//	}
//	public void setBirthday(int vBirthday) {
//		this.birthday = vBirthday;
//	}
//	
//	
////	GETTER
//	public String getName() {
//		return this.name;
//	}
//	public int getMSSV() {
//		return this.MSSV;
//	}
//	public int getBirthday() {
//		return this.birthday;
//	}
	
	
	
//	chuột phải SOURCE chọn getter setter
//	GETER
	public String getName() {
		return name;
	}
//	SETTER
	public void setName(String name) {
		this.name = name;
	}

	public int getMSSV() {
		return MSSV;
	}

	public void setMSSV(int mSSV) {
		MSSV = mSSV;
	}

	public int getBirthday() {
		return birthday;
	}

	public void setBirthday(int birthday) {
		this.birthday = birthday;
	}
	
//	tính tuổi
	public int getAge() {
//		lấy số năm hiện tại
		Calendar now = Calendar.getInstance();
		return now.get(Calendar.YEAR) - this.getBirthday();
	}
	
	
	
//	show student infor
	public void show_infor() {
		System.out.println("student infor");
		System.out.println("name\t\t: " + this.getName());
		System.out.println("birthday \t: " + this.getBirthday());
		System.out.println("MSSV\t\t: " + this.getMSSV());
	}
	
}
