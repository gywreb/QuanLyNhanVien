/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ultility;

/**
 *
 * @author gywreb
 */
public class ValidData {
    
    public String validString(String str) {
        
        //Xoa khoang trang thua o dau va cuoi
        str  = str.trim();
        StringBuilder newStr = new StringBuilder();
        //Xoa khoang trang thua giua 2 ky tu
        for(int i = 0; i < str.length(); i++) {
            if(Character.isSpaceChar(str.charAt(i))) {
                //neu i la dau cach thi ktra i + 1 la dau cach  
                if(!Character.isSpaceChar(str.charAt(i + 1)))
                    //i + 1 la dau cach thi ko cho noi i vao newStr
                    //cho den ky tu i + 1 ko phai la dau cach thi noi i
                    newStr.append(str.charAt(i));
            }
            //neu i khong phai la dau cach thi noi i
            else newStr.append(str.charAt(i));
        }
        return newStr.toString();
    }
    
    public boolean isInteger(String str) {
        
        boolean valid = true;
        try {
            // neu chuyen duoc String thanh Integer
            Integer.parseInt(str);
        } catch(Exception e) {
            valid = false;
        }
        
        return valid;
    }
}
     

