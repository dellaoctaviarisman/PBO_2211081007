/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dellanew.dao;

import dellanew.model.Anggota;
import java.sql.*; 
import java.util.List;

/**
 *
 * @author LAB-MM
 */
public class AnggotaDaoImpl implements AnggotaDao{
    private Connection connection;
    
    public AnggotaDaoImpl(Connection connection) {
        this.connection = connection;
    }
    
   public void insert (Anggota anggota) throws Exception {
       String sql = "insert into anggota values(?,?,?,?)";
       PreparedStatement ps = connection.prepareStatement(sql);
       ps.setString(1, anggota.getKodeanggota());
       ps.setString(2, anggota.getNamaanggota());
       ps.setString(3, anggota.getAlamat());
       ps.setString(4, anggota.getJeniskelamin());
       ps.executeUpdate();
       ps.close();
   }

    @Override
    public void update(Anggota anggota) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Anggota anggota) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Anggota getAnggota(String kodeanggota) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Anggota> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
