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
public interface BukuDao {
    void save (Buku buku);
    void update(int index, Buku buku);
    void delete (int index);
    Buku getBuku(int index);
    List <Buku> getAll();
}
