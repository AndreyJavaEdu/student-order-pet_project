package edu.pet_project.studentorder.dao;


import edu.pet_project.studentorder.domain.CountryArea;
import edu.pet_project.studentorder.domain.PassportOffice;
import edu.pet_project.studentorder.domain.RegisterOffice;
import edu.pet_project.studentorder.domain.Street;
import edu.pet_project.studentorder.exception.DaoException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.stream.Collectors;

public class DictionaryDaoImplTest {

    @BeforeClass //выполняется вначале один раз перд всеми методами
    public static void startUp() throws Exception {
      DBInit.startUp();
    }

    @Test
    public void testStreet() throws DaoException {
        List<Street> d = new DictionaryDaoImpl().findStreets("про");
        Assert.assertTrue(d.size() == 2);
    }

    @Test
    public void testPassportOffice() throws DaoException {
        List<PassportOffice> po = new DictionaryDaoImpl().findPassportOffices("010020000000");
        Assert.assertTrue(po.size() == 2);
    }

    @Test
    public void testRegisterOffice() throws DaoException {
        List<RegisterOffice> ro = new DictionaryDaoImpl().findRegisterOffices("010010000000");
        Assert.assertTrue(ro.size() == 2);
    }

    @Test
    public void testArea() throws DaoException {
        List<CountryArea> countryArea1 = new DictionaryDaoImpl().findAreas("");
        Assert.assertTrue(countryArea1.size()==2);

        List<CountryArea> countryArea2 = new DictionaryDaoImpl().findAreas("020000000000");
        Assert.assertTrue(countryArea2.size()==2);

        List<CountryArea> countryArea3 = new DictionaryDaoImpl().findAreas("020010000000");
        Assert.assertTrue(countryArea3.size()==2);

        List<CountryArea> countryArea4 = new DictionaryDaoImpl().findAreas("020010010000");
        Assert.assertTrue(countryArea4.size()==2);
    }
}
