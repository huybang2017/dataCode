package handleMaganement.ObjOrder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*2. Thực đơn của quán bao gồm 4 loại nước uống chính: Trà sữa, cà phê, sinh
tố và nước trái cây.
3. Sản phẩm: Mỗi loại nước uống có nhiều lựa chọn gọi là sản phẩm của quán
ví dụ Trà sửa có Trà sữa đường đen, trà sữa trân châu, hồng trà, trà đào, Trà
chanh,...Nước trái cây có nước ép táo, nước ép thơm,...Mỗi sản phẩm có giá
riêng.
Mỗi sản phẩm có thể uống đá hoặc không đá nhưng phụ thuộc vào từng sản
phẩm. ví dụ cà phê có thể uống đá hoặc không nhưng trà sữa trân châu hoặc
Trà sữa đường đen thì chỉ cung cấp 1 loại là uống với đá.
Mỗi phần sẽ có 3 cỡ: cỡ nhỏ, vừa và lớn.
 */

import java.util.ArrayList;
import java.util.Scanner;

import handleMaganement.ObjCustomer.Customer;
import handleMaganement.ObjEmployee.ManagerEmployee;
import handleMaganement.ObjEmployee.OrderEmployee;

public class QuanNuoc {

	// Tạo danh sách sản phẩm
	private ArrayList<SanPham> menu = new ArrayList<>();
	private ManagerEmployee managerEmployee = new ManagerEmployee();
	ArrayList<Integer> quantities = new ArrayList<>();
	ArrayList<SanPham> monsDaChon = new ArrayList<>();
	Customer customer = new Customer();
	// private OrderEmployee orderEmployee = new OrderEmployee() ;

	public QuanNuoc() {
		// Constructor - Thêm các sản phẩm vào menu ở đây
		themSanPhamVaoMenu("/Users/m1lt43/Desktop/HuyUupdate/src/data/SanPham.txt");
	}

	public void thucHienChucNang() {
		hienThiMenu();
		// Nhập số lượng món nước cần gọi
		Scanner scanner = new Scanner(System.in);
		System.out.print("Bạn muốn dùng tại chỗ hay mang đi? (1. Tại chỗ / 2. Mang đi): ");
		int luaChonDungTaiCho = scanner.nextInt();
		customer.setCustomerType(luaChonDungTaiCho == 1);
		System.out.print("Nhập tổng số lượng nước bạn muốn gọi: ");
		int tongSoLuong = scanner.nextInt();

		int checkSoLuong;
		int checkTongSoNuoc = 0;
		int i = 0;
		do {
			// Mảng để lưu thông tin về món nước đã chọn
			System.out.print("Nhập số lượng món nước bạn muốn gọi: ");
			int SoLuong = scanner.nextInt();
			quantities.add(SoLuong);
			checkTongSoNuoc += SoLuong;
			System.out.print("Nhập loại món nước thứ " + (i + 1) + ": ");
			int loaiMonNuoc = scanner.nextInt();

			// Kiểm tra xem loại món có tồn tại trong menu không
			if (loaiMonNuoc >= 1 && loaiMonNuoc <= menu.size()) {
				SanPham sanPham = menu.get(loaiMonNuoc - 1);

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
				if (checkTongSoNuoc >= tongSoLuong) {
					break;
				}
			} else {
				System.out.println("Loại món nước không hợp lệ.");
				return;
			}
			i++;
			System.out.println("bạn muốn gọi nước nữa không ? (nhấn 1 là có nhấn 0 là hủy)");
			checkSoLuong = Integer.parseInt(scanner.nextLine());
		} while (checkSoLuong == 1);

		// Kiểm tra xem số lượng có hợp lệ không
		if (tongSoLuong <= 0) {
			System.out.println("Số lượng không hợp lệ.");
			return;
		}

		// // Mảng để lưu thông tin về món nước đã chọn
		// SanPham[] monsDaChon = new SanPham[soLuong];
		//
		// // Nhập loại món nước cụ thể
		// for (int i = 0; i < soLuong; i++) {
		// System.out.print("Nhập loại món nước thứ " + (i + 1) + ": ");
		// int loaiMonNuoc = scanner.nextInt();
		//
		// // Kiểm tra xem loại món có tồn tại trong menu không
		// if (loaiMonNuoc >= 1 && loaiMonNuoc <= menu.size()) {
		// SanPham sanPham = menu.get(loaiMonNuoc - 1);
		//
		// // Kiểm tra có uống đá hay không
		// System.out.print("Có uống đá không? (1. Có / 2. Không): ");
		// int luaChonDa = scanner.nextInt();
		// sanPham.setCoDa(luaChonDa == 1);
		//
		// // Kiểm tra có chọn size hay không
		// if (sanPham.isCoSize()) {
		// System.out.print("Chọn size (1. Nhỏ / 2. Vừa / 3. Lớn): ");
		// int luaChonSize = scanner.nextInt();
		// sanPham.setSize(getSizeFromChoice(luaChonSize));
		// }
		//
		// // Nhập ghi chú cho món nước
		// System.out.print("Nhập ghi chú cho món nước: ");
		// scanner.nextLine(); // Đọc bỏ dòng trắng
		// String ghiChu = scanner.nextLine();
		//
		// // Lưu thông tin vào mảng
		// sanPham.setGhiChu(ghiChu);
		// monsDaChon[i] = sanPham;
		// } else {
		// System.out.println("Loại món nước không hợp lệ.");
		// return;
		// }
		// }

		// Hiển thị thông tin về các món đã chọn
		System.out.println("Thông tin về các món đã chọn:");

		for (SanPham sanPham : monsDaChon) {
			// System.out.println("Món: " + sanPham.getTenSanPham() + ", Loại: " +
			// sanPham.getLoai() + ", Giá: "
			// + sanPham.getGia() + " VND, Ghi chú: " + sanPham.getGhiChu() + ", Size: " +
			// sanPham.getSize()
			// + ", Đá: " + (sanPham.getCoDa() ? "Có" : "Không"));
			System.out.println(sanPham.getGia());
		}
		customer.createOrder();
		customer.InfoCustomer();
		OrderEmployee orderEmployee = new OrderEmployee();
		orderEmployee.createBill(customer, monsDaChon, quantities);
	}
	//
	// orderManager.addOrder(new Order(monsDaChon));

	private void themSanPhamVaoMenu(String fileName) {
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] attributes = line.split(",");

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

					SanPham sanPham = new SanPham();
					sanPham.setMaSanPham(maSanPham);
					sanPham.setTenSanPham(tenSanPham);
					sanPham.setLoai(loai);
					sanPham.setGia(gia);
					sanPham.setCoDa(coDa);
					sanPham.setMoTaDa(moTaDa);
					sanPham.setCoSize(coSize);
					sanPham.setSize(size);
					sanPham.setGhiChu(ghiChu);
					menu.add(sanPham);
				} else {
					// Handle the case where the attributes array does not have enough elements
					System.out.println("Invalid data format: " + line);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void hienThiMenu() {
		System.out.println("Menu:");

		for (int i = 0; i < menu.size(); i++) {
			SanPham sanPham = menu.get(i);
			System.out.println((i + 1) + ". " + sanPham.getTenSanPham() + " - " + sanPham.getLoai() + " - "
					+ sanPham.getGia() + " VND");
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