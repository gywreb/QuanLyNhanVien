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
public class ChiNhanh {
    private int ID_ChiNhanh;
    private String Ten_ChiNhanh;
    
    public int getID_ChiNhanh() {
        return ID_ChiNhanh;
    }

    public String getTen_ChiNhanh() {
        return Ten_ChiNhanh;
    }

    public void setID_ChiNhanh(int ID_ChiNhanh) {
        this.ID_ChiNhanh = ID_ChiNhanh;
    }

    public void setTen_ChiNhanh(String Ten_ChiNhanh) {
        this.Ten_ChiNhanh = Ten_ChiNhanh;
    }
    
    public ChiNhanh () {
        this.ID_ChiNhanh = 0;
        this.Ten_ChiNhanh = null;
    }
    public ChiNhanh(int ID_ChiNhanh, String Ten_ChiNhanh) {
        this.ID_ChiNhanh = ID_ChiNhanh;
        this.Ten_ChiNhanh = Ten_ChiNhanh;
    }

    @Override
    public String toString() {
        return "ChiNhanh{" + "ID_ChiNhanh=" + ID_ChiNhanh + ", Ten_ChiNhanh=" + Ten_ChiNhanh + '}';
    }
    
}
