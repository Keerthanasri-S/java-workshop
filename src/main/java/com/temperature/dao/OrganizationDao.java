package com.temperature.dao;

import java.sql. Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import com.temperature.model.OrganizationRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class OrganizationDao {
    @Autowired
    private final DataSource dataSource;

    public OrganizationDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public OrganizationRep save(OrganizationRep org) {
        try (Connection conn = dataSource.getConnection()) {
            if (org.org_id() == null) {
                String sql = "INSERT INTO organization(name,  email, phone, website) VALUES (?, ?, ?, ?)";
                try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                    stmt.setString(1, org.name());
                    stmt.setString(2, org.email());
                    stmt.setString(3, org.phone());
                    stmt.setString(4, org.website());
                    stmt.executeUpdate();

                    try (ResultSet rs = stmt.getGeneratedKeys()) {
                        if (rs.next()) {
                            return new OrganizationRep(
                                    org.org_id(), org.name(),
                                    org.email(),
                                    org.phone(),
                                    org.website()
                            );
                        }
                    }
                }
            } else {
                String sql = "UPDATE organization SET name=?,  email=?, phone=?, website=? WHERE org_id=?";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, org.name());
                    stmt.setString(2, org.email());
                    stmt.setString(3, org.phone());
                    stmt.setString(4, org.website());
                    stmt.setInt(5, org.org_id());
                    stmt.executeUpdate();
                    return org;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public Optional<OrganizationRep> findById(Integer org_id) throws SQLException {
        String sql = "SELECT * FROM organization WHERE org_id=?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, org_id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(new OrganizationRep(
    rs.getInt("org_id"),
    rs.getString("name"),
    rs.getString("email"),
    rs.getString("phone"),
    rs.getString("website")
));

                }
            }
        }
        return Optional.empty();
    }

    public List<OrganizationRep> findAll() {
        List<OrganizationRep> list = new ArrayList<>();
        String sql = "SELECT * FROM organization";
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new OrganizationRep(
                    rs.getInt("org_id"),
                                                rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("website")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public long count() {
        String sql = "SELECT COUNT(*) FROM organization";
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    public void deleteById(Integer org_id) {
        String sql = "DELETE FROM organization WHERE org_id=?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, org_id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteAll() {
        String sql = "DELETE FROM organization";
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}