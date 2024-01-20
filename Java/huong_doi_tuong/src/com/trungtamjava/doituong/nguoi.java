package com.trungtamjava.doituong;

public class nguoi {
	String ten;
	String diaChi;
	int tuoi;
	
	public void diLai(String ten) {
		System.out.println(ten + "đi lại");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new nguoi(); //đối tượng 1
		nguoi anhA = new nguoi(); //đối tượng 2
		nguoi anhB = new nguoi(); //đối tượng 3
		
		anhA.diLai("anhA");
		
		anhB.diLai("anhB");
	}

}
