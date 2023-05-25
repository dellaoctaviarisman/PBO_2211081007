/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.b.model;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Windows 10 Pro
 */

public class PegawaiDaoImpl implements PegawaiDao {
    List<Pegawai> data = new ArrayList<>();
    
    public PegawaiDaoImpl() {
        data.add(new Pegawai("1111", "Ali", "Batu Sangkar"));
        data.add(new Pegawai("1112", "Della", "Padang"));
        data.add(new Pegawai("1113", "Dinda", "Sijunjung"));
    }
    
    public void save(Pegawai pegawai){
        data.add(pegawai);
    }
    
    public void update(int index, Pegawai pegawai){
        data.set(index, pegawai);
    }
    
    public void delete(int index){
        data.remove(index);
    }
    
    public Pegawai getPegawai(int index){
        return data.get(index);
    }
    
    public List<Pegawai> getAll(){
        return data;
    }
    
}
