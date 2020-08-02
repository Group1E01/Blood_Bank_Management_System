/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phase3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Group 1E
 */
class Validate {
    public static boolean validateEmail(String email) {                           
       boolean status=false;    
       String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
       Pattern pattern = Pattern.compile(EMAIL_PATTERN);
       Matcher matcher=pattern.matcher(email);
       if(matcher.matches())
       {
           status=true;
       }
       else{
           status=false;
       }
           return status;
            
    }
     public static boolean validatePhone(String s) 
    { 
        // The given argument to compile() method  
        // is regular expression. With the help of  
        // regular expression we can validate mobile 
        // number.  
        // 1) Begins with 0 
        // 2) Then contains 7 or 8 or 9. 
        // 3) Then contains 10 digits 
        Pattern p = Pattern.compile("(0)?[0-9]{10}"); 
  
        // Pattern class contains matcher() method 
        // to find matching between given number  
        // and regular expression 
        Matcher m = p.matcher(s); 
        return (m.find() && m.group().equals(s)); 
    }
}
