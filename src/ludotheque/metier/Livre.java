/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ludotheque.metier;

import java.time.LocalDate;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author tosanchez
 */
public class Livre{
    
   
    private final StringProperty titre = new SimpleStringProperty();

    /**
     *
     * @return
     */
    public String getTitre() {return titre.get();}

    /**
     *
     * @param titre
     */
    public void setTitre(String titre) {this.titre.set(titre);}

    /**
     *
     * @return
     */
    public StringProperty titreProperty(){return titre;}
        
    private final IntegerProperty idLivre = new SimpleIntegerProperty();

    /**
     *
     * @return
     */
    public Integer getIdLivre() {return idLivre.get();}

    /**
     *
     * @param idLivre
     */
    public void setIdLivre(Integer idLivre) {this.idLivre.set(idLivre);}

    /**
     *
     * @return
     */
    public IntegerProperty idLivreProperty(){return idLivre;}
        
    private final ObjectProperty<LocalDate> dateParution = new SimpleObjectProperty<LocalDate>();

    /**
     *
     * @return
     */
    public LocalDate getDateParution() {return dateParution.get();}

    /**
     *
     * @param dateParution
     */
    public void setDateParution(LocalDate dateParution) {this.dateParution.set(dateParution);}

    /**
     *
     * @return
     */
    public ObjectProperty<LocalDate> dateParutionProperty(){return dateParution;}
        
    private final StringProperty auteur = new SimpleStringProperty();

    /**
     *
     * @return
     */
    public String getAuteur() {return auteur.get();}

    /**
     *
     * @param auteur
     */
    public void setAuteur(String auteur) {this.auteur.set(auteur);}

    /**
     *
     * @return
     */
    public StringProperty auteurProperty(){return auteur;}
        
    private final StringProperty description = new SimpleStringProperty();
        
    /**
     *
     * @return
     */
    public String getDescription(){return description.get();}        

    /**
     *
     * @param description
     */
    public void setDescription(String description){this.description.set(description);}

    /**
     *
     * @return
     */
    public StringProperty descriptionProperty(){return description;}
        
    private final StringProperty urlImage = new SimpleStringProperty();

    /**
     *
     * @return
     */
    public String getUrlImage() {return urlImage.get();}

    /**
     *
     * @param urlImage
     */
    public void setUrlImage(String urlImage) {this.urlImage.set(urlImage);}

    /**
     *
     * @return
     */
    public StringProperty urlImageProperty(){return urlImage;}
        
    private final BooleanProperty estEmprunter = new SimpleBooleanProperty();

    /**
     *
     * @return
     */
    public Boolean getEstEmprunter() {return estEmprunter.get();}

    /**
     *
     * @param estEmprunter
     */
    public void setEstEmprunter(Boolean estEmprunter){this.estEmprunter.set(estEmprunter);}

    /**
     *
     * @return
     */
    public BooleanProperty estEmprunterProperty(){return estEmprunter;}
    
    /**
     *
     * @param idLivre
     * @param titre
     * @param dateParution
     * @param auteur
     * @param description
     * @param urlImage
     * @param estEmprunter
     */
    public Livre(int idLivre, String titre, LocalDate dateParution, String auteur, String description, String urlImage, Boolean estEmprunter) {
        setIdLivre(idLivre);
        setTitre(titre);
        setDateParution(dateParution);
        setAuteur(auteur);
        setDescription(description);
        setUrlImage(urlImage);
        setEstEmprunter(estEmprunter);
    }

    @Override
    public String toString() {
        return this.getIdLivre() + " | " + this.getTitre();
    }

}

  