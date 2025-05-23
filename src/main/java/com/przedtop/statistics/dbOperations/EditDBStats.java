package com.przedtop.statistics.dbOperations;

import com.przedtop.statistics.settings.DBSettings;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EditDBStats {
    public void incrementBlocksBroken(Player player) {
        try (Connection connection = DriverManager.getConnection(DBSettings.URL, DBSettings.USER, DBSettings.PASSWORD);
             PreparedStatement statement = connection.prepareStatement("UPDATE playersData SET blocksBreak = blocksBreak + 1 WHERE uuid = ?")) {
            statement.setString(1, player.getUniqueId().toString());
            statement.executeUpdate();
        } catch (SQLException e) {
            Bukkit.getConsoleSender().sendMessage("Error while updating blocks broken: " + e.getMessage());
        }
    }

    public void incrementBlocksPlaced(Player player) {
        try (Connection connection = DriverManager.getConnection(DBSettings.URL, DBSettings.USER, DBSettings.PASSWORD);
             PreparedStatement statement = connection.prepareStatement("UPDATE playersData SET blocksPlaced = blocksPlaced + 1 WHERE uuid = ?")) {
            statement.setString(1, player.getUniqueId().toString());
            statement.executeUpdate();
        } catch (SQLException e) {
            Bukkit.getConsoleSender().sendMessage("Error while updating blocks placed: " + e.getMessage());
        }
    }

    public void incrementTimeSpent(Player player, int time) {
        try (Connection connection = DriverManager.getConnection(DBSettings.URL, DBSettings.USER, DBSettings.PASSWORD);
             PreparedStatement statement = connection.prepareStatement("UPDATE playersData SET timeSpent = timeSpent + ? WHERE uuid = ?")) {
            statement.setInt(1, time);
            statement.setString(2, player.getUniqueId().toString());
            statement.executeUpdate();
        } catch (SQLException e) {
            Bukkit.getConsoleSender().sendMessage("Error while updating time spent: " + e.getMessage());
        }
    }

    public void incrementKills(Player player) {
        try (Connection connection = DriverManager.getConnection(DBSettings.URL, DBSettings.USER, DBSettings.PASSWORD);
             PreparedStatement statement = connection.prepareStatement("UPDATE playersData SET kills = kills + 1 WHERE uuid = ?")) {
            statement.setString(1, player.getUniqueId().toString());
            statement.executeUpdate();
        } catch (SQLException e) {
            Bukkit.getConsoleSender().sendMessage("Error while updating kills: " + e.getMessage());
        }
    }

    public void incrementDeaths(Player player) {
        try (Connection connection = DriverManager.getConnection(DBSettings.URL, DBSettings.USER, DBSettings.PASSWORD);
             PreparedStatement statement = connection.prepareStatement("UPDATE playersData SET deaths = deaths + 1 WHERE uuid = ?")) {
            statement.setString(1, player.getUniqueId().toString());
            statement.executeUpdate();
        } catch (SQLException e) {
            Bukkit.getConsoleSender().sendMessage("Error while updating deaths: " + e.getMessage());
        }
    }
}
