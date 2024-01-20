
package handleMaganement.ObjOrder;

public class SanPham {
    private String maSanPham;
    private String tenSanPham;
    private String loai;
    private int gia;

    private String ghiChu;

    public SanPham() {
        // Constructor mặc định
    }

    public SanPham(String maSanPham, String tenSanPham, String loai, int gia, String ghiChu) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.loai = loai;
        this.gia = gia;
        this.ghiChu = ghiChu;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    @Override
    public String toString() {
        return "Mã sản phẩm: " + maSanPham +
                ", Tên sản phẩm: " + tenSanPham +
                ", Loại: " + loai +
                ", Giá: " + gia + " VND" +
                ", Ghi chú: " + (ghiChu != null ? ghiChu : "");
        // Thêm các trường khác của đối tượng vào đây

    }
}
