package edu.pet_project.studentorder.dao;


import org.junit.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.stream.Collectors;

public class DictionaryDaoImplTest {

    @BeforeClass //выполняется вначале один раз перд всеми методами
    public static void startUp() throws URISyntaxException, IOException {
        URL url1 = DictionaryDaoImplTest.class.getClassLoader()
                .getResource("student_project.sql");
        URL url2 = DictionaryDaoImplTest.class.getClassLoader()
                .getResource("student_data.sql");

        Path path1 = Paths.get(url1.toURI());
        Path path2 = Paths.get(url2.toURI());
        List<String> str1 = Files.readAllLines(path1);
        List<String> str2 = Files.readAllLines(path2);

        String sql1 = str1.stream().collect(Collectors.joining(" "));
        String sql2 = str2.stream().collect(Collectors.joining(" "));

        try(Connection con = ConnectionBuilder.getConnection();
            Statement stmt = con.createStatement()){
            stmt.executeUpdate(sql1);
            stmt.executeUpdate(sql2);

        } catch (SQLException ex){
            ex.printStackTrace();
        }
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