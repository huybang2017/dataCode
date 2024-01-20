package handleMaganement.ObjTable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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

    // Thêm một bàn mới
    public void addTable(Table table) {
        this.tableCount++;
        if (tableCount >= tables.size()) {
            tables.add(table);
        } else {
            System.out.println("Không thể thêm nhiều hơn, danh sách bàn đã đầy.");
        }
    }

    // Hiển thị thông tin về tất cả các bàn
    public void displayTables() {
        System.out.println("List of Tables:");
        for (Table table : tables) {
            System.out.println(table.toString());
        }
    }

    // Tìm kiếm bàn theo số bàn
    public void findTable(int capacity) {
        TableManager tableManager = new TableManager();
        // Đọc dữ liệu từ file data.txt và thêm vào TableManager
        TableManager.readTableData("/Users/m1lt43/Desktop/HuyUupdate/src/data/table.txt", tableManager);

        // Hiển thị thông tin về tất cả các bàn
        tableManager.displayTables();

        // Tìm bàn trống
        Table availableTable = TableManager.findAvailableTable(tableManager, capacity);

        if (availableTable != null) {
            System.out.println("Bàn trống: " + availableTable.toString());
        } else {
            System.out.println("Không có bàn trống.");
        }
    }

    // Lấy danh sách tất cả các bàn
    public ArrayList<Table> getTables() {
        return this.tables;
    }

    public static Table findAvailableTable(TableManager tableManager, int capacity) {
        for (Table table : tableManager.getTables()) {
            if (!table.isOccupied() && table.getCapacity() >= capacity) {
                return table;
            }
        }
        return null;
    }

    // Phương thức đọc dữ liệu từ file và thêm vào TableManager
    public static Table readTableData(String filePath, TableManager tableManager) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("# Bàn")) {
                    // Bắt đầu định dạng mới cho thông tin bàn
                    int tableNumber = Integer.parseInt(br.readLine().split(": ")[1]);
                    int numberOfSeats = Integer.parseInt(br.readLine().split(": ")[1]);
                    boolean occupied = Boolean.parseBoolean(br.readLine().split(": ")[1]);

                    // Tạo đối tượng bàn và thêm vào TableManager
                    Table table = new Table(tableNumber, numberOfSeats, occupied);
                    tableManager.addTable(table);
                    // Đọc dòng trắng
                    br.readLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}