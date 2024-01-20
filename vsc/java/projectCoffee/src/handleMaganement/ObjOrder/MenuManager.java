
package handleMaganement.ObjOrder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuManager {
    private ArrayList<SanPham> menu;
    Scanner scanner = new Scanner(System.in);

    public MenuManager() {
        this.menu = new ArrayList<>();
        // Khởi tạo menu và thêm các sản phẩm vào đây
        docTuTapTin("/Users/m1lt43/Desktop/HuyUupdate/SanPham.txt");
    }

    public ArrayList<SanPham> getMenu() {
        return menu;
    }

    public void docTuTapTin(String tenTapTin) {
        File file = new File(tenTapTin);
        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.replaceAll("\"", "").split(", ");

                if (parts.length == 7 || parts.length == 8) {
                    SanPham sanPham = new SanPham();
                    sanPham.setTenSanPham(parts[0]);
                    sanPham.setLoai(parts[1]);
                    sanPham.setGia(Integer.parseInt(parts[2]));
                    sanPham.setCoDa(Boolean.parseBoolean(parts[3]));
                    sanPham.setMoTaDa(parts[4]);
                    sanPham.setCoSize(Boolean.parseBoolean(parts[5]));
                    sanPham.setSize(parts[6]);

                    if (parts.length == 8) {
                        sanPham.setGhiChu(parts[7]);
                    }

                    menu.add(sanPham);
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
