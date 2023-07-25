/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dellanew.dao;
import java.sql.*;
import java.util.*;
import dellanew.model.Buku;
/**
 *
 * @author Windows 10 Pro
 */
public class BukuDaoImpl implements BukuDao{
    private Connection connection;
    
    public BukuDaoImpl(Connection connection){ //construktor
        this.connection = connection;
    }
    
    public void insert (Buku buku) throws Exception{
        String sql = "INSERT INTO buku VALUES (?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, buku.getKodebuku());
        ps.setString(2, buku.getJudulbuku());
        ps.setString(3, buku.getPengarang());
        ps.setString(4, buku.getPenerbit());
        ps.executeUpdate();
    }
    
    public void update (Buku buku) throws Exception{
        String sql = "UPDATE buku SET judulbuku = ?, pengarang= ?, penerbit= ? "
                + "WHERE kodebuku = ?";
        //parameter index sesuai query yang dibuat
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, buku.getJudulbuku());
        ps.setString(2, buku.getPengarang());
        ps.setString(3, buku.getPenerbit());
        ps.setString(4, buku.getKodebuku());
        ps.executeUpdate();
    }
    
    public void delete (Buku buku) throws Exception{
        String sql = "DELETE FROM buku WHERE kodebuku= ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, buku.getKodebuku());
        ps.executeUpdate();
    }
    
    public Buku getBuku (String kodebuku) throws Exception{
        String sql = "SELECT * FROM buku WHERE kodebuku = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, kodebuku);
        ResultSet rs = ps.executeQuery();
        Buku buku = null;
        if(rs.next()){
            buku = new Buku();
            buku.setKodebuku(rs.getString(1));
            buku.setJudulbuku(rs.getString(2));
            buku.setPengarang(rs.getString(3));
            buku.setPenerbit(rs.getString(4));
        }
        return buku;
    }
    
    public List<Buku> getAll() throws Exception{
        String sql = "SELECT * FROM buku";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        Buku buku;
        List<Buku> list = new ArrayList<>();
        while(rs.next()){
            buku = new Buku(); //menambahkan constructor default di model.Buku
            buku.setKodebuku(rs.getString(1));
            buku.setJudulbuku(rs.getString(2));
            buku.setPengarang(rs.getString(3));
            buku.setPenerbit(rs.getString(4));
            list.add(buku);
        }
        return list;
    }
    
}
