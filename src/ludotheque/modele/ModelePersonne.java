/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ludotheque.modele;

import javafx.beans.property.ListProperty;
import javafx.beans.property.ReadOnlyListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ludotheque.metier.Livre;
import ludotheque.metier.Personne;

/**
 *
 * @author tosanchez
 */
public class ModelePersonne {
    
    private final ObservableList<Personne> lesPersonnesObs = FXCollections.observableArrayList();

    

    private final ListProperty<Personne> lesPersonnes = new SimpleListProperty<>(lesPersonnesObs);

    /**
     *
     * @return
     */
    public ObservableList<Personne> getLesPersonnes() {return lesPersonnes.get();}

    /**
     *
     * @return
     */
    public ReadOnlyListProperty<Personne> lesPersonnesProperty() {return lesPersonnes;}

    /**
     *
     */
    public ModelePersonne() {
        lesPersonnesObs.add(new Personne("00005", "Lapine", "Jacques"));
        lesPersonnesObs.add(new Personne("00045", "Laboule", "Biboule"));
        lesPersonnesObs.add(new Personne("00750", "Partout", "Passe"));
        lesPersonnesObs.add(new Personne("00052", "Dany", "Lady"));
        lesPersonnesObs.add(new Personne("00013", "Sam-Aire", "Nick"));    
    }
    
}
