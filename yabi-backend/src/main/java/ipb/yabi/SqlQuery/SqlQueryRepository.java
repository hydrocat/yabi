package ipb.yabi.SqlQuery;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface SqlQueryRepository extends PagingAndSortingRepository<SqlQuery, Long> {
    public SqlQuery findByName(String name);

}
