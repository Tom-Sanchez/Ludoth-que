/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ludotheque.controller;

import java.io.IOException;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ludotheque.metier.Personne;
import ludotheque.modele.ModelePersonne;

/**
 *
 * @author Tom
 */
public class PageAjouterPersonneController {
    
    @FXML
    Button ajouterButton;

    @FXML
    Label idPersonneLabel, nomPersonneLabel, prenomPersonneLabel;
    
    @FXML
    TextField textFieldId, textFieldPersonne, textFieldNom;
    
    String idPersonne, nomPersonne, prenomPersonne;
    
    
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
    public final void setLeModeleLivre(ModelePersonne value) {
        leModelePersonne.set(value);
    }

    /**
     *
     * @return
     */
    public ObjectProperty<ModelePersonne> leModeleLivreProperty() {
        return leModelePersonne;
    }
    
    /**
     *
     * @return
     * @throws IOException
     */
    @FXML
    public Personne ajouterPersonne() throws IOException{
       
       
        
       idPersonne=textFieldId.getText();
       nomPersonne=textFieldNom.getText();
       prenomPersonne=textFieldPersonne.getText();
       
       System.out.println(nomPersonne);
       System.out.println(prenomPersonne);
       Personne newPersonne = new Personne(idPersonne,nomPersonne,prenomPersonne);        
       return newPersonne;
          
    }
    
    
    @FXML
    private void revenir() throws IOException {
        ajouterButton.getScene().getWindow().hide();
    }

    
}
