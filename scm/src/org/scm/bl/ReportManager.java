/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.scm.bl;

import java.sql.Connection;
import java.sql.SQLException;
import org.scm.db.ScsDBConnection;

/**
 *
 * @author Personal
 */
public class ReportManager extends ScsDBConnection{
     public ReportManager() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
	        
	    }
     public Connection DBConnectionForReport() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
	        return super.getConnection();
	    }
}
