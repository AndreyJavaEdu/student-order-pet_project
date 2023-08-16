package edu.pet_project.studentorder.dao;


import org.junit.*;

public class DictionaryDaoImplTest {

    @BeforeClass //выполняется вначале один раз перд всеми методами
    public static void startUp(){
        System.out.println("START UP");
    }

    @AfterClass // запускается один раз только после всех методов
    public static void EndTest(){
        System.out.println("END TEST");
    }
    @After // запускается после каждого метода
    public void EndTestMecthod(){
        System.out.println("END TEST MECTOD!!!");
    }
    @Before //выполняется перед каждым тестом
    public void startTest(){
        System.out.println("START");
    }
    @Test
    public void TestEx1(){
        System.out.println("TEST1");
    }
    @Test
//    @Ignore
    public void TestEx2(){
        System.out.println("TEST2");
    }
    @Test
    public void TestEx3(){
        System.out.println("TEST3");
//        throw new RuntimeException("BAD RESULT");
    }
}