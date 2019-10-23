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
            switch(chon){ 
                case 1:
                    /*nv = new NhanVien();
                    do {
                        System.out.println("Nhap id nhan vien: ");
                        nv.setID_Nhanvien(Integer.valueOf(doc.nextLine()));
                    }while(ds.checkNV(nv.getID_Nhanvien()) == 0);
                    System.out.println("Nhap ten: ");
                    nv.setTen(doc.nextLine());
                    System.out.println("Nhap ngay sinh: ");
                    do {
                        try {
                            StringBuilder ngaysinh = new StringBuilder();
                            System.out.println("Nhap nam: ");
                            ngaysinh.append(Integer.valueOf(doc.nextLine())).append("-");
                            System.out.println("Nhap thang: ");
                            ngaysinh.append(Integer.valueOf(doc.nextLine())).append("-");
                            System.out.println("Nhap ngay: ");
                            ngaysinh.append(Integer.valueOf(doc.nextLine()));
                            Date birthday = Date.valueOf(ngaysinh.toString());
                            nv.setBirth(birthday);
                            kt = 0;
                        } catch (IllegalArgumentException e) {
                            //e.printStackTrace();
                            kt = 1;
                        }
                    }while (kt == 1);
                    do {
                        System.out.println("Hay chon phong ban: ");
                        ds.allPB();
                        nv.setId_phong_ban(Integer.valueOf(doc.nextLine()));
                        
                        System.out.println("Hay chon chi nhanh: ");
                        ds.allCN();
                        nv.setId_chi_nhanh(Integer.valueOf(doc.nextLine()));
                        
                    } while(ds.checkPB(nv.getId_phong_ban()) == 1 || ds.checkCN(nv.getId_chi_nhanh()) == 1);*/
                    nv = Menu.nhapNV();
                    //ds.insertNV(nv);
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
                case 4:
                    ds.searchNV("1999-3-19", 3);
                break;
                case 5:
                    ds.updateNV("1", 3, 2);
                break;
                default: chon = 0; break; 
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

