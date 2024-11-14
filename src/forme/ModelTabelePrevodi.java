/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Prevod;

/**
 *
 * @author Korisnik
 */
public class ModelTabelePrevodi extends AbstractTableModel {
    List<Prevod> lista=new ArrayList<>();
    String kolone[]={"prevod", "jezik"};

    public ModelTabelePrevodi(List<Prevod> lista) {
        this.lista = lista;
    }

    

    public List<Prevod> getLista() {
        return lista;
    }
    
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Prevod p=lista.get(rowIndex);
        switch(columnIndex){
            case 0: return p.getPrevod();
            case 1: return p.getJezik().getNaziv();
            default: return "n/a";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    
}
