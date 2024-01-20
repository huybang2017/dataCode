package MainCore;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import HandleList.ListEmployee;
import HandleList.ListProduct;
import handleMaganement.ObjOrder.QuanNuoc;
import handleMaganement.ObjOrder.SanPham;
import handleMaganement.ObjTable.TableMenu;

public class CoffeeShopManagement {
    public void CoffeeMenu() {
        Scanner scanner = new Scanner(System.in);
        QuanNuoc quannuoc = new QuanNuoc();
        // ListEmployee listEmployee = new ListEmployee();

        boolean flag = true;
        do {
            System.out.println("+---------------------------------------------+");
            System.out.println("|        Hệ thống quản lý nhà hàng            |");
            System.out.println("| -------------------=====--------------------|");
            System.out.println("| 1. Quản lý bàn                              |");
            System.out.println("| 2. Quản lý thực đơn                         |");
            System.out.println("| 3. Quản lý sản phẩm                         |");
            System.out.println("| 4. Quản lý khách hàng                       |");
            System.out.println("| 5. Quản lý nhân viên                        |");
            System.out.println("| 6. Đặt đơn và tính tiền                     |");
            System.out.println("| 7. Món thêm                                 |");
            System.out.println("| 8. Đăng kí thành viên                       |");
            System.out.println("| 9. Thống kê và báo cáo                      |");
            System.out.println("| 10. Thoát                                   |");
            System.out.println("+---------------------------------------------+");

            System.out.print("Mời bạn chọn trong các menu trên: ");
            System.out.print("Mời bạn chọn: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    TableMenu tableMenu = new TableMenu();
                    tableMenu.callBackTable();
                    break;

                case 2:
                    quannuoc.thucHienChucNang();
                    break;
                case 3:
                    listProduct();
                    break;
                case 4:
                    // Code quản lý khách hàng
                    break;
                case 5:
                    // quan li nhan vien
                    System.out.println("Ban chon danh sach nhan vien");
                    listEmployee();

                    break;
                case 6:
                    // Code đặt đơn và tính tiền
                    break;
                case 7:
                    // Code món thêm
                    break;
                case 8:
                    // Code đăng kí thành viên
                    break;
                case 9:
                    // Code thống kê và báo cáo
                    break;
                case 10:
                    System.out.println("Tạm biệt!");
                    flag = false;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Mời bạn chọn lại.");
                    break;
            }
        } while (flag);
    }

