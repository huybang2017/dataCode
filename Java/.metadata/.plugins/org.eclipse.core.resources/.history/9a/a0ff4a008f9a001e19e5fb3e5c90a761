package handleMaganement.ObjTable;

/*1. Bàn: Quán có nhiều bàn được đánh số thứ tự theo cách sắp xếp của quản
lý. Có 3 loại bàn bàn theo số chỗ ngồi: 2, 4 và 8 chỗ. Khách hàng không được
tự ý chuyển chỗ bàn ghế.
 */

public class Table {
    private int tableNumber;
    private int capacity; // Số chỗ ngồi
    private boolean occupied;

    public Table() {

    }

    public Table(int tableNumber, int capacity, boolean occupied) {
        this.tableNumber = tableNumber;
        this.capacity = capacity;
        this.occupied = occupied;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    @Override
    public String toString() {
        return "Table " + tableNumber + " - Capacity: " + capacity + " - Occupied: " + (occupied ? "Yes" : "No");
    }
}
