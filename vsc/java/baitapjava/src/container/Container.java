package container;

import car.Car;

import java.util.Scanner;

public class Container extends Car {
    private int trongTai;

    public Container(int trongTai) {
        this.trongTai = trongTai;
    }

    public Container() {
    }

    public Container(String bienSo, String mauXe, String label, int trongTai) {
        super(bienSo, mauXe, label);
        this.trongTai = trongTai;
    }

    @Override
    public void inuptCar() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("nhập biển số xe: ");
        String bienSoXe = scanner.nextLine();
        System.out.print("nhập màu xe: ");
        String mauXe = scanner.nextLine();
        System.out.print("nhập nhãn hiệu: ");
        String label = scanner.nextLine();
        System.out.print("nhập trọng tải xe: ");
        int trongTai = Integer.parseInt(scanner.nextLine());

        super.setBienSo(bienSoXe);
        super.setMauXe(mauXe);
        super.setLabel(label);
        this.setTrongTai(trongTai);
    }

    @Override
    public String getInfo() {
        return super.getBienSo() + ";" + super.getMauXe() + ";" + super.getLabel() + ";" + this.getTrongTai();
    }

    @Override
    public long calcCar() {
        long price = 0;
        if (this.getTrongTai() < 3) {
            price = 15000;
        } else {
            price = 30000;
        }
        return price;
    }

    public int getTrongTai() {
        return trongTai;
    }

    public void setTrongTai(int trongTai) {
        this.trongTai = trongTai;
    }
}
