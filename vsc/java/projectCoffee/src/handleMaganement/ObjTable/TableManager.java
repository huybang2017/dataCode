package handleMaganement.ObjTable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import HandleList.Stream;

public class TableManager {
    private ArrayList<Table> tables;
    private int tableCount;
    private static Stream stream = new Stream();
    private String filePath = "/home/huy/Documents/vsc/java/projectOOP/src/data/table.txt";

    public TableManager() {
        this.tables = new ArrayList<>();
        this.tableCount = 0;
    }

    public static void readTableData(String filePath, TableManager tableManager) {
        try {
            // Đọc dữ liệu từ tệp và thêm bàn vào TableManager
            ArrayList<String> tableLines = stream.read(filePath);
            for (String line : tableLines) {
                String[] parts = line.split(";");
                if (parts.length >= 5) {
                    String tableCode = parts[0].trim().substring(8);
                    int tableNumber = Integer.parseInt(parts[1].trim().split(" ")[2]);
                    int numberOfSeats = Integer.parseInt(parts[2].trim().split(" ")[2]);
                    String tableName = parts[3].trim().split(":")[1].trim();
                    boolean statusTable = parts[4].trim().split(":")[1].trim().equalsIgnoreCase("Đã Đặt");

                    Table table = new Table(tableCode, tableNumber, numberOfSeats, tableName, statusTable);
                    tableManager.addTable(table);
                } else {
                    System.out.println("Dòng không hợp lệ: " + line);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void userInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập mã bàn: ");
        String tableCode = scanner.nextLine();

        System.out.print("Nhập số bàn: ");
        int tableNumber = scanner.nextInt();
        System.out.print("Nhập số ghế: ");
        int numberOfSeats = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nhập tên bàn: ");
        String tableName = scanner.nextLine();
        Table newTable = new Table(tableCode, tableNumber, numberOfSeats, tableName, false);
        this.addTable(newTable);
        this.writeTablesToFile(this.filePath);
    }

    public void addTable(Table table) {
        if (table != null) {
            tables.add(table);
            this.tableCount++;
        } else {
            System.out.println("Không thể thêm bàn null vào danh sách.");
        }
    }

    public void displayTables() {
        System.out.println("List of Tables:");
        for (Table table : tables) {
            System.out.println(table.toString());
            System.out.println();
        }
    }

    public ArrayList<Table> getTables() {
        return this.tables;
    }

    public boolean deleteTable(String tableCode) {
        Table tableToDelete = findTableByCode(tableCode);

        if (tableToDelete != null) {
            tables.remove(tableToDelete);
            writeTablesToFile("/home/huy/Documents/vsc/java/projectOOP/src/data/table.txt"); // Thay đổi đường dẫn file
            return true;
        }

        System.out.println("Không tìm thấy bàn để xoá.");
        return false;
    }

    private Table findTableByCode(String tableCode) {
        for (Table table : tables) {
            if (table.getTableCode().equals(tableCode)) {
                return table;
            }
        }
        return null;
    }

    public void updateTable(String tableCode) {
        Scanner scanner = new Scanner(System.in);

        Table tableToUpdate = findTableByCode(tableCode);
        if (tableToUpdate == null) {
            System.out.println("Bàn không tồn tại trong danh sách.");
            return;
        }

        System.out.println("Thông tin hiện tại của bàn:");
        System.out.println(tableToUpdate.toString());

        // Lựa chọn
        System.out.println("Chọn thông tin cần sửa:");
        System.out.println("1. Mã bàn");
        System.out.println("2. Số bàn");
        System.out.println("3. Số ghế");
        System.out.println("4. Tên bàn");
        System.out.println("5. Sửa trạng thái bàn");
        // Thêm lựa chọn sửa tên bàn

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        switch (choice) {
            case 1:
                System.out.print("Nhập mã bàn mới: ");
                String newTableCode = scanner.nextLine();
                tableToUpdate.setTableCode(newTableCode);
                break;
            case 2:
                System.out.print("Nhập số bàn mới: ");
                int newTableNumber = scanner.nextInt();
                tableToUpdate.setTableNumber(newTableNumber);
                break;
            case 3:
                System.out.print("Nhập số ghế mới: ");
                int newNumberOfSeats = scanner.nextInt();
                tableToUpdate.setNumberOfSeats(newNumberOfSeats);
                break;
            case 4:
                System.out.print("Nhập tên bàn mới: ");
                String newTableName = scanner.nextLine();
                tableToUpdate.setTableName(newTableName);
                break;
            case 5:
                System.out.print("Nhập trạng thái bàn: (true/false)");
                Boolean setStatusTable = Boolean.parseBoolean(scanner.nextLine());
                tableToUpdate.setStatusTable(setStatusTable);
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
                return;
        }
        writeTablesToFile(filePath);
        System.out.println("Bàn đã được cập nhật và tệp đã được cập nhật.");
    }

    public void findTable(int numberOfSeats) {
        ArrayList<Table> matchingTables = new ArrayList<>();
        for (Table table : tables) {
            if (table.getNumberOfSeats() == numberOfSeats) {
                matchingTables.add(table);
            }
        }

        if (!matchingTables.isEmpty()) {
            System.out.println("Các bàn có số ghế là " + numberOfSeats + ":");
            for (Table table : matchingTables) {
                System.out.println(table.toString());
            }
        } else {
            System.out.println("Không có bàn nào có số ghế là " + numberOfSeats);
        }
    }

    public void writeTablesToFile(String filePath) {

        ArrayList<String> tableData = new ArrayList<>();
        for (Table table : tables) {
            tableData.add("Mã bàn: " + table.getTableCode() + ";Số bàn: " + table.getTableNumber() +
                    ";Số ghế: " + table.getNumberOfSeats() + ";Tên bàn: " + table.getTableName() +  ";Trạng thái bàn: " + (table.isStatusTable() ? "Đã đặt" : "Bàn trống"));
        }
        try {
            // Ghi dữ liệu bàn vào tệp1
            stream.addAll(filePath, tableData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
