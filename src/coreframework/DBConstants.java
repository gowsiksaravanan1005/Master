package coreframework;



import java.sql.Connection;

public class DBConstants {
    private static DBConstants obj;
    public static DBConstants getInstance(){return (obj ==null) ? obj = new DBConstants() : obj;}
    private Connection ConnectionSYST;
    public Connection getConnectionSYST(){ return  ConnectionSYST;}
    public void setConnectionSYST(Connection connectionSYST) { ConnectionSYST = connectionSYST;}
    public void storeConnection(Connection conn, Environment env){
        if(env.equals(Environment.SYST)) {
            setConnectionSYST((conn));
        }
    }

    public Connection getConnection(Environment env){
        Connection conn;
        if(env.equals(Environment.SYST)){
            conn = getConnectionSYST();
        }
        else{
            conn=null;
        }
        return conn;
    }

}
