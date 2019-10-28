/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managment;

import Data.ChiNhanh;
import Data.NhanVien;
import Data.PhongBan;
import java.sql.SQLException;

/**
 *
 * @author gywreb
 */
public interface CauTrucCongTy {
    public int checkNV(int id) throws SQLException;
    public void insertNV(NhanVien nv) throws SQLException;
    public void updateNV(String condition, int choice, int id) throws SQLException;
    public void deleteNV(int id /*int choice*/) throws SQLException;
    public int checkCN(int id) throws SQLException;
    public void allCN() throws SQLException;
    public void insertCN(ChiNhanh cn) throws SQLException;
    public void insertPB(PhongBan pb) throws SQLException;
    public int checkPB(int id) throws SQLException;
    public void allPB() throws SQLException;
    public void ChangeInfoChiNhanh(int ID,String Ten_CN) throws SQLException;
    public void ChangeInfoPhongBan(int ID,String Ten_PB) throws SQLException;
    public void QueryFindChiNhanhByTen(String Ten_CN )throws SQLException;
    public void QueryFindChiNhanhByID(int ID_ChiNhanh )throws SQLException;
    public void QueryFindPhongBanByTen(String Ten_PB) throws SQLException;
    public void QueryFindPhongBanByID(int ID_PB)throws SQLException;
    public void DelChiNhanh(int ID) throws SQLException;
    public void DelPhongBan(int ID) throws SQLException;
}
