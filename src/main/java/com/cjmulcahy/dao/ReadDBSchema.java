package com.cjmulcahy.dao;

import com.cjmulcahy.domain.DataHolder;

import java.sql.Connection;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Chris on 1/16/2017.
 */
public interface ReadDBSchema {

    public boolean connectToDB(String DBURL,String DBUSER,String DBPASSWORD,String DRIVER) throws SQLException,ClassNotFoundException;

    public ArrayList<String> listColumns(String tableName) throws SQLException;

    public ArrayList<String> listTables() throws SQLException;

    public ArrayList<Object> processQuery(String query) throws SQLException;


}
