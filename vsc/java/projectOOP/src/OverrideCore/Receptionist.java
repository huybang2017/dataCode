package OverrideCore;

import AbstractCore.TypeEmployee;
import handleMaganement.ObjEmployee.Employee;

public class Receptionist extends Employee implements TypeEmployee {

    @Override
    public void position() {
        super.setPosition("Luong co ban ");
    }

    @Override
    public void salary() {
        super.setSalary("6.000.000 vnd");
    }
}
