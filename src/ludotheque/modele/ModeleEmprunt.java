/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ludotheque.modele;

import java.time.LocalDate;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ReadOnlyListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ludotheque.metier.Emprunt;

/**
 *
 * @author tosanchez
 */
public class ModeleEmprunt {
    
    private ObservableList<Emprunt> lesEmpruntsObs = FXCollections.observableArrayList();

    private final ListProperty<Emprunt> lesEmprunts = new SimpleListProperty<>(lesEmpruntsObs);

    /**
     *
     * @return
     */
    public ObservableList<Emprunt> getLesEmprunts() {return lesEmprunts.get();}

    /**
     *
     * @return
     */
    public ReadOnlyListProperty<Emprunt> lesEmpruntsProperty() {return lesEmprunts;}
    
    /**
     *
     */
    public ModeleEmprunt(){
        
        lesEmpruntsObs.add(new Emprunt("Tintin au Congo", "00005", LocalDate.of(2018, 02, 01)));
        lesEmpruntsObs.add(new Emprunt("Tintin au Tibet", "00045", LocalDate.of(2017, 02, 02)));
        lesEmpruntsObs.add(new Emprunt("Tintin au Perou", "00750",LocalDate.of(2017, 05, 05)));
    }
        
    
}
