package com.avinash.sqlconnect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.transform.Result;

/**
 * Created by Avinash on 19-01-2018.
 */

public class GetData {

    Connection connect;
    String ConnectionResult="";
    Boolean isSuccess=false;

    public List<Map<String,String>> getdata(){
        List<Map<String,String>> data=null;
        data = new ArrayList<Map<String,String>>();

        try{
            ConnectionHelper connectionHelper=new ConnectionHelper();
            connect=connectionHelper.connections();
            if(connect==null){
                ConnectionResult="Check Your Internet Access!";
            }else{
                String query="select * from T1";
                Statement stmt=connect.createStatement();
                ResultSet rs=stmt.executeQuery(query);

                while(rs.next()){
                    Map<String,String> datanum=new HashMap<String,String>();
                    datanum.put("User1",rs.getString("UsrName"));
                    datanum.put("Pass1",rs.getString("Passwd"));
                    data.add(datanum);
                }

                ConnectionResult="Successfull";
                isSuccess=true;
                connect.close();
            }
        }catch (Exception ex){
            isSuccess=false;
            ConnectionResult=ex.getMessage();
        }
        return data;
    }
}
