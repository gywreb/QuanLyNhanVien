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
    
    private static Scanner choice = new Scanner(System.in);
    private static int chon;
    private static CongTy QuanLy = new CongTy();
    
    public static int Form() {
        
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
                break;
                case 5:
                    System.out.println("1. Sua Ten cua nhan vien");
                    System.out.println("2. Sua Ngay sinh cua nhan vien");
                    System.out.println("3. Chuyen nhan vien sang phong ban khac");
                    System.out.println("4. Chuyen nhan vien sang chi nhanh khac");
                    System.out.println("===== HAY CHON SO MUC BAN MUON THUC HIEN =====");
                    
                    chon = Integer.valueOf(choice.nextLine());
                break;
                case 6:
                    System.out.println("1. Chon phong ban co nhan vien muon xoa");
                    System.out.println("2. Chon chi nhanh co nhan vien muon xoa");
                     System.out.println("===== HAY CHON SO MUC BAN MUON THUC HIEN =====");
                    
                    chon = Integer.valueOf(choice.nextLine());
                break;
                default: 
                    chon = 0;
                break;    
            }
        }
        return chon;
    }
    
    public static NhanVien nhapNV() throws SQLException {
        
        int kt;
        int idnv, idpb, idcn;
        Date birth = null;
        String ten;
        do {
            System.out.println("Nhap id nhan vien: ");
            idnv = Integer.valueOf(choice.nextLine());
        }while(QuanLy.checkNV(idnv) == 0);
        System.out.println("Nhap ten: ");
        ten = choice.nextLine();
        System.out.println("Nhap ngay sinh: ");
        do {
            try {
                StringBuilder ngaysinh = new StringBuilder();
                System.out.println("Nhap nam: ");
                ngaysinh.append(Integer.valueOf(choice.nextLine())).append("-");
                System.out.println("Nhap thang: ");
                ngaysinh.append(Integer.valueOf(choice.nextLine())).append("-");
                System.out.println("Nhap ngay: ");
                ngaysinh.append(Integer.valueOf(choice.nextLine()));
                birth = Date.valueOf(ngaysinh.toString());
                kt = 0;
            } catch (IllegalArgumentException e) {
                //e.printStackTrace();
                kt = 1;
            }
        }while (kt == 1);
        do {
            System.out.println("Hay chon phong ban: ");
            QuanLy.allPB();
            idpb = Integer.valueOf(choice.nextLine());

            System.out.println("Hay chon chi nhanh: ");
            QuanLy.allCN();
            idcn = Integer.valueOf(choice.nextLine());

        } while(QuanLy.checkPB(idpb) == 1 || QuanLy.checkCN(idcn) == 1);
        
        NhanVien nhanvien = new NhanVien(idnv,ten,birth,idpb,idcn);
        QuanLy.insertNV(nhanvien);
        
        return nhanvien;
    }
}
