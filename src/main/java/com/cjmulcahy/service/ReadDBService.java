package com.cjmulcahy.service;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Chris on 1/16/2017.
 */
public interface ReadDBService {

    public boolean connectToDB(String DBURL,String DBUSER,String DBPASSWORD,String DRIVER) throws SQLException,ClassNotFoundException;

    public ArrayList<String> listTables() throws SQLException;
}
