package ipb.yabi.test.testPojo;

import ipb.yabi.SqlQuery.SqlQuery;

/**
 *
 * @author hydrocat
 */
public interface SqlQueryForTesting {
    
    public static SqlQuery selectAllArtists(){return new SqlQuery();};
    public static SqlQuery calculateTotalByMediaType(){return new SqlQuery();};
}
