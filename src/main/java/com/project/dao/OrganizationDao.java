package com.project.dao;

import com.project.model.OrganizationRep;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrganizationDao {
    private final DataSource dataSource;

    public OrganizationDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public OrganizationRep save(OrganizationRep org) {
        try (Connection conn = dataSource.getConnection()) {
            if (org.id() == null) {
                String sql = "INSERT INTO organization(name, certificateid, type, email, phone, ceo) VALUES (?, ?, ?, ?, ?, ?)";
                try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                    stmt.setString(1, org.name());
                    stmt.setString(2, org.certificateid());
                    stmt.setString(3, org.type());
                    stmt.setString(4, org.email());
                    stmt.setString(5, org.phone());
                    stmt.setString(6, org.ceo());
                    stmt.executeUpdate();

                    try (ResultSet rs = stmt.getGeneratedKeys()) {
                        if (rs.next()) {
                            return new OrganizationRep(
                                    rs.getInt(1),
                                    org.name(),
                                    org.certificateid(),
                                    org.type(),
                                    org.email(),
                                    org.phone(),
                                    org.ceo()
                            );
                        }
                    }
                }
            } else {
                String sql = "UPDATE organization SET name=?, certificateid=?, type=?, email=?, phone=?, ceo=? WHERE id=?";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setString(1, org.name());
                    stmt.setString(2, org.certificateid());
                    stmt.setString(3, org.type());
                    stmt.setString(4, org.email());
                    stmt.setString(5, org.phone());
                    stmt.setString(6, org.ceo());
                    stmt.setInt(7, org.id());
                    stmt.executeUpdate();
                    return org;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public Optional<OrganizationRep> findById(int id) {
        String sql = "SELECT * FROM organization WHERE id=?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(new OrganizationRep(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("certificateid"),
                            rs.getString("type"),
                            rs.getString("email"),
                            rs.getString("phone"),
                            rs.getString("ceo")
                    ));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
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
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("certificateid"),
                        rs.getString("type"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("ceo")
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

    public void deleteById(int id) {
        String sql = "DELETE FROM organization WHERE id=?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
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