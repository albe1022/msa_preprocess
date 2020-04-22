package workflow;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RawDataRepository extends CrudRepository<RawData, Long> {


}