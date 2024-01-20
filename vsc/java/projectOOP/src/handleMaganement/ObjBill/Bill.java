package handleMaganement.ObjBill;

import java.util.ArrayList;
import java.util.Date;

import handleMaganement.ObjCustomer.Customer;

public class Bill {
    ArrayList<OrderItem> products = new ArrayList<>();
    ArrayList<Integer> quantities = new ArrayList<Integer>();
    private Date date;
    private Customer customer;

    public Bill(Customer customer, ArrayList<OrderItem> products, ArrayList<Integer> quantities) {
        this.customer = customer;
        this.products.addAll(products);
        this.quantities.addAll(quantities);
        this.date = new Date();
    }

    public void addProduct(OrderItem product, int quantity) {
        products.add(product);
        quantities.add(quantity);
    }

    public ArrayList<OrderItem> getProducts() {
        return products;
    }

    public ArrayList<Integer> getQuantities() {
        return quantities;
    }

    public Date getDate() {
        return date;
    }

    public int calculateTotalPrice() {
        int totalPrice = 0;
        for (int i = 0; i < products.size(); i++) {
            // System.out.println(products);
            OrderItem product = products.get(i);
            int quantity = quantities.get(i);
            totalPrice += product.getGia() * quantity;
        }
        return totalPrice;
    }

    public void displayBill() {
        // Display customer information
        System.out.println("\nThông tin khách hàng và Hóa đơn:");
        System.out.println(
                "+-----------------------+-------------------------+---------------+----------------+--------+");
        System.out.printf("| %-21s | %-23s | %-13s | %-14s | %-6s |\n", "Tên khách hàng", "Địa chỉ", "Giới tính",
                "Số điện thoại", "Tuổi");
        System.out.println(
                "+-----------------------+-------------------------+---------------+----------------+--------+");
        System.out.printf("| %-21s | %-23s | %-13s | %-14s | %-6s |\n",
                customer.getName(), customer.getAddress(), customer.getGender(), customer.getTelephoneNumber(),
                customer.getAge());

        System.out.println(
                "+-----------------------+-------------------------+---------------+----------------+--------+");

        // Display information about ordered products
        System.out.println("\nSản phẩm đã đặt:");
        System.out.println(
                "+------+--------------------------------+---------------+--------+--------+--------+-------------------------+---------------+");
        System.out.printf("| %-4s | %-30s | %-13s | %-7s | %-6s | %-21s | %-23s |\n", "STT", "Tên sản phẩm", "Loại",
                "Số lượng", "Giá",
                "Tên khách hàng", "Số điện thoại");
        System.out.println(
                "+------+--------------------------------+---------------+--------+--------+--------+-------------------------+---------------+");

        int totalPrice = 0;

        // Loop through the list of products and quantities
        for (int i = 0; i < products.size(); i++) {
            OrderItem product = products.get(i);
            int quantity = quantities.get(i);
            int productTotalPrice = product.getGia() * quantity;

            // Calculate the total price for each product
            totalPrice += productTotalPrice;

            // Display product details in the table, including customer information
            System.out.printf("| %-4d | %-30s | %-13s | %-7d | %-6d | %-21s | %-23s  |\n",
                    i + 1, product.getTenSanPham(), product.getLoai(), quantity, productTotalPrice,
                    customer.getName(), customer.getTelephoneNumber());
        }

        // Display the bottom border of the product table
        System.out.println(
                "+------+--------------------------------+---------------+--------+--------+--------+-------------------------+---------------+");

        // Display the total price
        System.out.println("\nTổng tiền: " + totalPrice);
        System.out.println('\n');
    }

    public Customer getCustomer() {
        return customer;
    }
}