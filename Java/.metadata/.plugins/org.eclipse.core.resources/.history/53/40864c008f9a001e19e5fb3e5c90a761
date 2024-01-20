
package handleMaganement.ObjEmployee;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import handleMaganement.Person;

public class Employee extends Person {
    private String idEmployee;
    private String position;
    private String salary;

    public Employee() {

    }

    public Employee(String idEmployee, String name, String address, int age, String telephoneNumber, String gender,
            String position, String salary) {
        // Gọi constructor của lớp cha
        super(name, telephoneNumber, age, address, gender);
        this.idEmployee = idEmployee;
        this.position = position;
        this.salary = salary;
    }

    // Getter và setter cho idEmployee
    public String getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(String idEmployee) {
        this.idEmployee = idEmployee;
    }

    // Getter và setter cho position
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    // Getter và setter cho salary
    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public void inputForEmployee() {
        Scanner sc = new Scanner(System.in);
        Matcher matcher;

        do {
            System.out.print("Nhap ma nhan vien: ");
            setIdEmployee(sc.nextLine());

            String idEmployee = getIdEmployee();
            if (idEmployee == null || idEmployee.isEmpty() || !idEmployee.matches("^NV[0-9]{2}$")) {
                System.out.println("Ma nhan vien khong hop le. Vui long nhap lai.");
            }
        } while (getIdEmployee() == null || getIdEmployee().isEmpty() || !getIdEmployee().matches("^NV[0-9]{2}$"));

        // Kiểm tra tên nhân viên
        do {
            System.out.print("Nhap ten nhan vien: ");
            super.setName(sc.nextLine());
            String s = "[^0-9]";
            Pattern pattern = Pattern.compile(s);
            matcher = pattern.matcher(super.getName());
            if (!matcher.find()) {
                System.out.println("Ten nhan vien khong hop le. Vui long nhap lai.");
            }
        } while (!matcher.find());

        // Nhập địa chỉ nhân viên
        System.out.print("Nhap dia chi nhan vien: ");
        super.setAddress(sc.nextLine());

        // Kiểm tra tuổi nhân viên
        do {
            System.out.print("Nhap tuoi nhan vien: ");
            try {
                super.setAge(Integer.parseInt(sc.nextLine()));
                if (super.getAge() < 0) {
                    System.out.println("Tuoi khong hop le. Vui long nhap lai.");
                    continue; // Bắt nhập lại khi có lỗi
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap mot so nguyen cho tuoi.");
                continue; // Bắt nhập lại khi có lỗi
            }
            break; // Kết thúc vòng lặp khi không có lỗi
        } while (true);

        do {
            System.out.print("Nhap so dien thoai nhan vien: ");
            super.setTelephoneNumber(sc.nextLine());
            String s = "^[0-9]{10}$";
            Pattern pattern = Pattern.compile(s);
            matcher = pattern.matcher(super.getTelephoneNumber());

            if (!matcher.matches() || super.getTelephoneNumber().isEmpty()) {
                System.out.println("So dien thoai khong hop le. Vui long nhap lai.");
                continue; // Bắt nhập lại khi có lỗi
            } else if (!super.getTelephoneNumber().matches("\\d+")) {
                System.out.println("So dien thoai chi duoc chua chu so. Vui long nhap lai.");
                continue; // Bắt nhập lại khi có lỗi
            }
            break; // Kết thúc vòng lặp khi không có lỗi
        } while (true);

        // Nhập giới tính nhân viên
        do {
            System.out.print("Nhap gioi tinh nhan vien: ");
            setGender(sc.nextLine());
            // Kiểm tra giới tính nhân viên
            if (getGender().isEmpty()) {
                System.out.println("Gioi tinh nhan vien khong duoc de trong. Vui long nhap lai.");
                continue; // Bắt nhập lại khi có lỗi
            }
            break; // Kết thúc vòng lặp khi không có lỗi
        } while (true);
    }

    public void position() {
        setPosition("none");
    }

    public void salary() {
        setSalary("none");
    }

    public void getLineFromFile(String line) {
        String[] str = line.split(";");
        if (str.length >= 7) {
            setIdEmployee(str[0]);
            super.setName(str[1]);
            super.setAddress(str[2]);
            try {
                super.setAge(Integer.parseInt(str[3]));
            } catch (NumberFormatException e) {
                super.setAge(0);
            }
            super.setTelephoneNumber(str[4]);
            if (str.length > 7) {
                setGender(str[5]);
            } else {
                setGender("N/A");
            }
            setPosition(str[6]);
            setSalary(str[7]);

            // Thêm xử lý giới tính

        } else {
            // Xử lý khi không có đủ phần tử
            System.out.println("Dòng không hợp lệ: " + line);
        }
    }

    public String mergeInformationToFile() {
        // Kiểm tra mã nhân viên trước khi merge thông tin vào dạng chuỗi
        if (getIdEmployee().isEmpty() || !getIdEmployee().matches("^NV[0-9]{2}$")) {
            System.out.println("Ma nhan vien khong hop le: " + getIdEmployee());
            // Có thể thực hiện xử lý khác tùy vào yêu cầu của bạn
            // Ví dụ: Gán giá trị mặc định hoặc thông báo lỗi
            setIdEmployee("DefaultID");
        }

        return String.format("%s;%s;%s;%d;%s;%s;%s;%s", getIdEmployee(), super.getName(), super.getAddress(),
                super.getAge(), super.getTelephoneNumber(), getGender(), getPosition(), getSalary());
    }

    @Override
    public String toString() {
        // Đổi tên phương thức getEmployeeId() thành getIdEmployee()
        return String.format("| %-10s %-20s %-30s %-10s %-15s %-15s %-20s %-15s |",
                getIdEmployee(), super.getName(), super.getAddress(), super.getAge(), super.getTelephoneNumber(),
                getGender(), getPosition(), getSalary());
    }

    public void output() {
        System.out.println(toString());
    }
}
