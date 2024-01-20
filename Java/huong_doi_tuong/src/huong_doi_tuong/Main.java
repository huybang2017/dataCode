package huong_doi_tuong;

//nếu như class không nằm trong project khác thì dùng lệnh
//import ten project .class

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Main.main()");

//		khởi tạo class student
		student studentOne = new student();
		student studentwo = new student();

//		trong OOP không khai báo các thuộc tính như này mà dùng các SETTER
//		studentOne.name = "Huy";
//		studentOne.birthday = 2004;
//		studentOne.MSSV = 146;

//		SETTER
		studentOne.setBirthday(2004);
		studentOne.setName("Huy");
		studentOne.setMSSV(146);

		

//		System.out.println("student infor");
//		System.out.println("name : " + studentOne.getName());
//		System.out.println("birthday: " + studentOne.getBirthday());
//		System.out.println("MSSV: " + studentOne.getMSSV());
		studentOne.show_infor();
		
		System.out.println("số tuổi SV \t: " + studentOne.getAge());


		System.out.println("----------------------------");

//		System.out.println("student infor");
//		System.out.println("name : " + studentwo.getName());
//		System.out.println("birthday: " + studentwo.getBirthday());
//		System.out.println("MSSV: " + studentwo.getMSSV());
		studentwo.setBirthday(2004);
		studentwo.setMSSV(147);
		studentwo.setName("mi");
		
		studentwo.show_infor();
		
		System.out.println("số tuổi SV \t: " + studentwo.getAge());

	}

}
