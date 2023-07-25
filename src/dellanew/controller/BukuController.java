/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dellanew.controller;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import dellanew.dao.*;
import dellanew.db.DbHelper;
import dellanew.model.Buku;
import dellanew.view.FormBuku;
/**
 *
 * @author Windows 10 Pro
 */
public class BukuController {
        FormBuku view;
    Buku buku;
    BukuDao dao;
    Connection connection;
    
    public BukuController(FormBuku view){
        try {
            this.view = view;
            connection = DbHelper.getConnection();
            dao = new BukuDaoImpl(connection);
        } catch (SQLException ex) {
            Logger.getLogger(BukuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void clearForm(){
        view.getTxtKodeBuku().setText("");
        view.getTxtJudulBuku().setText("");
        view.getTxtPengarang().setText("");
        view.getTxtPenerbit().setText("");
    }
    
    public void tampil(){
        try {
            DefaultTableModel tabelModel = (DefaultTableModel)
                    view.getTblBuku().getModel();
            tabelModel.setRowCount(0);
            List<Buku> list = dao.getAll();
            for(Buku a : list){
                Object[] row = {
                    a.getKodebuku(),
                    a.getJudulbuku(),
                    a.getPengarang(),
                    a.getPenerbit()
                };
                tabelModel.addRow(row);
            }
        } catch (Exception ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insert(){
        try {
            buku = new Buku();
            buku.setKodebuku(view.getTxtKodeBuku().getText());
            buku.setJudulbuku(view.getTxtJudulBuku().getText());
            buku.setPengarang(view.getTxtPengarang().getText());
            buku.setPenerbit(view.getTxtPenerbit().getText());
            dao.insert(buku);
            JOptionPane.showMessageDialog(view, "Entri data Ok");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage());
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update(){
        try {
            buku.setKodebuku(view.getTxtKodeBuku().getText());
            buku.setJudulbuku(view.getTxtJudulBuku().getText());
            buku.setPengarang(view.getTxtPengarang().getText());
            buku.setPenerbit(view.getTxtPenerbit().getText());
            dao.update(buku);
            JOptionPane.showMessageDialog(view, "Update data Ok");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage());
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(){
        try {
            dao.delete(buku);
            JOptionPane.showMessageDialog(view, "Delete Data OK");
        } catch (Exception ex) {
            Logger.getLogger(BukuController.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    
    public void tabelKlik(){ //untuk mengisi textfield otomatis sesuai data yang di klik di tabel
        try {
            String kodebuku = view.getTblBuku()
                    .getValueAt(view.getTblBuku().getSelectedRow(), 0).toString();
            buku = dao.getBuku(kodebuku);
            view.getTxtKodeBuku().setText(buku.getKodebuku());
            view.getTxtJudulBuku().setText(buku.getJudulbuku());
            view.getTxtPengarang().setText(buku.getPengarang());
            view.getTxtPenerbit().setText(buku.getPenerbit());
        } catch (Exception ex) {
            Logger.getLogger(AnggotaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
