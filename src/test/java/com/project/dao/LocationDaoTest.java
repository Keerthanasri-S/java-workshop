package com.project.dao;

import com.project.dao.LocationDao;
import com.project.model.LocationRep;
import org.h2.jdbcx.JdbcDataSource;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LocationDaoTest {

    private static LocationDao locationDao;

    @BeforeAll
    static void setup() throws Exception {
        JdbcDataSource ds = new JdbcDataSource();
        ds.setURL("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
        ds.setUser("keerthana");

        try (Connection connection = ds.getConnection();
             Statement stmt = connection.createStatement()) {

            stmt.execute("""
                CREATE TABLE location (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    doorno VARCHAR(255),
                    street INT,
                    areaname VARCHAR(255),
                    city VARCHAR(255),
                    district VARCHAR(255),
                    state VARCHAR(255),
                    country VARCHAR(255),
                    pincode VARCHAR(20),
                    latitude DOUBLE,
                    longitude DOUBLE
                )
            """);
        }

        locationDao = new LocationDao(ds);
    }

    @Test

    void testSave() {
        LocationRep loc = locationDao.save(new LocationRep(null, "22A", 25, "Indira Nagar", "Chennai", "Chennai", "Tamil Nadu", "India", "600020", 12.0237, 20.9749));
        assertNotNull(loc.id());
        assertEquals("Chennai", loc.city());
    }

    @Test

    void testFindById() {
        LocationRep loc = locationDao.save(new LocationRep(null, "24B", 28, "T Nagar", "Chennai", "Chennai", "Tamil Nadu", "India", "600017", 19.4032, 20.3930));
        var found = locationDao.findById(loc.id());
        assertTrue(found.isPresent());
        assertEquals("T Nagar", found.get().areaname());
    }

    @Test
    void testUpdate() {
        LocationRep loc = locationDao.save(new LocationRep(null, "30C", 33, "Velachery", "Chennai", "Chennai", "Tamil Nadu", "India", "600042", 90.2903, 80.2180));
        LocationRep updated = locationDao.save(new LocationRep(loc.id(), "40C", 43, "Velachery", "Chennai", "Chennai", "Tamil Nadu", "India", "600042", 19.2030, 80.2190));
        assertEquals(loc.id(), updated.id());
        assertEquals(12.9615, updated.latitude());
    }

    @Test

    void testFindAll() {
        locationDao.save(new LocationRep(null, "15E", 22, "Anna Nagar", "Chennai", "Chennai", "Tamil Nadu", "India", "600040", 11.0022, 70.2020));
        List<LocationRep> all = locationDao.findAll();
        assertTrue(all.size() >= 1);
    }

    @Test
    void testDeleteById() {
        LocationRep loc = locationDao.save(new LocationRep(null, "16F", 14, "Adyar", "Chennai", "Chennai", "Tamil Nadu", "India", "600020", 19.2902, 20.2544));
        locationDao.deleteById(loc.id());
        assertTrue(locationDao.findById(loc.id()).isEmpty());
    }

    @Test
    void testDeleteAll() {
        locationDao.deleteAll();
        assertEquals(0, locationDao.findAll().size());
    }
}