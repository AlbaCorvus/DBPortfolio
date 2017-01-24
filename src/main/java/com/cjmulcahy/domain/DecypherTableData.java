package com.cjmulcahy.domain;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by Chris on 1/20/2017.
 */
public class DecypherTableData {

    private static DataHolder data;


    public static ArrayList<Object> decypher(ResultSet r) throws SQLException {

        ArrayList<Object> results =new ArrayList<>();
        ResultSetMetaData rsmd = r.getMetaData();
        int column_number = rsmd.getColumnCount();
        String name=rsmd.getTableName(3);

        while(r.next()) {
            data=new DataHolder();
            for (int i = 1; i < (column_number+1); i++) {
                switch (rsmd.getColumnTypeName(i)) {
                    case "INT":

                        data.getData().add(r.getInt(i));
                        break;
                    case "VARCHAR":

                        data.getData().add(r.getString(i));
                        break;
                    case "DECIMAL":

                        data.getData().add(r.getDouble(i));
                        break;
                    default:
                        System.out.println(rsmd.getColumnTypeName(i));
                        results.add(null);
                        break;
                }
            }
            results.add(data);
        }
        results.add(0,name);
        return results;
    }

}
