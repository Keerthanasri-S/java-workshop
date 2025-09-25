//package com.temperature.dao;
//
//import com.temperature.model.FloorRep;
//import com.temperature.model.ZoneRep;
//import org.h2.jdbcx.JdbcDataSource;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//import java.sql.SQLException;
//
//
//
//import static com.temperature.dao.FloorDao.findAll;
//
//class zoneDaoTest {
//    private final ZoneDao zoneDao ;
//
//     zoneDaoTest() throws SQLException {
//        JdbcDataSource jdbcDataSource = new JdbcDataSource();
//        jdbcDataSource.setURL("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
//        jdbcDataSource.setUser("keerthana");
//        try(var connection = jdbcDataSource.getConnection();
//        var statement = connection.createStatement()){
//            statement.execute("""
//                    CREATE TABLE zone(
//                    zoneNo int AUTO_INCREMENT PRIMARY KEY,
//                    noOfRoom int,
//                    zoneType VARCHAR(255) NOT NULL)
//                    """);
//        }
//        zoneDao = new ZoneDao(jdbcDataSource);
//    }
//    @Test
//    void testSave() throws SQLException {
//        ZoneRep zoneRep = zoneDao.save(new ZoneRep(null,4,"commerical"));
//        Assertions.assertNotNull(zoneRep.zoneNo(),"failed creation");
//        Assertions.assertEquals(4,zoneRep.noOfRooms(),"failed");
//
//        ZoneRep zoneRep1 = zoneDao.save(new ZoneRep(null,3,"resendial"));
//        Assertions.assertEquals(3,zoneRep1.noOfRooms());
//        Assertions.assertEquals("resendial",zoneRep1.zoneType());
//     }
//     @Test
//    void testFindAll() throws SQLException {
//         zoneDao.save(new ZoneRep(null,5,"commerical"));
//         zoneDao.save(new ZoneRep(null,5,"comm"));
//         var zone = zoneDao.findAll();
//         Assertions.assertEquals(1,zone.size());
//     }
//     @Test
//    void testFindById() throws SQLException {
//       var saved3 = zoneDao.save(new ZoneRep(null,20,"something"));
//       var result = zoneDao.findById(saved3.noOfRooms());
//       Assertions.assertEquals(20,result.get().noOfRooms());
//     }
//     @Test
//     void testDeleteId() throws SQLException {
//         var saved = zoneDao.save(new ZoneRep(null,90,"low"));
//         zoneDao.delete(saved.noOfRooms());
//         Assertions.assertTrue(zoneDao.findById(saved.zoneNo()).isEmpty());
//     }
//     @Test
//    void testDeleteAll() throws SQLException {
//         zoneDao.save(new ZoneRep(null,5,"commerical"));
//         zoneDao.save(new ZoneRep(null,15,"industrial"));
//         zoneDao.deleteAll();
//         Assertions.assertEquals(zoneDao.count1(),0,"failed");
//     }
//    @Test
//    void testCount() throws SQLException {
//        zoneDao.save(new ZoneRep(null,10,"godown"));
//        Assertions.assertEquals(1, zoneDao.count1());
//    }
//
//
//}