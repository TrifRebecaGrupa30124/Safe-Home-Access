package isp.lab9.exercise2;

public class Operation {
    private Type type;
    private Integer value;

    public Operation(Type type, Integer value) {
        this.type = type;
        this.value = value;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
