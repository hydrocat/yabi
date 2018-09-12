package ipb.yabi.test;

import ipb.yabi.Directory.Directory;
import ipb.yabi.Directory.DirectoryRepository;
import static org.hamcrest.CoreMatchers.is;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author hydrocat
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest
public class DirectoryTest {
    
    @Autowired
    DirectoryRepository repo;
    
    static Directory dir;
    
    @Test
    public void pass() {
        
    }
//    
//    @BeforeClass
//    public static void setUp(){
//        dir = new Directory();
//        dir.setConnectionString("jdbc:mysql/qualquercoisa/yabi");
//        dir.setName("Test Directory");
//        dir.setPassword("123");
//        dir.setUsername("root");
//        dir.setId(0l);
//    }
//    
//    @Test
//    public void testDatabaseConnection(){
//        assertThat(repo.count(),is(0l));
//    }
//    
//    @Test
//    public void saveDirectory(){
//        repo.save(dir);
//        assertThat(repo.count(),is(1l));
//    }
//    
//    @Test
//    public void checkDirecotryGotSavedAndHasID() {
//        repo.save(dir);
//        Directory d = repo.findAll().iterator().next();
//        assertThat(d.getName(),is(dir.getName()));
//        assertNotNull(d.getId());
//    }
//    
//    @Test
//    public void checkDirectoryFindByName() {
//        repo.save(dir);
//        Directory d = repo.findByName(dir.getName());
//        assertTrue(d.getName().equals(dir.getName()));
//    }
//     
//    
}
