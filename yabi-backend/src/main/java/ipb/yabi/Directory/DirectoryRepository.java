package ipb.yabi.Directory;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface DirectoryRepository extends PagingAndSortingRepository<Directory, Long> {

    public Directory findByName(String name);
}