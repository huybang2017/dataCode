package OverrideCore;

import AbstractCore.TypeEmployee;
import handleMaganement.ObjEmployee.Employee;

public class SalaryOrder extends Employee implements TypeEmployee {
    @Override
    public void position() {
        super.setPosition("Nhan vien dat don ");
    }

    @Override
    public void salary() {
        super.setSalary("7.000.000 vnd");

    }
}
