package com.project.dao;

import com.project.model.FloorRep;
import org.h2.jdbcx.JdbcDataSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;


import static com.project.dao.FloorDao.counts;
import static org.junit.jupiter.api.Assertions.*;

class FloorDaoTest {
    private final FloorDao floorDao;

    FloorDaoTest() throws SQLException {
        JdbcDataSource jdbcDataSource = new JdbcDataSource();
        jdbcDataSource.setURL("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
        jdbcDataSource.setUser("keerthana");
        try(var connection = jdbcDataSource.getConnection();
        var statement = connection.createStatement()){
            statement.execute("""
                    CREATE TABLE IF NOT EXISTS floor(
                    floorNo INT AUTO_INCREMENT PRIMARY KEY ,
                    zoneNo INT NOT NULL )
                    """);
        }
        floorDao = new FloorDao(jdbcDataSource);
    }
    @Test
    void testSave() throws SQLException {
        FloorRep floorRep = FloorDao.save(new FloorRep(null,2));
        Assertions.assertNotNull(floorRep.floorNo(),"creation failed");
        Assertions.assertEquals(2,floorRep.zoneNo());

        FloorRep floorRep1= FloorDao.save(new FloorRep(null,20));
        Assertions.assertEquals(20,floorRep1.zoneNo());
    }
    @Test
    void testFindAll() throws SQLException {
        FloorDao.save(new FloorRep(null,25));
        FloorDao.save(new FloorRep(null,30));
        var floorRep = FloorDao.findAll();
        Assertions.assertEquals(2,floorRep.size());
    }
    @Test
    void testFindId() throws SQLException {
        var saved =FloorDao.save(new FloorRep(null,30));
        var result = FloorDao.findById(saved.floorNo());
        Assertions.assertEquals(30,result.get().zoneNo());
    }
    @Test
    void testDeleteId() throws SQLException {
       var saved1= FloorDao.save(new FloorRep(null,60));
       FloorDao.deleteById(saved1.zoneNo());
       Assertions.assertTrue(FloorDao.findById(saved1.zoneNo()).isEmpty());
    }
    @Test
    void testDelete() throws SQLException {
        FloorDao.save(new FloorRep(null,40));
        FloorDao.save(new FloorRep(null,50));
        FloorDao.deleteAll();
        Assertions.assertEquals(counts(),0);
    }
    @Test
    void testCount() throws SQLException {
        FloorDao.save(new FloorRep(null,10));
        Assertions.assertEquals(1, counts());
    }
}