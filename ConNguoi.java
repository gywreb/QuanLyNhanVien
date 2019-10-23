/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.Date;

/**
 *
 * @author gywreb
 */
public abstract class ConNguoi {
    
    protected String ten;
    protected Date birth;

    public String getTen() {
        return ten;
    }

    public Date getBirth() {
        return birth;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public ConNguoi() {
        this.ten = null;
        this.birth = null;
    }

    public ConNguoi(String ten, Date birth) {
        this.ten = ten;
        this.birth = birth;
    }

    @Override
    public abstract String toString();
}
