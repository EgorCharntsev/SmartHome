package net.server.model;

import java.sql.Timestamp;

public class GSONResponse {
    private Integer id;
    private Integer sensorId;
    private String sensorState;
    private Timestamp sensorResponseTime;
    private Integer typeId;

    public GSONResponse(Integer id, Integer sensorId, String sensorState, Timestamp sensorResponseTime, Integer typeId) {
        this.id = id;
        this.sensorId = sensorId;
        this.sensorState = sensorState;
        this.sensorResponseTime = sensorResponseTime;
        this.typeId = typeId;
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

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }
}
