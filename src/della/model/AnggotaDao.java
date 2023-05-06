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
public interface AnggotaDao {
    void save(Anggota anggota);
    void update(int index, Anggota anggota);
    void delete(int index);
    Anggota getAnggota(int index);
    List<Anggota> getAll();
}


