package OverrideCore;

import AbstractCore.TypeEmployee;
import handleMaganement.ObjEmployee.Employee;

public class SalaryBartender extends Employee implements TypeEmployee {
    public void position() {
        super.setPosition("Luong co ban ");
    }

    @Override
    public void salary() {
        super.setSalary("7.000.000 vnd");
    }
}
