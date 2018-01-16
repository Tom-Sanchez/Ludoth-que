/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ludotheque.metier;

import java.time.LocalDate;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author tosanchez
 */
public class Emprunt {
    
    private final StringProperty titreLivre = new SimpleStringProperty();

    /**
     *
     * @return
     */
    public String getTitreLivre() {return titreLivre.get();}

    /**
     *
     * @param titre
     */
    public void setTitreLivre(String titre) {this.titreLivre.set(titre);}

    /**
     *
     * @return
     */
    public StringProperty titreLivreProperty(){return titreLivre;}
    
       
     private final StringProperty idPersonne = new SimpleStringProperty();

    /**
     *
     * @return
     */
    public String getIdPersonne() {return idPersonne.get();}

    /**
     *
     * @param idLivre
     */
    public void setIdPersonne(String idLivre) {this.idPersonne.set(idLivre);}

    /**
     *
     * @return
     */
    public StringProperty idPersonneProperty(){return idPersonne;}
        
    private final ObjectProperty<LocalDate> dateEmprunt = new SimpleObjectProperty<LocalDate>();

    /**
     *
     * @return
     */
    public LocalDate getDateEmprunt() {return dateEmprunt.get();}

    /**
     *
     * @param dateParution
     */
    public void setDateEmprunt(LocalDate dateParution) {this.dateEmprunt.set(dateParution);}

    /**
     *
     * @return
     */
    public ObjectProperty<LocalDate> dateEmpruntProperty(){return dateEmprunt;}
        
    /**
     *
     * @param titreLivre
     * @param idPersonne
     * @param dateEmprunt
     */
    public Emprunt(String titreLivre, String idPersonne, LocalDate dateEmprunt){
        setTitreLivre(titreLivre);
        setIdPersonne(idPersonne);
        setDateEmprunt(dateEmprunt);        
    }
        
    @Override
    public String toString() {
        return this.getTitreLivre() + " | " + this.getIdPersonne() + " | " + this.getDateEmprunt();
    }
}
