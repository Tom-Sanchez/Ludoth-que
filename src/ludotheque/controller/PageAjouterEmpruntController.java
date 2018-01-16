/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ludotheque.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import ludotheque.metier.Emprunt;
import ludotheque.modele.ModeleLivre;
import ludotheque.modele.ModelePersonne;

/**
 *
 * @author tosanchez
 */
public class PageAjouterEmpruntController {
    
    
    @FXML
    Button ajouterButton;

    @FXML
    TextField textFieldTitre, textFieldIdPersonne;
    
    @FXML
    DatePicker datePickerDate; 
   
    private String titreLivre,idPersonne;
    private LocalDate date;
    private Emprunt newEmprunt;
    
        private final ObjectProperty<ModeleLivre> leModeleLivre = new SimpleObjectProperty<>(new ModeleLivre());
    
    /**
     *
     * @return
     */
    public final ModeleLivre getLeModeleLivre() {
        return leModeleLivre.get();
    }

    /**
     *
     * @param value
     */
    public final void setLeModeleLivre(ModeleLivre value) {
        leModeleLivre.set(value);
    }

    /**
     *
     * @return
     */
    public ObjectProperty<ModeleLivre> leModeleLivreProperty() {
        return leModeleLivre;
    }
    
    private final ObjectProperty<ModelePersonne> leModelePersonne = new SimpleObjectProperty<>(new ModelePersonne());
    
    /**
     *
     * @return
     */
    public final ModelePersonne getLeModelePersonne() {
        return leModelePersonne.get();
    }

    /**
     *
     * @param value
     */
    public final void setLeModelePersonne(ModelePersonne value) {
        leModelePersonne.set(value);
    }

    /**
     *
     * @return
     */
    public ObjectProperty<ModelePersonne> leModelePersonneProperty() {
        return leModelePersonne;
    }
    
    /**
     *
     * @return
     * @throws IOException
     */
    @FXML
    public Emprunt ajouter() throws IOException{
       
       
        
       idPersonne=textFieldIdPersonne.getText();
       titreLivre=textFieldTitre.getText();
       date=datePickerDate.getValue(); 

       int tailleP = getLeModelePersonne().getLesPersonnes().size();
       LocalDate d1 = LocalDate.now();
       
       for (int i=0;i<tailleP;i++){
           String idP = getLeModelePersonne().getLesPersonnes().get(i).idPersonneProperty().getValue();
           
           if(idP.equals(idPersonne)){
              
           }
       }
       
       if(date.compareTo(d1)<0){
           return null;
       }
       
       if(titreLivre !=  null){}
       
        int taille = getLeModeleLivre().getLesLivres().size();
        
        String titre;
        
        for (int i=0;i<taille;i++){
            titre=getLeModeleLivre().getLesLivres().get(i).titreProperty().getValue();
            
            if(titre.equals(titreLivre)){
                
                boolean emp = getLeModeleLivre().getLesLivres().get(i).estEmprunterProperty().getValue();
                
                if(emp==true){
                    return null;
                }
                else{
                 getLeModeleLivre().getLesLivres().get(i).estEmprunterProperty().setValue(true);
                 newEmprunt = new Emprunt(titreLivre,idPersonne, date);        
                 return newEmprunt;
                }
            }
          
        }
        
        
        
           
        return null;
    }      
    
    
    @FXML
    private void revenir() throws IOException {
        ajouterButton.getScene().getWindow().hide();
    }

}
