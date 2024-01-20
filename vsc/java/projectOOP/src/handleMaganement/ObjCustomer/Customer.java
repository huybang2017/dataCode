package handleMaganement.ObjCustomer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import handleMaganement.Person;
import handleMaganement.ObjOrder.SanPham;

public class Customer extends Person {
    private String maKH;
    private boolean customerType; // true for member, false for non-member
    private int birthMonth;
    private double discount;
    private ArrayList<SanPham> order;

    public Customer() {
        // Default constructor
    }

    public Customer(String maKH, String name, String telephoneNumber, int age, String address, String gender,
            boolean customerType, int birthMonth, Double discount, ArrayList<SanPham> order) {
        super(name, telephoneNumber, age, address, gender);
        this.maKH = maKH;
        this.customerType = customerType;
        this.birthMonth = birthMonth;
        this.discount = discount;
        this.order = order;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public boolean isCustomerType() {
        return customerType;
    }

    public void setCustomerType(boolean customerType) {
        this.customerType = customerType;
    }

    public int getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
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
        if (choice == 2) {
            return;
        }
        if (isMember) {
            System.out.print("Nhập tháng sinh nhật của bạn (1-12): ");
            int birthMonth = scanner.nextInt();
            this.setBirthMonth(birthMonth);
            this.setCustomerType(isMember);
        } else {
            this.setCustomerType(isMember);
        }

        InfoCustomer();
        System.out.println("thực hiện thành công!!");
    }

    public String generateRandomMaKH() {
        // Tạo một số ngẫu nhiên từ 10 đến Integer.MAX_VALUE
        int randomNumber = (int) (Math.random() * (Integer.MAX_VALUE - 10)) + 10;

        // Kết hợp số ngẫu nhiên với tiền tố "KH"
        String maKH = "KH" + randomNumber;

        // Return the generated MaKH
        return maKH;
    }

    public void InfoCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập thông tin đơn hàng:");

        // Tạo mới mã khách hàng
        String maKh = generateRandomMaKH();
        System.out.println("Mã khách hàng mới: " + maKh);
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

        scanner.nextLine();

        System.out.print("Nhập tháng sinh: ");
        while (!scanner.hasNextInt()) {
            System.out.println("tháng sinh phải là một số. Vui lòng nhập lại.");
            System.out.print("Nhập tháng sinh: ");
        }
        int monthBirthday = Integer.parseInt(scanner.nextLine());

        // Kiểm tra tuổi phải lớn hơn 0
        while (monthBirthday <= 0 || monthBirthday >= 13) {
            System.out.println("Tháng sinh phải lớn hơn 0 và bé hơn 13. Vui lòng nhập lại.");
            System.out.print("Nhập tháng sinh: ");
            monthBirthday = Integer.parseInt(scanner.nextLine());
        }

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

        System.out.println("+-------------------------------------------------------+");
        System.out.println("|                Thông Tin Khách Hàng                   |");
        System.out.println("+-------------------------------------------------------+");

        System.out.printf("| %-20s | %-30s |\n", "Mã KH", maKh);
        System.out.printf("| %-20s | %-30s |\n", "Tên", customerName);
        System.out.printf("| %-20s | %-30s |\n", "Số Điện Thoại", customerPhoneNumber);
        System.out.printf("| %-20s | %-30s |\n", "Tuổi", age);
        System.out.printf("| %-20s | %-30s |\n", "Địa Chỉ", address);
        System.out.printf("| %-20s | %-30s |\n", "Giới Tính", gender);
        System.out.printf("| %-20s | %-30s |\n", "Loại Khách Hàng",
                isCustomerType() ? "Thành Viên" : "Không Thành Viên");
        System.out.printf("| %-20s | %-30s |\n", "Tháng Sinh Nhật", monthBirthday);
        System.out.printf("| %-20s | %-30s |\n", "Giảm Giá", isCustomerType() ? getDiscount() : "Không giảm giá");

