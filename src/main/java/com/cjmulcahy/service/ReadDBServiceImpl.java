package com.cjmulcahy.service;

import com.cjmulcahy.dao.ReadDBSchema;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Chris on 1/16/2017.
 */
public class ReadDBServiceImpl implements ReadDBService{

    private ReadDBSchema readDB;

    public ReadDBServiceImpl(ReadDBSchema readDBSchema) {
        this.readDB = readDBSchema;

    }
    @Transactional
    @Override
    public boolean connectToDB(String DBURL, String DBUSER, String DBPASSWORD, String DRIVER) throws SQLException, ClassNotFoundException {
        return readDB.connectToDB(DBURL,DBUSER,DBPASSWORD,DRIVER);
    }

    @Transactional
    @Override
    public ArrayList<String> listTables() throws SQLException {
        return readDB.listTables();
    }
}
