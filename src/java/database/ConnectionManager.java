package database;

import java.sql.*;

public class ConnectionManager {
    private final String url;
    private final String login;
    private final String password;

    public ConnectionManager(String url, String login, String password) {
        this.url = url;
        this.login = login;
        this.password = password;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, login, password);
    }

    public void createDBIfNotExist(){
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            String sqlRequest = "DO $$BEGIN\n" +
                    "    IF NOT EXISTS (\n" +
                    "        SELECT 1 FROM pg_type WHERE typname = 'genre'\n" +
                    "    ) THEN\n" +
                    "        -- Create the genre type as an ENUM\n" +
                    "        CREATE TYPE genre AS ENUM (\n" +
                    "            'RAP', 'SOUL', 'POP', 'PHONK', 'PROGRESSIVE_ROCK'\n" +
                    "        );\n" +
                    "    END IF;\n" +
                    "\n" +
                    "                CREATE TABLE IF NOT EXISTS users\n" +
                    "                (\n" +
                    "                    id              SERIAL PRIMARY KEY,\n" +
                    "                    name            VARCHAR(40) UNIQUE      NOT NULL,\n" +
                    "                    password_digest VARCHAR(96)             NOT NULL,\n" +
                    "                    salt            VARCHAR(10)             NOT NULL,\n" +
                    "                    creation_date   TIMESTAMP DEFAULT NOW() NOT NULL\n" +
                    "                );\n" +
                    "                                \n" +
                    "              \n" +
                    "                                \n" +
                    "                CREATE TABLE IF NOT EXISTS labels\n" +
                    "                (\n" +
                    "                  \n" +
                    "                    sales     INT NOT NULL\n" +
                    "                        CONSTRAINT positive_sales CHECK (sales > 0)\n" +
                    "                );\n" +
                    "                                \n" +
                    "                CREATE TABLE IF NOT EXISTS musicbands\n" +
                    "                (\n" +
                    "                    id            SERIAL PRIMARY KEY,\n" +
                    "                    name          TEXT                    NOT NULL\n" +
                    "                        CONSTRAINT not_empty_name CHECK (length(name) > 0),\n" +
                    "                    x             INTEGER                 NOT NULL,\n" +
                    "                    y             INTEGER                 NOT NULL,\n" +
                    "                    creation_date TIMESTAMP DEFAULT NOW() NOT NULL,\n" +
                    "                    single_count  INT  NOT NULL,\n" +
                    "                    sales        INT,\n" +
                    "                    number_of_participants  INT          NOT NULL\n" +
                    "                        CONSTRAINT positive_sales CHECK (sales> 0),\n" +
                    "                    genre          genre,\n" +
                    "                    creator_id    INT                     NOT NULL REFERENCES users (id) ON DELETE CASCADE\n" +
                    "                );\n" +
                    "END$$;\n";
            statement.executeQuery(sqlRequest);
        } catch (SQLException ignored) {
        }

    }
}