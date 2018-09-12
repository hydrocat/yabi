package ipb.yabi.DatabaseReader;

import ipb.yabi.Directory.Directory;
import ipb.yabi.Directory.DirectoryRepository;
import ipb.yabi.SqlQuery.SqlQuery;
import ipb.yabi.SqlQuery.SqlQueryRepository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class DatabaseReader {

    @Autowired
    SqlQueryRepository queryRepo;
    @Autowired
    DirectoryRepository dirRepo;

    public DatabaseReader(SqlQueryRepository repo, DirectoryRepository dr) {
        queryRepo = repo;
        dirRepo = dr;
    }

    public DatabaseReader() {
    }

    public ArrayList<ArrayList<String>> runQuery(@PathVariable String queryId)
            throws SQLException {
        ArrayList<ArrayList<String>> result = new ArrayList<>();

        SqlQuery query = queryRepo.findById(Long.parseLong(queryId)).get();
        System.out.println("Command: " + query.getCommand());
        if (query == null) {
            System.out.println("Query not found");
            return result;
        }
        Directory dir = query.getDirectory();
        System.out.println("Database: " + dir.getName());

        Connection con = DriverManager.getConnection(
                dir.getConnectionString(),
                dir.getUsername(),
                dir.getPassword());

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query.getCommand());

        return readResultSet(rs);
    }

    private ArrayList<ArrayList<String>> readResultSet(ResultSet rs)
            throws SQLException {

        ArrayList<ArrayList<String>> data = new ArrayList<>();//return variable

        //extract metadata        
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnCount = rsmd.getColumnCount();
        ArrayList<String> columnNames = new ArrayList<>();

        //adds column information
        for (int column = 1; column < columnCount + 1; column++) {
            columnNames.add(
                    rsmd.getColumnName(column));
        }
        data.add(columnNames);

        //reads data
        while (rs.next()) {
            data.add(readRow(rs, columnCount));
        }

        return data;
    }

    private ArrayList<String> readRow(
            ResultSet rs,
            int columnCount)
            throws SQLException {

        ArrayList<String> row = new ArrayList<>();
        for (int column = 1; column < columnCount + 1; column++) {
            row.add(rs.getString(column));
        }

        return row;
    }

    private ArrayList<Integer> readTypes(ResultSetMetaData rsmd) throws SQLException {
        long columnCount = rsmd.getColumnCount();

        ArrayList<Integer> types = new ArrayList<>();

        for (int column = 1; column < columnCount + 1; column++) {
            types.add(rsmd.getColumnType(column));
        }

        return types;
    }

}
