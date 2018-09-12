package ipb.yabi.test;

import ipb.yabi.Directory.Directory;
import ipb.yabi.Directory.DirectoryRepository;
import ipb.yabi.SqlQuery.SqlQuery;
import ipb.yabi.SqlQuery.SqlQueryRepository;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author hydrocat
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest
@ActiveProfiles("test")
public class SqlQueryTest {


    @Autowired
    SqlQueryRepository queryRepo;
    @Autowired
    DirectoryRepository dirRepo;
    
    Directory dir;
    SqlQuery query;
    
    @Test
    public void pass() {
        
    }
//
//    
//    @Before
//    public void begin() {
//        dir = new Directory();
//        dir.setConnectionString("This is a connection String");
//        dir.setName("TestDirectory");
//        dir.setPassword("password");
//        dir.setUsername("root");
//
//        query = new SqlQuery();
//        query.setCommand("This is a sql statement for testing purposes");
//        query.setDescription("This is a test description");
//        query.setName("TestQuery");
//
//    }
//    
//    @Test
//    public void testDirectory() {
//        Directory d = dirRepo.save(dir);
//        assertThat(d, is(not(nullValue())));
//    }
//
//    @Test
//    public void connectionTest() {
//        assertThat(queryRepo.count(), is(0l));
//    }
//    
//    @Test
//    public void saveQuery() {
//        SqlQuery s = queryRepo.save(query);
//        assertThat(s, is(not(nullValue())));
//    }
//    
//    @Test
//    public void findSqlByName() {
//        queryRepo.save(query);
//        SqlQuery s = queryRepo.findByName("TestQuery");
//        assertThat(s, is(not(nullValue())));
//    }
//    
//    @Test
//    public void saveWithDirectory() {
//        Directory d = dirRepo.save(dir);
//        query.setDirectory(d);
//        
//        SqlQuery s = queryRepo.save(query);
//        assertThat(s.getId(), is(not(nullValue())));
//        assertThat(s.getDirectory(), is(not(nullValue())));
//        assertThat(s.getDirectory().getName(), is("TestDirectory"));
//    }

}
