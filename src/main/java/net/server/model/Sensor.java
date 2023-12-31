package net.server.model;

import java.sql.Timestamp;

public class Sensor {

    private Integer id;
    private Integer sensorTypeId;
    private Boolean sensorStatus;
    private Timestamp sensorCommissionDate;

    public Sensor(Integer id, Integer sensorTypeId, Boolean sensorStatus, Timestamp sensorCommissionDate) {
        this.id = id;
        this.sensorTypeId = sensorTypeId;
        this.sensorStatus = sensorStatus;
        this.sensorCommissionDate = sensorCommissionDate;
    }

    public Sensor(Integer sensorTypeId, Boolean sensorStatus, Timestamp sensorCommissionDate) {
        this.sensorTypeId = sensorTypeId;
        this.sensorStatus = sensorStatus;
        this.sensorCommissionDate = sensorCommissionDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSensorTypeId() {
        return sensorTypeId;
    }

    public void setSensorTypeId(Integer sensorTypeId) {
        this.sensorTypeId = sensorTypeId;
    }

    public Boolean getSensorStatus() {
        return sensorStatus;
    }

    public void setSensorStatus(Boolean sensorStatus) {
        this.sensorStatus = sensorStatus;
    }

    public Timestamp getSensorCommissionDate() {
        return sensorCommissionDate;
    }

    public void setSensorCommissionDate(Timestamp sensorCommissionDate) {
        this.sensorCommissionDate = sensorCommissionDate;
    }
}
