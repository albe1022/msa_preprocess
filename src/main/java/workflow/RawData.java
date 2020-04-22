package workflow;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="RawData_table")
public class RawData {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private String dataType;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
        public String getDataType() {
            return dataType;
        }

        public void setDataType(String dataType) {
            this.dataType = dataType;
        }

}
