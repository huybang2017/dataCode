package handleMaganement.ObjTable;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TableManager {
    private ArrayList<Table> tables;
    private int tableCount;

    public TableManager() {
        this.tables = new ArrayList<Table>();
        this.tableCount = 0;
    }

    public TableManager(int maxTables) {
        this.tables = new ArrayList<>(maxTables);
        this.tableCount = 0;
    }

    public static void readTableData(String filePath, TableManager tableManager) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("Mã bàn:")) {
                    String[] parts = line.split(";");
                    if (parts.length >= 3) {
                        String tableCode = parts[0].trim().substring(6);
                        int tableNumber = Integer.parseInt(parts[1].split(": ")[1].trim());
                        int numberOfSeats = Integer.parseInt(parts[2].split(": ")[1].trim());

                        Table table = new Table(tableCode, tableNumber, numberOfSeats);
                        tableManager.addTable(table);
                    } else {
                        System.out.println("Dữ liệu không đúng định dạng: " + line);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }v

    public void userInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập mã bàn: ");
        String tableCode = scanner.nextLine();

        System.out.print("Nhập số bàn: ");
        int tableNumber = scanner.nextInt();
        System.out.print("Nhập số ghế: ");
        int numberOfSeats = scanner.nextInt();
        Table newTable = new Table(tableCode, tableNumber, numberOfSeats);
        this.addTable(newTable);
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
            writeTablesToFile("/Users/m1lt43/Desktop/HuyUupdate/src/dât/table.txt"); // Thay đổi đường dẫn file
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

    public void updateTable(String tableCode, String filePath) {
        Scanner scanner = new Scanner(System.in);

        Table tableToUpdate = null;
        for (Table table : tables) {
            if (table.getTableCode().equals(tableCode)) {
                tableToUpdate = table;
                break;
            }
        }
        if (tableToUpdate == null) {
            System.out.println("Bàn không tồn tại trong danh sách.");
            return;
        }
        System.out.println("Thông tin hiện tại của bàn:");
        System.out.println(tableToUpdate.toString());
        // lựa chọn
        System.out.println("Chọn thông tin cần sửa:");
        System.out.println("1. Mã bàn");
        System.out.println("2. Số bàn");
        System.out.println("3. Số ghế");

        int choice = scanner.nextInt();
        scanner.nextLine(); // consume the newline character
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
            default:
                System.out.println("Lựa chọn không hợp lệ.");
                return;
        }
        writeTablesToFile(filePath);
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
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, false))) {
            for (Table table : tables) {
                bw.write("Mã bàn: " + table.getTableCode() + ";Số bàn: " + table.getTableNumber() +
                        ";Số ghế: " + table.getNumberOfSeats());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
