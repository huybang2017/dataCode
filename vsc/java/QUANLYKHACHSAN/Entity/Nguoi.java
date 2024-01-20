package Entity;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Nguoi {
    static Scanner input = new Scanner(System.in);
    private String hoten, diachi, sdt, gioitinh, email;
    private int tuoi;

    public Nguoi() {
        hoten = "";
        diachi = "";
        tuoi = 0;
        gioitinh = "";
        sdt = "";
    }

    public Nguoi(String hoten, String diachi, int tuoi, String gioitinh, String sdt, String email) {
        this.hoten = hoten;
        this.diachi = diachi;
        this.tuoi = tuoi;
        this.gioitinh = gioitinh;
        this.sdt = sdt;
        this.email = email;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    // Hàm get set cho biến diachi
    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getGioiTinh() {
        return gioitinh;
    }

    public void setGioiTinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    // Hàm get set cho biến tuoi
    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    // Hàm get set cho biến sdt
    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void AddThongTin() {
        try {
            System.out.print("Nhap Ho Tên: ");
            setHoten(input.nextLine());

            do {
                System.out.print("Nhap Tuoi: ");
                setTuoi(input.nextInt());
            } while (tuoi <= 0 );

            do {
                input.nextLine();
                System.out.print("Nhap Gioi Tính (Nam hoac Nu): ");
                setGioiTinh(input.nextLine());
            } while (!gioitinh.equalsIgnoreCase("Nam") && !gioitinh.equalsIgnoreCase("Nu"));

            System.out.print("Nhap Dia Chi: ");
            setDiachi(input.nextLine());

            do {
                System.out.print("Nhap Email: ");
                setEmail(input.nextLine());
            } while (email.contains("@gmail.com") == false);

            do {
                System.out.print("Nhap So Dien Thoai: ");
                setSdt(input.nextLine());
            } while (sdt.length() != 10);

        } catch (InputMismatchException ie) {
            System.out.println("Gia tri khong hop le, hay nhap lai!!!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
