package handleMaganement.ObjTable;

import java.io.File;
import java.util.Scanner;

public class TableMenu {
    private TableManager tableManager;

    public void callBackTable() {
        this.tableManager = new TableManager();
        String filePath = "/home/huy/Documents/vsc/java/projectOOP/src/data/table.txt";

        // Kiểm tra đường dẫn callBackTable đọc
        if (isValidFilePath(filePath)) {
            TableManager.readTableData(filePath, this.tableManager);
            displayTableMenu(tableManager);
        } else {
            System.out.println("Đường dẫn file không hợp lệ.");
        }
    }

    public static boolean isValidFilePath(String filePath) {
        File file = new File(filePath);
        return file.exists() && file.isFile();
    }

    public void displayTableMenu(TableManager tableManager) {
        Scanner scanner = new Scanner(System.in);
        boolean tableMenuFlag = true;
        do {
            System.out.println("Chức năng quản lý bàn:");
            System.out.println("1. Thêm bàn mới.");
            System.out.println("2. Hiển thị danh sách bàn.");
            System.out.println("3. Tìm kiếm bàn.");
            System.out.println("4. Xoá bàn.");
            System.out.println("5. Sửa thông tin bàn.");
            System.out.println("6. Quay lại menu chính.");
            System.out.print("Mời bạn chọn: ");
            int tableChoice = scanner.nextInt();
            scanner.nextLine();
            switch (tableChoice) {
                case 1:
                    tableManager.userInput();
                    break;
                case 2:
                    tableManager.displayTables();
                    break;
                case 3:
                    System.out.print("Nhập số ghế cần tìm: ");
                    int capacity = Integer.parseInt(scanner.nextLine());
                    tableManager.findTable(capacity);
                    break;
                case 4:
                    System.out.print("Nhập mã bàn cần xoá: ");
                    String tableCodeToDelete = scanner.next();
                    if (tableManager.deleteTable(tableCodeToDelete)) {
                        System.out.println("Bàn đã được xoá.");
                    } else {
                        System.out.println("Không tìm thấy bàn để xoá.");
                    }
                    break;
                case 5:
                    System.out.print("Nhập mã bàn cần sửa: ");
                    String tableCodeToEdit = scanner.next();
                    tableManager.updateTable(tableCodeToEdit);
                    break;
                case 6:
                    tableMenuFlag = false;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Mời bạn chọn lại.");
                    break;
            }
        } while (tableMenuFlag);
    }
}
