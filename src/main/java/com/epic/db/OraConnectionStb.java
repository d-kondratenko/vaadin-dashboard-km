package com.epic.db;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Data
@Service
public class OraConnectionStb {
    @Value("${userconfig.ora.dburl_stb}")
    private String oraUrl;

    public Connection createConnection() throws ClassNotFoundException, SQLException {
        Connection con = null;
        Class.forName("oracle.jdbc.OracleDriver");
        con = DriverManager.getConnection(oraUrl);
        return con;
    }
}