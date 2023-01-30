package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {
    String stringTest = "StringId";
    double doubleTest = 0.0;
    Employee as = new Employee(stringTest, doubleTest);

    @Test
    void theTestForTheConstruc(){
        assertEquals("StringId", as.getId());
        assertEquals(0,as.getSalary());
//        String onePieceOfString= "String";
//        int oneNumber = 0;
//        Employee as = new Employee(onePieceOfString, oneNumber);
//        assertEquals(as,);
    }

    @Test
    void testForTheGetId() {
        String StringForTesting="testingGetId";
        as.setId(StringForTesting);
        assertTrue(as.getId()=="testingGetId");
    }

    @Test
    void testForTheSetId() {
        String StringForTesting="testingSetId";
        as.setId(StringForTesting);
        assertTrue(as.getId()=="testingSetId");
    }

    @Test
    void testForTheGetSalary() {
        as.setSalary(0.5);
        assertTrue(as.getSalary() == 0.5);
    }

    @Test
    void testForTheSetSalary() {
        as.setSalary(1.5);
        assertTrue(as.getSalary() == 1.5);
    }

    @Test
    void testForTheIsPaid() {
        boolean testIsPaid = false;
        as.setPaid(testIsPaid);
        assertTrue(as.isPaid()==false);
    }

    @Test
    void testForTheSetPaid() {
        boolean testIsPaid = true;
        as.setPaid(testIsPaid);
        assertTrue(as.isPaid()==true);
    }

    @Test
    void testForTheToString() {
        assertEquals(as.toString(), "Employee [id=" + stringTest + ", salary=" + doubleTest + "]");
    }
}