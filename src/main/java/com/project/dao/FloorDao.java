package com.project.dao;

import com.project.model.FloorRep;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FloorDao {
    private static DataSource dataSource;
    public FloorDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static FloorRep save(FloorRep floorRep) throws SQLException {
        if(floorRep != null){
            if(floorRep.floorNo() == null){
                final String insert = "INSERT INTO floor (zoneNo) VAlUES (?) ";
                try(var connection = dataSource.getConnection();
                var prepareStatement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS)){
                    prepareStatement.setInt(1,floorRep.zoneNo());
                    prepareStatement.execute();
                    try(var rs = prepareStatement.getGeneratedKeys()){
                        while (rs.next()){
                            int generate_id = rs.getInt(1);
                            return new FloorRep(generate_id, floorRep.zoneNo());
                        }
                    }
                }
            }
        }else{
             final String update = "UPDATE floor SET zoneNo = ? WHERE floorNo = ?";
             try(var connection = dataSource.getConnection();
             var preparestatemet = connection.prepareStatement(update)){
                 preparestatemet.setInt(1,floorRep.floorNo());
                 preparestatemet.setInt(2,floorRep.zoneNo());
                 preparestatemet.executeUpdate();
             }
        }
        return floorRep;
    }

    public static List findAll() throws SQLException {
        final String find = "SELECT * FROM floor";
        List floors = new ArrayList<>();
        try(var connection = dataSource.getConnection();
        var preparestatement = connection.prepareStatement(find);
        var rs = preparestatement.executeQuery()){
           while (rs.next()){
                floors.add(new FloorRep(rs.getInt("floorNo"), rs.getInt("zoneNo") ));
            }
        }
        return floors;
    }

    public static Optional<FloorRep> findById(Integer floorNo) throws SQLException {
        final String findid = "SELECT floorNo , zoneNo FROM floor WHERE floorNO = ?";
        try(var connection = dataSource.getConnection();
        var preparestatement = connection.prepareStatement(findid)){
            preparestatement.setInt(1,floorNo);
            try(var rs = preparestatement.executeQuery()){
                while (rs.next()){
                    return Optional.of(new FloorRep(rs.getInt("floorNo"),rs.getInt("zoneNo")));
                }
            }
        }
        return Optional.empty();
    }

    public static void deleteById(int floorNo) throws SQLException {
        final String delete = "DELETE  FROM floor WHERE floorNo = ?";
        try(var Connection = dataSource.getConnection();
        var preparestatement = Connection.prepareStatement(delete)){
            preparestatement.setInt(1,floorNo);
            preparestatement.executeUpdate();
        }
    }

    public static void deleteAll() throws SQLException {
        final String deleteall = "DELETE  FROM floor";
        try (var connection = dataSource.getConnection();
        var prepareStatement = connection.prepareStatement(deleteall)){
            prepareStatement.executeUpdate();
        }
    }

    public static long counts() throws SQLException {
        final  String count = "SELECT COUNT(*) FROM floor";
        try(var connection = dataSource.getConnection();
        var prepareStatement = connection.prepareStatement(count);
        var rs = prepareStatement.executeQuery()){
            while(rs.next()){
                return rs.getLong(1);
            }
        }
        return 0;
    }
}
