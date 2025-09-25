package com.temperature;

import java.sql.Connection;
import java.sql.Statement;

import org.h2.jdbcx.JdbcDataSource;
import org.junit.jupiter.api.BeforeAll;


import com.temperature.dao.LocationDao;
import com.temperature.dao.OrganizationDao;


public class TempDataIntegrationTest {

        private static OrganizationDao organizationDao;
        private static LocationDao locationDao;
    @BeforeAll
    static void setup() throws Exception {
        JdbcDataSource ds = new JdbcDataSource();
        ds.setURL("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
        ds.setUser("sa");
        ds.setPassword("");

        try (Connection conn = ds.getConnection(); Statement stmt = conn.createStatement()) {
            stmt.execute("""
        CREATE TABLE organization (
            org_id INT AUTO_INCREMENT PRIMARY KEY,
            name VARCHAR(255),
            email VARCHAR(255),
            phone VARCHAR(20),
            website VARCHAR(255)
        )
        """);

            stmt.execute("""
        CREATE TABLE location (
            location_id INT AUTO_INCREMENT PRIMARY KEY,
            location_name VARCHAR(255),
            address VARCHAR(255),
            org_id INT,
            FOREIGN KEY (org_id) REFERENCES organization(org_id)
        )
        """);
        }

        organizationDao = new OrganizationDao(ds);
        locationDao = new LocationDao(ds);
    }

}

