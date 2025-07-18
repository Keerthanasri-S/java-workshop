package com.project.dao;

import com.project.model.BuildingRep;
import org.h2.jdbcx.JdbcDataSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static com.project.dao.BuildingDao.count;
import static org.junit.jupiter.api.Assertions.*;

class BuildingDaoTest {
    private  BuildingDao buildingDao;

    @BeforeEach
    void  BuildingDaoTest() throws SQLException {
        JdbcDataSource jdbcDataSource = new JdbcDataSource();
        jdbcDataSource.setURL("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
        jdbcDataSource.setUser("keerthana");
        try(var connection = jdbcDataSource.getConnection();
            var statement = connection.createStatement()){
            statement.execute("""
                    CREATE TABLE IF NOT EXISTS building(
                    buildingno INT PRIMARY KEY AUTO_INCREMENT,
                    name VARCHAR(255),
                    noOfFloors INT)
                    """);
        }
        buildingDao = new BuildingDao(jdbcDataSource);
    }

    @Test
    void testSave() throws SQLException {
        BuildingRep buildingRep = BuildingDao.save(new BuildingRep("TechTower",null,1));
        assertNotNull(buildingRep.bulidingno(),"building number creation failed");

        BuildingRep buildingRep1 = BuildingDao.save(new BuildingRep ("infinitfy plaza",null,4));
        Assertions.assertEquals("infinitfy plaza",buildingRep1.name(),"failed");
        Assertions.assertEquals(buildingRep1.noOfFloors(),buildingRep1.noOfFloors(),"creation failed");
    }
    @Test
    void testFindAll() throws SQLException {
        BuildingDao.save(new BuildingRep("taj mahal",null,1));
        BuildingDao.save(new BuildingRep("infinity plaza",null,4));
        var buildingRep = BuildingDao.findAll();
        Assertions.assertEquals(2,buildingRep.size());

    }
    @Test
    void testfindbyId() throws SQLException {
        var saved= BuildingDao.save(new BuildingRep("something else",null,3));
        var result = BuildingDao.findById(saved.bulidingno());
        Assertions.assertEquals("something else",result.get().name());
    }
    @Test
    void testdeleteById() throws SQLException {
        var saved1 = BuildingDao.save(new BuildingRep("taj mahal",null,1));
        BuildingDao.deleteId(saved1.bulidingno());
        Assertions.assertTrue(BuildingDao.findById(saved1.bulidingno()).isEmpty());
    }
    @Test
    void testDelete() throws SQLException {
        BuildingDao.save(new BuildingRep("infinity plaza",null,4));
        BuildingDao.save(new BuildingRep("tech plaza",null,1));
        BuildingDao.deleteAll();
        Assertions.assertEquals(count(),0);
    }
    @Test
    void testCount() throws SQLException {
        BuildingDao.save(new BuildingRep("techno genesis",null,2));
        Assertions.assertEquals(1,BuildingDao.count());
    }

}