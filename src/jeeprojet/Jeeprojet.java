
package jeeprojet;


import com.database.DB;
import com.login.loginframe;

public class Jeeprojet {

    public static void main(String[] args) {
     loginframe loginObj = new  loginframe();
     loginObj.show();
   DB.Loadconnection();
    
    }
    
}
