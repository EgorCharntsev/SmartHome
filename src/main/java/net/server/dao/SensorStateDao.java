package net.server.dao;

import net.server.model.SensorState;
import net.util.DatabaseConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SensorStateDao implements Dao<SensorState> {

    private final Connection connection = DatabaseConnectionUtil.getConnection();

    private SensorState sensorStateFromResultSet(ResultSet resultSet) throws SQLException {
        return new SensorState(
                resultSet.getInt("id"),
                resultSet.getInt("sensor_id"),
                resultSet.getString("sensor_state"),
                resultSet.getTimestamp("response_time")
        );
    }

    @Override
    public void insert(SensorState sensorState) {
        String query = "INSERT INTO sensor_states (sensor_state, response_time, sensor_id) " +
                "VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, sensorState.getSensorState());
            preparedStatement.setTimestamp(2, sensorState.getSensorResponseTime());
            preparedStatement.setInt(3, sensorState.getSensorId());
            preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public SensorState get(Integer id) {
        String query = "SELECT * FROM sensor_states WHERE sensor_states.id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return sensorStateFromResultSet(resultSet);
            } else {
                return null;
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public List<SensorState> getAll() {
        String query = "SELECT * FROM sensor_states";
        try (Statement statement = connection.createStatement()) {
            List<SensorState> sensorStates = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                sensorStates.add(sensorStateFromResultSet(resultSet));
            }
            return sensorStates;
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

}
