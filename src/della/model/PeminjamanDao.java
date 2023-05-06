/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package della.model;
import java.util.List;
/**
 *
 * @author Windows 10 Pro
 */
public interface PeminjamanDao {
    void save(Peminjaman peminjaman);
    void update(int index, Peminjaman peminjaman);
    void delete(int index);
    Peminjaman getPeminjaman(int index);
    List<Peminjaman> getAll();
}
