/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manasik.marketplace;

import java.sql.Date;
import javax.xml.bind.*;
import javax.xml.bind.annotation.*;

/**
 *
 * @author Rotal
 */
@XmlRootElement(name="Catalog_produk")
public class Catalog_data {
    @XmlElement(name="id", required=true)
    private int id;
    @XmlElement(name="idPenjual", required=true)
    private int idPenjual;
    @XmlElement(name="name", required=true)
    private String name;
    @XmlElement(name="description", required=true)
    private String description;
    @XmlElement(name="price", required=true)
    private int price;
    @XmlElement(name="gambar", required=true)
    private String gambar;
    @XmlElement(name="tanggalDiTambah", required=true)
    private Date tanggalDiTambah;
    @XmlElement(name="namaPenjual", required=true)
    private String namaPenjual;
    @XmlElement(name="deleted", required=true)
    private int deleted;
    
    public Catalog_data() {
        id = 0;
        idPenjual = 0;
        name = "";
        description = "";
        price = 0;
        gambar = "";
        tanggalDiTambah = new Date(2016, 07, 31);
        namaPenjual = "";
        deleted = 0;
    }
    
    public Catalog_data(int id, int idP, String name, String desc, int harga, String gbr, Date tanggalTambah, String namaP, int del) {
        this.id = id;
        idPenjual = idP;
        this.name = name;
        description = desc;
        price = harga;
        gambar = gbr;
        tanggalDiTambah = tanggalTambah;
        namaPenjual = namaP;
        deleted = del;
    }
}
