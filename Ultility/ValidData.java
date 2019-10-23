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
    
    public static int validString(String str) {
        int valid = 1; //true
        char kytu;
        if(str.length() == 0) {
            valid = 0;
        }
        else {
            for(int i = 0; i < str.length(); i++) {
                //tra ve ky tu tai vi tri thu i cua str
                kytu = str.charAt(i);
                //ktra ky tu i co phai space hay ko ?
                if(Character.isSpaceChar(kytu) == false) {
                    if((kytu >= 65 && kytu <= 90) || (kytu >= 97 && kytu <= 122))
                        break;
                    else {
                        valid = 0;
                        break;
                    }
                }
                else valid = 0;
            }
        }
        return valid;
    }
     
}
