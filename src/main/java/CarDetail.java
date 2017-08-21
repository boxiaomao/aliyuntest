import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Boxiaomao on 2017/8/14 0014.
 */
public class CarDetail {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/test";
    //  Database credentials
    static final String USER = "root";
    static final String PASS = "1234";

    public static List findCarList(){
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
            String sql = "SELECT chb_car_model_id FROM chb_car_car"; //★
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
        System.out.println(findCarList());
        Connection conn = null;
        List hkt=findCarList();
        for (int z = 0; z <hkt.size() ; z++) {
            int ckg=(Integer) hkt.get(z);
            JSONObject json=CarFind.findCarDetailByCarId(String.valueOf(ckg));
            if (json.getIntValue("status") != 0) {
                System.out.println(json.getString("msg"));
            } else {
                JSONObject json1=json.getJSONObject("result");
                        String chb_car_model_id = json1.getString("id");
                        String name = json1.getString("name");
                        String initial = json1.getString("initial");
                        String parentid = json1.getString("parentid");
                        String logo = json1.getString("logo");
                        String price = json1.getString("price");
                        String yeartype = json1.getString("yeartype");
                        String productionstate = json1.getString("productionstate");
                        String salestate = json1.getString("salestate");
                        String sizetype = json1.getString("sizetype");
                        String depth = json1.getString("depth");
                        String basic_price = json1.getJSONObject("basic").getString("price");
                String basic_saleprice = json1.getJSONObject("basic").getString("saleprice");
                String basic_warrantypolicy = json1.getJSONObject("basic").getString("warrantypolicy");
                String basic_vechiletax = json1.getJSONObject("basic").getString("vechiletax");
                String basic_displacement = json1.getJSONObject("basic").getString("displacement");
                String basic_gearbox = json1.getJSONObject("basic").getString("gearbox");
                String basic_comfuelconsumption = json1.getJSONObject("basic").getString("comfuelconsumption");
                String basic_userfuelconsumption = json1.getJSONObject("basic").getString("userfuelconsumption");
                String basic_officialaccelerationtime100 = json1.getJSONObject("basic").getString("officialaccelerationtime100");
                String basic_testaccelerationtime100 = json1.getJSONObject("basic").getString("testaccelerationtime100");
                String basic_maxspeed = json1.getJSONObject("basic").getString("maxspeed");
                String basic_seatnum = json1.getJSONObject("basic").getString("seatnum");
                String body_color = json1.getJSONObject("body").getString("color");
                String body_len = json1.getJSONObject("body").getString("len");
                String body_width = json1.getJSONObject("body").getString("width");
                String body_height = json1.getJSONObject("body").getString("height");
                String body_wheelbase = json1.getJSONObject("body").getString("wheelbase");
                String body_fronttrack = json1.getJSONObject("body").getString("fronttrack");
                String body_reartrack = json1.getJSONObject("body").getString("reartrack");
                String body_weight = json1.getJSONObject("body").getString("weight");
                String body_fullweight = json1.getJSONObject("body").getString("fullweight");
                String body_mingroundclearance = json1.getJSONObject("body").getString("mingroundclearance");
                String body_approachangle = json1.getJSONObject("body").getString("approachangle");
                String body_departureangle = json1.getJSONObject("body").getString("departureangle");
                String body_luggagevolume = json1.getJSONObject("body").getString("luggagevolume");
                String body_luggagemode = json1.getJSONObject("body").getString("luggagemode");
                String body_luggageopenmode = json1.getJSONObject("body").getString("luggageopenmode");
                String body_inductionluggage = json1.getJSONObject("body").getString("inductionluggage");
                String body_doornum = json1.getJSONObject("body").getString("doornum");
                String body_tooftype = json1.getJSONObject("body").getString("tooftype");
                String body_hoodtype = json1.getJSONObject("body").getString("hoodtype");
                String body_roofluggagerack = json1.getJSONObject("body").getString("sportpackage");
                String body_sportpackage = json1.getJSONObject("body").getString("sportpackage");
                String engine_position = json1.getJSONObject("engine").getString("position");
                String engine_model = json1.getJSONObject("engine").getString("model");
                String engine_displacement = json1.getJSONObject("engine").getString("displacement");
                String engine_displacementml = json1.getJSONObject("engine").getString("displacementml");
                String engine_intakeform = json1.getJSONObject("engine").getString("intakeform");
                String engine_cylinderarrangetype = json1.getJSONObject("engine").getString("cylinderarrangetype");
                String engine_cylindernum = json1.getJSONObject("engine").getString("cylindernum");
                String engine_valvetrain = json1.getJSONObject("engine").getString("valvetrain");
                String engine_valvestructure = json1.getJSONObject("engine").getString("valvestructure");
                String engine_compressionratio = json1.getJSONObject("engine").getString("compressionratio");
                String engine_bore = json1.getJSONObject("engine").getString("bore");
                String engine_stroke = json1.getJSONObject("engine").getString("stroke");
                String engine_maxhorsepower = json1.getJSONObject("engine").getString("maxhorsepower");
                String engine_maxpower = json1.getJSONObject("engine").getString("maxpower");
                String engine_maxpowerspeed = json1.getJSONObject("engine").getString("maxpowerspeed");
                String engine_maxtorque = json1.getJSONObject("engine").getString("maxtorque");
                String engine_maxtorquespeed = json1.getJSONObject("engine").getString("maxtorquespeed");
                String engine_fueltype = json1.getJSONObject("engine").getString("fueltype");
                String engine_fuelgrade = json1.getJSONObject("engine").getString("fuelgrade");
                String engine_fuelmethod = json1.getJSONObject("engine").getString("fuelmethod");
                String engine_fueltankcapacity = json1.getJSONObject("engine").getString("fueltankcapacity");
                String engine_cylinderheadmaterial = json1.getJSONObject("engine").getString("cylinderheadmaterial");
                String engine_cylinderbodymaterial = json1.getJSONObject("engine").getString("cylinderbodymaterial");
                String engine_environmentalstandards = json1.getJSONObject("engine").getString("environmentalstandards");
                String engine_startstopsystem = json1.getJSONObject("engine").getString("startstopsystem");
                String gearbox_gearbox = json1.getJSONObject("gearbox").getString("gearbox");
                String gearbox_shiftpaddles = json1.getJSONObject("gearbox").getString("shiftpaddles");
                        try{
                            //STEP 2: Register JDBC driver
                            Class.forName("com.mysql.jdbc.Driver");
                            //STEP 3: Open a connection
                            System.out.println("Connecting to database...");
                            conn = DriverManager.getConnection(DB_URL,USER,PASS);
                            //STEP 4: Execute a query
                            System.out.println("Creating statement...");
                            String sql = "insert into chb_car_detail(chb_car_model_id,name,initial,logo_url,parent_id,price,yeartype,productionstate,salestate,sizetype,depth,basic_price,basic_saleprice,basic_warrantypolicy,basic_vechiletax,basic_displacement,basic_gearbox,basic_comfuelconsumption,basic_userfuelconsumption,basic_officialaccelerationtime100,basic_testaccelerationtime100,basic_maxspeed,basic_seatnum,body_color,body_len,body_width,body_height,body_wheelbase,body_fronttrack,body_reartrack,body_weight,body_fullweight,body_mingroundclearance,body_approachangle,body_departureangle,body_luggagevolume,body_luggagemode,body_luggageopenmode,body_inductionluggage,body_doornum,body_tooftype,body_hoodtype,body_roofluggagerack,body_sportpackage,engine_position,engine_model,engine_displacement,engine_displacementml,engine_intakeform,engine_cylinderarrangetype,engine_cylindernum,engine_valvetrain,engine_valvestructure,engine_compressionratio,engine_bore,engine_stroke,engine_maxhorsepower,engine_maxpower,engine_maxpowerspeed,engine_maxtorque,engine_maxtorquespeed,engine_fueltype,engine_fuelgrade,engine_fuelmethod,engine_fueltankcapacity,engine_cylinderheadmaterial,engine_cylinderbodymaterial,engine_environmentalstandards,engine_startstopsystem,gearbox_gearbox,gearbox_shiftpaddles)  values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"; //★
                            PreparedStatement sta = conn.prepareStatement(sql);
                            sta.setString(1, chb_car_model_id);
                            sta.setString(2, name);
                            sta.setString(3, initial);
                            sta.setString(4, logo);
                            sta.setString(5, parentid);
                            sta.setString(6, yeartype);
                            sta.setString(7, price);
                            sta.setString(8, productionstate);
                            sta.setString(9, salestate);
                            sta.setString(10, sizetype);
                            sta.setString(11, depth);
                            sta.setString(12, basic_price);
                            sta.setString(13, basic_saleprice);
                            sta.setString(14, basic_warrantypolicy);
                            sta.setString(15, basic_vechiletax);
                            sta.setString(16, basic_displacement);
                            sta.setString(17, basic_gearbox);
                            sta.setString(18, basic_comfuelconsumption);
                            sta.setString(19, basic_userfuelconsumption);
                            sta.setString(20, basic_officialaccelerationtime100);
                            sta.setString(21, basic_testaccelerationtime100);
                            sta.setString(22, basic_maxspeed);
                            sta.setString(23, basic_seatnum);
                            sta.setString(24, body_color);
                            sta.setString(25, body_len);
                            sta.setString(26, body_width);
                            sta.setString(27, body_height);
                            sta.setString(28, body_wheelbase);
                            sta.setString(29, body_fronttrack);
                            sta.setString(30, body_reartrack);
                            sta.setString(31, body_weight);
                            sta.setString(32, body_fullweight);
                            sta.setString(33, body_mingroundclearance);
                            sta.setString(34, body_approachangle);
                            sta.setString(35, body_departureangle);
                            sta.setString(36, body_luggagevolume);
                            sta.setString(37, body_luggagemode);
                            sta.setString(38, body_luggageopenmode);
                            sta.setString(39, body_inductionluggage);
                            sta.setString(40, body_doornum);
                            sta.setString(41, body_tooftype);
                            sta.setString(42, body_hoodtype);
                            sta.setString(43, body_roofluggagerack);
                            sta.setString(44, body_sportpackage);
                            sta.setString(45, engine_position);
                            sta.setString(46, engine_model);
                            sta.setString(47, engine_displacement);
                            sta.setString(48, engine_displacementml);
                            sta.setString(49, engine_intakeform);
                            sta.setString(50, engine_cylinderarrangetype);
                            sta.setString(51, engine_cylindernum);
                            sta.setString(52, engine_valvetrain);
                            sta.setString(53, engine_valvestructure);
                            sta.setString(54, engine_compressionratio);
                            sta.setString(55, engine_bore);
                            sta.setString(56, engine_stroke);
                            sta.setString(57, engine_maxhorsepower);
                            sta.setString(58, engine_maxpower);
                            sta.setString(59, engine_maxpowerspeed);
                            sta.setString(60, engine_maxtorque);
                            sta.setString(61, engine_maxtorquespeed);
                            sta.setString(62, engine_fueltype);
                            sta.setString(63, engine_fuelgrade);
                            sta.setString(64, engine_fuelmethod);
                            sta.setString(65, engine_fueltankcapacity);
                            sta.setString(66, engine_cylinderheadmaterial);
                            sta.setString(67, engine_cylinderbodymaterial);
                            sta.setString(68, engine_environmentalstandards);
                            sta.setString(69, engine_startstopsystem);
                            sta.setString(70, gearbox_gearbox);
                            sta.setString(71, gearbox_shiftpaddles);
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

