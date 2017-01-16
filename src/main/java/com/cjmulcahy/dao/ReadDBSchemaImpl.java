package com.cjmulcahy.dao;

import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Chris on 1/16/2017.
 */


public class ReadDBSchemaImpl implements ReadDBSchema{

    private Connection conn;



    @Override
    public boolean connectToDB(String DBURL, String DBUSER, String DBPASSWORD,String DRIVER) throws SQLException, ClassNotFoundException {
           System.out.println(":::::::::::::::::::::::: In connect to database method now");
            Class.forName(DRIVER);
            conn= DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
        if(conn==null){return false;}
        return true;
    }

    @Override
    public ArrayList<String> listTables() throws SQLException {
        int count=0;
        ArrayList<String> table_names=new ArrayList<>();
        Statement state = conn.createStatement();
        ResultSet r = state.executeQuery("select * from books");
        System.out.println(":::::::::::::::::::::: In listTable method now");
        ResultSetMetaData rmd=r.getMetaData();
        count=rmd.getColumnCount();
        for(int i=0;i<count;i++){
            table_names.add(rmd.getColumnLabel(i+1));
            System.out.println(table_names.size());
            System.out.println(table_names.get(i));
        }

        r.close();
        state.close();

        if(!conn.isClosed()){conn.close();}
        conn=null;
        return table_names;
    }
}
