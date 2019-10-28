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
public class CongTy implements CauTrucCongTy {
    
    private static Connection SQLconn() throws SQLException {
        
        Connection conn = null;
       
        StringBuilder URL = new StringBuilder();
        URL.append("jdbc:sqlserver://DESKTOP-MG5DSO1:1433;databaseName=QuanLyNhanSu;");
        URL.append("user=").append("sa").append(";");
        URL.append("password=").append("sa").append(";");
        conn = DriverManager.getConnection(URL.toString());
        
        return conn;
    }
    
    @Override
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
        
        if(rs.next()) { //van con du lieu trong database de truy van
            idexist = 0;
            //System.out.println("ID da ton tai !");
        }
        return idexist;
    }
    @Override
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
        query.append("FROM NhanVien, PhongBan, ChiNhanh ");
        query.append(" WHERE NhanVien.id_phong_ban = PhongBan.ID_PhongBan AND NhanVien.id_chi_nhanh = ChiNhanh.ID_ChiNhanh ");
        
        switch (choice) {
            case 1:
                // Tim kiem theo ID_Nhanvien
                id = Integer.parseInt(condition);
                query.append(" AND ID_Nhanvien = ");
                query.append(id);
                break;
            case 2:
                //Tim kiem theo ten nhan vien
                query.append(" AND ten = '");
                query.append(condition).append("'"); 
                break;
            case 3:
                //Tim kiem theo ngay sinh
                query.append(" AND birth = '");
                query.append(condition).append("'"); 
                break;
            case 4:
                //Tim kiem theo ten phong ban
                query.append(" AND Ten_PhongBan = '");
                query.append(condition).append("'"); 
                break;
            case 5:
                //Tim kiem theo id phong ban
                id = Integer.parseInt(condition);
                query.append(" AND NhanVien.id_phong_ban = ");
                query.append(id);
                break;
            case 6:
                //Tim Kiem theo ten chi nhanh
                query.append(" AND Ten_ChiNhanh = '");
                query.append(condition).append("'");
                break;
            case 7:
                //Tim kiem theo id phong ban
                id = Integer.parseInt(condition);
                query.append(" AND NhanVien.id_chi_nhanh = ");
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
            System.out.println("ID | TEN NHAN VIEN | NGAYSINH | PHONG BAN | CHI NHANH");
            do {
                System.out.println(rs.getInt("ID_Nhanvien") + " | " + rs.getString("ten") + " | " + rs.getDate("birth") + " | " + rs.getString("Ten_PhongBan") + " | " + rs.getString("Ten_ChiNhanh"));
            } while(rs.next());
        }
        else System.out.println("KHONG CO THONG TIN PHU HOP VOI DU LIEU BAN NHAP!");
    }
    
    @Override
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
    
    @Override
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
   
    @Override
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
        
        if(rs.next()) { //van con du lieu trong database de truy van
            idexist = 0;
            //System.out.println("ID da ton tai !");
        }
        return idexist;
    }    
    
    @Override
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
    @Override
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
    
    @Override
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
    
    @Override
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
        
        if(rs.next()) { //van con du lieu trong database de truy van
            idexist = 0;
            //System.out.println("ID da ton tai !");
        }
        return idexist;
    }
    
    @Override
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
    
    @Override
    public void ChangeInfoChiNhanh(int ID,String Ten_CN) throws SQLException{
        // update ChiNhanh set Ten_ChiNhanh = 'Tan Phu' where ID_ChiNhanh = 1;
        Connection c = SQLconn();
        StringBuilder query = new StringBuilder();
        query.append("UPDATE ChiNhanh ");
        query.append("SET "
                + "Ten_ChiNhanh = '").append(Ten_CN).append("'");
        query.append(" WHERE ChiNhanh.ID_ChiNhanh=").append(String.valueOf(ID));
        PreparedStatement Sta = c.prepareStatement(query.toString());
        Sta.execute();
        System.out.println("Change successfully");
    }
    @Override
    public void ChangeInfoPhongBan(int ID,String Ten_PB) throws SQLException{
        // update ChiNhanh set Ten_ChiNhanh = 'Tan Phu' where ID_ChiNhanh = 1;
        Connection c = SQLconn();
        StringBuilder query = new StringBuilder();
        query.append("UPDATE PhongBan ");
        query.append("SET "
                + "Ten_PhongBan = '").append(Ten_PB).append("'");
        query.append(" WHERE PhongBan.ID_PhongBan = ").append(String.valueOf(ID));
        PreparedStatement Sta = c.prepareStatement(query.toString());
        Sta.execute();
        System.out.println("Change successfully");
    }
    @Override
    public void QueryFindChiNhanhByTen(String Ten_CN )throws SQLException{
        Connection c =  SQLconn();
        StringBuilder query = new StringBuilder();
        query.append("SELECT * ");
        query.append("FROM ChiNhanh ");
        query.append("WHERE Ten_ChiNhanh = '").append(Ten_CN).append("' ");
        PreparedStatement Sta = c.prepareStatement(query.toString());
        ResultSet rs = Sta.executeQuery();
        if(rs.next()){
            System.out.println("ID chi nhanh: "+rs.getInt(1)+"\nTen chi nhanh: "+rs.getString(2));
        }
        else{
            System.out.println("Khong co chi nhanh nay");
        }
        Sta.close();
        rs.close();
    }
    @Override
    public void QueryFindChiNhanhByID(int ID_ChiNhanh )throws SQLException{
        Connection c =  SQLconn();
        StringBuilder query = new StringBuilder();
        query.append("SELECT * ");
        query.append("FROM ChiNhanh ");
        query.append("WHERE ID_ChiNhanh = ").append(ID_ChiNhanh);
        PreparedStatement Sta = c.prepareStatement(query.toString());
        ResultSet rs = Sta.executeQuery();
        if(rs.next()){
            System.out.println("ID chi nhanh: "+rs.getInt(1)+"\nTen chi nhanh: "+rs.getString(2));
        }
        else{
            System.out.println("Khong co chi nhanh nay");
        }
        Sta.close();
        rs.close();
    }
    @Override
    public void QueryFindPhongBanByTen(String Ten_PB) throws SQLException{
        Connection c =  SQLconn();
        StringBuilder query = new StringBuilder();
        query.append("SELECT * ");
        query.append("FROM PhongBan ");
        query.append("WHERE Ten_PhongBan = '").append(Ten_PB).append("' ");
        PreparedStatement Sta = c.prepareStatement(query.toString());
        ResultSet rs = Sta.executeQuery();
        if(rs.next()){
            System.out.println("ID phong ban: "+rs.getInt(1)+"\nTen phong ban: "+rs.getString(2));
        }
        else{
            System.out.println("Khong co phong ban nay");
        }
        Sta.close();
        rs.close();
    }
    @Override
    public void QueryFindPhongBanByID(int ID_PB)throws SQLException{
        Connection c =  SQLconn();
        StringBuilder query = new StringBuilder();
        query.append("SELECT * ");
        query.append("FROM PhongBan ");
        query.append("WHERE ID_PhongBan = ").append(ID_PB);
        PreparedStatement Sta = c.prepareStatement(query.toString());
        ResultSet rs = Sta.executeQuery();
        if(rs.next()){
            System.out.println("ID phong ban: "+rs.getInt(1)+"\nTen phong ban: "+rs.getString(2));
        }
        else{
            System.out.println("Khong co phong ban nay");
        }
        Sta.close();
        rs.close();
    }
    
    @Override
    public void DelChiNhanh(int ID) throws SQLException{
        try{
            Connection c = SQLconn();
            StringBuilder query = new StringBuilder();
            query.append("DELETE FROM ChiNhanh WHERE ").append("ChiNhanh.ID_ChiNhanh = ").append(String.valueOf(ID));
            PreparedStatement sta = c.prepareStatement(query.toString());
            sta.execute();
            System.out.println("Delete Successfully");
        }
        catch(Exception e){
            System.out.println("Co nhan vien o chi nhanh khong the xoa duoc");
        }
    }
    @Override
    public void DelPhongBan(int ID) throws SQLException{
        try{
            Connection c = SQLconn();
            StringBuilder query = new StringBuilder();
            query.append("DELETE FROM PhongBan WHERE ").append("PhongBan.ID_ChiNhanh = ").append(String.valueOf(ID));
            PreparedStatement sta = c.prepareStatement(query.toString());
            sta.execute();
            System.out.println("Delete Successfully");
        }
        catch(Exception e){
            System.out.println("Co nhan vien o phong ban khong the xoa");
        }
    }
    
}
