package HandleList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import AbstractCore.TypeList;
import handleMaganement.ObjCustomer.Customer;

public class ListCustomer implements TypeList {
    private ArrayList<Customer> listCustomer;
    private static final String FILE_PATH = "/home/huy/Documents/vsc/java/projectOOP/src/data/KhachHang.txt";

    public ListCustomer() {
        listCustomer = new ArrayList<>();
    }

    @Override
    public void add() {
        Customer newCustomer = new Customer();
        newCustomer.InfoCustomer();
        if (!isCustomerExists(newCustomer)) {
            listCustomer.add(newCustomer);
            addCustomerToFile(newCustomer);
        } else {
            System.out.println("Thông tin khách hàng đã tồn tại.");
        }
    }

    @Override
    public void edit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã khách hàng cần sửa: ");
        String customerCodeToEdit = scanner.nextLine().trim();
        boolean customerFound = false;

        for (Customer customer : listCustomer) {
            if (customer.getMaKH().equalsIgnoreCase(customerCodeToEdit)) {
                System.out.println("Thông tin khách hàng cần sửa:");
                customer.printInfo();

                while (true) {
                    System.out.println("Chọn thuộc tính cần sửa:");
                    System.out.println("1. Tên khách hàng");
                    System.out.println("2. Số điện thoại");
                    System.out.println("3. Tuổi");
                    System.out.println("4. Tháng sinh");
                    System.out.println("5. Địa chỉ");
                    System.out.println("6. Giới tính");
                    System.out.println("0. Hoàn tất sửa đổi");

                    try {
                        System.out.print("Nhập lựa chọn của bạn: ");
                        int choice = scanner.nextInt();
                        scanner.nextLine();

                        switch (choice) {
                            case 1:
                                updateName(scanner, customer);
                                break;
                            case 2:
                                updatePhoneNumber(scanner, customer);
                                break;
                            case 3:
                                updateAge(scanner, customer);
                                break;
                            case 4:
                                updateMonthBirthday(scanner, customer);
                                break;
                            case 5:
                                updateAddress(scanner, customer);
                                break;
                            case 6:
                                updateGender(scanner, customer);
                                break;
                            case 0:
                                System.out.println("Cập nhật thông tin khách hàng thành công. Kết thúc chương trình.");
                                break;
                            default:
                                System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                        }

                    } catch (Exception e) {
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                        scanner.nextLine(); // Đọc bỏ giá trị không phải số để tránh lặp vô hạn
                    }

                    // Cập nhật thông tin khách hàng vào file
                    updateCustomerInFile(customer);
                    saveListToFile();
                    customerFound = true;
                    break;
                }
            }
        }

