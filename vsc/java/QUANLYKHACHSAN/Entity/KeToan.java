package Entity;

public class KeToan extends NhanVien {
    private int so_sosach;

    public KeToan(){
        so_sosach = 0;
    }
    public KeToan(String ID_Worker, String hoten, Integer tuoi, String gioitinh, String diachi, String email, String sdt, String shift, int so_sosach) {
        super(ID_Worker, hoten, tuoi, gioitinh, diachi, email, sdt, shift);
        this.so_sosach = so_sosach;
    }

    public int getSo_sosach() {
        return so_sosach;
    }

    public void setSo_sosach(int so_sosach) {
        this.so_sosach = so_sosach;
    }

    public void nhapketoan(){
        super.nhapnhanvien();
        System.out.print("Nhap So So Sách Ke Toán Da Xu Lý: ");
        setSo_sosach(input.nextInt());
    }
}
