package net.server.system;

import net.server.dao.SensorDao;
import net.server.dao.SensorStateDao;
import net.server.model.Sensor;
import net.server.model.SensorState;
import net.util.DatabaseConnectionUtil;

import java.sql.Connection;
import java.sql.Timestamp;
import java.util.List;

public class SmartHomeSystem {

    private static SmartHomeSystem instance;
    private final SensorDao sensorDao = new SensorDao();
    private final SensorStateDao sensorStateDao = new SensorStateDao();

    private SmartHomeSystem() { }

    public static SmartHomeSystem getInstance() {
        if (instance == null) instance = new SmartHomeSystem();
        return instance;
    }

    public void run() {
        List<Sensor> availableSensors = sensorDao.getAll();
        for (Sensor availableSensor : availableSensors) {
            int sensorState = (int) (Math.random());
            sensorStateDao.insert(new SensorState(
                    availableSensor.getId(),
                    String.valueOf(sensorState),
                    new Timestamp(System.currentTimeMillis())
            ));
        }
    }

}
