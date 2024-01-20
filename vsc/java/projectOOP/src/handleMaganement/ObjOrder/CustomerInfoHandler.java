package handleMaganement.ObjOrder;

public class CustomerInfoHandler {
//     Customer customer = new Customer();
//     private Scanner scanner;

//     public CustomerInfoHandler(Scanner scanner) {
//         this.scanner = scanner;
//     }

//     public Customer generateCustomerInfo() {

//         System.out.println("Nhập thông tin đơn hàng:");

//         customer.generateRandomMaKH();
//         String maKh = customer.getMaKH();
//         System.out.println("Mã khách hàng mới: " + maKh);

//         // Nhập thông tin về khách hàng
//         System.out.print("Nhập tên khách hàng: ");
//         String customerName = scanner.nextLine();

//         // Kiểm tra tên khách hàng không được để trống
//         while (customerName.trim().isEmpty()) {
//             System.out.println("Tên khách hàng không được để trống. Vui lòng nhập lại.");
//             System.out.print("Nhập tên khách hàng: ");
//             customerName = scanner.nextLine();
//         }

//         String customerPhoneNumber;
//         do {
//             System.out.print("Nhập số điện thoại: ");
//             customerPhoneNumber = scanner.nextLine();

//             // Kiểm tra số điện thoại có đúng định dạng không
//             if (!customerPhoneNumber.matches("\\d{10}")) {
//                 System.out.println("Số điện thoại không hợp lệ. Vui lòng nhập lại (10 chữ số).");
//             } else {
//                 // Nếu số điện thoại hợp lệ, thoát khỏi vòng lặp
//                 break;
//             }
//         } while (true);

//         // Kiểm tra số điện thoại có đúng định dạng không
//         System.out.print("Nhập tuổi: ");
//         while (!scanner.hasNextInt()) {
//             System.out.println("Tuổi phải là một số. Vui lòng nhập lại.");
//             System.out.print("Nhập tuổi: ");
//             scanner.next(); // Đọc bỏ giá trị không phải số để tránh lặp vô hạn
//         }

//         int age = scanner.nextInt();
//         // Thêm lệnh scanner.nextLine() để "đọc bỏ" dòng còn lại
//         scanner.nextLine();

//         System.out.print("Nhập tháng sinh: ");
//         while (!scanner.hasNextInt()) {
//             System.out.println("Tháng sinh phải là một số. Vui lòng nhập lại.");
//             System.out.print("Nhập tháng sinh: ");
//         }

//         int monthBirthday = Integer.parseInt(scanner.nextLine());

//         // Kiểm tra tuổi phải lớn hơn 0
//         while (monthBirthday <= 0 || monthBirthday >= 13) {
//             System.out.println("Tháng sinh phải lớn hơn 0 và bé hơn 13. Vui lòng nhập lại.");
//             System.out.print("Nhập tháng sinh: ");
//             monthBirthday = Integer.parseInt(scanner.nextLine());
//         }

//         System.out.print("Nhập địa chỉ: ");
//         String address = scanner.nextLine();

//         // Kiểm tra địa chỉ không được để trống
//         while (address.trim().isEmpty()) {
//             System.out.println("Địa chỉ không được để trống. Vui lòng nhập lại.");
//             System.out.print("Nhập địa chỉ: ");
//             address = scanner.nextLine();
//         }

//         System.out.print("Nhập giới tính: ");
//         String gender = scanner.nextLine().trim().toLowerCase();

//         // Kiểm tra giới tính không được để trống
//         while (gender.isEmpty()) {
//             System.out.println("Giới tính không được để trống. Vui lòng nhập lại.");
//             System.out.print("Nhập giới tính: ");
//             gender = scanner.nextLine().trim().toLowerCase();
//         }

//         customer.setMaKH(maKh);
//         customer.setName(customerName);
//         customer.setAddress(address);
//         customer.setGender(gender);
//         customer.setTelephoneNumber(customerPhoneNumber);
//         customer.setAge(age);
//         customer.setCustomerType(false);
//         customer.setBirthMonth(monthBirthday);

//         customer.setDiscount(customer.applyDiscount());

//         return customer;
//     }

//     public void processOrder() {
//         boolean continueShopping = true;

//         do {
//             customer = customerInfoHandler.generateCustomerInfo();
//             displayCustomerInfo(customer);

//             // Nếu bạn muốn thêm logic xử lý đơn hàng ở đây, bạn có thể gọi các phương thức
//             // từ lớp Order
//             // Ví dụ: Order order = new Order(); order.processOrder();

//             System.out.println("1. Tiếp tục mua hàng");
//             System.out.println("2. Quay lại menu chính");
//             System.out.println("3. Kết thúc");

//             int choice = getUserChoice();

//             switch (choice) {
//                 case 1:
//                     // Thực hiện các hành động liên quan đến việc tiếp tục mua hàng
//                     System.out.println("Vui lòng nhập nước cần gọi: ");
//                     break;
//                 case 2:
//                     // Quay lại ban đầu (hoặc thực hiện các hành động liên quan đến việc quay lại)
//                     continueShopping = false;
//                     break;
//                 case 3:
//                     System.out.println("Cảm ơn bạn đã sử dụng dịch vụ!");
//                     return; // Kết thúc phương thức nếu người dùng chọn kết thúc
//                 default:
//                     System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
//             }
//         } while (continueShopping);
//     }

//     private void displayCustomerInfo(Customer customer) {
//         // Hiển thị thông tin khách hàng
//         System.out.println("+-------------------------------------------------------+");
//         // ... (Phần hiển thị thông tin của khách hàng như bạn đã thực hiện trước đó)
//         System.out.printf("| %-20s | %-30s |\n", "Giảm Giá", isCustomerType() ? getDiscount() : "Không giảm giá");

//         System.out.println("+-------------------------------------------------------+");
//         // Cập nhật thông tin của khách hàng hiện tại
//         customer.setMaKH(customer.getMaKH());
//         customer.setName(customer.getName());
//         customer.setAddress(customer.getAddress());
//         customer.setGender(customer.getGender());
//         customer.setTelephoneNumber(customer.getTelephoneNumber());
//         customer.setAge(customer.getAge());
//         customer.setCustomerType(false);
//         customer.setBirthMonth(customer.getBirthMonth());

//         customer.setDiscount(applyDiscount());
//     }

//     private int getUserChoice() {
//         int choice;
//         System.out.print("Lựa chọn của bạn: ");
//         while (true) {
//             try {
//                 choice = scanner.nextInt();
//                 scanner.nextLine(); // Đọc bỏ dòng trống
//                 break;
//             } catch (InputMismatchException e) {
//                 System.out.println("Vui lòng nhập một số.");
//                 scanner.nextLine(); // Đọc bỏ dòng trống
//             }
//         }
//         return choice;
//     }

//     public Double applyDiscount() {
//         Double discountAmount = 0.0;
//         if (customer.isCustomerType() && customer.getBirthMonth() == Calendar.getInstance().get(Calendar.MONTH) + 1) {
//             // Nếu là thành viên và là tháng sinh nhật, giảm 10%
//             discountAmount = customer.getDiscount() * 0.1;
//             customer.setDiscount(discountAmount);
//             System.out.println("Bạn đã được giảm giá " + discountAmount + " VND.");
//         } else {
//             System.out.println("Không có giảm giá nào được áp dụng.");
//         }
//         return discountAmount;
//     }
}
