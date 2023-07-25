/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dellanew.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import dellanew.model.*;
import java.sql.*;
/**
 *
 * @author Windows 10 Pro
 */
public class PeminjamanDaoImpl implements PeminjamanDao {
    private Connection connection;
    
    public PeminjamanDaoImpl(Connection connection){
        this.connection = connection;
    }
    
    public void insert(Peminjaman peminjaman) throws SQLException, Exception{
        String sql = "INSERT INTO peminjaman VALUES(?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, peminjaman.getAnggota().getKodeanggota());
        ps.setString(2, peminjaman.getBuku().getKodebuku());
        ps.setString(3, peminjaman.getTglPinjam());
        ps.setString(4, peminjaman.getTglKembali());
        ps.executeUpdate();
    }
    
    public void update(Peminjaman peminjaman) throws SQLException, Exception{
        String sql = "UPDATE peminjaman SET tglkembali=? "
                + "WHERE kodeanggota=? AND kodebuku=? AND tglpinjam=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, peminjaman.getTglKembali());
        ps.setString(2,peminjaman.getAnggota().getKodeanggota());
        ps.setString(3, peminjaman.getBuku().getKodebuku());
        ps.setString(4, peminjaman.getTglPinjam());
        ps.executeUpdate();
    }
    
    public void delete(Peminjaman peminjaman) throws SQLException, Exception{
        String sql = "DELETE FROM peminjaman WHERE kodeanggota=? AND kodebuku=? AND tglpinjam=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, peminjaman.getAnggota().getKodeanggota());
        ps.setString(2, peminjaman.getBuku().getKodebuku());
        ps.setString(3, peminjaman.getTglPinjam());
        ps.executeUpdate();
    }
    
    @Override
    public Peminjaman getPeminjaman(String kodeanggota, String kodebuku, String tglpinjam) throws SQLException, Exception{
        String sql = "SELECT * FROM peminjaman "
                + "WHERE kodeanggota=? AND kodebuku=? AND tglpinjam=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, kodeanggota);
        ps.setString(2, kodebuku);
        ps.setString(3, tglpinjam);
        ResultSet rs = ps.executeQuery();
        Peminjaman peminjaman = null;
        if(rs.next()){
            peminjaman = new Peminjaman();
            //mengambil data kodeanggota
            AnggotaDao daoAnggota = new AnggotaDaoImpl(connection);
            Anggota anggota = daoAnggota.getAnggota(kodeanggota);
            peminjaman.setAnggota(anggota);
            
            //mengambil data kodebuku
            BukuDao daoBuku = new BukuDaoImpl(connection);
            Buku buku = daoBuku.getBuku(kodebuku);
            peminjaman.setBuku(buku);
            
            peminjaman.setTglPinjam(rs.getString(3));
            peminjaman.setTglKembali(rs.getString(4));
        }
        return peminjaman;
    }
    
    public List<Peminjaman> getAll() throws SQLException, Exception{
        String sql = "SELECT * FROM peminjaman";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        Peminjaman peminjaman;
        List<Peminjaman> list = new ArrayList<>();
        while(rs.next()){
            peminjaman = new Peminjaman();
            AnggotaDao daoAnggota = new AnggotaDaoImpl(connection);
            Anggota anggota = daoAnggota.getAnggota(rs.getString(1));
            peminjaman.setAnggota(anggota);
            
            BukuDao daoBuku = new BukuDaoImpl(connection);
            Buku buku = daoBuku.getBuku(rs.getString(2));
            peminjaman.setBuku(buku);
            
            peminjaman.setTglPinjam(rs.getString(3));
            peminjaman.setTglKembali(rs.getString(4));
            list.add(peminjaman); // berfungsi untuk menampilkan data yang diambil, jadi jika tidak pakai ini maka tidak ada data yang tampil
        }
        return list;
    }
    
}
