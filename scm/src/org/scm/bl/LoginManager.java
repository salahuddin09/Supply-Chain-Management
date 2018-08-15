package org.scm.bl;

import java.sql.SQLException;
import java.util.List;

import org.scm.db.ScsDAO;
import org.scm.model.Login;

public class LoginManager extends ScsDAO{
public LoginManager() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        
    }
    
    public List<Login> selectNewLogin() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        return super.selectLogin();
    }
}
