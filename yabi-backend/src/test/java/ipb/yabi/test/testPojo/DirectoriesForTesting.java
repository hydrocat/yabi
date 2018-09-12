package ipb.yabi.test.testPojo;

import ipb.yabi.Directory.Directory;
import java.util.ArrayList;
import lombok.Getter;



/**
 *
 * @author hydrocat
 */
public class DirectoriesForTesting {
    
    @Getter public static Directory maria    = new Directory(10l, "jdbc:mariadb://localhost:3306/Chinook",      "MariaDB",  "root",    "root");
    @Getter public static Directory oracle   = new Directory(20l, "jdbc:oracle:thin:@//localhost:1521",         "OracleXE", "chinook", "p4ssw0rd");
    @Getter public static Directory postgres = new Directory(30l, "jdbc:postgresql://localhost:5432/postgres",  "Postgres", "postgres","root");
    @Getter public static Directory sqlserver= new Directory(40l, "jdbc:sqlserver://localhost:1433;DatabaseName=chinook","SqlServer", "sa", "rootPassword1");
    @Getter public static Directory[] dirs = {maria,oracle,postgres,sqlserver};
    
}
