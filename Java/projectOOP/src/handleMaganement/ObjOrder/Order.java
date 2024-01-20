package handleMaganement.ObjOrder;
/*
6. Đặt đơn và tính tiền: Khi khách hàng đến, nhân viên sẽ hỏi khách dùng
tại chỗ hay mang đi, nếu khách dùng tại chỗ số lượng khách hàng và chọn
bàn phù hợp.
Bước 2: nhân viên sẽ tiến hành đặt đơn cho khách thông qua ứng dụng, do
đó việc thay đổi nước uống chỉ được thực hiện trong quá trình đặt đơn của
nhân viên sau đó không thể điều chỉnh nữa.
 */

import java.sql.Date;
import java.util.List;

import handleMaganement.ObjCustomer.Customer;

public class Order {
    private int orderId;
    private Customer customer;
    private List<SanPham> SanPham;
    private boolean dineIn; // true if dining in, false if takeout
    private int tableNumber; // table number if dining in
    private Date orderTime;
    private boolean orderCompleted;

    public Order(int orderId, Customer customer, List<SanPham> SanPham, boolean dineIn, int tableNumber,
            Date orderTime, boolean orderCompleted) {
        this.orderId = orderId;
        this.customer = customer;
        this.SanPham = SanPham;
        this.dineIn = dineIn;
        this.tableNumber = tableNumber;
        this.orderTime = orderTime;
        this.orderCompleted = orderCompleted;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<SanPham> getSanPhams() {
        return SanPham;
    }

    public void setSanPhams(List<SanPham> SanPham) {
        this.SanPham = SanPham;
    }

    public boolean isDineIn() {
        return dineIn;
    }

    public void setDineIn(boolean dineIn) {
        this.dineIn = dineIn;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public boolean isOrderCompleted() {
        return orderCompleted;
    }

    public void setOrderCompleted(boolean orderCompleted) {
        this.orderCompleted = orderCompleted;
    }

    // public void placeOrder(Employee employee) {
    // if (!orderCompleted) {
    // employee.takeOrder(this);
    // orderCompleted = true;
    // } else {
    // System.out.println("Order has already been placed.");
    // }
    // }
}