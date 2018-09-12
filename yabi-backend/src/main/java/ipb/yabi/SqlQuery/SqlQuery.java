package ipb.yabi.SqlQuery;

import ipb.yabi.Directory.Directory;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author hydrocat
 */
@NoArgsConstructor
@AllArgsConstructor
@Entity
public @Data class SqlQuery {
    
    @Id
    @GeneratedValue
    private Long id;
    
    private String command;
    private String name;
    private String description;
    @ManyToOne
    private Directory directory;
    
}
