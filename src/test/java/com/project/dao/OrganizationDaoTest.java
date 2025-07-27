package com.project.dao;

import com.project.dao.OrganizationDao;
import com.project.model.OrganizationRep;
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
                CREATE TABLE organization (
                    id INT AUTO_INCREMENT PRIMARY KEY,
                    name VARCHAR(255),
                    certificateid VARCHAR(255),
                    type VARCHAR(255),
                    email VARCHAR(255),
                    phone VARCHAR(20),
                    ceo VARCHAR(255)
                )
            """);
        }

        organizationDao = new OrganizationDao(ds);
    }

    @Test

    void testSave() throws SQLException {
        OrganizationRep org = new OrganizationRep(null, "Tech Corp", "CERT123", "Private", "contact@techcorp.com", "1234567890", "Alice Smith");
        OrganizationRep saved = organizationDao.save(org);
        assertNotNull(saved.id());
        assertEquals("Tech Corp", saved.name());
    }

    @Test

    void testUpdate() throws SQLException {
        OrganizationRep org = organizationDao.save(new OrganizationRep(null, "Edu Inc", "CERT456", "Public", "info@edu.com", "9876543210", "John Doe"));
        OrganizationRep updated = organizationDao.save(new OrganizationRep(org.id(), "Edu Ltd", "CERT456", "Public", "info@edu.com", "9876543210", "Jane Roe"));

        assertEquals(org.id(), updated.id());
        assertEquals("Edu Ltd", updated.name());
        assertEquals("Jane Roe", updated.ceo());
    }

    @Test

    void testFindById() throws SQLException {
        OrganizationRep org = organizationDao.save(new OrganizationRep(null, "Health Org", "CERT789", "Non-Profit", "contact@health.org", "9999999999", "Dr. Smith"));
        var result = organizationDao.findById(org.id());

        assertTrue(result.isPresent());
        assertEquals("Health Org", result.get().name());
    }

    @Test

    void testFindAll() throws SQLException {
        organizationDao.save(new OrganizationRep(null, "EnviroTech", "CERT001", "NGO", "enviro@tech.org", "1111111111", "Leo K."));
        organizationDao.save(new OrganizationRep(null, "Green Future", "CERT002", "NGO", "green@future.org", "2222222222", "Mia G."));
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
        OrganizationRep org = organizationDao.save(new OrganizationRep(null, "Temp Org", "CERT003", "Private", "temp@org.com", "3333333333", "Temp CEO"));
        organizationDao.deleteById(org.id());
        assertTrue(organizationDao.findById(org.id()).isEmpty());
    }

    @Test

    void testDeleteAll() throws SQLException {
        organizationDao.deleteAll();
        assertEquals(0, organizationDao.count());
    }
}