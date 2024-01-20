package handleMaganement.ObjBill;

import handleMaganement.ObjOrder.SanPham;

public class OrderItem extends SanPham {
    private boolean coDa;
    private String moTaDa;
    private boolean coSize;
    private String size; 
    public OrderItem() {

    }

    public OrderItem(String maSanPham, String tenSanPham, String loai, int gia, String ghiChu, boolean coDa,
            String moTaDa, boolean coSize, String size) {
        super(maSanPham, tenSanPham, loai, gia, ghiChu);
        this.coDa = coDa;
        this.moTaDa = moTaDa;
        this.coSize = coSize;
        this.size = size;
    }

    public boolean isCoDa() {
        return coDa;
    }

    public void setCoDa(boolean coDa) {
        this.coDa = coDa;
    }

    public String getMoTaDa() {
        return moTaDa;
    }

    public void setMoTaDa(String moTaDa) {
        this.moTaDa = moTaDa;
    }

    public boolean isCoSize() {
        return coSize;
    }

    public void setCoSize(boolean coSize) {
        this.coSize = coSize;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

}
