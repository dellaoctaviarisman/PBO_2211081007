/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dellanew.dao;
import dellanew.model.Pengembalian;
import java.util.List;
/**
 *
 * @author Windows 10 Pro
 */
public interface PengembalianDao {
        void insert(Pengembalian pengembalian) throws Exception;
    void update(Pengembalian pengembalian) throws Exception;
    void delete(Pengembalian pengembalian) throws Exception;
    Pengembalian getPengembalian(String kodeanggota, String kodebuku, String tglpinjam) throws Exception;
    List<Pengembalian> getAll() throws Exception;
    int terlambat(String tgl1, String tgl2) throws Exception;
}

