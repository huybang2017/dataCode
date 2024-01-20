package handleMaganement.ObjCustomer;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import handleMaganement.Person;
import handleMaganement.ObjOrder.SanPham;

public class Customer extends Person {
    private boolean isMember;
    private int birthMonth;
    private boolean discount;
    private boolean customerType;
    private ArrayList<SanPham> order;

    public Customer() {

    }

    public Customer(String name, String telephoneNumber, int age, String address, String gender, boolean isMember,
            int birthMonth, boolean discount, boolean customerType, ArrayList<SanPham> order) {
        super(name, telephoneNumber, age, address, gender);
        this.isMember = isMember;
        this.birthMonth = birthMonth;
        this.discount = discount;
        this.customerType = customerType;
        this.order = order;
    }

    public boolean isMember() {
        return isMember;
    }

    public void setMember(boolean isMember) {
        this.isMember = isMember;
    }

    public int getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    }

    public boolean isDiscount() {
        return discount;
    }

    public void setDiscount(boolean discount) {
        this.discount = discount;
    }

    public boolean isCustomerType() {
        return customerType;
    }

    public void setCustomerType(boolean customerType) {
        this.customerType = customerType;
    }

    public ArrayList<SanPham> getOrder() {
        return order;
    }

    public void setOrder(ArrayList<SanPham> order) {
        this.order = order;
    }

    public void receiveOrder() {
        System.out.println("Nhân viên " + getName() + " đang nhận đơn hàng từ khách hàng.");
        createOrder();
    }

    public void createOrder() {
        Scanner scanner = new Scanner(System.in);
        Customer customer = new Customer();
        System.out.println("Nhập thông tin đơn hàng:");

        // Nhập thông tin về khách hàng
        System.out.print("Bạn có muốn đăng ký thành viên không? (1. Có / 2. Không): ");
        int choice = scanner.nextInt();
        boolean isMember = choice == 1;

        if (isMember) {
            System.out.print("Nhập tháng sinh nhật của bạn (1-12): ");
            int birthMonth = scanner.nextInt();
            this.setBirthMonth(birthMonth);
            this.setMember(isMember);
        } else {
            this.setMember(false);
        }
        // System.out.print("Nhập số lượng sản phẩm trong đơn hàng: ");
        //
        // int numberOfProducts = scanner.nextInt();
        //
        // for (int i = 0; i < numberOfProducts; i++) {
        // System.out.println("Nhập thông tin cho sản phẩm thứ " + (i + 1) + ":");
        // SanPham sanPham = createProduct();
        // order.add(sanPham); // Thêm sản phẩm vào đơn hàng của khách hàng
        // }
        System.out.println("Đơn hàng đã được tạo!");
    }

    public SanPham createProduct() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập mã sản phẩm: ");
        String maSanPham = scanner.next();

        System.out.print("Nhập tên sản phẩm: ");
        String tenSanPham = scanner.next();

        System.out.print("Nhập loại sản phẩm: ");
        String loai = scanner.next();

        System.out.print("Nhập giá sản phẩm: ");
        int gia = scanner.nextInt();

        System.out.print("Có đá hay không? (true/false): ");
        boolean coDa = scanner.nextBoolean();

        // Additional variables assumed to be used in the constructor of SanPham
        System.out.print("Nhập mô tả đá: ");
        String moTaDa = scanner.next();

        System.out.print("Có size hay không? (true/false): ");
        boolean coSize = scanner.nextBoolean();

        String size = "nhỏ"; // Default value for size
        if (coSize) {
            System.out.print("Nhập size: ");
            size = scanner.nextLine();
        }

        System.out.print("Nhập ghi chú: ");
        String ghiChu = scanner.next();

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
        // Tạo đối tượng SanPham và trả về
        return sanPham;
    }

    public void InfoCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập thông tin đơn hàng:");

        // Nhập thông tin về khách hàng
        System.out.print("Nhập tên khách hàng: ");
        String customerName = scanner.nextLine();

        // Kiểm tra tên khách hàng không được để trống
        while (customerName.trim().isEmpty()) {
            System.out.println("Tên khách hàng không được để trống. Vui lòng nhập lại.");
            System.out.print("Nhập tên khách hàng: ");
            customerName = scanner.nextLine();
        }

        System.out.print("Nhập số điện thoại: ");
        String customerPhoneNumber = scanner.nextLine();

        // Kiểm tra số điện thoại có đúng định dạng không
        while (!customerPhoneNumber.matches("\\d{10}")) {
            System.out.println("Số điện thoại không hợp lệ. Vui lòng nhập lại (10 chữ số).");
            System.out.print("Nhập số điện thoại: ");
            customerPhoneNumber = scanner.nextLine();
        }

        System.out.print("Nhập tuổi: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Tuổi phải là một số. Vui lòng nhập lại.");
            System.out.print("Nhập tuổi: ");
            scanner.next(); // Đọc bỏ giá trị không phải số để tránh lặp vô hạn
        }
        int age = scanner.nextInt();

        // Kiểm tra tuổi phải lớn hơn 0
        while (age <= 0) {
            System.out.println("Tuổi phải lớn hơn 0. Vui lòng nhập lại.");
            System.out.print("Nhập tuổi: ");
            age = scanner.nextInt();
        }

        // Tiêu thụ ký tự mới (new line) còn lại
        scanner.nextLine();

        System.out.print("Nhập địa chỉ: ");
        String address = scanner.nextLine();

        // Kiểm tra địa chỉ không được để trống
        while (address.trim().isEmpty()) {
            System.out.println("Địa chỉ không được để trống. Vui lòng nhập lại.");
            System.out.print("Nhập địa chỉ: ");
            address = scanner.nextLine();
        }

        System.out.print("Nhập giới tính: ");
        String gender = scanner.nextLine();

        // Kiểm tra giới tính không được để trống
        while (gender.trim().isEmpty()) {
            System.out.println("Giới tính không được để trống. Vui lòng nhập lại.");
            System.out.print("Nhập giới tính: ");
            gender = scanner.nextLine();
        }

        // Hiển thị thông tin khách hàng
        // System.out.println("\nThông tin khách hàng:");
        // System.out.println("Tên: " + customerName);
        // System.out.println("Số điện thoại: " + customerPhoneNumber);
        // System.out.println("Tuổi: " + age);
        // System.out.println("Địa chỉ: " + address);
        // System.out.println("Giới tính: " + gender);
        System.out.println("+-------------------------------------------------------+");
        System.out.println("|                Thông Tin Khách Hàng                   |");
        System.out.println("+-------------------------------------------------------+");

        System.out.printf("| %-20s | %-30s |\n", "Tên", customerName);
        System.out.printf("| %-20s | %-30s |\n", "Số Điện Thoại", customerPhoneNumber);
        System.out.printf("| %-20s | %-30s |\n", "Tuổi", age);
        System.out.printf("| %-20s | %-30s |\n", "Địa Chỉ", address);
        System.out.printf("| %-20s | %-30s |\n", "Giới Tính", gender);

        System.out.println("+-------------------------------------------------------+");
        // Cập nhật thông tin của khách hàng hiện tại
        this.setName(customerName);
        this.setAddress(address);
        this.setGender(gender);
        this.setTelephoneNumber(customerPhoneNumber);
        this.setAge(age);
    }

    public void applyDiscount(double totalAmount) {
        if (isMember() && getBirthMonth() == Calendar.getInstance().get(Calendar.MONTH) + 1) {
            // Nếu là thành viên và là tháng sinh nhật, giảm 10%
            double discountAmount = totalAmount * 0.1;
            setDiscount(discount);(discountAmount);
            System.out.println("Bạn đã được giảm giá " + discountAmount + " VND.");
        } else {
            System.out.println("Không có giảm giá nào được áp dụng.");
        }
    }

}
