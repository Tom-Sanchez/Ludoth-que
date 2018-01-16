/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ludotheque.modele;

import java.time.LocalDate;
import java.util.Random;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ReadOnlyListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ludotheque.metier.Livre;

/**
 *
 * @author tosanchez
 */
public class ModeleLivre {
    
    
    private final Random rdn = new Random();
    private final int maxNombreLivres = 500;
    
    private final ObservableList<Livre> lesLivresObs = FXCollections.observableArrayList();

    

    private final ListProperty<Livre> lesLivres = new SimpleListProperty<>(lesLivresObs);

    /**
     *
     * @return
     */
    public ObservableList<Livre> getLesLivres() {return lesLivres.get();}

    /**
     *
     * @return
     */
    public ReadOnlyListProperty<Livre> lesLivresProperty() {return lesLivres;}

    /**
     *
     */
    public ModeleLivre() {
        lesLivresObs.add(new Livre(rdn.nextInt(maxNombreLivres),"Tintin au Tibet", LocalDate.of(1988, 11, 9),"Hergé","BD Tintin au Tibet","/ludotheque/ressources/TintinAuTibet.jpg",true));
        lesLivresObs.add(new Livre(rdn.nextInt(maxNombreLivres),"Tintin au Congo", LocalDate.of(1945, 12, 7),"Hergé","BD Tintin au Congo","/ludotheque/ressources/TintinAuCongo.jpg",true));
        lesLivresObs.add(new Livre(rdn.nextInt(maxNombreLivres),"Tintin au Pérou", LocalDate.of(1998, 10, 3),"Hergé","BD Tintin au Pérou","/ludotheque/ressources/TintinAuPérou.jpg",true));
        lesLivresObs.add(new Livre(rdn.nextInt(maxNombreLivres),"Martine n'a pas de culotte", LocalDate.of(1995, 02, 3),"Marlier","BD Martine","/ludotheque/ressources/Martinesansculotte.jpg",false));
        lesLivresObs.add(new Livre(rdn.nextInt(maxNombreLivres),"Martine tente un low-kick", LocalDate.of(1994, 02, 3),"Marlier","BD Martine","/ludotheque/ressources/Martinelowkick.jpg",false));
    }

}