    public void listEmployee() {
        Matcher matcher;
        String selectTemp;
        int select;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("+---------------------------------------------+");
            System.out.println("|              Danh sach nhan vien            |");
            System.out.println("| -------------------=====--------------------|");
            System.out.println("| 1. Them thong tin nhan vien                 |");
            System.out.println("| 2. Sua thong tin nhan vien                  |");
            System.out.println("| 3. Xoa thong tin nhan vien                  |");
            System.out.println("| 4. Tim kiem thong tin nhan vien             |");
            System.out.println("| 5. Xuat thong tin nhan vien                 |");
            System.out.println("| 0. Tro ve                                   |");
            System.out.println("+---------------------------------------------+");

            do {
                System.out.print("Nhap lua chon: ");
                selectTemp = sc.nextLine();
                String s = "^[0-9]{1}";
                Pattern pattern = Pattern.compile(s);
                matcher = pattern.matcher(selectTemp);
            } while (!matcher.find());
            select = Integer.parseInt(selectTemp);
            ListEmployee listEmployee = new ListEmployee();
            listEmployee.readListEmployee();

            switch (select) {
                case 1:
                    System.out.println("Ban chon them thong tin nhan vien");
                    listEmployee.add();
                    break;
                case 2:
                    System.out.println("Ban chon sua thong tin nhan vien");
                    listEmployee.edit();
                    break;
                case 3:
                    System.out.println("Ban chon xoa thong tin nhan vien");
                    listEmployee.remove();
                    break;
                case 4:
                    System.out.println("Ban chon tim kiem thong tin nhan vien");
                    listEmployee.find();
                    break;
                case 5:
                    System.out.println("Ban chon xuat thong tin nhan vien");
                    listEmployee.display();
                    break;
                case 0:
                    System.out.println("Tro ve");
                    break;
                default:
                    System.out.println("Lua chon loi! Vui long chon lai");
                    break;
            }

        } while (select != 0);

    }

    public void listProduct() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("+----------------------------------------------+");
            System.out.println("|            Quản lý sản phẩm                  |");
            System.out.println("| -------------------=====---------------------|");
            System.out.println("| 1. Hiển thị danh sách sản phẩm               |");
            System.out.println("| 2. Thêm sản phẩm                             |");
            System.out.println("| 3. Sửa thông tin sản phẩm                    |");
            System.out.println("| 4. Xóa sản phẩm                              |");
            System.out.println("| 5. Tìm kiếm sản phẩm                         |");
            System.out.println("| 0. Quay lại                                  |");
            System.out.println("+----------------------------------------------+");

            System.out.print("Mời bạn chọn: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    ListProduct listProduct = new ListProduct();
                    ArrayList<SanPham> productList = listProduct.getProductList();

                    // In ra danh sách sản phẩm để kiểm tra
                    for (SanPham sanPham : productList) {
                        System.out.println(sanPham);
                    }
                    break;
                case 2:
                    // Thêm sản phẩm
                    ListProduct listProduct1 = new ListProduct();

                    // Nhập thông tin mới từ người dùng
                    System.out.print("Nhập mã sản phẩm mới: ");
                    String maSanPham = scanner.nextLine();
                    System.out.print("Nhập tên sản phẩm mới: ");
                    String tenSanPham = scanner.nextLine();
                    System.out.print("Nhập loại sản phẩm mới: ");
                    String loai = scanner.nextLine();
                    System.out.print("Nhập giá sản phẩm mới: ");
                    int gia = scanner.nextInt();
                    scanner.nextLine(); // Đọc dòng trống
                    System.out.print("Có đá hay không (true/false): ");
                    boolean coDa = scanner.nextBoolean();
                    scanner.nextLine(); // Đọc dòng trống
                    System.out.print("Mô tả đá mới: ");
                    String moTaDa = scanner.nextLine();
                    System.out.print("Có size hay không (true/false): ");
                    boolean coSize = scanner.nextBoolean();
                    scanner.nextLine(); // Đọc dòng trống
                    System.out.print("Nhập size mới: ");
                    String size = scanner.nextLine();
                    System.out.print("Ghi chú mới: ");
                    String ghiChu = scanner.nextLine();

                    // Tạo một đối tượng SanPham mới
                    SanPham newProduct = new SanPham();
                    newProduct.setMaSanPham(maSanPham);
                    newProduct.setTenSanPham(tenSanPham);
                    newProduct.setLoai(loai);
                    newProduct.setGia(gia);
                    newProduct.setCoDa(coDa);
                    newProduct.setMoTaDa(moTaDa);
                    newProduct.setCoSize(coSize);
                    newProduct.setSize(size);
                    newProduct.setGhiChu(ghiChu);

                    // Thêm sản phẩm mới và ghi vào tệp
                    listProduct1.addProduct(newProduct);
                    break;
                case 3:
                    // Sửa thông tin sản phẩm
                    System.out.println("Nhập mã sản phẩm bạn muốn sửa:");
                    String maSanPhamToEdit = scanner.nextLine();
                    ListProduct listProduct2 = new ListProduct();
                    listProduct2.updateProduct(maSanPhamToEdit);
                    break;
                case 4:
                    // Xóa sản phẩm
                    System.out.println("nhập mã sản phảm bạn muốn xóa");
                    String maSanPham1 = scanner.nextLine();
                    ListProduct listProduct3 = new ListProduct();
                    listProduct3.removeProduct(maSanPham1);
                    break;
                case 5:
                    // Tìm kiếm sản phẩm
                    System.out.println("nhập mã sản phảm bạn muốn tìm kiếm");
                    String maSanPham2 = scanner.nextLine();
                    ListProduct listProduct4 = new ListProduct();
                    SanPham foundProduct = listProduct4.findProductById(maSanPham2);
                    if (foundProduct != null) {
                        System.out.println("Thông tin sản phẩm: " + foundProduct);
                    }
                    break;
                case 0:
                    // Quay lại
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Mời bạn chọn lại.");
                    break;
            }
        } while (choice != 0);
    }
}
