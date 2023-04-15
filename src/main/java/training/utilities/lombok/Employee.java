package training.utilities.lombok;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.extern.java.Log;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;


@Data // shortcut annotation combining @ToString, @EqualsAndHashCode, @Getter @Setter and @RequiredArgsConstructor
// @Value // immutable variant of @Data with all fields final
@Builder
@Log
public class Employee
{
    int id;
    
    String firstName;
    
    String lastName;
    
    @Getter(lazy = true)
    private final Collection<String>
        reports = getHugeMapOfAllReports();
        
    
    void logTrial()
    {
        log.info("Test");
    }
    
    private Collection<String> getHugeMapOfAllReports()
    {
        return List.of("Important Report", "Another Report", "Final Report");
    }
}
