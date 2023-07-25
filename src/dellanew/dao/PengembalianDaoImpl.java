/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dellanew.dao;
import com.mysql.cj.xdevapi.PreparableStatement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import dellanew.model.*;
/**
 *
 * @author Windows 10 Pro
 */
public class PengembalianDaoImpl implements PengembalianDao {
    
    private Connection connection;
    private AnggotaDao anggotaDao;
    private BukuDao bukuDao;
    private PeminjamanDao peminjamanDao;
    
    public PengembalianDaoImpl(Connection connection){
        this.connection = connection;
        anggotaDao = new AnggotaDaoImpl(connection);
        bukuDao = new BukuDaoImpl(connection);
        peminjamanDao = new PeminjamanDaoImpl(connection);
    }
    
    public void insert(Pengembalian pengembalian) throws Exception{
        String sql = "INSERT INTO pengembalian VALUES(?,?,?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, pengembalian.getAnggota().getKodeanggota());
        ps.setString(2, pengembalian.getBuku().getKodebuku());
        ps.setString(3, pengembalian.getPeminjaman().getTglPinjam());
        ps.setString(4, pengembalian.getTgldikembalikan());
        ps.setInt(5, pengembalian.getTerlambat());
        ps.setDouble(6, pengembalian.getDenda());
        ps.executeUpdate();
    }
    
    public void update(Pengembalian pengembalian) throws Exception{
        String sql = "UPDATE pengembalian SET tanggaldikembalikan "
                + "WHERE kodeanggota=? AND kodebuku=? AND tanggalpinjam=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, pengembalian.getTgldikembalikan());
        ps.setString(2, pengembalian.getAnggota().getKodeanggota());
        ps.setString(3, pengembalian.getBuku().getKodebuku());
        ps.setString(4, pengembalian.getPeminjaman().getTglPinjam());
        ps.executeUpdate();
    }
    
    public void delete(Pengembalian pengembalian) throws Exception{
        String sql = "DELETE FROM peminjaman "
                + "WHERE kodeanggota=? AND kodebuku=? AND tanggalpinjam=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, pengembalian.getAnggota().getKodeanggota());
        ps.setString(2, pengembalian.getBuku().getKodebuku());
        ps.setString(3, pengembalian.getPeminjaman().getTglPinjam());
        ps.executeUpdate();
    }
    
    public Pengembalian getPengembalian(String kodeanggota, String kodebuku, String tglpinjam) throws Exception{
        String sql = "SELECT * FROM pengembalian "
                + "WHERE kodeanggota=? AND kodebuku=? AND tanggalpinjam=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, kodeanggota);
        ps.setString(2, kodebuku);
        ps.setString(3, tglpinjam);
        ResultSet rs = ps.executeQuery();
        Pengembalian pengembalian = null;
        if(rs.next()){
            pengembalian = new Pengembalian();
            Anggota anggota = anggotaDao.getAnggota(kodeanggota);
            pengembalian.setAnggota(anggota);
            
            Buku buku = bukuDao.getBuku(kodebuku);
            pengembalian.setBuku(buku);
            
            Peminjaman peminjaman = peminjamanDao.getPeminjaman(kodeanggota, kodebuku, tglpinjam);
            pengembalian.setPeminjaman(peminjaman);
            
            pengembalian.setTgldikembalikan(rs.getString("tanggaldikembalikan"));
            pengembalian.setTerlambat(rs.getInt("terlambat"));
            pengembalian.setDenda(rs.getInt("denda"));
            
        }
        return pengembalian;
    }
    
    public int terlambat(String tgl1, String tgl2) throws Exception{
        int selisih=0;
        String sql = "SELECT DATEDIFF(?, ?) AS selisih";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, tgl1);
        ps.setString(2, tgl2);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            selisih = rs.getInt(1);
        }
        return selisih;
    }
    
    public List<Pengembalian> getAll() throws Exception{
        String sql = "SELECT 'anggota'.'kodeanggota', 'anggota'.'namaanggota', 'buku'.'kodebuku', 'buku'.'judulbuku' "
                + "'peminjaman'.'tglpinjam', 'peminjaman'.'tglkembali', 'pengembalian'.'tgldikembalikan', "
                + "'pengembalian'.'terlambat', 'pengembalian'.'denda' "
                + "FROM 'peminjaman' INNER JOIN 'anggota' ON 'peminjaman'.'kodeanggota' = 'anggota'.'kodeanggota' "
                + "INNER JOIN 'buku' ON 'peminjaman'.'kodebuku' = 'buku'.'kodebuku' "
                + "LEFT JOIN 'pengembalian' ON ('peminjaman'.'kodeanggota' = 'pengembalian'.'kodeanggota' "
                + "AND  'peminjaman'.'kodebuku' = 'pengembalian'.'kodebuku' "
                + "AND 'peminjaman'.'tglpinjam' = 'pengembalian'.'tglpinjam') ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        Pengembalian pengembalian = null;
        List<Pengembalian> list = new ArrayList<>();
        while(rs.next()){
            pengembalian = new Pengembalian();
            pengembalian.setAnggota(anggotaDao.getAnggota(rs.getString("kodeanggota")));
            pengembalian.setBuku(bukuDao.getBuku(rs.getString("kodebuku")));
            pengembalian.setPeminjaman(peminjamanDao.getPeminjaman(
                    (rs.getString("kodeanggota")),
                    (rs.getString("kodebuku")),
                    (rs.getString("tglpinjam"))));
            pengembalian.setTgldikembalikan(rs.getString("tgldikembalikan"));
            pengembalian.setTerlambat(rs.getInt("terlambat"));
            pengembalian.setDenda(rs.getDouble("denda"));
            list.add(pengembalian);
        }
        return list;
    }
    
}
