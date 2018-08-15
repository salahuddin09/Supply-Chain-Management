package org.scm.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ScsDBConnection {
    
        private Connection conn;
        public String url = "jdbc:mysql://localhost:3306/";
        public String dbName = "scs";
        public String driver = "com.mysql.jdbc.Driver";
        
        public String userName = "root";
        public String password = ""; 
        
        //private static ScsDBConnection scsDBConnection;
        
        
        protected ScsDBConnection() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
            Class.forName(driver).newInstance();
            conn = (Connection) DriverManager.getConnection(url+dbName,userName, password);
        }
        
       /* protected static ScsDBConnection getInstance() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
            if(scsDBConnection==null){
                 
                return new ScsDBConnection();
            }
            else{
                return scsDBConnection;
            }
        }                       */                            
        
        protected Connection getConnection(){
            return this.conn;
        }
        
}
