package HandleList;

import AbstractCore.TypeList;
import handleMaganement.ObjCustomer.Customer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class ListCustomer implements TypeList {
	private ArrayList<Customer> listCustomer; // Thay đổi kiểu dữ liệu của mảng
	private static final String FILE_PATH = "/home/huy/Documents/Java/projectOOP/src/data/KhachHang.txt";

	public ListCustomer() {
		// Initialize the ArrayList
		listCustomer = new ArrayList<>();
	}

	@Override
	public void add() {
		// Create a new customer
		Customer newCustomer = new Customer();
		// Set the customer's data (you may use Scanner or other means to get input)
		newCustomer.InfoCustomer();
		System.out.println(newCustomer);

		// Add the new customer to the list
		listCustomer.add(newCustomer);

		// Add the new customer to the file
		addCustomerToFile(newCustomer);
	}

	@Override
	public void edit() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhập mã khách hàng cần sửa: ");
		String customerCodeToEdit = scanner.nextLine();
		boolean customerFound = false;
		for (Customer customer : listCustomer) {
			if (customer.getMaKH().equalsIgnoreCase(customerCodeToEdit)) {
				// Display existing customer information
				System.out.println("Thông tin khách hàng cần sửa:");
				customer.printInfo();

				// Get new information from the user
				System.out.println("Nhập thông tin mới:");

				// You can add more fields to update based on your Customer class
				customer.InfoCustomer();

				// Update the customer in the file
				updateCustomerInFile(customer);

				System.out.println("Thông tin khách hàng sau khi sửa:");
				customer.printInfo();

				customerFound = true;
				break;
			}
		}

		if (!customerFound) {
			System.out.println("Không tìm thấy khách hàng có mã: " + customerCodeToEdit);
		}
		// Save the changes to the file after editing
		saveListToFile();
	}

	@Override
	public void remove() {
	    Scanner scanner = new Scanner(System.in);
	    System.out.print("Nhập mã khách hàng cần xóa: ");
	    String customerCodeToDelete = scanner.nextLine();

	    boolean customerFound = false;

	    for (Customer customer : listCustomer) {
	        if (customer.getMaKH().equalsIgnoreCase(customerCodeToDelete)) {
	            // Display existing customer information
	            System.out.println("Thông tin khách hàng cần xóa:");
	            customer.printInfo();

	            // Confirm deletion
	            System.out.print("Bạn có chắc chắn muốn xóa khách hàng này? (Y/N): ");
	            String confirm = scanner.nextLine().toUpperCase();
	            if (confirm.equals("Y")) {
	                // Remove the customer from the list
	                listCustomer.remove(customer);

	                // Update the file after removal
	                saveListToFile();

	                System.out.println("Khách hàng đã được xóa.");
	            } else {
	                System.out.println("Khách hàng không được xóa.");
	            }

	            customerFound = true;
	            break;
	        }
	    }

	    if (!customerFound) {
	        System.out.println("Không tìm thấy khách hàng có mã: " + customerCodeToDelete);
	    }
	}

	@Override
	public void find() {
	    Scanner scanner = new Scanner(System.in);
	    System.out.print("Nhập mã khách hàng cần tìm kiếm: ");
	    String customerCodeToFind = scanner.nextLine();

	    boolean customerFound = false;

	    for (Customer customer : listCustomer) {
	        if (customer.getMaKH().equalsIgnoreCase(customerCodeToFind)) {
	            // Display customer information
	            System.out.println("Thông tin khách hàng cần tìm kiếm:");
	            customer.printInfo();
	            customerFound = true;
	            break;
	        }
	    }

	    if (!customerFound) {
	        System.out.println("Không tìm thấy khách hàng có mã: " + customerCodeToFind);
	    }
	}


	@Override
	public void display() {
		// Placeholder for displaying the list of customers
		for (Customer customer : listCustomer) {
			customer.printInfo();
		}
	}

	private ArrayList<String> readDataFromFile(String filePath) throws IOException {
		ArrayList<String> data = new ArrayList<>();
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath, StandardCharsets.UTF_8))) {
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				data.add(line);
			}
		}
		return data;
	}

	public void readListCustomer() {
		try {
			ArrayList<String> data = readDataFromFile(FILE_PATH);
			for (String line : data) {
				Customer customer = new Customer();
				customer.getLineFromFile(line);
				listCustomer.add(customer); // Thêm từng khách hàng vào ArrayList
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void addCustomerToFile(Customer customer) {
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
			// Append the new customer data to the file
			bufferedWriter.write(customer.getDataForFile());
			bufferedWriter.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void updateCustomerInFile(Customer customer) {
		try {
			ArrayList<String> data = readDataFromFile(FILE_PATH);

			// Update the information in the ArrayList
			for (int i = 0; i < data.size(); i++) {
				String line = data.get(i);
				if (line.startsWith(customer.getMaKH())) {
					data.set(i, customer.getDataForFile());
					break;
				}
			}

			// Write the updated data back to the file
			try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_PATH))) {
				for (String line : data) {
					bufferedWriter.write(line);
					bufferedWriter.newLine();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void saveListToFile() {
		try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_PATH))) {
			for (Customer customer : listCustomer) {
				bufferedWriter.write(customer.getDataForFile());
				bufferedWriter.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ListCustomer customerList = new ListCustomer();
		customerList.readListCustomer();
		customerList.edit();
		customerList.display();
	}

}

