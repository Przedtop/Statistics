package com.przedtop.statistics;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import com.przedtop.statistics.settings.DBSettings;

import java.sql.*;

public class OnJoin implements Listener {

    @EventHandler
    void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        if(!isPlayerInDatabase(player)) {
            try(Connection connection = DriverManager.getConnection(DBSettings.URL, DBSettings.USER, DBSettings.PASSWORD);
                PreparedStatement statement = connection.prepareStatement("INSERT INTO playersData (uuid, blocksBreak, blocksPlaced, timeSpent, kills, deaths) VALUES (?, ?, ?, ?, ?, ?)"))
            {
                statement.setString(1, player.getUniqueId().toString());
                statement.setInt(2, 0); // blocksBreak
                statement.setInt(3, 0); // blocksPlaced
                statement.setInt(4, 0); // timeSpent
                statement.setInt(5, 0); // kills
                statement.setInt(6, 0); // deaths
                statement.executeUpdate();
                Bukkit.getConsoleSender().sendMessage("Player " + player.getName() + " added to database.");
            } catch (SQLException exception) {
                Bukkit.getConsoleSender().sendMessage("Error while adding player to database: " + exception.getMessage());
            }
        }
    }

    boolean isPlayerInDatabase(Player player) {
        try(Connection connection = DriverManager.getConnection(DBSettings.URL, DBSettings.USER, DBSettings.PASSWORD);
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM playersData WHERE uuid = ?")) {
            statement.setString(1, player.getUniqueId().toString());
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            Bukkit.getConsoleSender().sendMessage("Error while checking if player is in database: " + e.getMessage());
        }
        return false;
    }
}
