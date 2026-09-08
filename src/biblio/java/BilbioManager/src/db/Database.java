package BilbioManager.src.db;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    private static final String URL = "jdbc:sqlite:mediatheque.db";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static void initSchema() throws SQLException, IOException {
        String sql = Files.readString(Path.of("schema.sql"));
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            for (String instruction : sql.split(";")) {
                if (!instruction.isBlank()) {
                    stmt.execute(instruction);
                }
            }
        }
    }
}
