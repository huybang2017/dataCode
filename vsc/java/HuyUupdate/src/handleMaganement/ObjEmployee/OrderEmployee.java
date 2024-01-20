package handleMaganement.ObjEmployee;

import java.util.ArrayList;
import java.util.Scanner;

import HandleList.ListOrder;
import handleMaganement.ObjBill.Bill;
import handleMaganement.ObjCustomer.Customer;
import handleMaganement.ObjOrder.SanPham;

public class OrderEmployee extends Employee {
    private ArrayList<Bill> bills = new ArrayList<>();
    private int numOfBills;
    private boolean isDineIn; // Biến để kiểm tra xem khách hàng dùng tại chỗ hay mang đi
    private int numCustomers; // Số lượng khách hàng khi dùng tại chỗ
    private String selectedTable;
    private String Status;
    private BartenderEmployee bartenderEmployee;

    Scanner scanner = new Scanner(System.in);
    ListOrder listOrder = new ListOrder();

    // Empty Constructor

    public OrderEmployee() {

    };

    public OrderEmployee(String idEmployee, String name, String address, int age, String telephoneNumber, String gender,
            String position, String salary, ArrayList<Bill> bills, int numOfBills, boolean isDineIn, int numCustomers,
            String selectedTable, String status, BartenderEmployee bartenderEmployee, Scanner scanner,
            ListOrder listOrder) {
        super(idEmployee, name, address, age, telephoneNumber, gender, position, salary);
        this.bills = bills;
        this.numOfBills = numOfBills;
        this.isDineIn = isDineIn;
        this.numCustomers = numCustomers;
        this.selectedTable = selectedTable;
        Status = status;
        this.bartenderEmployee = bartenderEmployee;
        this.scanner = scanner;
        this.listOrder = listOrder;
    }

    public ArrayList<Bill> getBills() {
        return bills;
    }

    public void setBills(ArrayList<Bill> bills) {
        this.bills = bills;
    }

    public int getNumOfBills() {
        return numOfBills;
    }

    public void setNumOfBills(int numOfBills) {
        this.numOfBills = numOfBills;
    }

    public boolean isDineIn() {
        return isDineIn;
    }

    public int getNumCustomers() {
        return numCustomers;
    }

    public void setNumCustomers(int numCustomers) {
        this.numCustomers = numCustomers;
    }

    public String getSelectedTable() {
        return selectedTable;
    }

