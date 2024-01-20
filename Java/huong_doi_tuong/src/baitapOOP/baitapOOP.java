package baitapOOP;

import java.util.Scanner;

public class baitapOOP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
//		nhập số lượng sinh viên
		System.out.println("nhập số lượng sinh viên");
		int quantity = Integer.parseInt(scan.nextLine());

		Student listStudent[] = new Student[quantity];
		inputStudent(listStudent);		
		tinhDiem(listStudent);
		timSinhVienYeu(listStudent);
	}

	public static void inputStudent(Student[] listStudent) {
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < listStudent.length; i++) {
			// thông tin sinh viên
			System.out.println("nhập tên");
			String ten = scan.nextLine();
			System.out.println("nhập MSSV");
			String MSSV = scan.nextLine();
			System.out.println("nhâp điểm toán");
			float diemToan = Float.parseFloat(scan.nextLine());
			System.out.println("nhập điểm lý");
			float diemLy = Float.parseFloat(scan.nextLine());
			System.out.println("nhập điểm hóa");
			float diemHoa = Float.parseFloat(scan.nextLine());
			listStudent[i] = new Student(ten, MSSV, diemToan, diemHoa, diemLy);

		}
	}

	public static void tinhDiem(Student[] listStudent) {
		// TODO Auto-generated method stub
		float DTB_max = 0;
		for (int i = 0; i < listStudent.length; i++) {
			if (DTB_max <= listStudent[i].tinhDiemTrungBinh()) {
				DTB_max = listStudent[i].tinhDiemTrungBinh();
			}
		}
		System.out.println("điểm trung bình cao nhất: " + DTB_max);
	}

	public static void timSinhVienYeu(Student[] listStudent) {
		for (int i = 0; i < listStudent.length; i++) {
			if (listStudent[i].xepLoaiSinhVien() == "yếu") {
				System.out.println("sinh viên yếu: " + listStudent[i].name);
			}
		}
	}

}

interface ClassificationStudent {
	int xuatXac = 9;
	int gioi = 8;
	int kha = 7;
	int tbKha = 6;
	int tb = 5;

	float tinhDiemTrungBinh();

	String xepLoaiSinhVien();
}

class Student extends People implements ClassificationStudent {
	float diemToan;
	float diemLy;
	float diemHoa;

	public Student(String name, String MSSV, float diemToan, float diemHoa, float diemLy) {
		// TODO Auto-generated constructor stub
		super(name, MSSV);
		this.diemToan = diemToan;
		this.diemHoa = diemHoa;
		this.diemLy = diemLy;
	}

	public float getDiemToan() {
		return diemToan;
	}

	public void setDiemToan(float diemToan) {
		this.diemToan = diemToan;
	}

	public float getDiemLy() {
		return diemLy;
	}

	public void setDiemLy(float diemLy) {
		this.diemLy = diemLy;
	}

	public float getDiemHoa() {
		return diemHoa;
	}

	public void setDiemHoa(float diemHoa) {
		this.diemHoa = diemHoa;
	}

	@Override
	public float tinhDiemTrungBinh() {
		// TODO Auto-generated method stub
		float DTB;
		DTB = (this.diemToan + this.diemHoa + this.diemLy) / 3;
		return DTB;
	}

	@Override
	public String xepLoaiSinhVien() {
		// TODO Auto-generated method stub
		if (this.tinhDiemTrungBinh() >= this.xuatXac) {
			return "xuất xắc";
		} else if (this.tinhDiemTrungBinh() >= this.gioi && this.tinhDiemTrungBinh() < this.xuatXac) {
			return "giỏi";
		} else if (this.tinhDiemTrungBinh() >= this.kha && this.tinhDiemTrungBinh() < this.gioi) {
			return "khá";
		} else if (this.tinhDiemTrungBinh() >= this.tbKha && this.tinhDiemTrungBinh() < this.kha) {
			return "TB khá";
		} else if (this.tinhDiemTrungBinh() >= this.tb && this.tinhDiemTrungBinh() < this.tbKha) {
			return "trung bình";
		} else {
			return "yếu";
		}
	}
}

abstract class People {
	String MSSV;
	String name;

	public People(String name, String MSSV) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.MSSV = MSSV;
	}

	public String getMSSV() {
		return MSSV;
	}

	public void setMSSV(String mSSV) {
		MSSV = mSSV;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}