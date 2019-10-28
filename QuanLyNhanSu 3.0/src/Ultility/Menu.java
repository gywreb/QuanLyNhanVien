/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ultility;

import Data.ChiNhanh;
import Data.NhanVien;
import Data.PhongBan;
import Managment.CongTy;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;
/**
 *
 * @author gywreb
 */
public class Menu {
    
    private  Scanner choice = new Scanner(System.in);
    private int chon;
    private CongTy QuanLy = new CongTy();
    private ValidData test = new ValidData();
    
    public int Form() {
        int kt  = 1;
        String nhap1, chon1; 
        int nhap = 0;
        do {
            System.out.println("--------QUAN LY NHAN VIEN--------");
            System.out.print("\n1: Nhap mot nhan vien"); 
            System.out.print("\n2: Nhap mot chi nhanh"); 
            System.out.print("\n3: Nhap mot phong ban"); 
            System.out.print("\n4: Tim thong tin cua nhan vien");
            System.out.print("\n5: Sua thong tin cua nhan vien");
            System.out.print("\n6: Xoa nhan vien");
            System.out.print("\n7: Tim chi nhanh theo ten");
            System.out.print("\n8: Tim chi nhanh theo id");
            System.out.print("\n9: Tim phong ban theo ten");
            System.out.print("\n10: Tim phong ban theo id");
            System.out.print("\n11: Sua ten cua chi nhanh");
            System.out.print("\n12: Sau ten cua phong ban");
            System.out.print("\n13: Xoa chi nhanh");
            System.out.print("\n14: Xoa phong ban");
            System.out.print("\n *** EXIT(0) ***\n");
            System.out.println("\n===== HAY CHON SO MUC BAN MUON THUC HIEN =====");
            nhap1 = choice.nextLine();
            if(!test.isInteger(nhap1)) {
                System.out.println("CHON BANG SO!!");
                kt = 0;
            }
            else {
                nhap = Integer.parseInt(nhap1);
                kt = 1;
            }
        }while (kt == 0);
        
        if(nhap != 4 && nhap != 5 && nhap != 6)
            chon = nhap;
        else {
            switch(nhap) {
                case 4:
                    do {
                        System.out.println("1. Tim nhan vien bang ID");
                        System.out.println("2. Tim nhan vien bang Ten");
                        System.out.println("3. Tim nhan vien bang Ngay sinh");
                        System.out.println("4. Tim nhan vien bang Ten Phong Ban");
                        System.out.println("5. Tim nhan vien bang ID Phong Ban");
                        System.out.println("6. Tim nhan vien bang Ten Chi Nhanh");
                        System.out.println("7. Tim nhan vien bang ID Chi Nhanh");
                        System.out.println("8. In ra tat ca nhan vien");
                        System.out.println("===== HAY CHON SO MUC BAN MUON THUC HIEN =====");

                        chon1 = choice.nextLine();
                        if(!test.isInteger(chon1)) {
                            System.out.println("CHON BANG SO!!");
                            kt = 0;
                        }
                        else {
                            nhap = Integer.parseInt(chon1);
                            kt = 1;
                        }
                    }while(kt == 0);
                    chon = Integer.parseInt(chon1);
                    chon += 14;
                    
                break;
                case 5:
                    do {
                        System.out.println("1. Sua Ten cua nhan vien");
                        System.out.println("2. Sua Ngay sinh cua nhan vien");
                        System.out.println("3. Chuyen nhan vien sang phong ban khac");
                        System.out.println("4. Chuyen nhan vien sang chi nhanh khac");
                        System.out.println("===== HAY CHON SO MUC BAN MUON THUC HIEN =====");

                        chon1 = choice.nextLine();
                        if(!test.isInteger(chon1)) {
                            System.out.println("CHON BANG SO!!");
                            kt = 0;
                        }
                        else {
                            nhap = Integer.parseInt(chon1);
                            kt = 1;
                        }
                    }while(kt == 0);
                    chon = Integer.parseInt(chon1);
                    chon += 22;
                    
                break;
                case 6:
                    do {
                        System.out.println("1. Chon phong ban co nhan vien muon xoa");
                        System.out.println("2. Chon chi nhanh co nhan vien muon xoa");
                        System.out.println("===== HAY CHON SO MUC BAN MUON THUC HIEN =====");
                        chon1 = choice.nextLine();
                        if(!test.isInteger(chon1)) {
                            System.out.println("CHON BANG SO!!");
                            kt = 0;
                        }
                        else {
                            nhap = Integer.parseInt(chon1);
                            kt = 1;
                        }
                    }while(kt == 0);
                    chon = Integer.parseInt(chon1);
                    chon += 26;
                    
                break;
                default: 
                    chon = 0;
                break;    
            }
        }
        return chon;
    }
    
