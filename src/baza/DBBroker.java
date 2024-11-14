/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baza;

import model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Korisnik
 */
public class DBBroker {

    public List<Prevod> vratiPrevodePremaSrpskom(Srpski sr) {
        try {
            List<Prevod> lista = new ArrayList<>();

            String upit = "SELECT * FROM prevod p join SRPSKI s on s.id=p.srpski JOIN jezik j ON j.id=p.jezik WHERE p.srpski=" + sr.getId();
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                int ids = rs.getInt("s.id");
                String nazivs = rs.getString("s.naziv");
                Srpski s = new Srpski(ids, nazivs);

                int idj = rs.getInt("j.id");
                String naziv = rs.getString("j.naziv");
                Jezik j = new Jezik(idj, naziv);

                String prevod = rs.getString("p.prevod");
                Prevod p = new Prevod(s, j, prevod);
                lista.add(p);

            }

            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Srpski> vratiListuSrpski() {
        try {
            List<Srpski> lista = new ArrayList<>();

            String upit = "SELECT * FROM srpski";
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                int ids = rs.getInt("id");
                String nazivs = rs.getString("naziv");
                Srpski s = new Srpski(ids, nazivs);

                lista.add(s);

            }

            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Jezik> vratiListuJezik() {
        try {
            List<Jezik> lista = new ArrayList<>();

            String upit = "SELECT * FROM jezik";
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                int ids = rs.getInt("id");
                String nazivs = rs.getString("naziv");
                Jezik j = new Jezik(ids, nazivs);

                lista.add(j);

            }

            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Prevod> vratiPrevodePrema(Srpski s, Jezik j) {
         try {
            List<Prevod> lista = new ArrayList<>();

            String upit = "SELECT * FROM prevod p join SRPSKI s on s.id=p.srpski JOIN jezik j ON j.id=p.jezik WHERE p.srpski=" + s.getId()+" AND p.jezik="+j.getId();
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while (rs.next()) {
                int ids = rs.getInt("s.id");
                String nazivs = rs.getString("s.naziv");
                Srpski sr = new Srpski(ids, nazivs);

                int idj = rs.getInt("j.id");
                String naziv = rs.getString("j.naziv");
                Jezik je = new Jezik(idj, naziv);

                String prevod = rs.getString("p.prevod");
                Prevod p = new Prevod(sr, je, prevod);
                lista.add(p);

            }

            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean ubaciPrevode(String srpRec, Jezik odabraniJezik, String[] niz) {
 
        try {
            String upit1="INSERT INTO srpski (naziv) VALUES (?)";
            PreparedStatement ps=Konekcija.getInstance().getConnection().prepareStatement(upit1, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, srpRec);
            
            int red=ps.executeUpdate();
            if(red>0){
                int kljuc=0;
                ResultSet rs=ps.getGeneratedKeys();
                if(rs.next()){
                    kljuc=rs.getInt(1);
                }
                if(kljuc!=0){
                    String upit2="INSERT INTO prevod (srpski, jezik, prevod) VALUES (?,?,?)";
                    PreparedStatement ps2=Konekcija.getInstance().getConnection().prepareStatement(upit2);
                    for(String r:niz){
                        ps2.setInt(1, kljuc);
                        ps2.setInt(2, odabraniJezik.getId());
                        ps2.setString(3, r);
                        ps2.addBatch();
                    }
                    ps2.executeBatch();
                    
                    
                }
                
                
                Konekcija.getInstance().getConnection().commit();
            }
            
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    
    }

}
