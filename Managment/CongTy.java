/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managment;

import Data.ChiNhanh;
import Data.NhanVien;
import Data.PhongBan;
import java.sql.*;

/**
 *
 * @author gywreb
 */
public class CongTy {
    
    private static Connection SQLconn() throws SQLException {
        
        Connection conn = null;
       
        StringBuilder URL = new StringBuilder();
        URL.append("jdbc:sqlserver://DESKTOP-MG5DSO1:1433;databaseName=QuanLyNhanSu;");
        URL.append("user=").append("sa").append(";");
        URL.append("password=").append("sa").append(";");
        conn = DriverManager.getConnection(URL.toString());
        
        return conn;
    }
    
    public int checkNV(int id) throws SQLException {
        
        int idexist  = 1;
        Connection c = SQLconn();
        StringBuilder query = new StringBuilder();
        
        query.append("SELECT *");
        query.append("FROM NhanVien");
        query.append(" WHERE ID_Nhanvien = ?");
        
        PreparedStatement sta = c.prepareStatement(query.toString());
        sta.setInt(1, id); //(thu tu cua bien, bien)
        ResultSet rs  = sta.executeQuery();
        
        int idcheck;
        if(rs.next()) { //van con du lieu trong database de truy van
            idcheck = rs.getInt("ID_Nhanvien");
            if(idcheck == id) {
                idexist = 0;
                System.out.println("ID da ton tai !");
            }
        }
        return idexist;
    }
    public void insertNV(NhanVien nv) throws SQLException {
        
        Connection c = SQLconn();
        
        StringBuilder query = new StringBuilder();
        
        Date date = Date.valueOf(nv.getBirth().toString());
        query.append("INSERT INTO NhanVien(ID_Nhanvien,ten,birth,id_phong_ban,id_chi_nhanh)");
        query.append("VALUES (").append(nv.getID_Nhanvien()).append(",'").append(nv.getTen()).append("','").append(date).append("',").append(nv.getId_phong_ban()).append(",").append(nv.getId_chi_nhanh()).append(")");
        
        PreparedStatement sta = c.prepareStatement(query.toString());
        sta.executeUpdate(); //thuc thi cau lenh truy van

        c.close();
        sta.close();
    }
    
    public void searchNV(String condition, int choice) throws SQLException {
        
        Connection c = SQLconn();
        int id;
        StringBuilder query = new StringBuilder();
        query.append("SELECT *");
        query.append("FROM NhanVien");
        
        switch (choice) {
            case 1:
                // Tim kiem theo ID_Nhanvien
                id = Integer.parseInt(condition);
                query.append(" WHERE ID_Nhanvien = ");
                query.append(id);
                break;
            case 2:
                //Tim kiem theo ten nhan vien
                //System.out.println("NHAN VIEN CO TEN: " + condition);
                query.append(" WHERE ten = '");
                query.append(condition).append("'"); 
                break;
            case 3:
                //Tim kiem theo ngay sinh
                //System.out.println("NHAN VIEN CO NGAY SINH: " + condition);
                query.append(" WHERE birth = '");
                query.append(condition).append("'"); 
                break;
            case 4:
                //Tim kiem theo ten phong ban
                //System.out.println("NHAN VIEN CUA PHONG BAN: " + condition);
                query.append(",PhongBan");
                query.append(" WHERE NhanVien.id_phong_ban = PhongBan.ID_PhongBan AND Ten_PhongBan = '");
                query.append(condition).append("'"); 
                break;
            case 5:
                //Tim kiem theo id phong ban
                id = Integer.parseInt(condition);
                //System.out.println("NHAN VIEN Co ID PHONG BAN: " + condition);
                query.append(" WHERE NhanVien.id_phong_ban = ");
                query.append(id);
                break;
            case 6:
                //Tim Kiem theo ten chi nhanh
                //System.out.println("NHAN VIEN CUA CHI NHANH: " + condition);
                query.append(",ChiNhanh");
                query.append(" WHERE NhanVien.id_chi_nhanh = ChiNhanh.ID_ChiNhanh AND Ten_ChiNhanh = '");
                query.append(condition).append("'");
                break;
            case 7:
                //Tim kiem theo id phong ban
                id = Integer.parseInt(condition);
                //System.out.println("NHAN VIEN Co ID CHI NHANH: " + condition);
                query.append(" WHERE NhanVien.id_chi_nhanh = ");
                query.append(id); 
                break;
            case 8:
                //In ra tat ca nhan vien
                break;
            default:
                System.out.println("KHONG CO LUA CHON CAN TIM !");
                break;
        }
        
        PreparedStatement sta = c.prepareStatement(query.toString());
        ResultSet rs  = sta.executeQuery();
        if(rs.next()) {
            System.out.println("ID | TEN NHAN VIEN | NGAYSINH");
            while(rs.next()) {
                System.out.println(rs.getInt("ID_Nhanvien") + " | " + rs.getString("ten") + " | " + rs.getDate("birth"));
            }
        }
        else System.out.println("KHONG CO THONG TIN PHU HOP VOI DU LIEU BAN NHAP!");
    }
    
