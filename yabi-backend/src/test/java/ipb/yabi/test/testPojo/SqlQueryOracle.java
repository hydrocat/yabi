package ipb.yabi.test.testPojo;

import ipb.yabi.SqlQuery.SqlQuery;

/**
 *
 * @author hydrocat
 */
public class SqlQueryOracle implements SqlQueryForTesting{

    public static SqlQuery selectAllArtists() {
        return new SqlQuery(21l,
                "select Name from Artist",
                "ORACLE Artists",
                "ORACLE See the name of all artists",
                null);
    }

    public static SqlQuery calculateTotalByMediaType(){
        return new SqlQuery(22l,
                "select sum(Track.UnitPrice) as Name, MediaTypeId from Track group by Track.MediaTypeId;",
                "totalByMediaType", "Calculates the total by media type", null);
    }
    
}
