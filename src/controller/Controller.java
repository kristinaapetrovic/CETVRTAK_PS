/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import baza.DBBroker;
import java.util.List;
import model.Jezik;
import model.Prevod;
import model.Srpski;


/**
 *
 * @author Korisnik
 */
public class Controller {
    
    private static Controller instance;
    private DBBroker dbb=new DBBroker();
    private Jezik odabraniJezik;

    public Jezik getOdabraniJezik() {
        return odabraniJezik;
    }

    public void setOdabraniJezik(Jezik odabraniJezik) {
        this.odabraniJezik = odabraniJezik;
    }
    
  


    private Controller() {
        
        
    }

    
    
    public static Controller getInstance() {
        if(instance==null) instance=new Controller();
        return instance;
    }

    

    public List<Prevod> vratiPrevodePremaSrpskom(Srpski sr) {
        return dbb.vratiPrevodePremaSrpskom(sr);
    }

    public List<Srpski> vratiListuSrpski() {
        return dbb.vratiListuSrpski();
    }

    public List<Jezik> vratiListuJezik() {
        return dbb.vratiListuJezik();
    }

    public List<Prevod> vratiPrevodePremaSJ(Srpski s, Jezik j) {
        return dbb.vratiPrevodePrema(s,j);
    }

    public boolean ubaciPrevode(String srpRec, Jezik odabraniJezik, String[] niz) {
        return dbb.ubaciPrevode(srpRec, odabraniJezik, niz);
    }

 
    
    
    
}