    public void setSelectedTable(String selectedTable) {
        this.selectedTable = selectedTable;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public BartenderEmployee getBartenderEmployee() {
        return bartenderEmployee;
    }

    public void setBartenderEmployee(BartenderEmployee bartenderEmployee) {
        this.bartenderEmployee = bartenderEmployee;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public ListOrder getListOrder() {
        return listOrder;
    }

    public void setListOrder(ListOrder listOrder) {
        this.listOrder = listOrder;
    }

    public void setDineIn(boolean isDineIn) {
        this.isDineIn = isDineIn;
        if (isDineIn) {
            System.out.print("Nhập số lượng khách hàng: ");
            this.numCustomers = scanner.nextInt();
            System.out.print("Chọn bàn phù hợp: ");
            this.selectedTable = scanner.next();
        }
    }

    // Thêm hàm để hỏi khách hàng có dùng tại chỗ hay mang đi
    public void askDineInOrTakeAway() {
        System.out.print("Khách hàng có dùng tại chỗ không? (Có(true)/Không(false)): ");
        this.isDineIn = scanner.nextBoolean();
        if (isDineIn) {
            System.out.print("Nhập số lượng khách hàng: ");
            this.numCustomers = scanner.nextInt();
            System.out.print("Chọn bàn phù hợp: ");
            this.selectedTable = scanner.next();
        }
    }

    private void confirmOrder(Customer customer, Bill bill) {
        System.out.println("Đơn đặt hàng của khách hàng " + customer.getName() + " đã được xác nhận.");
        System.out.println("Chi tiết đơn hàng:");
        bill.displayBill();
    }

    // tao bill , dat don thong qua ung dung
    public void createBill(Customer customer, ArrayList<SanPham> products, ArrayList<Integer> quantities) {
        this.Status = "Đang Đặt";
        if ("Đang Đặt".equalsIgnoreCase(this.Status)) {
            Bill bill = new Bill(customer, products, quantities);
            bills.add(bill);
            confirmOrder(customer, bill);
        } else {
            System.out.println("Không thể đặt đơn khi không ở trạng thái 'Đang Đặt'.");
        }
    }

    // Hạn chế việc thay đổi khi đơn đã đặt
    public void changeOrder(Bill bill, SanPham newProduct, int newQuantity) {
        if ("Đang Đặt".equalsIgnoreCase(this.Status)) {
        } else {
            System.out.println("Không thể thay đổi đơn hàng đã đặt.");
        }
    }

    // Kiem tra ton tai don hang

    // Phương thức để thay đổi nước uống hoặc thêm/sửa đổi món
    public void modifyOrder(Bill bill) {
        if ("Đang Đặt".equalsIgnoreCase(this.getStatus())) {
            System.out.println("Đơn hàng hiện tại:");
            bill.displayBill();
            // Hỏi khách hàng muốn thực hiện thay đổi gì
            System.out.println("1. Thay đổi nước uống");
            System.out.println("2. Thêm/Sửa đổi món");
            System.out.print("Chọn hành động (1 hoặc 2): ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    changeDrink(bill);
                    break;
                case 2:
                    modifyProduct(bill);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
            System.out.println("Đơn hàng sau khi thay đổi:");
            bill.displayBill();
        } else {
            System.out.println("Không thể thay đổi đơn hàng đã đặt.");
        }
    }

    // Thay doi nuoc uong
    private void changeDrink(Bill bill) {
        // Thực hiện thay đổi nước uống
        System.out.println("Nhập mã sản phẩm mới: ");
        String newProductCode = scanner.next();
        System.out.println("Nhập số lượng mới: ");
        int newQuantity = scanner.nextInt();
        // Tìm sản phẩm trong đơn hàng và thay đổi
        for (int i = 0; i < bill.getProducts().size(); i++) {
            if (bill.getProducts().get(i).getMaSanPham().equals(newProductCode)) {
                bill.getQuantities().set(i, newQuantity);
                System.out.println("Thay đổi nước uống thành công.");
                break;
            }
        }
    }

    private void modifyProduct(Bill bill) {
        // Thực hiện thêm/sửa đổi món
        System.out.println("Nhập mã sản phẩm mới: ");
        String newProductCode2 = scanner.next();
        System.out.println("Nhập số lượng mới: ");
        int newQuantity2 = scanner.nextInt();
        // Tìm sản phẩm trong đơn hàng và thêm/sửa đổi
        boolean found = false;
        for (int i = 0; i < bill.getProducts().size(); i++) {
            if (bill.getProducts().get(i).getMaSanPham().equals(newProductCode2)) {
                int currentQuantity = bill.getQuantities().get(i);
                bill.getQuantities().set(i, currentQuantity + newQuantity2);
                System.out.println("Thêm/Sửa đổi món thành công.");
                found = true;
                break;
            }
        }
        // Nếu sản phẩm chưa có trong đơn hàng, thêm mới
        if (!found) {
            // Thêm sản phẩm mới vào đơn hàng
            System.out.print("Nhập mã sản phẩm mới: ");
            String newProductCode = scanner.next();
            // kiem tra san pham ton tai khong
            SanPham newProduct = listOrder.findProductByCode(newProductCode);

            if (newProduct != null) {
                System.out.println("Thêm món mới thành công.");
                bill.getProducts().add(newProduct);
                bill.getQuantities().add(newQuantity2);
            } else {
                System.out
                        .println("Sản phẩm không tồn có trong danh sách sản phẩm. Vui lòng kiểm tra lại mã sản phẩm.");
            }
        }
    }

    // hinh thuc thah toan
    public void processPayment(Bill bill) {
        if ("Đã Thanh Toán".equalsIgnoreCase(this.Status)) {
            System.out.println("Đơn hàng đã được thanh toán trước đó.");
        } else if ("Đang Đặt".equalsIgnoreCase(this.Status)) {
            // Hiển thị chi tiết đơn hàng
            System.out.println("Chi tiết đơn hàng:");
            bill.displayBill();

            // Tính tổng tiền
            int totalAmount = bill.calculateTotalPrice();

            // Gọi phương thức thanh toán (có thể sử dụng các cổng thanh toán khác nhau như
            // ví điện tử, thẻ tín dụng, v.v.)
            boolean paymentSuccess = processPayment(totalAmount);

            if (paymentSuccess) {
                System.out.println("Thanh toán thành công. Cảm ơn quý khách!");
                this.Status = "Đã Thanh Toán";
            } else {
                System.out.println("Thanh toán thất bại. Vui lòng thử lại sau.");
            }
        } else {
            System.out.println("Không thể thanh toán đơn khi không ở trạng thái 'Đang Đặt'.");
        }
    }

    // ... (Các phương thức khác)

    private boolean processPayment(int amount) {
        // Giả sử rằng thanh toán luôn thành công
        System.out.println("Đang xử lý thanh toán...");
        System.out.println("Đã thanh toán thành công: " + amount + " VNĐ");
        return true;
    }

}
