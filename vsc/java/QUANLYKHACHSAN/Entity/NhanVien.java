package Entity;

public class NhanVien extends Nguoi {
    private String ID_Worker, Shift;

    public NhanVien(String ID_Worker, String hoten, Integer tuoi, String gioitinh, String diachi, String email, String sdt, String shift) {
        super(hoten, diachi, tuoi, gioitinh, sdt, email);
        this.ID_Worker = ID_Worker;
        this.Shift = shift;
    }

    public NhanVien() {
        super();
    }

    public String getID_Worker() {
        return ID_Worker;
    }

    public void setID_Worker(String ID_Worker) {
        this.ID_Worker = ID_Worker;
    }

    public String getShift() {
        return Shift;
    }

    public void setShift(String shift) {
        this.Shift = shift;
    }

    public void nhapnhanvien(){
        super.AddThongTin();
        System.out.print("Nhap Ca Truc (Vd: Ca Sang, Chieu, Toi, Full Time, v.v.): ");
        setShift(input.nextLine());
    }
}