    public NhanVien nhapNV() throws SQLException {
        
        int kt = 1;
        int idnv = 0, idpb = 0, idcn = 0;
        Date birth = null;
        String ten = null;
        do{
            try {
                do {
                    System.out.println("Nhap id nhan vien: ");
                    idnv = Integer.valueOf(choice.nextLine());
                    System.out.println("Hay chon phong ban: ");
                    QuanLy.allPB();
                    idpb = Integer.valueOf(choice.nextLine());
                    System.out.println("Hay chon chi nhanh: ");
                    QuanLy.allCN();
                    idcn = Integer.valueOf(choice.nextLine());
                } while(QuanLy.checkNV(idcn) == 0 || QuanLy.checkCN(idcn) == 1 || QuanLy.checkPB(idcn) == 1);
                
                System.out.println("Nhap ten: ");
                ten = test.validString(choice.nextLine());
                
                System.out.println("Nhap ngay sinh: ");
                StringBuilder ngaysinh = new StringBuilder();
                System.out.println("Nhap nam: ");
                ngaysinh.append(Integer.valueOf(choice.nextLine())).append("-");
                System.out.println("Nhap thang: ");
                ngaysinh.append(Integer.valueOf(choice.nextLine())).append("-");
                System.out.println("Nhap ngay: ");
                ngaysinh.append(Integer.valueOf(choice.nextLine()));
                birth = Date.valueOf(ngaysinh.toString());
            } 
            catch (IllegalArgumentException e) {
                System.out.println("DU LIEU NHAP VAO KHONG HOP LE! MOI NHAP LAI!");
                kt = 0;
            }

        } while(kt == 0 || ten.length() == 0);
        
        NhanVien nhanvien = new NhanVien(idnv,ten,birth,idpb,idcn);
        
        return nhanvien;
    }
    
    public String timNV(int chon) throws SQLException {
        int kt = 1, id = 0;//luon dung
        Date birth = null;
        String condition = null;
        switch(chon) { 
            case 15:
                do {                    
                    System.out.print("\nNhap ID: ");
                    condition  = choice.nextLine();
                    if(!test.isInteger(condition)) {
                        System.out.println("NHAP SAI KIEU DU LIEU! HAY NHAP SO!");
                        kt = 0;
                    }
                    else kt = 1;
                } while (kt == 0);
                break;
            case 16:
                System.out.print("\nNhap ten nhan vien: ");
                condition = choice.nextLine();
                break;
            case 17:
                do  {
                    try {
                        StringBuilder ngaysinh = new StringBuilder();
                        System.out.println("Nhap ngay sinh nhan vien: ");
                        System.out.println("Nhap nam: ");
                        ngaysinh.append(Integer.valueOf(choice.nextLine())).append("-");
                        System.out.println("Nhap thang: ");
                        ngaysinh.append(Integer.valueOf(choice.nextLine())).append("-");
                        System.out.println("Nhap ngay: ");
                        ngaysinh.append(Integer.valueOf(choice.nextLine()));
                        birth = Date.valueOf(ngaysinh.toString());
                        condition = ngaysinh.toString();
                    } catch (Exception e) {
                        System.out.println("DU LIEU NHAP SAI! HAY NHAP LAI!");
                        kt = 0;
                    }
                } while (kt == 0);
                break;
            case 18:
                QuanLy.allPB();
                System.out.print("\nNhap ten phong ban: ");
                condition = choice.nextLine();
                break;
            case 19:
                do {
                    QuanLy.allPB();
                    System.out.print("\nNhap id phong ban: ");
                    condition = choice.nextLine();
                    if(!test.isInteger(condition)) {
                        System.out.println("NHAP SAI KIEU DU LIEU! HAY NHAP SO!");
                        kt = 0;
                     }
                    else kt = 1;
                } while (kt == 0);
                break;
            case 20:
                QuanLy.allCN();
                System.out.print("\nNhap ten chi nhanh: ");
                condition = choice.nextLine();
                break;
            case 21:
                do {
                    QuanLy.allCN();
                    System.out.print("\nNhap id chi nhanh: ");
                    condition = choice.nextLine();
                    if(!test.isInteger(condition)) {
                        System.out.println("NHAP SAI KIEU DU LIEU! HAY NHAP SO!");
                        kt = 0;
                     }
                    else kt = 1;
                }while (kt == 0);
                break;
            case 22:
                System.out.print("\nIn ra tat ca nhan vien: ");
                condition = "";
                break;
            default:
                condition = "";
                break;
       }
       condition = test.validString(condition);
       return condition;
    }
    
