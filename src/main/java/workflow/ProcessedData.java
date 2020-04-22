package workflow;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="ProcessedData_table")
public class ProcessedData {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Long rawDataId;
    private String dataType;

    @PostPersist
    public void onPostPersist(){
        DataPreprocessed dataPreprocessed = new DataPreprocessed();
        BeanUtils.copyProperties(this, dataPreprocessed);
        dataPreprocessed.publish();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getRawDataId() {
        return rawDataId;
    }

    public void setRawDataId(Long rawDataId) {
        this.rawDataId = rawDataId;
    }
    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }




}
