package workflow;

public class DataSaved extends AbstractEvent {

    private Long id;
    private String DataType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getDataType() {
        return DataType;
    }

    public void setDataType(String DataType) {
        this.DataType = DataType;
    }
}