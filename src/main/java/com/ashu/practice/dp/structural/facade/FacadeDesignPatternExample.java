package com.ashu.practice.dp.structural.facade;

import java.sql.Connection;

enum DbType {
    MYSQL, ORACLE
}

enum ReportType {
    HTML, PDF, CSV
}

public class FacadeDesignPatternExample {
    public static void main(String[] args) {
        String tableName = "employee";
        HelperFacade.generateReport(DbType.MYSQL, ReportType.HTML, tableName);
        HelperFacade.generateReport(DbType.ORACLE, ReportType.PDF, tableName);
    }
}

class HelperFacade {
    private HelperFacade() {
    }

    public static void generateReport(DbType dbType, ReportType reportType, String tableName) {
        Connection connection = null;

        switch (dbType) {
            case MYSQL -> {
                connection = MySqlHelper.getMySqlDBConnection();
                switch (reportType) {
                    case HTML -> MySqlHelper.generateMySqlHTMLReport(tableName, connection);
                    case PDF -> MySqlHelper.generateMySqlPDFReport(tableName, connection);
                    case CSV -> MySqlHelper.generateMySqlCSVReport(tableName, connection);
                }
            }
            case ORACLE -> {
                connection = OracleHelper.getOracleDBConnection();
                switch (reportType) {
                    case HTML -> OracleHelper.generateOracleHTMLReport(tableName, connection);
                    case PDF -> OracleHelper.generateOraclePDFReport(tableName, connection);
                    case CSV -> OracleHelper.generateOracleCSVReport(tableName, connection);
                }
            }
        }

    }
}


class MySqlHelper {
    public static Connection getMySqlDBConnection() {
        //get MySql DB connection using connection parameters
        return null;
    }

    public static void generateMySqlPDFReport(String tableName, Connection con) {
        System.out.println("get data from mysql table and generate pdf report");
    }

    public static void generateMySqlHTMLReport(String tableName, Connection con) {
        System.out.println("get data from mysql table and generate html report");
    }

    public static void generateMySqlCSVReport(String tableName, Connection con) {
        System.out.println("get data from mysql table and generate csv report");
    }
}

class OracleHelper {
    public static Connection getOracleDBConnection() {
        //get Oracle DB connection using connection parameters
        return null;
    }

    public static void generateOraclePDFReport(String tableName, Connection con) {
        System.out.println("get data from oracle table and generate pdf report");
    }

    public static void generateOracleHTMLReport(String tableName, Connection con) {
        System.out.println("get data from oracle table and generate html report");
    }

    public static void generateOracleCSVReport(String tableName, Connection con) {
        System.out.println("get data from oracle table and generate csv report");
    }
}