package com.przedtop.statistics.dbOperations;

import com.przedtop.statistics.settings.DBSettings;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.sql.*;

public class GetDBStats {
    int getBlocksBroken(Player player) {
        try (Connection connection = DriverManager.getConnection(DBSettings.URL, DBSettings.USER, DBSettings.PASSWORD);
             PreparedStatement statement = connection.prepareStatement("Select blocksBreak FROM playersData WHERE uuid = ?")) {
            statement.setString(1, player.getUniqueId().toString());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("blocksBreak");
            }
        } catch (SQLException e) {
            Bukkit.getConsoleSender().sendMessage("Error while updating blocks broken: " + e.getMessage());
            return 0;
        }
        return 0;
    }
}
