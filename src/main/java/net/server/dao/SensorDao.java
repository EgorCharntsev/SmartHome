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
                resultSet.getInt("id"),
                resultSet.getInt("type_id"),
                resultSet.getBoolean("status"),
                resultSet.getString("state"),
                resultSet.getTimestamp("commission_date")
        );
    }

    @Override
    public void insert(Sensor sensor) {
        String query = "INSERT INTO sensors (status, state, commission_date, type_id) " +
                "VALUES (?, ?, ?, ?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setBoolean(1, sensor.getSensorStatus());
            preparedStatement.setString(2, sensor.getSensorState());
            preparedStatement.setTimestamp(3, sensor.getSensorCommissionDate());
            preparedStatement.setInt(4, sensor.getSensorTypeId());
            preparedStatement.executeUpdate();
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

    public int getCount() {
        String query = "SELECT COUNT(*) FROM sensors";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
            return -1;
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

}
