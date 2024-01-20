package handleMaganement.ObjCustomer;

import java.util.Calendar;

class MembershipManager {
    public static double calculateDiscount(Customer customer, double totalAmount) {
        if (customer.isMember() && isBirthday(customer)) {
            // Nếu là thành viên và là tháng sinh nhật, giảm 10% tổng giá trị đơn hàng
            return totalAmount * 0.1;
        } else {
            return 0;
        }
    }

    public static Customer registerMember(String name, String telephoneNumber, int age, String address, String gender) {
        // Thực hiện đăng ký thành viên, có thể thêm các bước khác nếu cần
        Calendar today = Calendar.getInstance();
        int currentMonth = today.get(Calendar.MONTH) + 1;
        return new Customer(name, telephoneNumber, age, address, gender, true, currentMonth, 0);
    }

    // Hàm kiểm tra ngày sinh nhật
    public static boolean isBirthday(Customer customer) {
        Calendar today = Calendar.getInstance();
        int currentMonth = today.get(Calendar.MONTH) + 1;
        return customer.getBirthMonth() == currentMonth;
    }
}
