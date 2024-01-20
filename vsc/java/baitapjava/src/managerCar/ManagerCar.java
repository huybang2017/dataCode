package managerCar;

import bus.Bus;
import car.Car;
import container.Container;

import java.util.Scanner;

public class ManagerCar {
    Car[] car = new Car[100];
    private int quantityCar;

    public ManagerCar() {
    }

    public int getQuantityCar() {
        return quantityCar;
    }

    public void setQuantityCar(int quantityCar) {
        this.quantityCar = quantityCar;
    }

    public void addBus() {
        Bus bus = new Bus();
        bus.inuptCar();
        for (int i = 0; i < this.quantityCar; i++) {
            if(car[i] == null){
                car[i] = bus;
                break;
            }
        }
    }

    public void addContainer() {
        Container container = new Container();
        container.inuptCar();
        for (int i = 0; i < this.quantityCar; i++) {
            if(car[i] == null){
                car[i] = container;
                break;
            }
        }
    }

    public long priceTotal() {
        long price = 0;
        for (int i = 0; i < this.quantityCar; i++) {
            price += car[i].calcCar();
        }
        return price;
    }

    public void management() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhập số lượng xe");
        int quantity = Integer.parseInt(scanner.nextLine());
        this.setQuantityCar(quantity);
        for (int i = 0; i < this.getQuantityCar(); i++) {
                System.out.println("chọn xe (1.xe buýt) / (2.xe tải)");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice){
                    case 1:
                        this.addBus();
                        break;
                    case 2:
                        this.addContainer();
                        break;
                    default:
                        i--;
                        System.out.println("nhập sai định dạng");
                }
        }
    }
}
