/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Objects;

/**
 *
 * @author Korisnik
 */
public class Prevod {
   
    private Srpski srpski;
    private Jezik jezik;
    private String prevod;

    public Prevod() {
    }

    public Prevod(Srpski srpski, Jezik jezik, String prevod) {
        this.srpski = srpski;
        this.jezik = jezik;
        this.prevod = prevod;
    }

    public Srpski getSrpski() {
        return srpski;
    }

    public void setSrpski(Srpski srpski) {
        this.srpski = srpski;
    }

    public Jezik getJezik() {
        return jezik;
    }

    public void setJezik(Jezik jezik) {
        this.jezik = jezik;
    }

    public String getPrevod() {
        return prevod;
    }

    public void setPrevod(String prevod) {
        this.prevod = prevod;
    }

    @Override
    public String toString() {
        return prevod;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Prevod other = (Prevod) obj;
        if (!Objects.equals(this.prevod, other.prevod)) {
            return false;
        }
        if (!Objects.equals(this.srpski, other.srpski)) {
            return false;
        }
        return Objects.equals(this.jezik, other.jezik);
    }
    
}
