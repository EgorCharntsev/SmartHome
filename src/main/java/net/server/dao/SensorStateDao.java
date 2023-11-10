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
                resultSet.getInt(1),
                resultSet.getInt(2),
                resultSet.getString(3),
                resultSet.getTimestamp(4)
        );
    }

    @Override
    public void insert(SensorState sensorState) {
        String query = "INSERT INTO sensor_states (sensor_id, sensor_state, sensor_response_time) " +
                "VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, sensorState.getSensorId());
            preparedStatement.setString(2, sensorState.getSensorState());
            preparedStatement.setTimestamp(3, sensorState.getSensorResponseTime());
            preparedStatement.executeQuery();
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
