package com.project.dao;

import com.project.model.BuildingRep;
import org.h2.jdbcx.JdbcDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Optional;

public class BuildingDao {

    private static DataSource dataSource;
    public BuildingDao(final DataSource dataSource) {
        this.dataSource =dataSource ;
    }

    public static BuildingRep save(BuildingRep buildingRep) throws SQLException {
        if(buildingRep != null){
            if(buildingRep.bulidingno() == null){
                final String insertSql = "INSERT INTO building ( name, noOfFloors) VALUES(?,?)";
                try(Connection connection = dataSource.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(insertSql,Statement.RETURN_GENERATED_KEYS)){
                    preparedStatement.setString(1, buildingRep.name());
                    preparedStatement.setInt(2,buildingRep.noOfFloors());
                    preparedStatement.execute();
                    try(ResultSet resultSet = preparedStatement.getGeneratedKeys()){
                        if (resultSet.next()){
                            int generatedId = resultSet.getInt(1);
                            return new BuildingRep(buildingRep.name(),generatedId, buildingRep.noOfFloors());
                        }
                    }
                }

            }
        }
        else {
            final String updateSql = "UPDATE building SET name =? , noOfFloor = ? WHERE buildingno = ?";
            try(var connection =dataSource.getConnection();
            var prepareStatement = connection.prepareStatement(updateSql)){
                prepareStatement.setString(1, buildingRep.name());
                prepareStatement.setInt(2,buildingRep.noOfFloors());
                prepareStatement.setInt(3,buildingRep.bulidingno());
                prepareStatement.executeUpdate();
                return new BuildingRep(buildingRep.name(), buildingRep.bulidingno(), buildingRep.noOfFloors());
            }
        }
        return null;
    }

    public static List<BuildingRep> findAll() throws SQLException {
        final String findSql = "SELECT * FROM building";
        List<BuildingRep> buildingReps = new ArrayList<>();
        try(var connection = dataSource.getConnection();
        var presta = connection.prepareStatement(findSql);
        var resultset = presta.executeQuery()){
            while (resultset.next()){
                buildingReps.add(new BuildingRep(resultset.getString("name"), resultset.getInt("buildingno"), resultset.getInt("noOfFloors") ));
            }
        }
        return buildingReps;
    }

    public static Optional<BuildingRep> findById(Integer bulidingno) throws SQLException {
      final String findIdSql = "SELECT name,noOfFloors,buildingno FROM building WHERE buildingno=?";
        try(var connection = dataSource.getConnection();
            var presta = connection.prepareStatement(findIdSql))
        {
            presta.setInt(1,bulidingno);
            try(var resultset = presta.executeQuery()){
            while (resultset.next()){
                return Optional.of(new BuildingRep(resultset.getString("name"), resultset.getInt("buildingno"), resultset.getInt("noOfFloors") ));
            }
        }
        }
        return Optional.empty();
    }

    public static void deleteId(final Integer bulidingno) throws SQLException {
        final String deleteSql = "DELETE FROM building WHERE buildingno = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedstatement = connection.prepareStatement(deleteSql)) {
            preparedstatement.setInt(1, bulidingno);
            preparedstatement.executeUpdate();
        }
    }

    public static void deleteAll() throws SQLException {
        final String delete = "DELETE  FROM building";
        try(Connection connectionection= dataSource.getConnection();
            PreparedStatement preparedStatement = connectionection.prepareStatement(delete)) {
            preparedStatement.executeUpdate();
        }
    }

    public static long count() throws SQLException {
        final String count = "SELECT COUNT(*) FROM building";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedstatement = connection.prepareStatement(count);
             ResultSet rs = preparedstatement.executeQuery()) {
            if (rs.next()) {
                return rs.getLong(1);
            }
        }
        return 0;
    }
}
