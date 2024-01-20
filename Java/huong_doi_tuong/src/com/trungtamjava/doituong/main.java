package com.trungtamjava.doituong;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		person A = new person();
		person B = new person();
		
		A.setTen("HUY");
		A.setTuoi(18);
		
		B.setTen("DUNG");
		B.setTuoi(18);
		
		System.out.println("người thứ nhất: " + A.getTen() + " " + A.getTuoi());
		System.out.println("người thứ hai: " + B.getTen() + " " + B.getTuoi());
	}

}
