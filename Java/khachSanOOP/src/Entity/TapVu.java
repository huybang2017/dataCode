package Entity;

public class TapVu extends NhanVien {
    private int so_phongdondep;

    public TapVu() {
        so_phongdondep = 0;
    }

    public TapVu(String ID_Worker, String hoten, Integer tuoi, String gioitinh, String diachi, String email, String sdt,
            String shift, int so_phongdondep) {
        super(ID_Worker, hoten, tuoi, gioitinh, diachi, email, sdt, shift);
        this.so_phongdondep = so_phongdondep;
    }

    public int getSo_phongdondep() {
        return so_phongdondep;
    }

    public void setSo_phongdondep(int so_phongdondep) {
        this.so_phongdondep = so_phongdondep;
    }

    public void nhaptapvu() {
        super.nhapnhanvien();
        System.out.print("Nhap So Luong Phòng Tap Vu Da Don Dep: ");
        setSo_phongdondep(input.nextInt());
    }
}
