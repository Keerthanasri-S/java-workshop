package com.project.dao;

import com.project.model.SensorRep;
import org.h2.jdbcx.JdbcDataSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class SensorDaoTest {

        private SensorDao sensorDao;

        @BeforeEach
        void setUp() throws SQLException {
            JdbcDataSource dataSource = new JdbcDataSource();
            dataSource.setURL("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
            dataSource.setUser("nexa");

            try (var connection = dataSource.getConnection();
                 var statement = connection.createStatement()) {
                statement.execute("""
                CREATE TABLE IF NOT EXISTS sensor(
                    sensor_id INT PRIMARY KEY AUTO_INCREMENT,
                    sensor_no INT
                )
            """);
            }

            sensorDao = new SensorDao(dataSource);
        }

        @Test
        void testSave() throws SQLException {
            var saved = SensorDao.save(new SensorRep(null, 100));
            assertNotNull(saved.sensor_id());
            assertEquals(100, saved.sensor_no());
        }

        @Test
        void testFindAll() throws SQLException {
            SensorDao.save(new SensorRep(null, 101));
            SensorDao.save(new SensorRep(null, 102));
            var all = SensorDao.findAll();
            assertEquals(2, all.size());
        }

        @Test
        void testFindById() throws SQLException {
            var saved = SensorDao.save(new SensorRep(null, 103));
            var found = SensorDao.findById(saved.sensor_id());
            assertTrue(found.isPresent());
            assertEquals(103, found.get().sensor_no());
        }

        @Test
        void testDeleteById() throws SQLException {
            var saved = SensorDao.save(new SensorRep(null, 104));
            SensorDao.deleteById(saved.sensor_id());
            var found = SensorDao.findById(saved.sensor_id());
            assertTrue(found.isEmpty());
        }

        @Test
        void testDeleteAll() throws SQLException {
            SensorDao.save(new SensorRep(null, 105));
            SensorDao.save(new SensorRep(null, 106));
            SensorDao.deleteAll();
            assertEquals(0, SensorDao.count());
        }

        @Test
        void testCount() throws SQLException {
            SensorDao.save(new SensorRep(null, 107));
            assertEquals(1, SensorDao.count());
        }
    }

