package managerMonster;

import fireMonster.FireMonster;
import monster.Monster;
import stoneMonster.StoneMonster;
import waterMonster.WaterMonster;

import java.util.Arrays;
import java.util.Scanner;

public class ManagerMonster {

    private int quantityMonster;
    Monster[] monsters = new Monster[100];

    public ManagerMonster() {
    }

    Scanner scanner = new Scanner(System.in);

    public void addFireMonster() {
        FireMonster fireMonster = new FireMonster();
        System.out.println("nhập tên fire monster: ");
        String name = scanner.nextLine();
        fireMonster.setName(name);
        for (int i = 0; i < this.quantityMonster; i++) {
            if (monsters[i] == null) {
                monsters[i] = fireMonster;
                break;
            }
        }
    }

    public void addWaterMonster() {
        WaterMonster waterMonster = new WaterMonster();
        System.out.println("nhập tên water monster: ");
        String name = scanner.nextLine();
        waterMonster.setName(name);
        for (int i = 0; i < this.quantityMonster; i++) {
            if (monsters[i] == null) {
                monsters[i] = waterMonster;
                break;
            }
        }
    }

    public void addStoneMonster() {
        StoneMonster stoneMonster = new StoneMonster();
        System.out.println("nhập tên stone monster: ");
        String name = scanner.nextLine();
        stoneMonster.setName(name);
        for (int i = 0; i < this.quantityMonster; i++) {
            if (monsters[i] == null) {
                monsters[i] = stoneMonster;
                break;
            }
        }
    }

    public void searchMonster(String name) {
        for (int i = 0; i < this.quantityMonster; i++) {
            if (monsters[i].getName().toUpperCase().trim().equals(name.toUpperCase().trim())) {
                monsters[i].attack();
            }
        }

    }

    public void callAttack() {
        for (int i = 0; i < this.quantityMonster; i++) {
            monsters[i].attack();
        }
    }

//    public void deleteMonster(String name) {
//        int indexMonster = -1;
//        for (int i = 0; i < quantityMonster; i++) {
//            if (monsters[i].getName().trim().toLowerCase().equals(name.trim().toLowerCase())) {
//                indexMonster = i;
//                System.out.println(indexMonster);
//            }
//        }
//        if (indexMonster != -1) {
//            Monster [] startMonster = Arrays.copyOf(monsters,indexMonster);
//            Monster [] endMonster = Arrays.copyOfRange(monsters,indexMonster + 1, quantityMonster);
//            Monster [] newMonster = Arrays.copyOf(startMonster,quantityMonster - 1);
//            System.arraycopy(endMonster,0,newMonster,startMonster.length,endMonster.length);
//            monsters = newMonster;
//            this.setQuantityMonster(newMonster.length);
//        }
//    }

    public void deleteMonster(String name) {
        int indexDelete = -1;
        for (int i = 0; i < quantityMonster; i++) {
            if (monsters[i].getName().equals(name)) {
                indexDelete = i;
            }
        }

        if (indexDelete != -1) {
            System.arraycopy(monsters, indexDelete + 1, monsters, indexDelete, monsters.length - indexDelete - 1);
            monsters = Arrays.copyOf(monsters,quantityMonster - 1);
            System.out.println("Delete Ok");
            this.setQuantityMonster(monsters.length);
        } else {
            System.out.println(" k ok ");
        }

    }

    public int getQuantityMonster() {
        return quantityMonster;
    }

    public void setQuantityMonster(int quantityMonster) {
        this.quantityMonster = quantityMonster;
    }

    public void managemnet() {
        boolean flag = true;
        while (flag) {
            System.out.println("chọn phương thức (1.thêm quái vật,2.tất cả cùng attack,3.tìm kiếm quái vật băng tên,4.xóa quái vật,0.để thoát)");
            int phuongThuc = Integer.parseInt(scanner.nextLine());
            switch (phuongThuc) {
                case 1:
                    System.out.println("nhập số lượng quái vật: ");
                    int quantity = Integer.parseInt(scanner.nextLine());
                    this.setQuantityMonster(quantity);
                    for (int i = 0; i < this.quantityMonster; i++) {
                        System.out.println("chọn quái vật: (1.fireMonster,2.waterMonster,3.stoneMonster");
                        int choice = Integer.parseInt(scanner.nextLine());
                        switch (choice) {
                            case 1:
                                this.addFireMonster();
                                break;
                            case 2:
                                this.addWaterMonster();
                                break;
                            case 3:
                                this.addStoneMonster();
                                break;
                            default:
                                i--;
                                break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("tất cả cùng attack: !!!!!!!!!!!!!!");
                    this.callAttack();
                    break;
                case 3:
                    System.out.print("nhập tên quái vật cần tìm kiếm: ");
                    String nameSearch = scanner.nextLine();
                    this.searchMonster(nameSearch);
                    break;
                case 4:
                    System.out.println("nhập quái vật cần xóa: ");
                    String nameDelete = scanner.nextLine();
                    this.deleteMonster(nameDelete);
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    break;
            }
        }
    }
}
