import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/**
 * Created by Boxiaomao on 2017/8/10 0010.
 */
public class Main {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/test";
    //  Database credentials
    static final String USER = "root";
    static final String PASS = "1234";

    public static List findBrandList(){
        Connection conn = null;
        List snh=new ArrayList();
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            String sql = "SELECT chb_car_model_id FROM chb_car_brand"; //★
            PreparedStatement sta = conn.prepareStatement(sql);
            ResultSet akb=sta.executeQuery();
            while(akb.next()) {
                snh.add(akb.getInt("chb_car_model_id"));
            }
            conn.close();
            System.out.println("snh");
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
        }// nothing we can do
        try{
            if(conn!=null)
                conn.close();
        }catch(SQLException se){
            se.printStackTrace();
        }//end finally try

       return  snh;
    }



    public static void main(String[] args) {
        System.out.println(findBrandList());
        Connection conn = null;
        List hkt=findBrandList();
        for (int z = 0; z <hkt.size() ; z++) {
            int ckg=(Integer) hkt.get(z);
        List<Map> akb=CarFind.findCarTypeByBrandId(String.valueOf(ckg));
        System.out.println(akb);
        for (int i = 0; i < akb.size(); i++) {
            Map ske=akb.get(i);
            String chb_car_model_id = (String) ske.get("chb_car_model_id");
            String trade_chb_car_model_id = (String) ske.get("trade_chb_car_model_id");
            String trade_fullname = (String) ske.get("trade_fullname");
            String tradel_initial = (String) ske.get("tradel_initial");
            String trade_name = (String) ske.get("trade_name");
            String full_name = (String) ske.get("full_name");
            String logo_url = (String) ske.get("logo_url");
            String parent_id = (String) ske.get("parent_id");
            String sale_state = (String) ske.get("sale_state");
            String depth = (String) ske.get("depth");
            String type_name = (String) ske.get("type_name");
                    try{
                        //STEP 2: Register JDBC driver
                        Class.forName("com.mysql.jdbc.Driver");
                        //STEP 3: Open a connection
                        System.out.println("Connecting to database...");
                        conn = DriverManager.getConnection(DB_URL,USER,PASS);
                        //STEP 4: Execute a query
                        System.out.println("Creating statement...");
                        String sql = "insert into chb_car_type122(chb_car_model_id,trade_chb_car_model_id,trade_fullname,tradel_initial,trade_name,full_name,logo_url,parent_id,sale_state,depth,type_name) values(?,?,?,?,?,?,?,?,?,?,?)"; //★
                        PreparedStatement sta = conn.prepareStatement(sql);
                        sta.setString(1, chb_car_model_id);
                        sta.setString(2, trade_chb_car_model_id);
                        sta.setString(3, trade_fullname);
                        sta.setString(4, tradel_initial);
                        sta.setString(5, trade_name);
                        sta.setString(6, full_name);
                        sta.setString(7, logo_url);
                        sta.setString(8, parent_id);
                        sta.setString(9, sale_state);
                        sta.setString(10, depth);
                        sta.setString(11, type_name);
                        int rows = sta.executeUpdate();
                        conn.close();
                    }catch(SQLException se){
                        //Handle errors for JDBC
                        se.printStackTrace();
                    }catch(Exception e){
                        //Handle errors for Class.forName
                        e.printStackTrace();
                    }finally{
                        //finally block used to close resources
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
            }


