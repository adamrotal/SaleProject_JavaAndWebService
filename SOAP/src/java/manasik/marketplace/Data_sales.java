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
public class Data_sales {
    @XmlElement(name="id", required=true)
    private int id;
    @XmlElement(name="idProduk", required=true)
    private int idProduk;
    @XmlElement(name="idPembeli", required=true)
    private int idPembeli;
    @XmlElement(name="namaPembeli", required=true)
    private String namaPembeli;
    @XmlElement(name="fullAddress", required=true)
    private String fullAddress;
    @XmlElement(name="postalCode", required=true)
    private String postalCode;
    @XmlElement(name="phoneNumber", required=true)
    private String phoneNumber;
    @XmlElement(name="creditCard", required=true)
    private String creditCard;
    @XmlElement(name="codeVerification", required=true)
    private String codeVerification;
    @XmlElement(name="tanggalDiBeli", required=true)
    private Date tanggalDiBeli;
    @XmlElement(name="kuantitas", required=true)
    private int kuantitas;
    @XmlElement(name="idPenjual", required=true)
    private int idPenjual;
    
    public Data_sales() {
        id = 0;
        idProduk = 0;
        idPembeli = 0;
        namaPembeli = "";
        fullAddress = "";
        postalCode = "";
        phoneNumber = "";
        creditCard = "";
        codeVerification = "";
        tanggalDiBeli = new Date(2016, 07, 31);
        kuantitas = 0;
        idPenjual = 0;
    }
    
    public Data_sales(int id, int idpro, int idbeli, String namabeli, String alamat,
            String kodepos, String telp, String credit, String codeVerif, 
            Date beli, int banyaknya, int idjual)
    {
        this.id = id;
        idProduk = idpro;
        idPembeli = idbeli;
        namaPembeli = namabeli;
        fullAddress = alamat;
        postalCode = kodepos;
        phoneNumber = telp;
        creditCard = credit;
        codeVerification = codeVerif;
        tanggalDiBeli = beli;
        kuantitas = banyaknya;
        idPenjual = idjual;
    }
}
