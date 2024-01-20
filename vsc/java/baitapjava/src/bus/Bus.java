package bus;

import car.Car;

import java.util.Scanner;

public class Bus extends Car {
    private int tuyenXeBus;
    private int lengthTrip;

    @Override
    public void inuptCar() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("nhập biển số xe: ");
        String bienSoXe = scanner.nextLine();
        System.out.print("nhập màu xe: ");
        String mauXe = scanner.nextLine();
        System.out.print("nhập nhãn hiệu: ");
        String label = scanner.nextLine();
        System.out.print("nhập số tuyến xe bus: ");
        int tuyenXeBus = Integer.parseInt(scanner.nextLine());
        System.out.print("nhập độ dài lộ trình: ");
        int lengthTrip = Integer.parseInt(scanner.nextLine());


        this.setTuyenXeBus(tuyenXeBus);
        this.setLengthTrip(lengthTrip);
    }

    @Override
    public String getInfo() {
        return super.getBienSo() + ";" + super.getMauXe() + ";" + super.getLabel() + ";" + this.getTuyenXeBus() + ";" + this.getLengthTrip();
    }

    @Override
    public long calcCar() {
        long price = 0;
        if (this.lengthTrip > 20) {
            price = 10000;
        } else {
            price = 5000;
        }
        return price;
    }

    public Bus(int tuyenXeBus, int lengthTrip) {
        this.tuyenXeBus = tuyenXeBus;
        this.lengthTrip = lengthTrip;
    }

    public Bus() {
    }

    public Bus(String bienSo, String mauXe, String label, int tuyenXeBus, int lengthTrip) {
        super(bienSo, mauXe, label);
        this.tuyenXeBus = tuyenXeBus;
        this.lengthTrip = lengthTrip;
    }

    public int getTuyenXeBus() {
        return tuyenXeBus;
    }

    public void setTuyenXeBus(int tuyenXeBus) {
        this.tuyenXeBus = tuyenXeBus;
    }

    public int getLengthTrip() {
        return lengthTrip;
    }

    public void setLengthTrip(int lengthTrip) {
        this.lengthTrip = lengthTrip;
    }
}
