/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Data.Login;
import Data.Register;
import java.util.ArrayList;

/**
 *
 * @author Easy_IT
 */
public class UserService {
    ArrayList<String> cap = new ArrayList<>();

    public UserService(Login lg) {
        cap.add(lg.getUser());
        cap.add(lg.getPass());
    }
    public UserService(Register rs) {
        cap.add(rs.getUsername());
        cap.add(rs.getPassword());
        cap.add(rs.getRePassword());
        cap.add(rs.getEmail());
        cap.add(rs.getReEmail());
    }
    
    public static boolean haveEmptyAnyObject(UserService a) {
        for(int i=0;i<a.cap.size();i++) {
            if(a.cap.get(i).equals(""))
                return true;
        }
        return false;
    }
    public static boolean registerInputHasSameData(Register rs) {
        return rs.getPassword().equals(rs.getRePassword()) && rs.getEmail().equals(rs.getReEmail());
    }
}
