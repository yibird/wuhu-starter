package io.github.yibird.starter.core.utils;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import javax.sql.DataSource;

import io.github.yibird.starter.core.enums.DataSourceType;

public class DataSourceUtils {
     public static DataSourceType getDatabaseType(DataSource dataSource) {
        try (Connection conn = dataSource.getConnection()) {
            DatabaseMetaData metaData = conn.getMetaData();
            String dbProductName = metaData.getDatabaseProductName().toLowerCase();
            if (dbProductName.contains("mysql")) {
                return DataSourceType.MYSQL;
            } else if (dbProductName.contains("postgresql")) {
                return DataSourceType.POSTGRESQL;
            } else if (dbProductName.contains("oracle")) {
                return DataSourceType.ORACLE;
            } else if (dbProductName.contains("sql server")) {
                return DataSourceType.SQLSERVER;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
