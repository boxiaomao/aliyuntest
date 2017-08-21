import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Boxiaomao on 2017/8/14 0014.
 */
public class NewMain {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/test";
    //  Database credentials
    static final String USER = "root";
    static final String PASS = "1234";

    public static List findType(){
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
            String sql = "SELECT chb_car_model_id FROM chb_car_type"; //★
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
        System.out.println(findType());
        Connection conn = null;
        List hkt=findType();
        for (int z = 0; z <hkt.size() ; z++) {
            int ckg=(Integer) hkt.get(z);
            JSONObject json=CarFind.findCarByCarType(String.valueOf(ckg));
                if (json.getIntValue("status") != 0) {
                    System.out.println(json.getString("msg"));
                } else {
                    JSONObject json1=json.getJSONObject("result");
                    JSONArray resultarr11= null;
                     resultarr11 = json1.getJSONArray("list");
                    if (resultarr11==null){
                        continue ;
                    }else {
                    for (int i = 0; i < resultarr11.size(); i++) {
                        JSONObject obj = (JSONObject) resultarr11.getJSONObject(i);
                        String chb_car_model_id = obj.getString("id");
                        String full_name = json1.getString("fullname");
                        String initial = json1.getString("initial");
                        String name = obj.getString("name");
                        String depth = obj.getString("depth");
                        String logo_url = obj.getString("logo");
                        String price = obj.getString("price");
                        String year_type = obj.getString("yeartype");
                        String production_state = obj.getString("productionstate");
                        String parent_id = obj.getString("parentid");
                        String sale_state = obj.getString("salestate");
                        String size_type = obj.getString("sizetype");
                try{
                    //STEP 2: Register JDBC driver
                    Class.forName("com.mysql.jdbc.Driver");
                    //STEP 3: Open a connection
                    System.out.println("Connecting to database...");
                    conn = DriverManager.getConnection(DB_URL,USER,PASS);
                    //STEP 4: Execute a query
                    System.out.println("Creating statement...");
                    String sql = "insert into chb_car_car(model_id,initial,full_name,name,depth,logo_url,price,year_type,production_state,type_id,sale_state,size_type) values(?,?,?,?,?,?,?,?,?,?,?,?)"; //★
                    PreparedStatement sta = conn.prepareStatement(sql);
                    sta.setString(1, chb_car_model_id);
                    sta.setString(2, full_name);
                    sta.setString(3, initial);
                    sta.setString(4, name);
                    sta.setString(5, depth);
                    sta.setString(6, logo_url);
                    sta.setString(7, price);
                    sta.setString(8, year_type);
                    sta.setString(9, production_state);
                    sta.setInt(10, ckg);
                    sta.setString(11, sale_state);
                    sta.setString(12, size_type);
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
    }
}
