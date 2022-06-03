package DataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class DBConnection {
    private  static DBConnection obj;
    private static Connection con=null;


    public static DBConnection getInstance(){return (obj==null)?obj=new DBConnection() : obj;}

    public static void createConnection(){
        String connectionUrl = "jbc:sqlserver://" + "Gowsika\\SQLEXPRESS" + ";database=master" + ";integratedSecurity=true" + ";UseNTLMv2=true" + ";Trusted_Connection=yes"+";Encrypt=true" + ";TrustServerCertificate=true";
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con= DriverManager.getConnection(connectionUrl);
        }catch(SQLException throwables) {
            throwables.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static List<LinkedHashMap<String, String>> exeQueryAndResultLinkedHashMap(String query) {
        List<LinkedHashMap<String, String>> list = new ArrayList<>();
        Connection dbConnection = null;
        Statement statement;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jbc:sqlserver://" + "KARTHIK\\SQLEXPRESS" + ";database=master" + ";integratedSecurity=true" + ";UseNTLMv2=true" + ";Trusted_Connection=yes" + ";Encrypt=true" + ";TrustServerCertificate=true";
            con = DriverManager.getConnection(connectionUrl);
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                LinkedHashMap<String, String> result = new LinkedHashMap<>();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    result.put(rs.getMetaData().getColumnName(i),
                            (rs.getString(i) != null) ? rs.getString(i).trim() : "Null");
                }
                list.add(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally{
            try{
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public static void main(String[] args) {
        String qry= "select * from emp";
        exeQueryAndResultLinkedHashMap(qry);

    }
}
