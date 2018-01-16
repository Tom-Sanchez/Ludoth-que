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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import ludotheque.metier.Personne;
import ludotheque.modele.ModeleEmprunt;
import ludotheque.modele.ModelePersonne;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

/**
 *
 * @author Tom
 */
public class PageListePersonneController {
    
    @FXML
    private ListView<Personne> listeDesPersonnes;
    
    @FXML
    Label labelNom, labelIdPersonne, labelPrenom;
    
    @FXML
    Button retour;
    
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
     */
    @FXML
    public void initialize() {
        listeDesPersonnes.itemsProperty().bind(leModelePersonne.get().lesPersonnesProperty());
        listeDesPersonnes.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue) -> {

            if (oldValue != null) {
                labelNom.textProperty().unbindBidirectional(newValue.NomPersonneProperty());
                labelIdPersonne.textProperty().unbindBidirectional(newValue.idPersonneProperty());
                labelPrenom.textProperty().unbindBidirectional(newValue.PrenomPersonneProperty());
                
                
            }

            if (newValue != null) {
                labelNom.textProperty().bind(newValue.NomPersonneProperty());
                labelIdPersonne.textProperty().bind(newValue.idPersonneProperty());
                labelPrenom.textProperty().bind(newValue.PrenomPersonneProperty());
            }
        });
    }
    
    @FXML
    private void revenir() throws IOException {
        retour.getScene().getWindow().hide();
    }
    
    @FXML
    private void afficherPageSupprimer() throws IOException {
        Alert confirmationSuppression = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationSuppression.setTitle("Attention!");
        confirmationSuppression.setContentText("Voulez-vous vraiment supprimer cette personne?");
        confirmationSuppression.showAndWait();
        
        if (confirmationSuppression.getResult()== ButtonType.OK){
            final int idx = listeDesPersonnes.getSelectionModel().getSelectedIndex();
            if(idx!=-1){
                getLeModelePersonne().getLesPersonnes().remove(idx);
            }
            else {
                Alert erreurSuppression = new Alert(Alert.AlertType.ERROR);
                erreurSuppression.setTitle("Problème ... ");
                erreurSuppression.setContentText("Veuillez sélectionner un emprunt");
                erreurSuppression.showAndWait();
            }
        }
        
        if (confirmationSuppression.getResult()== ButtonType.CANCEL){           
        }       
    }
    
    @FXML
    private void afficherPageAjouter() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ludotheque/ihm/PageAjouterPersonne.fxml"));
        Parent root = loader.load();
        Stage ajouterLivreStage = new Stage();
        ajouterLivreStage.setScene(new Scene(root));
        ajouterLivreStage.showAndWait();
        
        Personne newPersonne = ((PageAjouterPersonneController) loader.getController()).ajouterPersonne();
        if(newPersonne==null){
                    
            Alert erreurSuppression = new Alert(Alert.AlertType.ERROR);            
            erreurSuppression.setTitle("Problème ... ");
            erreurSuppression.setContentText("Veuillez entrer un titre de livre existant ou une personne inscrite");
            erreurSuppression.showAndWait();
           
        }
        else{
        getLeModelePersonne().getLesPersonnes().add(newPersonne);
        }
    }

}
