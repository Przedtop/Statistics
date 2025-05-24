package com.przedtop.statistics.dbOperations;

import com.przedtop.statistics.settings.DBSettings;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.sql.*;

public class GetDBStats {
    public int getBlocksBroken(Player player) {
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

    public int getBlocksPlaced(Player player) {
        try (Connection connection = DriverManager.getConnection(DBSettings.URL, DBSettings.USER, DBSettings.PASSWORD);
             PreparedStatement statement = connection.prepareStatement("Select blocksPlaced FROM playersData WHERE uuid = ?")) {
            statement.setString(1, player.getUniqueId().toString());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("blocksPlaced");
            }
        } catch (SQLException e) {
            Bukkit.getConsoleSender().sendMessage("Error while updating blocks placed: " + e.getMessage());
            return 0;
        }
        return 0;
    }

    public int getDeaths(Player player) {
        try (Connection connection = DriverManager.getConnection(DBSettings.URL, DBSettings.USER, DBSettings.PASSWORD);
             PreparedStatement statement = connection.prepareStatement("Select deaths FROM playersData WHERE uuid = ?")) {
            statement.setString(1, player.getUniqueId().toString());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("deaths");
            }
        } catch (SQLException e) {
            Bukkit.getConsoleSender().sendMessage("Error while updating deaths: " + e.getMessage());
            return 0;
        }
        return 0;
    }

    public int getKills(Player player) {
        try (Connection connection = DriverManager.getConnection(DBSettings.URL, DBSettings.USER, DBSettings.PASSWORD);
             PreparedStatement statement = connection.prepareStatement("Select kills FROM playersData WHERE uuid = ?")) {
            statement.setString(1, player.getUniqueId().toString());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("kills");
            }
        } catch (SQLException e) {
            Bukkit.getConsoleSender().sendMessage("Error while updating kills: " + e.getMessage());
            return 0;
        }
        return 0;
    }
}
