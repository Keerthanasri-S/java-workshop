//package com.temperature;
//
//import com.temperature.dao.LocationDao;
//import com.temperature.model.LocationRep;
//import org.h2.jdbcx.JdbcDataSource;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.sql.SQLException;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class LocationDaoTest {
//
//    private LocationDao locationDao;
//
//    @BeforeEach
//    void setUp() throws SQLException {
//        JdbcDataSource ds = new JdbcDataSource();
//        ds.setURL("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
//        ds.setUser("nexa");
//
//        try (var conn = ds.getConnection();
//             var stmt = conn.createStatement()) {
//
//            stmt.execute("""
//                CREATE TABLE organization (
//                    org_id INT PRIMARY KEY
//                )
//            """);
//
//            stmt.execute("""
//                CREATE TABLE location (
//                    location_id INT PRIMARY KEY AUTO_INCREMENT,
//                    location_name VARCHAR(255),
//                    address VARCHAR(255),
//                    org_id INT,
//                    FOREIGN KEY (org_id) REFERENCES organization(org_id)
//                )
//            """);
//
//            stmt.execute("INSERT INTO organization(org_id) VALUES (101)");
//        }
//
//        locationDao = new LocationDao(ds);
//    }
//
//    @Test
//    void testSave() throws SQLException {
//        var saved = LocationDao.save(new LocationRep(null, "Tower A", "Chennai", 101));
//        assertNotNull(saved.location_id());
//    }
//
//    @Test
//    void testFindById() throws SQLException {
//        var saved = LocationDao.save(new LocationRep(null, "Block B", "Bangalore", 101));
//        var result = LocationDao.findById(saved.location_id());
//        assertTrue(result.isPresent());
//        assertEquals("Block B", result.get().location_name());
//    }
//
//    @Test
//    void testFindAll() throws SQLException {
//        LocationDao.save(new LocationRep(null, "Loc1", "Area1", 101));
//        LocationDao.save(new LocationRep(null, "Loc2", "Area2", 101));
//        List<LocationRep> all = LocationDao.findAll();
//        assertEquals(2, all.size());
//    }
//
//    @Test
//    void testDeleteById() throws SQLException {
//        var saved = LocationDao.save(new LocationRep(null, "ToDelete", "Area", 101));
//        LocationDao.deleteById(saved.location_id());
//        assertTrue(LocationDao.findById(saved.location_id()).isEmpty());
//    }
//
//    @Test
//    void testDeleteAll() throws SQLException {
//        LocationDao.save(new LocationRep(null, "A", "Addr", 101));
//        LocationDao.save(new LocationRep(null, "B", "Addr", 101));
//        LocationDao.deleteAll();
//        assertEquals(0, LocationDao.count());
//    }
//
//    @Test
//    void testCount() throws SQLException {
//        LocationDao.save(new LocationRep(null, "One", "Somewhere", 101));
//        assertEquals(1, LocationDao.count());
//    }
//}