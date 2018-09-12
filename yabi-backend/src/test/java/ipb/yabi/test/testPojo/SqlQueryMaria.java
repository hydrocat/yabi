package ipb.yabi.test.testPojo;

import ipb.yabi.SqlQuery.SqlQuery;

/**
 *
 * @author hydrocat
 */
public class SqlQueryMaria implements SqlQueryForTesting{
    
    public static SqlQuery selectAllArtists() {
        return new SqlQuery(11l,
                "select Name from Artist;",
                "Artists",
                "See the name of all artists",
                null);
    }
    
    public static SqlQuery calculateTotalByMediaType(){
        return new SqlQuery(12l,
                "select sum(Track.UnitPrice) as Name, MediaTypeId from Track group by Track.MediaTypeId;",
                "totalByMediaType", "Calculates the total by media type", null);
    }
}
