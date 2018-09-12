package ipb.yabi.DatabaseReader;

import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hydrocat
 */
@RestController
public class DatabaseReaderController {
    @GetMapping("/runQuery/{queryId}")
    public ArrayList<ArrayList<String>> runQuery(@PathVariable String queryId)
        throws SQLException{
        return new DatabaseReader().runQuery(queryId);
    }
}
