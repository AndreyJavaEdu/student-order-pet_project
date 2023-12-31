package edu.pet_project.studentorder.dao;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.stream.Collectors;

public class DBInit {
    public static void startUp() throws Exception {
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

        try (Connection con = ConnectionBuilder.getConnection();
             Statement stmt = con.createStatement()) {
            stmt.executeUpdate(sql1);
            stmt.executeUpdate(sql2);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
