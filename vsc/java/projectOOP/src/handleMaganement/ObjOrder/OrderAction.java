package handleMaganement.ObjOrder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import HandleList.ListCustomer;
import handleMaganement.ObjBill.OrderItem;
import handleMaganement.ObjCustomer.Customer;
import handleMaganement.ObjEmployee.ManagerEmployee;

public class OrderAction {
    private ArrayList<OrderItem> menu = new ArrayList<>();
    ArrayList<Integer> quantities = new ArrayList<>();
    private ManagerEmployee managerEmployee = new ManagerEmployee();
    ArrayList<OrderItem> monsDaChon = new ArrayList<>();
    private static final String FILE_PATH_LISTBILL = "/home/huy/Documents/vsc/java/projectOOP/src/data/ListBill.txt";
    private static final String FILE_PATH_ORDERDETAILS = "/home/huy/Documents/vsc/java/projectOOP/src/data/orderDetails.txt";
    private static final String FILE_PATH_THONGKE = "/home/huy/Documents/vsc/java/projectOOP/src/data/ThongKe.txt";
    Customer customer = new Customer();
    ListCustomer listCustomer = new ListCustomer();

    public void writeToFileKhachHang() {
        listCustomer.readListCustomer();
        listCustomer.addCustomerToListBill();
    }

    public OrderAction() {
        themSanPhamVaoMenu(FILE_PATH_ORDERDETAILS);
    }

    public void displayProduct() {
        System.out.println("Thông tin về các món ");
        for (OrderItem orderItem : monsDaChon) {
            System.out.println(
                    "Mã sản phẩm: " + orderItem.getMaSanPham() + ", Ten san pham: " + orderItem.getTenSanPham() +
                            ", Ghi chú: " + orderItem.getGhiChu() + ", Đá: " + (orderItem.isCoDa() ? "Có" : "Không") +
                            ", Size: " + orderItem.getSize());
        }
    }

    public void thucHienChucNang() {
        hienThiMenu();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Bạn muốn dùng tại chỗ hay mang đi? (1. Tại chỗ / 2. Mang đi): ");
        int luaChonDungTaiCho = scanner.nextInt();
        customer.setCustomerType(luaChonDungTaiCho == 1);
        int checkSoLuong;
        int checkTongSoNuoc = 0;
        int i = 0;
        do {
            // Mảng để lưu thông tin về món nước đã chọn
            System.out.print("Vui lòng nhập nước cần gọi: ");
            int loaiMonNuoc = scanner.nextInt();
            OrderItem sanPham = menu.get(loaiMonNuoc - 1);

            // Kiểm tra có uống đá hay không
            System.out.print("Có uống đá không? (1. Có / 2. Không): ");
            int luaChonDa = scanner.nextInt();
            sanPham.setCoDa(luaChonDa == 1);

            // Kiểm tra có chọn size hay không
            if (sanPham.isCoSize()) {
                System.out.print("Chọn size (1. Nhỏ / 2. Vừa / 3. Lớn): ");
                int luaChonSize = scanner.nextInt();
                sanPham.setSize(getSizeFromChoice(luaChonSize));
            }

            // Nhập ghi chú cho món nước
            System.out.print("Nhập ghi chú cho món nước: ");
            scanner.nextLine(); // Đọc bỏ dòng trắng
            String ghiChu = scanner.nextLine();

            // Lưu thông tin vào mảng
            sanPham.setGhiChu(ghiChu);
            monsDaChon.add(sanPham);

            System.out.print("Bạn muốn gọi thêm nước không? (Nhấn 1 để tiếp tục, Nhấn 0 để kết thúc): ");
            checkSoLuong = scanner.nextInt();
        } while (checkSoLuong == 1);

        // Kiểm tra xem số lượng có hợp lệ khôn

        System.out.println("Thông tin về các món đã chọn:");
        for (OrderItem orderItem : monsDaChon) {
            System.out.println("Món: " + orderItem.getTenSanPham() + ", Loại: " +
                    orderItem.getLoai() + ", Giá: "
                    + orderItem.getGia() + " VND, Ghi chú: " + orderItem.getGhiChu() +
                    ", Size: " + orderItem.getSize() + ", Đá: " + (orderItem.isCoDa() ? "Có" : "Không"));
        }
        writeToFileKhachHang();
        // OrderEmployee orderEmployee = new OrderEmployee();
        // orderEmployee.createBill(customer, monsDaChon, quantities);
        luuDonDatHang();
    }

    // }
    private void themSanPhamVaoMenu(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] attributes = line.split(";");

                // Make sure the attributes array has at least 9 elements
                if (attributes.length >= 9) {
                    String maSanPham = attributes[0].trim();
                    String tenSanPham = attributes[1].trim();
                    String loai = attributes[2].trim();
                    int gia = Integer.parseInt(attributes[3].trim());
                    boolean coDa = Boolean.parseBoolean(attributes[4].trim());
                    String moTaDa = attributes[5].trim();
                    boolean coSize = Boolean.parseBoolean(attributes[6].trim());
                    String size = attributes[7].trim();
                    String ghiChu = attributes[8].trim();

                    OrderItem orderItem = new OrderItem(maSanPham, tenSanPham, loai, gia, ghiChu, coDa, moTaDa, coSize,
                            size);
                    menu.add(orderItem);
                } else {
                    // Handle the case where the attributes array does not have enough elements
                    System.out.println("Invalid data format: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void luuDonDatHang() {
        try (BufferedWriter writerOrderDetails = new BufferedWriter(
                new FileWriter(FILE_PATH_THONGKE, true));
                BufferedWriter writerListBill = new BufferedWriter(
                        new FileWriter(FILE_PATH_LISTBILL, true))) {

            for (OrderItem orderItem : monsDaChon) {
                // Ghi thông tin chi tiết đơn hàng vào file ORDERDETAILS
                writerOrderDetails.write("Mã sản phẩm: " + orderItem.getMaSanPham() +
                        ", Ten san pham: " + orderItem.getTenSanPham() +
                        ", Đá: " + (orderItem.isCoDa() ? "Có" : "Không") +
                        ", Size: " + orderItem.getSize() +
                        ", Ghi chú: " + orderItem.getGhiChu() +
                        ", Ngày đặt hàng: " + LocalDate.now() + "\n");

                // Ghi thông tin chi tiết đơn hàng vào file LISTBILL
                writerListBill.write("Mã sản phẩm: " + orderItem.getMaSanPham() +
                        ", Ten san pham: " + orderItem.getTenSanPham() +
                        ", Đá: " + (orderItem.isCoDa() ? "Có" : "Không") +
                        ", Size: " + orderItem.getSize() +
                        ", Ghi chú: " + orderItem.getGhiChu() + "\n");
            }
            monsDaChon.clear();
            System.out.println("Thông tin đơn đặt hàng đã được lưu.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void hienThiMenu() {
        System.out.println("Menu:");

        for (int i = 0; i < menu.size(); i++) {
            OrderItem orderItem = (OrderItem) menu.get(i); // Ép kiểu sang OrderItem
            System.out.println((i + 1) + ". " + orderItem.getTenSanPham() + " - " +
                    orderItem.getLoai() + " - "
                    + orderItem.getGia() + " VND");
        }
    }

    private static String getSizeFromChoice(int choice) {
        switch (choice) {
            case 1:
                return "Nhỏ";
            case 2:
                return "Vừa";
            case 3:
                return "Lớn";
            default:
                return "Nhỏ"; // Hoặc giá trị mặc định khác tùy theo yêu cầu của bạn
        }
    }

}
