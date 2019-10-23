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
import java.sql.Date;
        
public class NhanVien extends ConNguoi{
    private int ID_Nhanvien;
    private int id_phong_ban;
    private int id_chi_nhanh;
    
    public int getID_Nhanvien() {
        return ID_Nhanvien;
    }

    public int getId_phong_ban() {
        return id_phong_ban;
    }

    public int getId_chi_nhanh() {
        return id_chi_nhanh;
    }
    
    public void setID_Nhanvien(int ID_Nhanvien) {
        this.ID_Nhanvien = ID_Nhanvien;
    }

    public void setId_phong_ban(int id_phong_ban) {
        this.id_phong_ban = id_phong_ban;
    }

    public void setId_chi_nhanh(int id_chi_nhanh) {
        this.id_chi_nhanh = id_chi_nhanh;
    }

    public NhanVien() {
        super();
        this.ID_Nhanvien = 0;
        this.id_phong_ban = 0;
        this.id_chi_nhanh = 0;
    }

    public NhanVien(int ID_Nhanvien, String ten, Date birth, int id_phong_ban, int id_chi_nhanh) {
        super(ten,birth);
        this.ID_Nhanvien = ID_Nhanvien;
        this.id_phong_ban = id_phong_ban;
        this.id_chi_nhanh = id_chi_nhanh;
    }
    
    @Override
    public String toString() {
        return "ID: "+ this.ID_Nhanvien + "\nTen: " + ten + "\nNgay sinh: " + birth +"\nID_PhongBan: " + this.id_phong_ban + "\nID_ChiNhanh: " + this.id_chi_nhanh;
    }
    
}
