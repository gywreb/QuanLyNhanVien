/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ultility;

import Data.NhanVien;
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
        
        int nhap; 
        
        System.out.println("--------QUAN LY NHAN VIEN--------");
        System.out.print("\n1: Nhap mot nhan vien"); 
        System.out.print("\n2: Nhap mot chi nhanh"); 
        System.out.print("\n3: Nhap mot phong ban"); 
        System.out.print("\n4: Tim thong tin cua nhan vien");
        System.out.print("\n5: Sua thong tin cua nhan vien");
        System.out.print("\n6: Xoa thong tin cua nhan vien\n");
        System.out.println("\n===== HAY CHON SO MUC BAN MUON THUC HIEN =====");
        
        nhap = Integer.valueOf(choice.nextLine());
        if(nhap <= 3)
            chon = nhap;
        else {
            switch(nhap) {
                case 4:
                    System.out.println("1. Tim nhan vien bang ID");
                    System.out.println("2. Tim nhan vien bang Ten");
                    System.out.println("3. Tim nhan vien bang Ngay sinh");
                    System.out.println("4. Tim nhan vien bang Ten Phong Ban");
                    System.out.println("5. Tim nhan vien bang ID Phong Ban");
                    System.out.println("6. Tim nhan vien bang Ten Chi Nhanh");
                    System.out.println("7. Tim nhan vien bang ID Chi Nhanh");
                    System.out.println("8. In ra tat ca nhan vien");
                    System.out.println("===== HAY CHON SO MUC BAN MUON THUC HIEN =====");
                    
                    chon = Integer.valueOf(choice.nextLine());
                    chon += 6;
                    
                break;
                case 5:
                    System.out.println("1. Sua Ten cua nhan vien");
                    System.out.println("2. Sua Ngay sinh cua nhan vien");
                    System.out.println("3. Chuyen nhan vien sang phong ban khac");
                    System.out.println("4. Chuyen nhan vien sang chi nhanh khac");
                    System.out.println("===== HAY CHON SO MUC BAN MUON THUC HIEN =====");
                    
                    chon = Integer.valueOf(choice.nextLine());
                    chon += 14;
                    
                break;
                case 6:
                    System.out.println("1. Chon phong ban co nhan vien muon xoa");
                    System.out.println("2. Chon chi nhanh co nhan vien muon xoa");
                    System.out.println("===== HAY CHON SO MUC BAN MUON THUC HIEN =====");
                    
                    chon = Integer.valueOf(choice.nextLine());
                    chon += 18;
                    
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

        } while(kt == 0);
        
        NhanVien nhanvien = new NhanVien(idnv,ten,birth,idpb,idcn);
        
        return nhanvien;
    }
    
    public String timNV(int chon) throws SQLException {
        int kt = 1, id = 0;//luon dung
        Date birth = null;
        String condition = null;
        switch(chon) { 
            case 7:
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
            case 8:
                System.out.print("\nNhap ten nhan vien: ");
                condition = choice.nextLine();
                break;
            case 9:
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
            case 10:
                QuanLy.allPB();
                System.out.print("\nNhap ten phong ban: ");
                condition = choice.nextLine();
                break;
            case 11:
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
            case 12:
                QuanLy.allCN();
                System.out.print("\nNhap ten chi nhanh: ");
                condition = choice.nextLine();
                break;
            case 13:
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
            case 14:
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
                case 15:
                    System.out.print("\nNhap ten moi cua nhan vien: ");
                    condition = choice.nextLine();
                    break;
                case 16:
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
                case 17:
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
                case 18:
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
}