        if (!customerFound) {
            System.out.println("Không tìm thấy khách hàng có mã: " + customerCodeToEdit);
        }
    }

    @Override
    public void remove() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã khách hàng cần xóa: ");
        String customerCodeToDelete = scanner.nextLine();

        boolean customerFound = false;

        for (Customer customer : listCustomer) {
            if (customer.getMaKH().equalsIgnoreCase(customerCodeToDelete)) {
                System.out.println("Thông tin khách hàng cần xóa:");
                customer.printInfo();

                System.out.print("Bạn có chắc chắn muốn xóa khách hàng này? (Y/N): ");
                String confirm = scanner.nextLine().toUpperCase();
                if (confirm.equals("Y")) {
                    listCustomer.remove(customer);
                    saveListToFile();
                    System.out.println("Khách hàng đã được xóa.");
                } else {
                    System.out.println("Khách hàng không được xóa.");
                }

                customerFound = true;
                break;
            }
        }

        if (!customerFound) {
            System.out.println("Không tìm thấy khách hàng có mã: " + customerCodeToDelete);
        }
    }

    @Override
    public void find() {
        Scanner scanner = new Scanner(System.in);

        boolean continueSearch = true;

        while (continueSearch) {
            System.out.println("Chọn loại tìm kiếm:");
            System.out.println("1. Tìm theo mã khách hàng");
            System.out.println("2. Tìm theo tên khách hàng");
            System.out.println("3. Tìm theo số điện thoại");
            System.out.println("4. Tìm theo địa chỉ");
            System.out.println("5. Tìm theo tháng sinh");
            System.out.println("0. Thoát tìm kiếm");
            System.out.print("Nhập lựa chọn của bạn: ");
            int searchOption = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (searchOption == 0) {
                continueSearch = false;
                break;
            }

            System.out.print("Nhập thông tin tìm kiếm: ");
            String searchInput = scanner.nextLine().trim();

            boolean customerFound = false;

            for (Customer customer : listCustomer) {
                boolean match = false;
                switch (searchOption) {
                    case 1:
                        match = customer.getMaKH().equalsIgnoreCase(searchInput);
                        break;
                    case 2:
                        match = customer.getName().equalsIgnoreCase(searchInput);
                        break;
                    case 3:
                        match = customer.getTelephoneNumber().equalsIgnoreCase(searchInput);
                        break;
                    case 4:
                        match = customer.getAddress().equalsIgnoreCase(searchInput);
                        break;
                    case 5:
                        int searchYear = Integer.parseInt(searchInput);
                        match = customer.getBirthMonth() == searchYear;
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ.");
                        return;
                }

                if (match) {
                    System.out.println("Thông tin khách hàng:");
                    customer.printInfo();
                    customerFound = true;
                }
            }

            if (!customerFound) {
                System.out.println("Không tìm thấy khách hàng với thông tin: " + searchInput);
            }
        }
    }

    @Override
    public void display() {
        for (Customer customer : listCustomer) {
            customer.printInfo();
        }
    }

    public void addCustomerToListBill() {
        Customer newCustomer = new Customer();
        newCustomer.InfoCustomer();
        addCustomerToFileListBill(newCustomer);
        if (!isCustomerExists(newCustomer)) {
            listCustomer.add(newCustomer);
            addCustomerToFile(newCustomer);
        } else {
            System.out.println("Thông tin khách hàng đã tồn tại.");
        }
    }

    private ArrayList<String> readDataFromFile(String filePath) throws IOException {
        ArrayList<String> data = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath, StandardCharsets.UTF_8))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                data.add(line);
            }
        }
        return data;
    }

    public void readListCustomer() {
        try {
            ArrayList<String> data = readDataFromFile(FILE_PATH);
            for (String line : data) {
                Customer customer = new Customer();
                customer.getLineFromFile(line);
                listCustomer.add(customer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addCustomerToFile(Customer customer) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            bufferedWriter.write(customer.getDataForFile());
            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addCustomerToFileListBill(Customer customer) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter("/home/huy/Documents/vsc/java/projectOOP/src/data/ListBill.txt", true))) {
            bufferedWriter.write(customer.getDataForFile());
            bufferedWriter.write(String.valueOf(LocalDate.now()));
            bufferedWriter.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateCustomerInFile(Customer customer) {
        try {
            ArrayList<String> data = readDataFromFile(FILE_PATH);

            for (int i = 0; i < data.size(); i++) {
                String line = data.get(i);
                if (line.startsWith(customer.getMaKH())) {
                    data.set(i, customer.getDataForFile());
                    break;
                }
            }

            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_PATH))) {
                for (String line : data) {
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveListToFile() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Customer customer : listCustomer) {
                bufferedWriter.write(customer.getDataForFile());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void updateName(Scanner scanner, Customer customer) {
        System.out.print("Nhập tên mới: ");
        String newName = scanner.nextLine();
        customer.setName(newName);
        System.out.println("Tên khách hàng đã được cập nhật.");
    }

    private static void updatePhoneNumber(Scanner scanner, Customer customer) {
        System.out.print("Nhập số điện thoại mới: ");
        String newPhoneNumber = scanner.nextLine();
        customer.setTelephoneNumber(newPhoneNumber);
        System.out.println("Số điện thoại đã được cập nhật.");
    }

    private static void updateAge(Scanner scanner, Customer customer) {
        System.out.print("Nhập tuổi mới: ");
        int newAge = scanner.nextInt();
        while (newAge <= 0) {
            System.out.println("Tuổi phải lớn hơn 0. Vui lòng nhập lại.");
            System.out.print("Nhập tuổi: ");
            newAge = scanner.nextInt();
        }
        customer.setAge(newAge);
        System.out.println("Tuổi đã được cập nhật.");
    }

    private static void updateMonthBirthday(Scanner scanner, Customer customer) {
        System.out.print("Nhập tháng sinh mới: ");
        int newMonthBirthday = scanner.nextInt();
        while (newMonthBirthday <= 0 || newMonthBirthday >= 13) {
            System.out.println("Tháng sinh phải lớn hơn 0 và bé hơn 13. Vui lòng nhập lại.");
            System.out.print("Nhập tháng sinh: ");
            newMonthBirthday = scanner.nextInt();
        }
        customer.setBirthMonth(newMonthBirthday);
        System.out.println("Tháng sinh đã được cập nhật.");
    }

    private static void updateAddress(Scanner scanner, Customer customer) {
        System.out.print("Nhập địa chỉ mới: ");
        String newAddress = scanner.nextLine();
        customer.setAddress(newAddress);
        System.out.println("Địa chỉ đã được cập nhật.");
    }

    private static void updateGender(Scanner scanner, Customer customer) {
        System.out.print("Nhập giới tính mới: ");
        String newGender = scanner.nextLine();
        customer.setGender(newGender);
        System.out.println("Giới tính đã được cập nhật.");
    }

    public boolean isCustomerExists(Customer customerToCheck) {
        for (Customer existingCustomer : listCustomer) {
            // Kiểm tra tên không phải là null trước khi gọi equals
            if (existingCustomer.getName() != null &&
                    existingCustomer.getName().equals(customerToCheck.getName()) &&
                    existingCustomer.getTelephoneNumber().equals(customerToCheck.getTelephoneNumber()) &&
                    existingCustomer.getBirthMonth() == customerToCheck.getBirthMonth()) {
                return true;
            }
        }
        return false;
    }

    public void registerMember() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã khách hàng cần đăng ký thành viên: ");
        String customerCodeToRegister = scanner.nextLine().trim();

        boolean customerFound = false;

        for (Customer customer : listCustomer) {
            if (customer.getMaKH().equalsIgnoreCase(customerCodeToRegister)) {
                // Kiểm tra xem khách hàng đã là thành viên chưa
                if (customer.isCustomerType()) {
                    System.out.println("Khách hàng đã là thành viên.");
                    return;
                }

                // Đặt customertype = true và discount = 0.1
                customer.setCustomerType(true);
                customer.setDiscount(0.1);

                // Cập nhật thông tin khách hàng vào file
                updateCustomerInFile(customer);
                saveListToFile();
                customer.printInfo();
                System.out.println("Đăng ký thành viên thành công.");
                customerFound = true;
                break;
            }
        }

        if (!customerFound) {
            System.out.println("Không tìm thấy khách hàng có mã: " + customerCodeToRegister);
            System.out.println("1. Tạo khách hàng mới");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    add();
                    break;
                case 0:
                    System.out.println("Thoát đăng ký thành viên.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Thoát đăng ký thành viên.");
            }
        }
    }

    public void displayCustomerWithCurrentBirthday() {
        LocalDate currentDate = LocalDate.now();
        int currentMonth = currentDate.getMonthValue();

        boolean foundCustomer = false;

        for (Customer customer : listCustomer) {
            int customerBirthMonth = customer.getBirthMonth();

            if (customer.isCustomerType() && customerBirthMonth == currentMonth) {
                // Hiển thị thông tin của khách hàng
                System.out.println("Thông tin của khách hàng có tháng sinh trùng với tháng hiện tại:");
                customer.setDiscount(0.1);
                customer.printInfo();
                foundCustomer = true;
                updateCustomerInFile(customer);
            } else {
                updateCustomerInFile(customer);
                customer.setDiscount(0.0);
            }
        }

        if (!foundCustomer) {
            System.out.println("Không có khách hàng nào có ngày sinh trùng với ngày hôm nay.");
        }
    }

    public void handleCustomer() {
        Scanner scanner = new Scanner(System.in);
        ListCustomer customerList = new ListCustomer();
        customerList.readListCustomer();

        int choice;

        do {
            System.out.println("+----------------------------------------------+");
            System.out.println("|           Quản lý khách hàng                 |");
            System.out.println("| -------------------=====---------------------|");
            System.out.println("| 1. Hiển thị danh sách khách hàng             |");
            System.out.println("| 2. Thêm khách hàng                           |");
            System.out.println("| 3. Sửa thông tin khách hàng                  |");
            System.out.println("| 4. Xóa khách hàng                            |");
            System.out.println("| 5. Tìm kiếm khách hàng                       |");
            System.out.println("| 6. Xuất thông tin KH khuyến mãi              |");
            System.out.println("| 0. Quay lại                                  |");
            System.out.println("+----------------------------------------------+");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    customerList.readListCustomer();
                    customerList.display();
                    break;
                case 2:
                    customerList.readListCustomer();
                    customerList.add();
                    break;
                case 3:
                    customerList.readListCustomer();
                    customerList.edit();
                    break;
                case 4:
                    customerList.readListCustomer();
                    customerList.remove();
                    break;
                case 5:
                    customerList.readListCustomer();
                    customerList.find();
                    break;
                case 6:
                    customerList.readListCustomer();
                    customerList.displayCustomerWithCurrentBirthday();
                case 0:
                    System.out.println("Quay lại menu chính.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 0);
    }
}
