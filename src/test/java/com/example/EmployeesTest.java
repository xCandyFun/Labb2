package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Null;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyString;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeesTest{
    String stringTest = null;
    double doubleTest = 0.0;

    BankServiceImpl BS = new BankServiceImpl();
    EmployeeRepositoryImpl ER = new EmployeeRepositoryImpl();

    @Mock
    BankService TT;
    //EmployeeRepositoryImpl ERI = new EmployeeRepositoryImpl();
    //@Mock
    //EmployeeRepository ER; // = Mockito.mock(EmployeeRepository.class);

    Employees ES = new Employees(ER,BS);
    Employee EAT = new Employee(stringTest,doubleTest);





    @Test
    void payEmployees() {
        assertNull(ER.findAll());
     }
     @Test
    void Test(){

     }
}
