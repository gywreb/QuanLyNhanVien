/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managment;

import Data.ChiNhanh;
import Data.NhanVien;
import Data.PhongBan;
import Ultility.Menu;
import java.sql.SQLException;
import java.sql.Date;
//import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author gywreb
 */
public class QuanLyNhanSu {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args)  throws SQLException {
        
        CongTy KiemDuyet = new CongTy();
        CongTy ds = new CongTy();
        NhanVien nv;
        PhongBan pb;
        ChiNhanh cn;
        Menu menu = new Menu();
        int chon;
        int kt;
        //ds.SQLconn();
        //ds.initDSNV();
        Scanner doc = new Scanner(System.in);  
        String condition;
        int id, choice;
        
        do{  
            chon = menu.Form();
            //doc.nextLine();
            if (chon <= 3) {
                switch(chon){ 
                    case 1:
                        //NhanVien nv = new NhanVien();
                        nv = menu.nhapNV();
                        System.out.println("Luu Nhan Vien ?(y/n)");
                        KiemDuyet.insertNV(nv);
                        break;
                    case 2:
                        cn = new ChiNhanh();
                        do {
                            System.out.println("Nhap id chi nhanh: ");
                            cn.setID_ChiNhanh(Integer.valueOf(doc.nextLine()));
                            kt = ds.checkCN(cn.getID_ChiNhanh());
                        }while (kt == 0);
                        System.out.println("Nhap ten chi nhanh: ");
                        cn.setTen_ChiNhanh(doc.nextLine());

                        ds.insertCN(cn);

                    break;
                    case 3:
                       pb = new PhongBan();
                        do {
                            System.out.println("Nhap id phong ban: ");
                            pb.setID_PhongBan(Integer.valueOf(doc.nextLine()));
                            kt = ds.checkPB(pb.getID_PhongBan());
                        }while (kt == 0);
                        System.out.println("Nhap ten phong ban: ");
                        pb.setTen_PhongBan(doc.nextLine());

                        ds.insertPB(pb);
                    break;
                    default: chon = 0; break; 
                 }
            }
            //System.out.println(chon);
            if(chon >= 7 && chon <= 14) {
                choice = chon - 6;
                condition = menu.timNV(chon);
                KiemDuyet.searchNV(condition, choice);
            }
            else if(chon >= 15 && chon <=18) {
                choice = chon - 14;
                KiemDuyet.searchNV("", 8);
                System.out.print("Nhap ID nhan vien muon sua: ");
                id = Integer.valueOf(doc.nextLine());
                KiemDuyet.searchNV(String.valueOf(id), 1);
                condition = menu.suaNV(chon);
                KiemDuyet.updateNV(condition, choice, id);
            }
        }while (chon!=0); 
        doc.close();
        
        /*Connection c = null;
        try {
            StringBuilder URL = new StringBuilder();
            URL.append("jdbc:sqlserver://DESKTOP-MG5DSO1:1433;databaseName=QuanLyNhanSu;");
            URL.append("user=").append("sa").append(";");
            URL.append("password=").append("sa").append(";");
            c = DriverManager.getConnection(URL.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int choice = 4;
        String condition = "tan phu";
        StringBuilder query = new StringBuilder();
        
        query.append("SELECT *");
        query.append("FROM NhanVien");
        
        switch (choice) {
            case 1:
                // Tim kiem theo ID_Nhanvien
                int id = Integer.parseInt(condition);
                query.append(" WHERE ID_Nhanvien = ");
                query.append(id);
                break;
            case 2:
                //Tim kiem theo ten nhan vien
                query.append(" WHERE ten = '");
                query.append(condition).append("'"); //(thu tu cua bien, bien)
                break;
            case 3:
                //Tim kiem theo ten phong ban
                query.append(",PhongBan");
                query.append(" WHERE NhanVien.id_phong_ban = PhongBan.ID_PhongBan AND Ten_PhongBan = '");
                query.append(condition).append("'"); //(thu tu cua bien, bien)
                break;
            case 4:
                query.append(",ChiNhanh");
                query.append(" WHERE NhanVien.id_chi_nhanh = ChiNhanh.ID_ChiNhanh AND Ten_ChiNhanh = '");
                query.append(condition).append("'"); //(thu tu cua bien, bien)
            default:
                break;
        }
        PreparedStatement sta = c.prepareStatement(query.toString());
        ResultSet rs  = sta.executeQuery();
        while(rs.next()) {
            System.out.println(rs.getInt("ID_Nhanvien") + " | " + rs.getString("ten"));
        }*/
    }
}

