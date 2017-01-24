package com.cjmulcahy.web;

import com.cjmulcahy.dao.ReadDBSchemaImpl;
import com.cjmulcahy.domain.DataHolder;
import com.cjmulcahy.service.ReadDBService;
import com.cjmulcahy.service.ReadDBServiceImpl;
import com.google.gson.Gson;
import jdk.nashorn.internal.parser.JSONParser;
import jdk.nashorn.internal.runtime.regexp.RegExp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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

    @RequestMapping(value="getResults", method= RequestMethod.POST)
    @ResponseBody
    public String getResults(@RequestBody String query){
        ArrayList<Object> table_results=null;
        String tableData="";
        Gson gson = new Gson();
        try {
            if(dbService.connectToDB(env.getProperty("portfolio.db.url"), env.getProperty("portfolio.db.username"), env.getProperty("portfolio.db.password"), env.getProperty("portfolio.db.driver"))) {
                query=query.replace('+',' ');
                query=query.replace("%28","(");
                query=query.replace("%29",")");
                if(query.charAt(query.length()-1)=='=')
                query=query.replace("=","");
                table_results=dbService.processQuery(query);
                tableData=gson.toJson(table_results);
            }
        }catch(Exception e){
            System.out.println("failed to get tables");
            e.printStackTrace();
        }
        return gson.toJson(table_results);
    }

    @RequestMapping("db/import/{elementId}")
    @ResponseBody
    public String fetchTableData(@PathVariable("elementId") String elementId){
        ArrayList<String> table_columns=null;
        String tableList="";
        Gson gson = new Gson();
        try {
            if(dbService.connectToDB(env.getProperty("portfolio.db.url"), env.getProperty("portfolio.db.username"), env.getProperty("portfolio.db.password"), env.getProperty("portfolio.db.driver"))) {
                table_columns=dbService.listColumns(elementId);
                tableList=gson.toJson(table_columns);
            }
        }catch(Exception e){
            System.out.println("failed to get tables");
            e.printStackTrace();
        }


        return tableList;
    }

    @RequestMapping("db/importTables")
    @ResponseBody
    public String fetchTables(){
        ArrayList<String> tableNames=null;
        String tableList="";
        Gson gson = new Gson();
        try{
            if(dbService.connectToDB(env.getProperty("portfolio.db.url"), env.getProperty("portfolio.db.username"), env.getProperty("portfolio.db.password"), env.getProperty("portfolio.db.driver"))){
                tableNames=dbService.listTables();
                tableList=gson.toJson(tableNames);
            }
        }catch(Exception e){
            System.out.println("Failed to get Tables data");
            e.printStackTrace();
        }
        return tableList;
    }





}
