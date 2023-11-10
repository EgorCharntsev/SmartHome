package net.server.model;

import java.sql.Timestamp;

public class SensorState {
    private Integer id;
    private Integer sensorId;
    private String sensorState;
    private Timestamp sensorResponseTime;

    public SensorState(Integer id, Integer sensorId, String sensorState, Timestamp sensorResponseTime) {
        this.id = id;
        this.sensorId = sensorId;
        this.sensorState = sensorState;
        this.sensorResponseTime = sensorResponseTime;
    }

    public SensorState(Integer sensorId, String sensorState, Timestamp sensorResponseTime) {
        this.sensorId = sensorId;
        this.sensorState = sensorState;
        this.sensorResponseTime = sensorResponseTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSensorId() {
        return sensorId;
    }

    public void setSensorId(Integer sensorId) {
        this.sensorId = sensorId;
    }

    public String getSensorState() {
        return sensorState;
    }

    public void setSensorState(String sensorState) {
        this.sensorState = sensorState;
    }

    public Timestamp getSensorResponseTime() {
        return sensorResponseTime;
    }

    public void setSensorResponseTime(Timestamp sensorResponseTime) {
        this.sensorResponseTime = sensorResponseTime;
    }
}
