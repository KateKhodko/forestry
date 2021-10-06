package com.khodko.forestry;

import liquibase.Contexts;
import liquibase.LabelExpression;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/forestry", "postgres", "postgres");
            Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(connection));
            Liquibase liquibase = new liquibase.Liquibase("db.changelog/changes/db.changelog-master.xml", new ClassLoaderResourceAccessor(), database);
            liquibase.update(new Contexts(), new LabelExpression());
        } catch (SQLException | LiquibaseException e) {
            e.printStackTrace();
        }

        Menu menu = new Menu();
        menu.batch1();
//        menu.printMenu();

    }
}
