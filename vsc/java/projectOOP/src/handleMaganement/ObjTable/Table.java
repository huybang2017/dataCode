package handleMaganement.ObjTable;

public class Table {
    private String tableCode;
    private int tableNumber;
    private int numberOfSeats;
    private String tableName;

    private boolean statusTable;

    public Table() {
    }

    public Table(String tableCode, int tableNumber, int numberOfSeats, String tableName, boolean statusTable) {
        this.tableCode = tableCode;
        this.tableNumber = tableNumber;
        this.numberOfSeats = numberOfSeats;
        this.tableName = tableName; // Initialize the table name
        this.statusTable = statusTable;
    }

    public String getTableCode() {
        return tableCode;
    }

    public void setTableCode(String tableCode) {
        this.tableCode = tableCode;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public boolean isStatusTable() {
        return statusTable;
    }

    public void setStatusTable(boolean statusTable) {
        this.statusTable = statusTable;
    }

    @Override
    public String toString() {
        // Adjust the toString() method to include the table name
        return "Mã bàn: " + tableCode + "; Tên bàn: " + tableName + "; Số bàn: " + tableNumber +
                "; Số ghế: " + numberOfSeats + "; Trạng thái bàn: " + (statusTable ? "Đã đặt" : "Bàn trống");
    }
}
