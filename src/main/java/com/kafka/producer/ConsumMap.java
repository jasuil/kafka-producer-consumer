package com.kafka.producer;

public class ConsumMap {
    String id;
    String name;
    String memo;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Override
    public String toString() {
        return "consumMap{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", memo='" + memo + '\'' +
                '}';
    }
}
