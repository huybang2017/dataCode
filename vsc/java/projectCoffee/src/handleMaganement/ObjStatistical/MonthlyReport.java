package handleMaganement.ObjStatistical;

import java.util.ArrayList;

import BaseContructor.Date; // Import class Date từ gói BaseContructor

public class MonthlyReport {
    public Date reportDate; // Ngày của báo cáo hàng tháng
    private int totalOrders; // Tổng số đơn hàng
    private double totalRevenue; // Tổng doanh thu cho tháng
    private ArrayList<ProductQuantity> productQuantities; // Danh sách để lưu trữ số lượng sản phẩm

    // Constructor để khởi tạo đối tượng MonthlyReport với ngày báo cáo cụ thể
    public MonthlyReport(Date reportDate) {
        this.reportDate = reportDate;
        this.totalOrders = 0; // Khởi tạo tổng số đơn hàng là 0
        this.totalRevenue = 0.0; // Khởi tạo tổng doanh thu là 0.0
        this.productQuantities = new ArrayList<>(); // Khởi tạo danh sách số lượng sản phẩm
    }

    // Phương thức để thêm số lượng sản phẩm vào báo cáo
    public void addProductQuantity(String productCode, int quantity) {
        ProductQuantity productQuantity = findProductQuantity(productCode);

        // Nếu sản phẩm đã có trong báo cáo, cập nhật số lượng
        if (productQuantity != null) {
            productQuantity.setQuantity(productQuantity.getQuantity() + quantity);
        } else {
            // Nếu sản phẩm chưa có trong báo cáo, thêm một đối tượng ProductQuantity mới
            productQuantities.add(new ProductQuantity(productCode, quantity));
        }
    }

    // Phương thức riêng để tìm ProductQuantity bằng mã sản phẩm
    private ProductQuantity findProductQuantity(String productCode) {
        for (ProductQuantity productQuantity : productQuantities) {
            if (productQuantity.getProductCode().equals(productCode)) {
                return productQuantity; // Trả về đối tượng ProductQuantity đã tìm thấy
            }
        }
        return null; // Trả về null nếu không tìm thấy mã sản phẩm
    }

    // Ghi đè phương thức toString để cung cấp biểu diễn chuỗi của MonthlyReport
    @Override
    public String toString() {
        StringBuilder report = new StringBuilder();
        report.append("Thống kê hàng tháng - Tháng ").append(reportDate.getMonth()).append(", Năm ")
                .append(reportDate.getYear()).append("\n");
        report.append("Số đơn hàng: ").append(totalOrders).append("\n");
        report.append("Doanh thu: ").append(totalRevenue).append(" VND\n");
        report.append("Số lượng mỗi sản phẩm:\n");

        // Nối thông tin cho mỗi số lượng sản phẩm trong danh sách
        for (ProductQuantity productQuantity : productQuantities) {
            report.append(" - Mã sản phẩm ").append(productQuantity.getProductCode()).append(": ")
                    .append(productQuantity.getQuantity()).append("\n");
        }

        return report.toString(); // Trả về biểu diễn chuỗi cuối cùng của báo cáo
    }
}
