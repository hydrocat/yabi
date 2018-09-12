package ipb.yabi.test;

import ipb.yabi.DatabaseReader.DatabaseReader;
import ipb.yabi.Directory.Directory;
import ipb.yabi.Directory.DirectoryRepository;
import ipb.yabi.SqlQuery.SqlQuery;
import ipb.yabi.SqlQuery.SqlQueryRepository;
import ipb.yabi.test.testPojo.DirectoriesForTesting;
import ipb.yabi.test.testPojo.SqlQueryMaria;
import ipb.yabi.test.testPojo.SqlQueryOracle;
import ipb.yabi.test.testPojo.SqlQueryPostgress;
import ipb.yabi.test.testPojo.SqlQuerySqlServer;
import java.util.ArrayList;
import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.Map;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest
@Qualifier("DatabaseReader")
public class DatabaseReaderTest {

    @Autowired
    DirectoryRepository dirRepo;
    @Autowired
    SqlQueryRepository sqlRepo;

    DatabaseReader dbr;

    Map<String, Directory> dirs = new HashMap<>();
    
    @Test
    public void pass() {
        
    }
//
//    @Before
//    public void setUp() {
//        if (dirs.isEmpty()) {
//            for (Directory d : DirectoriesForTesting.dirs) {
//                dirs.put(d.getName(), dirRepo.save(d));
//            }
//
//            dbr = new DatabaseReader(sqlRepo, dirRepo);
//        }
//    }
//
//    @Test
//    public void mariaDbTest() throws Exception {
//        SqlQuery q = SqlQueryMaria.selectAllArtists();
//        q.setDirectory(dirs.get("MariaDB"));
//        q = sqlRepo.save(q);
//
//        ArrayList<ArrayList<String>> r = dbr.runQuery(q.getId().toString());
//
//        assertThat(r.size(), is(276));
//    }
//
//    @Test
//    public void oracleDbTest() throws Exception {
//        SqlQuery q = SqlQueryOracle.selectAllArtists();
//        q.setDirectory(dirs.get("OracleXE"));
//        q = sqlRepo.save(q);
//
//        ArrayList<ArrayList<String>> r = dbr.runQuery(q.getId().toString());
//
//        assertThat(r.size(), is(276));
//    }
//
//    @Test
//    public void postgressDbTest() throws Exception {
//        SqlQuery q = SqlQueryPostgress.selectAllArtists();
//        q.setDirectory(dirs.get("Postgres"));
//        q = sqlRepo.save(q);
//
//        ArrayList<ArrayList<String>> r = dbr.runQuery(q.getId().toString());
//
//        assertThat(r.size(), is(276));
//    }
//
//    @Test
//    public void sqlserverDbTest() throws Exception {
//        SqlQuery q = SqlQuerySqlServer.selectAllArtists();
//        q.setDirectory(dirs.get("SqlServer"));
//        q = sqlRepo.save(q);
//
//        ArrayList<ArrayList<String>> r = dbr.runQuery(q.getId().toString());
//
//        assertThat(r.size(), is(276));
//    }
//
}
