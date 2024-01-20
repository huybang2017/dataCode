package HandleList;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import handleMaganement.ObjOrder.SanPham;

public class ListProduct {
    private ArrayList<SanPham> sanpham = new ArrayList<>();
    private Stream stream = new Stream();

    public ListProduct() {
        initializeProducts();
    }

    public void initializeProducts() {
        try {
            String filePath = "/home/huy/Documents/vsc/java/projectOOP/src/data/SanPham.txt";
            ArrayList<String> lines = stream.read(filePath);

            // Initialize the ArrayList
            sanpham = new ArrayList<>();

            for (String line : lines) {
                String[] productData = line.split(";");

                // Check the array length
                if (productData.length == 5) {
                    SanPham sanPhamData = new SanPham();
                    sanPhamData.setMaSanPham(productData[0].trim());
                    sanPhamData.setTenSanPham(productData[1].trim());
                    sanPhamData.setLoai(productData[2].trim());
                    sanPhamData.setGia(Integer.parseInt(productData[3].trim()));
                    sanPhamData.setGhiChu(productData[4].trim());

                    // Thêm sản phẩm vào danh sách
                    sanpham.add(sanPhamData);
                } else {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception gracefully, log or throw a custom exception
        }
    }

    public ArrayList<SanPham> getProductList() {
        return sanpham;
    }

    public void addProduct(SanPham sanPham) {
        sanpham.add(sanPham);
        writeToFile(sanPham);
    }

    private void writeToFile(SanPham sanPham) {

        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter("/home/huy/Documents/vsc/java/projectOOP/src/data/SanPham.txt", true))) {
            bw.write(sanPham.getMaSanPham() + ";");
            bw.write(sanPham.getTenSanPham() + ";");
            bw.write(sanPham.getLoai() + ";");
            bw.write(sanPham.getGia() + ";");
            bw.write(sanPham.getGhiChu() != null ? sanPham.getGhiChu() : "");
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeProduct(String maSanPham) {
        SanPham productToRemove = findProductById(maSanPham);

        if (productToRemove != null) {
            sanpham.remove(productToRemove);
            updateFile();
            System.out.println("Sản phẩm đã được xóa và tệp đã được cập nhật.");
        } else {
            System.out.println("Không tìm thấy sản phẩm có mã: " + maSanPham);
        }
    }

    private void updateFile() {
        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter("/home/huy/Documents/vsc/java/projectOOP/src/data/SanPham.txt"))) {
            for (SanPham sanPham : sanpham) {
                bw.write(sanPham.getMaSanPham() + ";");
                bw.write(sanPham.getTenSanPham() + ";");
                bw.write(sanPham.getLoai() + ";");
                bw.write(sanPham.getGia() + ";");
                bw.write(sanPham.getGhiChu() != null ? sanPham.getGhiChu() : "");
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public SanPham findProductById(String maSanPham) {
        for (SanPham sanPham : sanpham) {
            if (sanPham.getMaSanPham().equals(maSanPham)) {
                return sanPham;
            }
        }
        System.out.println("Không tìm thấy sản phẩm có mã: " + maSanPham);
        return null;
    }

    public void updateProduct(String maSanPham) {
        SanPham productToUpdate = findProductById(maSanPham);

        if (productToUpdate != null) {
            System.out.println("Thông tin sản phẩm cần sửa:");
            System.out.println(productToUpdate);

            Scanner scanner = new Scanner(System.in);
            System.out.print("Nhập tên sản phẩm mới: ");
            String tenSanPham = scanner.nextLine();
            System.out.print("Nhập loại sản phẩm mới: ");
            String loai = scanner.nextLine();
            System.out.print("Nhập giá sản phẩm mới: ");
            int gia = scanner.nextInt();
            String size = scanner.nextLine();
            System.out.print("Ghi chú mới: ");
            String ghiChu = scanner.nextLine();

            productToUpdate.setTenSanPham(tenSanPham);
            productToUpdate.setLoai(loai);
            productToUpdate.setGia(gia);
            productToUpdate.setGhiChu(ghiChu);

            updateFile();

            System.out.println("Sản phẩm đã được cập nhật và tệp đã được cập nhật.");
        } else {
            System.out.println("Không tìm thấy sản phẩm có mã: " + maSanPham);
        }
    }

    public void editProduct(String maSanPham) {
        SanPham productToEdit = findProductById(maSanPham);

        if (productToEdit != null) {
            System.out.println("Thông tin sản phẩm cần sửa:");
            System.out.println(productToEdit);

            Scanner scanner = new Scanner(System.in);

            System.out.print("Nhập tên sản phẩm mới (Nhấn Enter để giữ nguyên): ");
            String tenSanPham = scanner.nextLine().trim();
            if (!tenSanPham.isEmpty()) {
                productToEdit.setTenSanPham(tenSanPham);
            }

            System.out.print("Nhập loại sản phẩm mới (Nhấn Enter để giữ nguyên): ");
            String loai = scanner.nextLine().trim();
            if (!loai.isEmpty()) {
                productToEdit.setLoai(loai);
            }

            System.out.print("Nhập giá sản phẩm mới (Nhấn Enter để giữ nguyên): ");
            String giaInput = scanner.nextLine().trim();
            if (!giaInput.isEmpty()) {
                try {
                    int gia = Integer.parseInt(giaInput);
                    productToEdit.setGia(gia);
                } catch (NumberFormatException e) {
                    System.out.println("Giá sản phẩm không hợp lệ. Sử dụng giá trước đó.");
                }
            }

            System.out.print("Nhập ghi chú mới (Nhấn Enter để giữ nguyên): ");
            String ghiChu = scanner.nextLine().trim();
            if (!ghiChu.isEmpty()) {
                productToEdit.setGhiChu(ghiChu);
            }

            System.out.println("Thông tin sản phẩm sau khi sửa:");
            System.out.println(productToEdit);

            updateFile();

            System.out.println("Sản phẩm đã được cập nhật và tệp đã được cập nhật.");
        } else {
            System.out.println("Không tìm thấy sản phẩm có mã: " + maSanPham);
        }
    }
}
