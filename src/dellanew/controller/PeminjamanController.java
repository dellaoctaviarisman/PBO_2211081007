/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dellanew.controller;
import dellanew.model.*;
import dellanew.dao.*;
import dellanew.db.DbHelper;
import dellanew.view.FormPeminjaman;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Windows 10 Pro
 */
public class PeminjamanController {
    FormPeminjaman formPeminjaman;
    Peminjaman peminjaman;
    PeminjamanDao peminjamanDao;
    AnggotaDao anggotaDao;
    BukuDao bukuDao;
    
    public PeminjamanController(FormPeminjaman formPeminjaman){
        try {
            this.formPeminjaman = formPeminjaman;
            peminjaman = new Peminjaman();
            peminjamanDao = new PeminjamanDaoImpl(DbHelper.getConnection());
            anggotaDao = new AnggotaDaoImpl(DbHelper.getConnection());
            bukuDao = new BukuDaoImpl(DbHelper.getConnection());
        } catch (SQLException ex) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void clearForm(){
        formPeminjaman.getTxtTglPinjam().setText("");
        formPeminjaman.getTxtTglKembali().setText("");
    }
    
    public void isiComboAnggota(){
        try {
            formPeminjaman.getCboKodeAnggota().removeAllItems();
            List<Anggota> list = anggotaDao.getAll();
            for(Anggota anggota : list){
                formPeminjaman.getCboKodeAnggota()
                        .addItem(anggota.getKodeanggota() + " - " + anggota.getNamaanggota());
            }
        } catch (Exception ex) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void isiComboBuku(){
        try {
            formPeminjaman.getCboKodeBuku().removeAllItems();
            List<Buku> list = bukuDao.getAll();
            for(Buku buku : list){
                formPeminjaman.getCboKodeBuku()
                        .addItem(buku.getKodebuku() + " - " + buku.getJudulbuku());
            }
        } catch (Exception ex) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insert(){
        try {
            //peminjaman = new Peminjaman();
            Anggota anggota = anggotaDao.getAnggota(formPeminjaman.getCboKodeAnggota()
                    .getSelectedItem().toString().split("-")[0]);
            peminjaman.setAnggota(anggota);
            
            Buku buku = bukuDao.getBuku(formPeminjaman.getCboKodeBuku()
                    .getSelectedItem().toString().split("-")[0]);
            peminjaman.setBuku(buku);
            
            peminjaman.setTglPinjam(formPeminjaman.getTxtTglPinjam().getText());
            peminjaman.setTglKembali(formPeminjaman.getTxtTglKembali().getText());
            peminjamanDao.insert(peminjaman);
            JOptionPane.showMessageDialog(formPeminjaman, "Entri OK");
        } catch (Exception ex) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update(){
        try {
            Anggota anggota = anggotaDao.getAnggota(formPeminjaman.getCboKodeAnggota()
                    .getSelectedItem().toString().split("-")[0]);
            peminjaman.setAnggota(anggota);
            Buku buku = bukuDao.getBuku(formPeminjaman.getCboKodeBuku()
                    .getSelectedItem().toString().split("-")[0]);
            peminjaman.setBuku(buku);
            peminjaman.setTglPinjam(formPeminjaman.getTxtTglPinjam().getText());
            peminjaman.setTglKembali(formPeminjaman.getTxtTglKembali().getText());
            peminjamanDao.update(peminjaman);
            JOptionPane.showMessageDialog(formPeminjaman, "Update Data OK");
        } catch (Exception ex) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(){
        try {
            peminjamanDao.delete(peminjaman);
            JOptionPane.showMessageDialog(formPeminjaman, "Delete Data OK");
        } catch (Exception ex) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void getPeminjaman(){ 
        try {
        // untuk mengambil data dari anggota dan peminjaman
        String kodeanggota = formPeminjaman.getTblPeminjaman()
                .getValueAt(formPeminjaman.getTblPeminjaman().getSelectedRow(), 0).toString();
        String kodebuku = formPeminjaman.getTblPeminjaman()
                .getValueAt(formPeminjaman.getTblPeminjaman().getSelectedRow(), 2).toString();
        String tglpinjam = formPeminjaman.getTblPeminjaman()
                .getValueAt(formPeminjaman.getTblPeminjaman().getSelectedRow(), 4).toString();
        
        peminjaman = peminjamanDao.getPeminjaman(kodeanggota, kodebuku, tglpinjam);
        Anggota anggota = anggotaDao.getAnggota(peminjaman.getAnggota().getKodeanggota());
        formPeminjaman.getCboKodeAnggota()
                .setSelectedItem(anggota.getKodeanggota() +" - "+ anggota.getNamaanggota());
        Buku buku = bukuDao.getBuku(peminjaman.getBuku().getKodebuku());
        formPeminjaman.getCboKodeBuku()
                .setSelectedItem(buku.getKodebuku()+ " - " + buku.getJudulbuku());
        formPeminjaman.getTxtTglPinjam().setText(peminjaman.getTglPinjam());
        formPeminjaman.getTxtTglKembali().setText(peminjaman.getTglKembali());
        } catch (Exception ex) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void tampil(){
        try {
            DefaultTableModel tableModel = (DefaultTableModel)
                    formPeminjaman.getTblPeminjaman().getModel();
            tableModel.setRowCount(0);
            List<Peminjaman> list = peminjamanDao.getAll();
            for(Peminjaman p : list){
                Anggota a = anggotaDao.getAnggota(p.getAnggota().getKodeanggota());
                Buku b = bukuDao.getBuku(p.getBuku().getKodebuku());
                Object[] row ={
                    a.getKodeanggota(),
                    a.getNamaanggota(),
                    b.getKodebuku(),
                    b.getJudulbuku(),
                    p.getTglPinjam(),
                    p.getTglKembali()
                };
                tableModel.addRow(row);
            }
        } catch (Exception ex) {
            Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
