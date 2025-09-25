package com.temperature;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.temperature.dao.OrganizationDao;
import org.h2.jdbcx.JdbcDataSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.temperature.model.OrganizationRep;
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
        OrganizationRep org = new OrganizationRep(1,"Tech Corp", "CERT123@gmail.com", "1234567890", "contact@techcorp.com");
        OrganizationRep saved = organizationDao.save(org);
        Assertions.assertNotNull(saved.org_id());
        Assertions.assertEquals("Tech Corp", saved.name());
    }

    @Test

    void testUpdate() throws SQLException {
        OrganizationRep org = organizationDao.save(new OrganizationRep(2,"Edu Inc", "CERT456@gmail.com", "1234567890", "info@edu.com"));
        OrganizationRep updated = organizationDao.save(new OrganizationRep(3,"Edu Ltd", "CERT456@gmail.com", "1234567890", "info@edu.com"));

        Assertions.assertEquals(org.org_id(), updated.org_id());
        Assertions.assertEquals("Edu Ltd", updated.name());
        Assertions.assertEquals("info@edu.com", updated.website());
    }

    @Test

    void testFindById() throws SQLException {
        OrganizationRep org = organizationDao.save(new OrganizationRep(4,"Health Org", "CERT789@gmail.com", "1234567890", "contact@health.org"));
        var result = organizationDao.findById(org.org_id());

        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals("Health Org", result.get().name());
    }

    @Test

    void testFindAll() throws SQLException {
        organizationDao.save(new OrganizationRep(5,"EnviroTech", "CERT001@gmail.com", "1234567890", "enviro@tech.org"));
        organizationDao.save(new OrganizationRep(6,"Green Future", "CERT002@gmail.com", "1234567890", "green@future.org"));
        List<OrganizationRep> list = organizationDao.findAll();

        Assertions.assertTrue(list.size() >= 2);
    }

    @Test

    void testCount() throws SQLException {
        long count = organizationDao.count();
        Assertions.assertTrue(count >= 1);
    }

    @Test

    void testDeleteById() throws SQLException {
        OrganizationRep org = organizationDao.save(new OrganizationRep(7,"Temp Org", "CERT003@gmail.com", "1234567890", "temp@org.com"));
        organizationDao.deleteById(org.org_id());
        Assertions.assertTrue(organizationDao.findById(org.org_id()).isEmpty());
    }

    @Test

    void testDeleteAll() throws SQLException {
        organizationDao.deleteAll();
        Assertions.assertEquals(0, organizationDao.count());
    }
}