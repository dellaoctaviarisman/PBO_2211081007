/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.b.controller;
import uts.b.view.FormPegawai;
import uts.b.model.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Windows 10 Pro
 */
public class Pegawaicontroller {
    private FormPegawai formPegawai;
    private PegawaiDao pegawaiDao;
    private Pegawai pegawai;
    
    public Pegawaicontroller(FormPegawai formPegawai){
        this.formPegawai = formPegawai;
        pegawaiDao = new pegawaiDaoImpl();
}
