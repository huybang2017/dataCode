package Entity;

public class KhachHang extends Nguoi {
    private String ID_KH;

    public KhachHang() {
        ID_KH = "";
    }

    public KhachHang(String ID_KH, String hoten, int tuoi, String gioitinh, String diachi, String email, String sdt) {
        super(hoten, diachi, tuoi, gioitinh, sdt, email);
        this.ID_KH = ID_KH;
    }

    public String getID_KH() {
        return ID_KH;
    }

    public void setID_KH(String ID_KH) {
        this.ID_KH = ID_KH;
    }
}