    public void updateNV(String condition, int choice, int id) throws SQLException {
        
        Connection c = SQLconn();
        StringBuilder query = new StringBuilder();
        int idc;
        
        query.append("UPDATE NhanVien ");
       
        switch(choice) {
            case 1:
                //Doi ten nhan vien
                query.append(" SET ten = '");
                query.append(condition).append("'");
                break;
            case 2:
                //Doi ngay sinh nhan vien
                query.append(" SET birth = '");
                query.append(condition).append("'");
                break;
            case 3:
                //Doi phong ban cua nhanh vien
                idc = Integer.valueOf(condition);
                query.append(" SET id_phong_ban = ");
                query.append(idc);
                break;
            case 4:
                //Doi chi nhanh cua nhan vien
                idc = Integer.valueOf(condition);
                query.append(" SET id_chi_nhanh = ");
                query.append(idc);
                break;
            default:
                System.out.println("KHONG CO LUA CHON CAN TIM!");
                break;
        }
        query.append(" WHERE ID_Nhanvien = ");
        query.append(id);
        
        PreparedStatement sta = c.prepareStatement(query.toString());
        sta.executeUpdate();
        
        c.close();
        sta.close();
    }
    
    public void deleteNV(int id /*int choice*/) throws SQLException {
        
        //Xoa nhan vien bang id(theo 1 phong ban hoac 1 chi nhanh tu searchNV)
        Connection c = SQLconn();
        StringBuilder query = new StringBuilder();
        int idc;
        
        query.append("DELETE FROM NhanVien ");
        query.append(" WHERE ID_Nhanvien = ");
        query.append(id);
        
        PreparedStatement sta = c.prepareStatement(query.toString());
        sta.executeUpdate();
        
        c.close();
        sta.close();
    }
   
    public int checkCN(int id) throws SQLException {
        
        int idexist  = 1;
        Connection c = SQLconn();
        StringBuilder query = new StringBuilder();
        
        query.append("SELECT *");
        query.append("FROM ChiNhanh");
        query.append(" WHERE ID_ChiNhanh = ?");
        
        PreparedStatement sta = c.prepareStatement(query.toString());
        sta.setInt(1, id); //(thu tu cua bien, bien)
        ResultSet rs  = sta.executeQuery();
        
        int idcheck;
        if(rs.next()) { //van con du lieu trong database de truy van
            idcheck = rs.getInt("ID_ChiNhanh");
            if(idcheck == id) {
                idexist = 0;
                System.out.println("ID da ton tai !");
            }
        }
        return idexist;
    }    
    
    public void allCN() throws SQLException {
        
        Connection c = SQLconn();
        StringBuilder query = new StringBuilder();
        
        query.append("SELECT *");
        query.append("FROM ChiNhanh");
        
        PreparedStatement sta = c.prepareStatement(query.toString());
        ResultSet rs  = sta.executeQuery();
        while(rs.next()) {
            System.out.println(rs.getInt("ID_ChiNhanh") + " | " + rs.getString("Ten_ChiNhanh"));
        }
    }
    public void insertCN(ChiNhanh cn) throws SQLException {
        
        Connection c = SQLconn();
        StringBuilder query = new StringBuilder();
        
        query.append("INSERT INTO ChiNhanh(ID_ChiNhanh,Ten_ChiNhanh)");
        query.append("VALUES (").append(cn.getID_ChiNhanh()).append(",'").append(cn.getTen_ChiNhanh()).append("')");
        
        PreparedStatement sta = c.prepareStatement(query.toString());
        sta.executeUpdate();
        
        c.close();
        sta.close();
    }
    
    public void insertPB(PhongBan pb) throws SQLException {
        
        Connection c = SQLconn();
        StringBuilder query = new StringBuilder();
        
        query.append("INSERT INTO PhongBan(ID_PhongBan,Ten_PhongBan)");
        query.append("VALUES (").append(pb.getID_PhongBan()).append(",'").append(pb.getTen_PhongBan()).append("')");
        
        // insert, update, delete su dung executeUpdate()
        PreparedStatement sta = c.prepareStatement(query.toString());
        sta.executeUpdate();
        
        c.close();
        sta.close();
    }
    
    public int checkPB(int id) throws SQLException {
        
        int idexist  = 1;
        Connection c = SQLconn();
        StringBuilder query = new StringBuilder();
        
        query.append("SELECT *");
        query.append("FROM PhongBan");
        query.append(" WHERE ID_PhongBan = ?");
        
        PreparedStatement sta = c.prepareStatement(query.toString());
        sta.setInt(1, id); //(thu tu cua bien, bien)
        ResultSet rs  = sta.executeQuery();
        
        int idcheck;
        if(rs.next()) { //van con du lieu trong database de truy van
            idcheck = rs.getInt("ID_PhongBan");
            if(idcheck == id) {
                idexist = 0;
                System.out.println("ID da ton tai !");
            }
        }
        return idexist;
    }
    
    public void allPB() throws SQLException {
        
        Connection c = SQLconn();
        StringBuilder query = new StringBuilder();
        
        query.append("SELECT *");
        query.append("FROM PhongBan");
        
        PreparedStatement sta = c.prepareStatement(query.toString());
        ResultSet rs  = sta.executeQuery();
        while(rs.next()) {
            System.out.println(rs.getInt("ID_PhongBan") + " | " + rs.getString("Ten_PhongBan"));
        }
    }
    
    
    
    
}
