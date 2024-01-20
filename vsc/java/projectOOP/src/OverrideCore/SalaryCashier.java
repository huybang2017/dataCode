package OverrideCore;

import AbstractCore.TypeEmployee;
import handleMaganement.ObjEmployee.Employee;

// public class SalaryTotal extends Employee implements TypeElement{

// }
public class SalaryCashier extends Employee implements TypeEmployee {
    @Override
    public void position() {
        super.setPosition("Nhan vien tinh tien");
    }

    @Override
    public void salary() {
        super.setSalary("10.000.000 vnd");

    }
}