/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author gywreb
 */
public class PhongBan {
    private int ID_PhongBan;
    private String Ten_PhongBan;

    public int getID_PhongBan() {
        return ID_PhongBan;
    }

    public String getTen_PhongBan() {
        return Ten_PhongBan;
    }

    public void setID_PhongBan(int ID_PhongBan) {
        this.ID_PhongBan = ID_PhongBan;
    }

    public void setTen_PhongBan(String Ten_PhongBan) {
        this.Ten_PhongBan = Ten_PhongBan;
    }
    
    public PhongBan() {
        this.ID_PhongBan = 0;
        this.Ten_PhongBan = null;
    }

    public PhongBan(int ID_PhongBan, String Ten_PhongBan) {
        this.ID_PhongBan = ID_PhongBan;
        this.Ten_PhongBan = Ten_PhongBan;
    }

    @Override
    public String toString() {
        return "PhongBan{" + "ID_PhongBan=" + ID_PhongBan + ", Ten_PhongBan=" + Ten_PhongBan + '}';
    }
}
