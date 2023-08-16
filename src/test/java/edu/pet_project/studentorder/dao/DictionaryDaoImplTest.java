package edu.pet_project.studentorder.dao;


import org.junit.Ignore;
import org.junit.Test;

public class DictionaryDaoImplTest {
    @Test
    public void TestEx1(){
        System.out.println("TEST1");
    }
    @Test
    @Ignore
    public void TestEx2(){
        System.out.println("TEST2");
    }
    @Test
    public void TestEx3(){
        System.out.println("TEST3");
        throw new RuntimeException("BAD RESULT");
    }
}