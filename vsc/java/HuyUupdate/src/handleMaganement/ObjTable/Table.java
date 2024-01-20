package handleMaganement.ObjTable;

/*1. Bàn: Quán có nhiều bàn được đánh số thứ tự theo cách sắp xếp của quản
lý. Có 3 loại bàn bàn theo số chỗ ngồi: 2, 4 và 8 chỗ. Khách hàng không được
tự ý chuyển chỗ bàn ghế.
 */

public class Table {
    private String tableCode;
    private int tableNumber; // Số bàn
    private int numberOfSeats; // Số ghế
public Table(){
    
}
    public Table(String tableCode, int tableNumber, int numberOfSeats) {
        this.tableCode = tableCode;
        this.tableNumber = tableNumber;
        this.numberOfSeats = numberOfSeats;
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

    @Override
    public String toString() {
        return "Mã bàn: " + tableCode + "; Số bàn: " + tableNumber + "; Số ghế: " + numberOfSeats;
    }
}