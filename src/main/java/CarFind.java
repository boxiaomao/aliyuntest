import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Boxiaomao on 2017/7/31 0031.
 */
public class CarFind {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/test";
    //  Database credentials
    static final String USER = "root";
    static final String PASS = "1234";
    public static JSONObject  findAllCarBrand(){
           String APPKEY = "be7533769f53fa29";// 你的appkey
           String URL = "http://api.jisuapi.com/car/brand";
            String result = null;
            String key ="appkey=" + APPKEY;
            try {
                result = HttpUtil.sendGet(URL, key);
                System.out.println(result);
                JSONObject json = JSONObject.parseObject(result);
                if (json.getIntValue("status") != 0) {
                    System.out.println(json.getString("msg"));
                } else {
                    JSONArray resultarr = json.getJSONArray("result");
                    for (int i = 0; i < resultarr.size(); i++) {
                        JSONObject obj = (JSONObject) resultarr.getJSONObject(i);
                        String id = obj.getString("id");
                        String name = obj.getString("name");
                        String initial = obj.getString("initial");
                        String parentid = obj.getString("parentid");
                        String logo = obj.getString("logo");
                        String depth = obj.getString("depth");
                    }
                }
                return json;
            } catch (Exception e) {
                e.printStackTrace();
            }
        return null;
    }
    public static List  findCarTypeByBrandId(String parentid){
        String APPKEY = "be7533769f53fa29";// 你的appkey
        String URL = "http://api.jisuapi.com/car/type";
        String result = null;
        String key ="appkey=" + APPKEY+"&parentid="+parentid;
        List<Map> back=new ArrayList();
        try {
            result = HttpUtil.sendGet(URL, key);
            System.out.println(result);
            JSONObject json = JSONObject.parseObject(result);
            if (json.getIntValue("status") != 0) {
                System.out.println(json.getString("msg"));
            } else {
                JSONArray resultarr = json.getJSONArray("result");
                for (int i = 0; i < resultarr.size(); i++) {
                    JSONObject obj = (JSONObject) resultarr.getJSONObject(i);
                    String id = obj.getString("id");
                    String name = obj.getString("name");
                    String initial = obj.getString("initial");
                    String fullname = obj.getString("fullname");
                    String parentid1 = obj.getString("parentid");
                    String logo = obj.getString("logo");
                    String depth = obj.getString("depth");
                    JSONArray resultByCarXi = obj.getJSONArray("list");
                    if(resultByCarXi.size()==0){
                        Map<String,String> akb=new HashMap<String, String>();
                        akb.put("chb_car_model_id","");
                        akb.put("trade_chb_car_model_id",id);
                        akb.put("trade_fullname",fullname);
                        akb.put("tradel_initial",initial);
                        akb.put("trade_name",name);
                        akb.put("type_name","");
                        akb.put("full_name","");
                        akb.put("logo_url","");
                        akb.put("parent_id",parentid);
                        akb.put("sale_state","");
                        akb.put("depth","2");
                        back.add(akb);
                    }else {
                        for (int j = 0; j < resultByCarXi.size(); j++) {
                            Map<String,String> akb=new HashMap<String, String>();
                            JSONObject obj1 = (JSONObject) resultByCarXi.getJSONObject(j);
                            String id1 = obj1.getString("id");
                            String name1 = obj1.getString("name");
                            String initial1 = obj1.getString("initial");
                            String parentid11 = obj1.getString("parentid");
                            String logo1= obj1.getString("logo");
                            String fullname1= obj1.getString("fullname");
                            String salestate1= obj1.getString("salestate");
                            String depth1 = obj1.getString("depth");
                            akb.put("chb_car_model_id",id1);
                            akb.put("trade_chb_car_model_id",id);
                            akb.put("trade_fullname",fullname);
                            akb.put("tradel_initial",initial);
                            akb.put("trade_name",name);
                            akb.put("type_name",name1);
                            akb.put("full_name",fullname1);
                            akb.put("logo_url",logo1);
                            akb.put("parent_id",parentid);
                            akb.put("sale_state",salestate1);
                            akb.put("depth",depth1);
                            back.add(akb);
                            System.out.println("  车系Id"+id + "  车系name" + name + "  initial" + initial + "  车型Id" +id1 + "  车型name" + name1 +"  fullname"+fullname1+"  logo"+logo1+"  salestate"+salestate1+"  depth"+depth1);
                        }
                    }

                }
            }
            return back;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return back;
    }

    public static JSONObject  findCarByCarType(String parentid){
        String APPKEY = "be7533769f53fa29";// 你的appkey
        String URL = "http://api.jisuapi.com/car/car";//http://api.jisuapi.com/car/car?appkey=yourappkey&parentid=219
        String result = null;
        String key ="appkey=" + APPKEY+"&parentid="+parentid;
        try {
            result = HttpUtil.sendGet(URL, key);
            System.out.println(result);
            JSONObject json = JSONObject.parseObject(result);
            return json;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static JSONObject  findCarDetailByCarId(String carid){
        String APPKEY = "be7533769f53fa29";// 你的appkey
        String URL = "http://api.jisuapi.com/car/detail";//http://api.jisuapi.com/car/detail?appkey=yourappkey&carid=2571
        String result = null;
        String key ="appkey=" + APPKEY+"&carid="+carid;
        try {
            result = HttpUtil.sendGet(URL, key);
            System.out.println(result);
            JSONObject json = JSONObject.parseObject(result);
            return json;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /*public static void main(String[] args) {
        //CarFind.findCarTypeByBrandId(258);
        Connection conn = null;
        Statement stmt = null;
        JSONObject json11=CarFind.findAllCarBrand();
        JSONArray resultarr11 = json11.getJSONArray("result");
        for (int i = 0; i < resultarr11.size(); i++) {
            JSONObject obj11 = (JSONObject) resultarr11.getJSONObject(i);
            String id11 = obj11.getString("id");
            JSONObject json1=CarFind.findCarTypeByBrandId(id11);
            JSONArray resultarr = json1.getJSONArray("result");
            for (int k = 0; k < resultarr.size(); k++) {
                JSONObject obj = (JSONObject) resultarr.getJSONObject(k);
                String id = obj.getString("id");
                String name = obj.getString("name");
                String initial = obj.getString("initial");
                String parentid1 = obj.getString("parentid");
                String logo = obj.getString("logo");
                String depth = obj.getString("depth");
                JSONArray resultByCarXi = obj.getJSONArray("list");
                for (int j = 0; j < resultByCarXi.size(); j++) {
                    JSONObject obj1 = (JSONObject) resultByCarXi.getJSONObject(j);
                    String id1 = obj1.getString("id");
                    String name1 = obj1.getString("name");
                    String initial1 = obj1.getString("initial");
                    String parentid11 = obj1.getString("parentid");
                    String logo1= obj1.getString("logo");
                    String fullname1= obj1.getString("fullname");
                    String salestate1= obj1.getString("salestate");
                    String depth1 = obj1.getString("depth");
                    try{
                        //STEP 2: Register JDBC driver
                        Class.forName("com.mysql.jdbc.Driver");
                        //STEP 3: Open a connection
                        System.out.println("Connecting to database...");
                        conn = DriverManager.getConnection(DB_URL,USER,PASS);
                        //STEP 4: Execute a query
                        System.out.println("Creating statement...");
                        String sql = "insert into car_brand(id,name,initial,parentid,logo,depth) values(?,?,?,?,?,?)"; //★
                        PreparedStatement sta = conn.prepareStatement(sql);
                        sta.setString(1, id);
                        sta.setString(2, name);
                        sta.setString(3, initial);
                        sta.setString(4, id);
                        sta.setString(5, id);
                        sta.setString(6, id);
                        int rows = sta.executeUpdate();
                        stmt.close();
                        conn.close();
                    }catch(SQLException se){
                        //Handle errors for JDBC
                        se.printStackTrace();
                    }catch(Exception e){
                        //Handle errors for Class.forName
                        e.printStackTrace();
                    }finally{
                        //finally block used to close resources
                        try{
                            if(stmt!=null)
                                stmt.close();
                        }catch(SQLException se2){
                        }// nothing we can do
                        try{
                            if(conn!=null)
                                conn.close();
                        }catch(SQLException se){
                            se.printStackTrace();
                        }//end finally try
                    }//end try



                }
            }

        }//end main}//end main
        }*/

/*

    JSONObject obj = (JSONObject) resultarr.getJSONObject(i);
    String id = obj.getString("id");

        try{
        //STEP 2: Register JDBC driver
        Class.forName("com.mysql.jdbc.Driver");
        //STEP 3: Open a connection
        System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(DB_URL,USER,PASS);
        //STEP 4: Execute a query
        System.out.println("Creating statement...");
        String sql = "insert into car_brand(id,name,initial,parentid,logo,depth) values(?,?,?,?,?,?)"; //★
        PreparedStatement sta = conn.prepareStatement(sql);
        sta.setString(1, id);
        sta.setString(2, name);
        sta.setString(3, initial);
        sta.setString(4, parentid);
        sta.setString(5, address);
        sta.setString(6, address);
        int rows = sta.executeUpdate();
        stmt.close();
        conn.close();
    }catch(SQLException se){
        //Handle errors for JDBC
        se.printStackTrace();
    }catch(Exception e){
        //Handle errors for Class.forName
        e.printStackTrace();
    }finally{
        //finally block used to close resources
        try{
            if(stmt!=null)
                stmt.close();
        }catch(SQLException se2){
        }// nothing we can do
        try{
            if(conn!=null)
                conn.close();
        }catch(SQLException se){
            se.printStackTrace();
        }//end finally try
    }//end try
        System.out.println("Goodbye!");
*/

}

