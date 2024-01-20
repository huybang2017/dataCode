package Entity;

public class LeTan extends NhanVien {
    private int so_khachtiepnhan;

    public LeTan() {
        so_khachtiepnhan = 0;
    }

    public LeTan(String ID_Worker, String hoten, Integer tuoi, String gioitinh, String diachi, String email,
            String sdt, String shift, int so_khachtiepnhan) {
        super(ID_Worker, hoten, tuoi, gioitinh, diachi, email, sdt, shift);
        this.so_khachtiepnhan = so_khachtiepnhan;
    }

    public int getSo_khachtiepnhan() {
        return so_khachtiepnhan;
    }

    public void setSo_khachtiepnhan(int so_khachtiepnhan) {
        this.so_khachtiepnhan = so_khachtiepnhan;
    }

    public void nhapletan() {
        super.nhapnhanvien();
        System.out.print("Nhap So Luong Khách Le Tân Da Tiep Nhan: ");
        setSo_khachtiepnhan(input.nextInt());
    }
}
