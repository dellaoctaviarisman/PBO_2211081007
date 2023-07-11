/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dellanew.controller;
import dellanew.model.Buku;
import dellanew.view.FormBuku;
import dellanew.dao.*;
import dellanew.db.DbHelper;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import javax.swing.text.View;
/**
 *
 * @author Windows 10 Pro
 */
public class BukuController {
        FormBuku view;
    Buku buku;
    BukuDao dao;
    Connection connection; 
    
    public BukuController(FormBuku view) {
        try {
            this.view = view;
            Connection connection = DbHelper.getConnection();
            dao = new BukuDaoImpl(connection);
        } catch (SQLException ex) {
            Logger.getLogger(BukuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void clearForm(){
        view.getTxtjudulbuku().setText(" ");
        view.getTxtkodebuku().setText(" ");
        view.getTxtpengarang().setText(" ");
        view.getTxtpenerbit().setText(" ");
    }
    
    public void tampil(){
        try {
            DefaultTableModel tablemodel = (DefaultTableModel) 
                    view.getTblBuku().getModel();
            tablemodel.setRowCount(0);
            List<Buku> list = dao.getAll();
            for(Buku a: list){
               Object[] row = {
                   a.getJudulBuku(),
                   a.getKodeBuku(),
                   a.getPengarang(),
                   a.getPenerbit()
               };
                tablemodel.addRow(row);
            }
        } catch (Exception ex) {
            Logger.getLogger(BukuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insert(){
        try {
            buku = new Buku();
            buku.setJudulBuku(view.getTxtjudulbuku().getText());
            buku.setKodeBuku(view.getTxtkodebuku().getText());
            buku.setPengarang(view.getTxtpengarang().getText());
            buku.setPenerbit(view.getTxtpenerbit().getText());
            dao.insert(buku);
            JOptionPane.showMessageDialog(view, "Entri Data OK");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage());
            Logger.getLogger(BukuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update(){
        try {
            buku.setJudulBuku(view.getTxtjudulbuku().getText());
            buku.setKodeBuku(view.getTxtkodebuku().getText());
            buku.setPengarang(view.getTxtpengarang().getText());
            buku.setPenerbit(view.getTxtpenerbit().getText());
            dao.update(buku);
            JOptionPane.showMessageDialog(view, "Update Data OK");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage());
            Logger.getLogger(BukuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void delete(){
        try {
            dao.delete(buku);
            JOptionPane.showMessageDialog(view, "Delete Data OK");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, "Delete Data OK");
            Logger.getLogger(BukuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void tabelklik(){
        try {
            String kodebuku = view.getTblBuku().
                    getValueAt(view.getTblBuku().getSelectedRow(), 0).toString();
            buku = dao.getBuku(kodebuku);
            view.getTxtjudulbuku().setText(buku.getJudulBuku());
            view.getTxtkodebuku().setText(buku.getKodeBuku());
            view.getTxtpengarang().setText(buku.getPengarang());
            view.getTxtpenerbit().setText(buku.getPenerbit());
            
        } catch (Exception ex) {
            Logger.getLogger(BukuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
