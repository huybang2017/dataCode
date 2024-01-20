package Entity;

public class ThuNgan extends NhanVien {
    private int so_hoadon;

    public ThuNgan() {
        so_hoadon = 0;
    }

    public ThuNgan(String ID_Worker, String hoten, Integer tuoi, String gioitinh, String diachi, String email,
            String sdt, String shift, int so_hoadon) {
        super(ID_Worker, hoten, tuoi, gioitinh, diachi, email, sdt, shift);
        this.so_hoadon = so_hoadon;
    }

    public int getSo_hoadon() {
        return so_hoadon;
    }

    public void setSo_hoadon(int so_hoadon) {
        this.so_hoadon = so_hoadon;
    }

    public void nhapthungan() {
        super.nhapnhanvien();
        System.out.print("Nhap So Hóa Don Thu Ngân Da Quan Ly: ");
        setSo_hoadon(input.nextInt());
    }
}
