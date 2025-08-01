package com.temperature.dao;

import com.temperature.dao.OrganizationDao;
import com.temperature.model.OrganizationRep;
import org.h2.jdbcx.JdbcDataSource;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class OrganizationDaoTest {

    private static OrganizationDao organizationDao;

    @BeforeAll
    static void setup() throws Exception {
        JdbcDataSource ds = new JdbcDataSource();
        ds.setURL("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
        ds.setUser("satha");

        try (Connection conn = ds.getConnection(); Statement stmt = conn.createStatement()) {
            stmt.execute("""
                CREATE TABLE  organization (
                    org_id INT AUTO_INCREMENT PRIMARY KEY,
                    name VARCHAR(255),
                    email VARCHAR(255),
                    phone VARCHAR(20),
                    website VARCHAR(255)
                )
            """);
        }

        organizationDao = new OrganizationDao(ds);
    }

    @Test

    void testSave() throws SQLException {
        OrganizationRep org = new OrganizationRep(null, "Tech Corp", "CERT123@gmail.com", "1234567890", "contact@techcorp.com");
        OrganizationRep saved = organizationDao.save(org);
        assertNotNull(saved.org_id());
        assertEquals("Tech Corp", saved.name());
    }

    @Test

    void testUpdate() throws SQLException {
        OrganizationRep org = organizationDao.save(new OrganizationRep(null, "Edu Inc", "CERT456@gmail.com", "1234567890", "info@edu.com"));
        OrganizationRep updated = organizationDao.save(new OrganizationRep(org.org_id(), "Edu Ltd", "CERT456@gmail.com", "1234567890", "info@edu.com"));

        assertEquals(org.org_id(), updated.org_id());
        assertEquals("Edu Ltd", updated.name());
        assertEquals("info@edu.com", updated.website());
    }

    @Test

    void testFindById() throws SQLException {
        OrganizationRep org = organizationDao.save(new OrganizationRep(null, "Health Org", "CERT789@gmail.com", "1234567890", "contact@health.org"));
        var result = organizationDao.findById(org.org_id());

        assertTrue(result.isPresent());
        assertEquals("Health Org", result.get().name());
    }

    @Test

    void testFindAll() throws SQLException {
        organizationDao.save(new OrganizationRep(null, "EnviroTech", "CERT001@gmail.com", "1234567890", "enviro@tech.org"));
        organizationDao.save(new OrganizationRep(null, "Green Future", "CERT002@gmail.com", "1234567890", "green@future.org"));
        List<OrganizationRep> list = organizationDao.findAll();

        assertTrue(list.size() >= 2);
    }

    @Test

    void testCount() throws SQLException {
        long count = organizationDao.count();
        assertTrue(count >= 1);
    }

    @Test

    void testDeleteById() throws SQLException {
        OrganizationRep org = organizationDao.save(new OrganizationRep(null, "Temp Org", "CERT003@gmail.com", "1234567890", "temp@org.com"));
        organizationDao.deleteById(org.org_id());
        assertTrue(organizationDao.findById(org.org_id()).isEmpty());
    }

    @Test

    void testDeleteAll() throws SQLException {
        organizationDao.deleteAll();
        assertEquals(0, organizationDao.count());
    }
}