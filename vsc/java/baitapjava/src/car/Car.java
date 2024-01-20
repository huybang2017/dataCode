package car;

import java.util.Scanner;

public abstract class Car {
    private String bienSo;
    private String mauXe;
    private String label;

    public Car() {
    }

    public Car(String bienSo, String mauXe, String label) {
        this.bienSo = bienSo;
        this.mauXe = mauXe;
        this.label = label;
    }

    public String getBienSo() {
        return bienSo;
    }

    public void setBienSo(String bienSo) {
        this.bienSo = bienSo;
    }

    public String getMauXe() {
        return mauXe;
    }

    public void setMauXe(String mauXe) {
        this.mauXe = mauXe;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public abstract void inuptCar();

    public  abstract String getInfo();

    public abstract long calcCar();
}
