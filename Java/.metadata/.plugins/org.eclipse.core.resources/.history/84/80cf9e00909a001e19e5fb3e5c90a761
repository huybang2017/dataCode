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

    private void initializeProducts() {
        try {
            String filePath = "/Users/m1lt43/Desktop/HuyUupdate/src/data/SanPham.txt";
            ArrayList<String> lines = stream.read(filePath);

            for (String line : lines) {
                String[] productData = line.split(";");
                if (productData.length >= 9) {
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
                new FileWriter("/Users/m1lt43/Desktop/HuyUupdate/src/data/SanPham.txt", true))) {
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
                new FileWriter("/Users/m1lt43/Desktop/HuyUupdate/src/data/SanPham.txt"))) {
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
            scanner.nextLine();
            System.out.print("Có đá hay không (true/false): ");
            boolean coDa = scanner.nextBoolean();
            scanner.nextLine();
            System.out.print("Mô tả đá mới: ");
            String moTaDa = scanner.nextLine();
            System.out.print("Có size hay không (true/false): ");
            boolean coSize = scanner.nextBoolean();
            scanner.nextLine();
            System.out.print("Nhập size mới: ");
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

            System.out.print("Có đá hay không (Nhấn Enter để giữ nguyên): ");
            String coDaInput = scanner.nextLine().trim();
            if (!coDaInput.isEmpty()) {
                try {
                    boolean coDa = Boolean.parseBoolean(coDaInput);
                    productToEdit.setCoDa(coDa);
                } catch (NumberFormatException e) {
                    System.out.println("Dữ liệu không hợp lệ. Sử dụng dữ liệu trước đó.");
                }
            }

            System.out.print("Mô tả đá mới (Nhấn Enter để giữ nguyên): ");
            String moTaDa = scanner.nextLine().trim();
            if (!moTaDa.isEmpty()) {
                productToEdit.setMoTaDa(moTaDa);
            }

            System.out.print("Có size hay không (Nhấn Enter để giữ nguyên): ");
            String coSizeInput = scanner.nextLine().trim();
            if (!coSizeInput.isEmpty()) {
                try {
                    boolean coSize = Boolean.parseBoolean(coSizeInput);
                    productToEdit.setCoSize(coSize);
                } catch (NumberFormatException e) {
                    System.out.println("Dữ liệu không hợp lệ. Sử dụng dữ liệu trước đó.");
                }
            }

            System.out.print("Nhập size mới (Nhấn Enter để giữ nguyên): ");
            String size = scanner.nextLine().trim();
            if (!size.isEmpty()) {
                productToEdit.setSize(size);
            }

            System.out.print("Ghi chú mới (Nhấn Enter để giữ nguyên): ");
            String ghiChu = scanner.nextLine().trim();
            if (!ghiChu.isEmpty()) {
                productToEdit.setGhiChu(ghiChu);
            }

            updateFile();

            System.out.println("Sản phẩm đã được cập nhật và tệp đã được cập nhật.");
        } else {
            System.out.println("Không tìm thấy sản phẩm có mã: " + maSanPham);
        }
    }
}
