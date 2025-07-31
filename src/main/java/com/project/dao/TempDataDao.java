package com.project.dao;


import com.project.model.Temp_dataRep;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TempDataDao {

    private static DataSource dataSource;

    public TempDataDao(DataSource dataSource) {
        TempDataDao.dataSource = dataSource;
    }

    public static Temp_dataRep save(Temp_dataRep tempDataRep) throws SQLException {
        final String insertSql = "INSERT INTO temp_data(temp_data, date_time) VALUES (?, ?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(insertSql)) {
            ps.setInt(1, tempDataRep.tempData());
            ps.setTimestamp(2, tempDataRep.dateTime());
            ps.executeUpdate();
        }
        return tempDataRep;
    }

    public static List<Temp_dataRep> findAll() throws SQLException {
        final String query = "SELECT temp_data, date_time FROM temp_data";
        List<Temp_dataRep> results = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                results.add(new Temp_dataRep(rs.getInt("temp_data"), rs.getTimestamp("date_time")));
            }
        }
        return results;
    }

    public static List<Temp_dataRep> findRecent(int minutes) throws SQLException {
        final String query = """
                SELECT temp_data, date_time FROM temp_data
                WHERE date_time >= CURRENT_TIMESTAMP - INTERVAL '? minute'
                """;
        List<Temp_dataRep> results = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, minutes);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    results.add(new Temp_dataRep(rs.getInt("temp_data"), rs.getTimestamp("date_time")));
                }
            }
        }
        return results;
    }

    public static void deleteAll() throws SQLException {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("DELETE FROM temp_data")) {
            ps.executeUpdate();
        }
    }

    public static long count() throws SQLException {
        final String countSql = "SELECT COUNT(*) FROM temp_data";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(countSql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getLong(1);
            }
        }
        return 0;
    }
}