        System.out.println("+-------------------------------------------------------+");
        // Cập nhật thông tin của khách hàng hiện tại
        this.setMaKH(maKh);
        this.setName(customerName);
        this.setAddress(address);
        this.setGender(gender);
        this.setTelephoneNumber(customerPhoneNumber);
        this.setAge(age);
        this.setCustomerType(false);
        this.setBirthMonth(monthBirthday);
        this.setDiscount(discount);
//        this.writeToFile("/home/huy/Documents/vsc/java/projectOOP/src/ListBill.txt");
    }

    public Double applyDiscount(double totalAmount) {
        Double discountAmount = 0.0;
        if (isCustomerType() && getBirthMonth() == Calendar.getInstance().get(Calendar.MONTH) + 1) {
            // Nếu là thành viên và là tháng sinh nhật, giảm 10%
            discountAmount = totalAmount * 0.1;
            setDiscount(discountAmount);
            System.out.println("Bạn đã được giảm giá " + discountAmount + " VND.");
        } else {
            System.out.println("Không có giảm giá nào được áp dụng.");
        }
        return discountAmount;
    }

    public void printInfo() {
        System.out.println("+-------------------------------------------------------+");
        System.out.println("|                Thông Tin Khách Hàng                   |");
        System.out.println("+-------------------------------------------------------+");

        System.out.printf("| %-20s | %-30s |\n", "Mã KH", getMaKH());
        System.out.printf("| %-20s | %-30s |\n", "Tên", getName());
        System.out.printf("| %-20s | %-30s |\n", "Số Điện Thoại", getTelephoneNumber());
        System.out.printf("| %-20s | %-30s |\n", "Tuổi", getAge());
        System.out.printf("| %-20s | %-30s |\n", "Địa Chỉ", getAddress());
        System.out.printf("| %-20s | %-30s |\n", "Giới Tính", getGender());
        System.out.printf("| %-20s | %-30s |\n", "Loại Khách Hàng",
                isCustomerType() ? "Thành Viên" : "Không Thành Viên");
        System.out.printf("| %-20s | %-30s |\n", "Tháng Sinh Nhật", getBirthMonth());
        System.out.printf("| %-20s | %-30s |\n", "Giảm Giá", isCustomerType() ? getDiscount() : "Không giảm giá");

    }

    // public String getDataForFile() {
    // // Return formatted data for writing to the file
    // return getMaKH() + ";" + getName() + ";" + getTelephoneNumber() + ";" +
    // getAge() + ";" + getAddress() + ";"
    // + getGender() + ";" + isCustomerType() + ";" + getBirthMonth() + ";" +
    // getDiscount() + ";";
    // }
    public String getDataForFile() {
        // Return formatted data for writing to the file
        StringBuilder data = new StringBuilder();

        // Thông tin khách hàng
        data.append("Mã KH: ").append(getMaKH()).append(";")
                .append("Tên: ").append(getName()).append(";")
                .append("Số Điện Thoại: ").append(getTelephoneNumber()).append(";")
                .append("Tuổi: ").append(getAge()).append(";")
                .append("Địa Chỉ: ").append(getAddress()).append(";")
                .append("Giới Tính: ").append(getGender()).append(";")
                .append("Loại Khách Hàng: ").append(isCustomerType() ? "Thành Viên" : "Không Thành Viên").append(";")
                .append("Tháng Sinh Nhật: ").append(getBirthMonth()).append(";")
                .append("Giảm Giá: ").append(getDiscount()).append(";\n");

        return data.toString();
    }

    public void getLineFromFile(String line) {
        // Tách thông tin theo dấu chấm phẩy và loại bỏ dấu cách ở đầu và cuối mỗi phần
        // tử
        String[] data = line.split(";");

        if (data.length >= 9) { // Bạn đã có ít nhất 9 trường trong dữ liệu
            // Xử lý thông tin chung
            setMaKH(data[0].split(":")[1].trim()); // Lấy giá trị sau dấu ":" và loại bỏ khoảng trắng
            setName(data[1].split(":")[1].trim());
            setTelephoneNumber(data[2].split(":")[1].trim());
            setAge(Integer.parseInt(data[3].split(":")[1].trim()));
            setAddress(data[4].split(":")[1].trim());
            setGender(data[5].split(":")[1].trim());
            setCustomerType(Boolean.parseBoolean(data[6].split(":")[1].trim()));
            setBirthMonth(Integer.parseInt(data[7].split(":")[1].trim()));
            setDiscount(Double.parseDouble(data[8].split(":")[1].trim()));

            // Xử lý thông tin đơn hàng nếu có
            for (int i = 9; i < data.length; i++) {
                SanPham sanPham = new SanPham();
                // Kiểm tra trước khi chuyển đổi
                if (!data[i].isEmpty() && data[i].contains(":")) {
                    // Tách thông tin sản phẩm theo dấu hai chấm
                    String[] productInfo = data[i].split(":");
                    if (productInfo.length == 2) {
                        sanPham.setMaSanPham(productInfo[1].trim());
                        getOrder().add(sanPham);
                    } else {
                        System.out.println("Dữ liệu sản phẩm không hợp lệ.");
                    }
                }
            }
        } else {
            System.out.println("Dữ liệu từ file không hợp lệ.");
        }
    }

    public void writeToFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            // Ghi dữ liệu của khách hàng vào file
            writer.write(getDataForFile());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi dữ liệu vào file: " + e.getMessage());
        }
    }

}