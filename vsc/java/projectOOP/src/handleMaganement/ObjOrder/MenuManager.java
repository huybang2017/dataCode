
package handleMaganement.ObjOrder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import handleMaganement.ObjBill.OrderItem;

public class MenuManager {
    private ArrayList<OrderItem> menu;
    Scanner scanner = new Scanner(System.in);

    public MenuManager() {
        this.menu = new ArrayList<>();
        // Khởi tạo menu và thêm các sản phẩm vào đây
        docTuTapTin("/home/huy/Documents/vsc/java/projectOOP/src/data/OrderDetails.txt");
    }

    public ArrayList<OrderItem> getMenu() {
        return menu;
    }

    public void docTuTapTin(String tenTapTin) {
        File file = new File(tenTapTin);
        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.replaceAll("\"", "").split(", ");

                if (parts.length == 7 || parts.length == 8) {
                    OrderItem OrderItem = new OrderItem();
                    OrderItem.setTenSanPham(parts[0]);
                    OrderItem.setLoai(parts[1]);
                    OrderItem.setGia(Integer.parseInt(parts[2]));
                    OrderItem.setCoDa(Boolean.parseBoolean(parts[3]));
                    OrderItem.setMoTaDa(parts[4]);
                    OrderItem.setCoSize(Boolean.parseBoolean(parts[5]));
                    OrderItem.setSize(parts[6]);

                    if (parts.length == 8) {
                        OrderItem.setGhiChu(parts[7]);
                    }

                    menu.add(OrderItem);
                } else {
                    System.out.println("Dữ liệu không hợp lệ: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Các phương thức khác ở đây
}
