//package com.temperature.dao;
//
//import com.temperature.model.ZoneRep;
//
//import javax.sql.DataSource;
//import java.awt.desktop.OpenFilesEvent;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//public class ZoneDao {
//    private final DataSource dataSource;
//    public ZoneDao(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
//
//    public ZoneRep save(ZoneRep zoneRep) throws SQLException {
//        if(zoneRep != null){
//            if(zoneRep.zoneNo()== null){
//                final String insert = "INSERT INTO zone (noOfRoom,zoneType) VALUES (?,?)";
//                try(var connection = dataSource.getConnection();
//                var preparestatement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS)){
//                    preparestatement.setInt(1,zoneRep.noOfRooms());
//                    preparestatement.setString(2,zoneRep.zoneType());
//                    preparestatement.execute();
//                    try(var rs = preparestatement.getGeneratedKeys()){
//                        while (rs.next()){
//                           int generate_id= rs.getInt(1);
//                           return new ZoneRep(generate_id, zoneRep.noOfRooms(), zoneRep.zoneType());
//                        }
//                    }
//                }
//            }else {
//                final String update = "UPDATE zone SET noOfRoom = ?,zoneType= ? WHERE zoneNo = ?";
//                try(var connection = dataSource.getConnection();
//                var prepareStatement = connection.prepareStatement(update)){
//                    prepareStatement.setInt(1,zoneRep.zoneNo());
//                    prepareStatement.setInt(2,zoneRep.noOfRooms());
//                    prepareStatement.setString(3,zoneRep.zoneType());
//                    prepareStatement.executeUpdate();
//                }
//            }
//        }
//        return null;
//    }
//
//    public List<ZoneRep> findAll() throws SQLException {
//        final String find = "Select * from zone";
//        List zones = new ArrayList<>();
//        try(var connection = dataSource.getConnection();
//        var prepareStatement = connection.prepareStatement(find)){
//            prepareStatement.execute();
//            try(var rs = prepareStatement.executeQuery()){
//                if(rs.next()){
//                     zones.add(new ZoneRep(rs.getInt("zoneNo"), rs.getInt("noOfRoom"),rs.getString("zoneType")));
//                }
//            }
//        }
//        return zones;
//    }
//
//    public Optional<ZoneRep> findById(int zoneNo) throws SQLException {
//        final String findId = "select zoneNo,noOfRoom,zoneType from zone where zoneNo=?";
//        try(var connection = dataSource.getConnection();
//        var preparestatement = connection.prepareStatement(findId)){
//            preparestatement.setInt(1,zoneNo);
//            try(var rs = preparestatement.executeQuery()){
//                while(rs.next()){
//                    return Optional.of(new ZoneRep(rs.getInt("zoneNo"),rs.getInt("noOfRoom"),rs.getString("zoneType")));
//                }
//            }
//        }
//        return Optional.empty();
//    }
//
//    public void deleteAll() throws SQLException {
//        final String delete = "delete from zone";
//        try(var connection = dataSource.getConnection();
//        var prepare =connection.prepareStatement(delete)){
//            prepare.execute();
//        }
//    }
//
//    public long count1() throws SQLException {
//        final String count = "select count(*) from zone";
//        try(var connection = dataSource.getConnection();
//        var prepare = connection.prepareStatement(count);
//        var rs = prepare.executeQuery()){
//           while (rs.next()){
//               return rs.getLong(1);
//           }
//        }
//        return 0;
//    }
//
//    public void delete(int zoneNo) throws SQLException {
//        final String deleteid = "delete from zone where zoneNo=?";
//        try(var connection = dataSource.getConnection();
//        var prepare = connection.prepareStatement(deleteid)){
//            prepare.setInt(1,zoneNo);
//         prepare.executeUpdate();
//        }
//    }
//}
