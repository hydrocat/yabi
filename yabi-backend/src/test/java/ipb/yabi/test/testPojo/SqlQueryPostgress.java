package ipb.yabi.test.testPojo;

import ipb.yabi.SqlQuery.SqlQuery;

/**
 *
 * @author hydrocat
 */
public class SqlQueryPostgress implements SqlQueryForTesting{

    public static SqlQuery selectAllArtists() {
        return new SqlQuery(31l,
                "select \"Name\" from \"Artist\";",
                "POSTGRES Artists",
                "POSTGRES See the name of all artists",
                null);
    }

    public static SqlQuery calculateTotalByMediaType(){
        return new SqlQuery(32l,
                "select sum(\"UnitPrice\") from \"Track\" group by \"MediaTypeId\";",
                "POSTGRES totalByMediaType", 
                "POSTGRES  Calculates the total by media type", null);
    }
    
}
