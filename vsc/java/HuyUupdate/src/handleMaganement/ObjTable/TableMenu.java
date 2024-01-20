package handleMaganement.ObjTable;

import java.util.Scanner;

public class TableMenu {
    public static void main(String[] args) {
        TableManager tableManager = new TableManager();
        TableManager.readTableData(
                "/Users/m1lt43/Desktop/HuyUupdate/src/data/table.txt",
                tableManager);

        displayTableMenu(tableManager);
    }

    public static void displayTableMenu(TableManager tableManager) {
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

            switch (tableChoice) {
                case 1:
                    tableManager.userInput();
                    break;
                case 2:
                    tableManager.displayTables();
                    break;
                case 3:
                    System.out.print("Nhập số ghế cần tìm: ");
                    int capacity = scanner.nextInt();
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
                    System.out.print("Nhập đường dẫn file: ");
                    String filePath = scanner.next();
                    tableManager.updateTable(tableCodeToEdit, filePath);
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
