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
import Ultility.ValidData;
import java.sql.SQLException;
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
        Menu menu = new Menu();
        ValidData kiemtra = new ValidData();
        NhanVien nv;
        PhongBan pb;
        ChiNhanh cn;
    
        int chon; 
        String lua;
        int kt = 1;
        String condition = null, ids;
        int id, choice = 0;
        Scanner doc = new Scanner(System.in);  

        do{  
            chon = menu.Form();
            if(chon <= 14) {
                switch(chon){ 
                    case 1:
                        nv = menu.nhapNV();
                        System.out.println("Luu Nhan Vien ?(y/n)");
                        lua = doc.nextLine();
                        if (lua.equals("y") || lua.equals("Y"))
                            KiemDuyet.insertNV(nv);
                        break;
                    case 2:
                        cn = menu.nhapCN();
                        System.out.println("Luu Chi Nhanh ?(y/n)");
                        lua = doc.nextLine();
                        if (lua.equals("y") || lua.equals("Y"))
                            KiemDuyet.insertCN(cn);
                        break;
                    case 3:
                        pb = menu.nhapPB();
                        System.out.println("Luu Phong Ban ?(y/n)");
                        lua = doc.nextLine();
                        if (lua.equals("y") || lua.equals("Y"))
                            KiemDuyet.insertPB(pb);
                        break;
                    case 7:
                        do {
                            System.out.println("Nhap ten chi nhanh: ");
                            condition = kiemtra.validString(doc.nextLine());
                            if(condition.length() == 0) {
                                System.out.println("CHUA NHAP TEN ");
                                kt = 0;
                            }
                        }while (kt == 0);
                        System.out.println(condition);
                        KiemDuyet.QueryFindChiNhanhByTen(condition);
                        doc.nextLine();
                        break;
                    case 8:
                        do {
                            System.out.println("Nhap id chi nhanh: ");
                            ids = doc.nextLine();
                            if(!kiemtra.isInteger(ids)) {
                                System.out.println("NHAP ID LA SO!");
                                kt = 0;
                            }
                        }while (kt == 0);
                        id = Integer.parseInt(ids);
                        KiemDuyet.QueryFindChiNhanhByID(id);
                        doc.nextLine();
                        break;
                    case 9:
                        do {
                            System.out.println("Nhap ten phong ban: ");
                            condition = kiemtra.validString(doc.nextLine());
                            if(condition.length() == 0) {
                                System.out.println("CHUA NHAP TEN ");
                                kt = 0;
                            }
                        }while (kt == 0);
                        KiemDuyet.QueryFindPhongBanByTen(condition);
                        doc.nextLine();
                        break;
                    case 10:
                        do {
                            System.out.println("Nhap id phong ban: ");
                            ids = doc.nextLine();
                            if(!kiemtra.isInteger(ids)) {
                                System.out.println("NHAP ID LA SO!");
                                kt = 0;
                            }
                        }while (kt == 0);
                        id = Integer.parseInt(ids);
                        KiemDuyet.QueryFindPhongBanByID(id);
                        doc.nextLine();
                        break;
                    case 11:
                        do {
                            KiemDuyet.allCN();
                            System.out.println("Nhap id chi nhanh: ");
                            ids = doc.nextLine();
                            if(!kiemtra.isInteger(ids)) {
                                System.out.println("NHAP ID LA SO!");
                                kt = 0;
                            }
                            else {
                                System.out.println("Ten moi cua chi nhanh: ");
                                condition = kiemtra.validString(doc.nextLine());
                                if(condition.length() == 0) {
                                    System.out.println("CHUA NHAP TEN ");
                                    kt = 0;
                                }
                            }
                        }while (kt == 0);
                        id = Integer.parseInt(ids);
                        System.out.println("Sua Chi Nhanh ?(y/n)");
                        lua = doc.nextLine();
                        if (lua.equals("y") || lua.equals("Y"))
                            KiemDuyet.ChangeInfoChiNhanh(id, condition);
                        break;
                    case 12:
                        do {
                            KiemDuyet.allPB();
                            System.out.println("Nhap id phong ban: ");
                            ids = doc.nextLine();
                            if(!kiemtra.isInteger(ids)) {
                                System.out.println("NHAP ID LA SO!");
                                kt = 0;
                            }
                            else {
                                System.out.println("Ten moi cua phong ban: ");
                                condition = kiemtra.validString(doc.nextLine());
                                if(condition.length() == 0) {
                                    System.out.println("CHUA NHAP TEN ");
                                    kt = 0;
                                }
                            }
                        }while (kt == 0);
                        id = Integer.parseInt(ids);
                        System.out.println("Sua Phong Ban ?(y/n)");
                        lua = doc.nextLine();
                        if (lua.equals("y") || lua.equals("Y"))
                            KiemDuyet.ChangeInfoPhongBan(id, condition);
                        break;
                    case 13:
                        do {
                            KiemDuyet.allCN();
                            System.out.println("Nhap id chi nhanh: ");
                            ids = doc.nextLine();
                            if(!kiemtra.isInteger(ids)) {
                                System.out.println("NHAP ID LA SO!");
                                kt = 0;
                            }
                        }while (kt == 0);
                        id = Integer.parseInt(ids);
                        System.out.println("Xoa Chi Nhanh ?(y/n)");
                        lua = doc.nextLine();
                        if (lua.equals("y") || lua.equals("Y"))
                            KiemDuyet.DelChiNhanh(id);
                        break;
                    case 14:
                        do {
                            KiemDuyet.allPB();
                            System.out.println("Nhap id phong ban: ");
                            ids = doc.nextLine();
                            if(!kiemtra.isInteger(ids)) {
                                System.out.println("NHAP ID LA SO!");
                                kt = 0;
                            }
                        } while (kt == 0);
                        id = Integer.parseInt(ids);
                        System.out.println("Xoa Phong Ban ?(y/n)");
                        lua = doc.nextLine();
                        if (lua.equals("y") || lua.equals("Y"))
                            KiemDuyet.DelPhongBan(id);
                        break;
                    default: chon = 0; break; 
                 }
            }
            if(chon >= 15 && chon <= 22) {
                choice = chon - 14;
                condition = menu.timNV(chon);
                KiemDuyet.searchNV(condition, choice);
                doc.nextLine();
            }
            else if(chon >= 23 && chon <= 26) {
                choice = chon - 22;
                KiemDuyet.searchNV("", 8);
                do {
                    System.out.print("Nhap ID nhan vien muon sua: ");
                    ids = doc.nextLine();
                    if(!kiemtra.isInteger(ids)) {
                        System.out.println("NHAP ID LA SO!");
                        kt = 0;
                    }
                }while(kt  == 0);
                id = Integer.parseInt(ids);
                KiemDuyet.searchNV(ids, 1);
                condition = menu.suaNV(chon);
                System.out.println("Sua nhan vien ?(y/n)");
                lua = doc.nextLine();
                if (lua.equals("y") || lua.equals("Y"))
                    KiemDuyet.updateNV(condition, choice, id);
            }
            
            else if(chon >= 27 && chon <= 28) {
                choice = chon - 26;
                id = menu.xoaNV();
                System.out.println("Xoa nhan vien ?(y/n)");
                lua = doc.nextLine();
                if (lua.equals("y") || lua.equals("Y"))
                    KiemDuyet.deleteNV(id); 
            }
        }while (chon!=0); 
        doc.close();     
        
    }
}

