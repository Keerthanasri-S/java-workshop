package com.project.dao;

import com.project.model.SensorRep;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SensorDao {

         private static DataSource dataSource;

        public SensorDao(DataSource dataSource) {
            SensorDao.dataSource = dataSource;
        }

        public static SensorRep save(SensorRep sensorRep) throws SQLException {
            if (sensorRep.sensor_id() == null) {
                final String insertSql = "INSERT INTO sensor(sensor_no) VALUES(?)";
                try (Connection connection = dataSource.getConnection();
                     PreparedStatement ps = connection.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS)) {
                    ps.setInt(1, sensorRep.sensor_no());
                    ps.execute();
                    try (ResultSet rs = ps.getGeneratedKeys()) {
                        if (rs.next()) {
                            int generatedId = rs.getInt(1);
                            return new SensorRep(generatedId, sensorRep.sensor_no());
                        }
                    }
                }
            } else {
                final String updateSql = "UPDATE sensor SET sensor_no = ? WHERE sensor_id = ?";
                try (Connection connection = dataSource.getConnection();
                     PreparedStatement ps = connection.prepareStatement(updateSql)) {
                    ps.setInt(1, sensorRep.sensor_no());
                    ps.setInt(2, sensorRep.sensor_id());
                    ps.executeUpdate();
                    return sensorRep;
                }
            }
            return null;
        }

        public static List<SensorRep> findAll() throws SQLException {
            final String query = "SELECT * FROM sensor";
            List<SensorRep> sensors = new ArrayList<>();
            try (Connection connection = dataSource.getConnection();
                 PreparedStatement ps = connection.prepareStatement(query);
                 ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    sensors.add(new SensorRep(rs.getInt("sensor_id"), rs.getInt("sensor_no")));
                }
            }
            return sensors;
        }

        public static Optional<SensorRep> findById(int sensorId) throws SQLException {
            final String query = "SELECT sensor_id, sensor_no FROM sensor WHERE sensor_id = ?";
            try (Connection connection = dataSource.getConnection();
                 PreparedStatement ps = connection.prepareStatement(query)) {
                ps.setInt(1, sensorId);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        return Optional.of(new SensorRep(rs.getInt("sensor_id"), rs.getInt("sensor_no")));
                    }
                }
            }
            return Optional.empty();
        }

        public static void deleteById(int sensorId) throws SQLException {
            final String deleteSql = "DELETE FROM sensor WHERE sensor_id = ?";
            try (Connection connection = dataSource.getConnection();
                 PreparedStatement ps = connection.prepareStatement(deleteSql)) {
                ps.setInt(1, sensorId);
                ps.executeUpdate();
            }
        }

        public static void deleteAll() throws SQLException {
            final String deleteSql = "DELETE FROM sensor";
            try (Connection connection = dataSource.getConnection();
                 PreparedStatement ps = connection.prepareStatement(deleteSql)) {
                ps.executeUpdate();
            }
        }

        public static long count() throws SQLException {
            final String countSql = "SELECT COUNT(*) FROM sensor";
            try (Connection connection = dataSource.getConnection();
                 PreparedStatement ps = connection.prepareStatement(countSql);
                 ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getLong(1);
                }
            }
            return 0;
        }
    }


