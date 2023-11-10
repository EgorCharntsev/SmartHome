package net.server.dao;

import net.server.model.Sensor;
import net.util.DatabaseConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SensorDao implements Dao<Sensor> {

    private final Connection connection = DatabaseConnectionUtil.getConnection();

    private Sensor sensorFromResultSet(ResultSet resultSet) throws SQLException {
        return new Sensor(
                resultSet.getInt(1),
                resultSet.getInt(2),
                resultSet.getBoolean(3),
                resultSet.getString(4),
                resultSet.getTimestamp(5)
        );
    }

    @Override
    public void insert(Sensor sensor) {
        String query = "INSERT INTO sensors (sensor_type_id, sensor_status, sensor_state, sensor_commission_date) " +
                "VALUES (?, ?, ?, ?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, sensor.getSensorTypeId());
            preparedStatement.setBoolean(2, sensor.getSensorStatus());
            preparedStatement.setString(3, sensor.getSensorState());
            preparedStatement.setTimestamp(4, sensor.getSensorCommissionDate());
            preparedStatement.executeQuery();
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public Sensor get(Integer id) {
        String query = "SELECT * FROM sensors WHERE sensors.id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return sensorFromResultSet(resultSet);
            } else {
                return null;
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public List<Sensor> getAll() {
        String query = "SELECT * FROM sensors";
        try (Statement statement = connection.createStatement()) {
            List<Sensor> sensors = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                sensors.add(sensorFromResultSet(resultSet));
            }
            return sensors;
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

}
