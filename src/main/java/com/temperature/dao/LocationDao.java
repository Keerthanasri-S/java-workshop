package com.temperature.dao;

import com.temperature.model.LocationRep;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LocationDao {

    private static DataSource dataSource;

    public LocationDao(DataSource dataSource) {
        LocationDao.dataSource = dataSource;
    }

    public static LocationRep save(LocationRep locationRep) throws SQLException {
        if (locationRep.location_id() == null) {
            final String insert = """
                INSERT INTO location(location_name, address, org_id)
                VALUES (?, ?, ?)
            """;
            try (Connection conn = dataSource.getConnection();
                 PreparedStatement ps = conn.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, locationRep.location_name());
                ps.setString(2, locationRep.address());
                ps.setInt(3, locationRep.org_id());
                ps.executeUpdate();

                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        return new LocationRep(rs.getInt(1), locationRep.location_name(), locationRep.address(), locationRep.org_id());
                    }
                }
            }
        } else {
            final String update = """
                UPDATE location SET location_name = ?, address = ?, org_id = ?
                WHERE location_id = ?
            """;
            try (Connection conn = dataSource.getConnection();
                 PreparedStatement ps = conn.prepareStatement(update)) {
                ps.setString(1, locationRep.location_name());
                ps.setString(2, locationRep.address());
                ps.setInt(3, locationRep.org_id());
                ps.setInt(4, locationRep.location_id());
                ps.executeUpdate();
                return locationRep;
            }
        }
        return null;
    }

    public static Optional<LocationRep> findById(int locationId) throws SQLException {
        final String query = "SELECT * FROM location WHERE location_id = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, locationId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(new LocationRep(
                            rs.getInt("location_id"),
                            rs.getString("location_name"),
                            rs.getString("address"),
                            rs.getInt("org_id")
                    ));
                }
            }
        }
        return Optional.empty();
    }

    public static List<LocationRep> findAll() throws SQLException {
        final String query = "SELECT * FROM location";
        List<LocationRep> locations = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                locations.add(new LocationRep(
                        rs.getInt("location_id"),
                        rs.getString("location_name"),
                        rs.getString("address"),
                        rs.getInt("org_id")
                ));
            }
        }
        return locations;
    }

    public static void deleteById(int locationId) throws SQLException {
        final String sql = "DELETE FROM location WHERE location_id = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, locationId);
            ps.executeUpdate();
        }
    }

    public static void deleteAll() throws SQLException {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("DELETE FROM location")) {
            ps.executeUpdate();
        }
    }

    public static long count() throws SQLException {
        final String sql = "SELECT COUNT(*) FROM location";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) return rs.getLong(1);
        }
        return 0;
    }
}