    public String suaNV(int chon) throws SQLException {
        int kt = 1; //luon dung
        Date birth = null;
        String condition = null;
            switch(chon) {
                case 23:
                    System.out.print("\nNhap ten moi cua nhan vien: ");
                    condition = choice.nextLine();
                    break;
                case 24:
                    do  {
                        try {
                            StringBuilder ngaysinh = new StringBuilder();
                            System.out.println("Nhap ngay sinh nhan vien: ");
                            System.out.println("Nhap nam: ");
                            ngaysinh.append(Integer.valueOf(choice.nextLine())).append("-");
                            System.out.println("Nhap thang: ");
                            ngaysinh.append(Integer.valueOf(choice.nextLine())).append("-");
                            System.out.println("Nhap ngay: ");
                            ngaysinh.append(Integer.valueOf(choice.nextLine()));
                            birth = Date.valueOf(ngaysinh.toString());
                            condition = ngaysinh.toString();
                        } catch (Exception e) {
                            System.out.println("DU LIEU NHAP SAI! HAY NHAP LAI!");
                            kt = 0;
                        }
                    } while (kt == 0);
                    break;
                case 25:
                    do {
                        do {
                            QuanLy.allPB();
                            System.out.println("Chuyen sang phong ban(ID): ");
                            condition = choice.nextLine();
                            if(!test.isInteger(condition)) {
                                System.out.println("NHAP SAI KIEU DU LIEU! HAY NHAP SO!");
                                kt = 0;
                            }
                            else kt = 1;
                        } while (kt == 0);
                        kt = QuanLy.checkPB(Integer.parseInt(condition));
                        if (kt == 1)
                            System.out.println("KHONG TON TAI ID PHONG BAN NAY! ");
                    } while(kt == 1);
                    break;
                case 26:
                    do {
                        do {
                            QuanLy.allPB();
                            System.out.println("Chuyen sang chi nhanh(ID): ");
                            condition = choice.nextLine();
                            if(!test.isInteger(condition)) {
                                System.out.println("NHAP SAI KIEU DU LIEU! HAY NHAP SO!");
                                kt = 0;
                            }
                            else kt = 1; 
                        } while (kt == 0);
                        kt = QuanLy.checkCN(Integer.parseInt(condition));
                        if (kt == 1)
                            System.out.println("KHONG TON TAI ID CHI NHANH NAY! ");
                    } while(kt == 1);
                    break;
                default:
                    condition = "";
                    break;
            }
       condition = test.validString(condition);
       return condition;
    } 
    
    public int xoaNV() throws SQLException {
        
        String id = null , id1 = null;
        int kt = 1 , idnv = 0;
        switch(chon) {
            case 27:
                do { 
                    QuanLy.allPB();
                    System.out.println("Nhap id phong ban co nhan vien muon xoa: ");
                    id1 = choice.nextLine();
                    if(!test.isInteger(id1)) {
                        System.out.println("NHAP ID LA SO!");
                        kt = 0;
                    }
                    else {
                        QuanLy.searchNV(id1,5);
                        System.out.println("Nhap id nhan vien muon xoa: ");
                        id = choice.nextLine();
                        if(!test.isInteger(id)) {
                            System.out.println("NHAP ID LA SO !");
                            kt  = 0;
                        }
                    }
                } while(kt == 0); 
                break;
             case 28:
                do {
                    QuanLy.allCN();
                    System.out.println("Nhap id chi nhanh co nhan vien muon xoa: ");
                    id1 = choice.nextLine();
                    if(!test.isInteger(id1)) {
                        System.out.println("NHAP ID LA SO!");
                        kt = 0;
                    }
                    else {
                        System.out.println("Nhap id nhan vien muon xoa: ");
                        QuanLy.searchNV(String.valueOf(id1),7);
                        id = choice.nextLine();
                        if(!test.isInteger(id1) || !test.isInteger(id)) {
                            System.out.println("NHAP ID LA SO !");
                            kt  = 0;
                        }
                    }
                } while(kt == 0); 
                break;
             default:
                idnv = 0;
                break;   
        }
        idnv = Integer.parseInt(id);
        return idnv;
    }
    public ChiNhanh nhapCN() throws SQLException {
        int kt = 1; 
        String id = null, tenCN = null;
        do {
            System.out.println("Nhap id chi nhanh: ");
            id = choice.nextLine();
            if(!test.isInteger(id)) {
                System.out.println("NHAP ID LA SO!");
                kt = 0;
            }
            else {
                kt = QuanLy.checkCN(Integer.valueOf(id));
                System.out.println("Nhap ten chi nhanh: ");
                tenCN = test.validString(choice.nextLine());
                if(tenCN.length() == 0) {
                    System.out.println("CHUA NHAP TEN ");
                    kt = 0;
                }
            }
        }while (kt == 0);
        
        ChiNhanh chinhanh = new ChiNhanh(Integer.parseInt(id), tenCN);
        return chinhanh;
    }
    
    public PhongBan nhapPB() throws SQLException {
        int kt = 1; 
        String id = null, tenPB = null;
        do {
            System.out.println("Nhap id phong ban: ");
            id = choice.nextLine();
            if(!test.isInteger(id)) {
                System.out.println("NHAP ID LA SO!");
                kt = 0;
            }
            else {
                kt = QuanLy.checkPB(Integer.valueOf(id));
                System.out.println("Nhap ten phong ban: ");
                tenPB = test.validString(choice.nextLine());
                if(tenPB.length() == 0) {
                    System.out.println("CHUA NHAP TEN");
                    kt = 0;
                }
            }
        }while (kt == 0);
        
        PhongBan phongban = new PhongBan(Integer.parseInt(id), tenPB);
        return phongban;
    }
}
