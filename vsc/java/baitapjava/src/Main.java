import managerCar.ManagerCar;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ManagerCar managerCar = new ManagerCar();
        managerCar.management();
        System.out.println("tổng tiền qua trạm là: " + managerCar.priceTotal());
    }
}