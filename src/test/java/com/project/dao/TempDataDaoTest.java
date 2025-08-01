//package com.temperature.dao;
//
//import com.temperature.model.Temp_dataRep;
//import org.h2.jdbcx.JdbcDataSource;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.sql.Timestamp;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class TempDataDaoTest {
//
//    private TempDataDao tempDataDao;
//
//    @BeforeEach
//    void setUp() throws Exception {
//        JdbcDataSource ds = new JdbcDataSource();
//        ds.setURL("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
//        ds.setUser("nexa");
//
//        try (var conn = ds.getConnection();
//             var stmt = conn.createStatement()) {
//            stmt.execute("""
//                CREATE TABLE IF NOT EXISTS temp_data (
//                    temp_data INT,
//                    date_time TIMESTAMP
//                )
//            """);
//        }
//
//        tempDataDao = new TempDataDao(ds);
//    }
//
//    @Test
//    void testSave() throws Exception {
//        Timestamp now = new Timestamp(System.currentTimeMillis());
//        Temp_dataRep saved = TempDataDao.save(new Temp_dataRep(25, now));
//        assertEquals(25, saved.tempData());
//        assertEquals(now, saved.dateTime());
//    }
//
//    @Test
//    void testFindAll() throws Exception {
//        TempDataDao.save(new Temp_dataRep(21, new Timestamp(System.currentTimeMillis())));
//        TempDataDao.save(new Temp_dataRep(30, new Timestamp(System.currentTimeMillis())));
//        List<Temp_dataRep> all = TempDataDao.findAll();
//        assertEquals(2, all.size());
//    }
//
//    @Test
//    void testDeleteAll() throws Exception {
//        TempDataDao.save(new Temp_dataRep(22, new Timestamp(System.currentTimeMillis())));
//        TempDataDao.deleteAll();
//        assertEquals(0, TempDataDao.count());
//    }
//
//    @Test
//    void testCount() throws Exception {
//        TempDataDao.save(new Temp_dataRep(23, new Timestamp(System.currentTimeMillis())));
//        assertEquals(1, TempDataDao.count());
//    }
//}