package com.cjmulcahy.web;

import com.cjmulcahy.dao.ReadDBSchemaImpl;
import com.cjmulcahy.service.ReadDBService;
import com.cjmulcahy.service.ReadDBServiceImpl;
import com.google.gson.Gson;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris on 1/16/2017.
 */
@Controller
@PropertySource("classpath:database.properties")
public class DBController {


    private ReadDBService dbService= new ReadDBServiceImpl(new ReadDBSchemaImpl());

    @Autowired
    private Environment env;

    @RequestMapping("/")
    public ModelAndView openHomePage(){

        return new ModelAndView("Home");
    }

    @RequestMapping("db/import")
    @ResponseBody
    public String fetchTables(){
        ArrayList<String> table_columns=null;
        String tableList="";
        Gson gson = new Gson();
        try {
            if(dbService.connectToDB(env.getProperty("portfolio.db.url"), env.getProperty("portfolio.db.username"), env.getProperty("portfolio.db.password"), env.getProperty("portfolio.db.driver"))) {
                table_columns=dbService.listTables();
                tableList=gson.toJson(table_columns);
            }
        }catch(Exception e){
            System.out.println("failed to get tables");
            e.printStackTrace();
        }


        return tableList;
    }





}
