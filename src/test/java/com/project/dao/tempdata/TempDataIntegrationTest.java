package com.temperature.dao.tempdata;

import com.temperature.dao.LocationDao;
import com.temperature.dao.OrganizationDao;
import com.temperature.model.LocationRep;
import com.temperature.model.OrganizationRep;
import org.h2.jdbcx.JdbcDataSource;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TempDataIntegrationTest {

        private static OrganizationDao organizationDao;
        private static LocationDao locationDao;
        @BeforeAll
        static void setup() throws Exception {
            JdbcDataSource ds = new JdbcDataSource();
            ds.setURL("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
            ds.setUser("keerthana");

            try (Connection conn = ds.getConnection(); Statement stmt = conn.createStatement()) {
                stmt.execute("""
                CREATE TABLE organization (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    name VARCHAR(255),
                    contactNo VARCHAR(20),
                    email VARCHAR(255),
                    website VARCHAR(20)
                )
            """);
                stmt.execute("""
                CREATE TABLE location (
                    location_id INT AUTO_INCREMENT PRIMARY KEY,
                    location_name VARCHAR(255),
                    address VARCHAR(255),
                    org_id INT REFERENCES Organization
                )
            """);
            }

            organizationDao = new OrganizationDao(ds);
            locationDao = new LocationDao(ds);
        }

        @Test
        public void testFlow() throws SQLException {
            OrganizationRep org = new OrganizationRep(null, "Tech Corp", "1234", "contact@techcorp.com", "www.abc.com");
            OrganizationRep saved = organizationDao.save(org);
            assertNotNull(saved.org_id());
            assertEquals("Tech Corp", saved.name());

            LocationRep location = locationDao.save(new LocationRep(null, "Madurai", "Othakadai", saved.org_id()));
            assertNotNull(location.location_id());
            assertEquals("Madurai", location.location_name());
        }
    }

