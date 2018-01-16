package ludotheque.controller;

import java.io.IOException;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import ludotheque.metier.Emprunt;
import ludotheque.metier.Livre;
import ludotheque.modele.ModeleEmprunt;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tosanchez
 */
public class PageListeEmpruntController {
    
    @FXML
    private ListView<Emprunt> listeDesEmprunts;
    
    @FXML
    Label labelTitre, labelIdPersonne, labelDate;
    
    @FXML
    Button retour;
    
    private final ObjectProperty<ModeleEmprunt> leModeleEmprunt = new SimpleObjectProperty<>(new ModeleEmprunt());
    
    /**
     *
     * @return
     */
    public final ModeleEmprunt getLeModeleEmprunt() {
        return leModeleEmprunt.get();
    }

    /**
     *
     * @param value
     */
    public final void setLeModeleEmprunt(ModeleEmprunt value) {
        leModeleEmprunt.set(value);
    }

    /**
     *
     * @return
     */
    public ObjectProperty<ModeleEmprunt> leModeleEmpruntProperty() {
        return leModeleEmprunt;
    }
    
    /**
     *
     */
    @FXML
    public void initialize() {
        listeDesEmprunts.itemsProperty().bind(leModeleEmprunt.get().lesEmpruntsProperty());
        listeDesEmprunts.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue) -> {

            if (oldValue != null) {
                labelTitre.textProperty().unbindBidirectional(newValue.titreLivreProperty());
                labelIdPersonne.textProperty().unbindBidirectional(newValue.idPersonneProperty());
                labelDate.textProperty().unbindBidirectional(newValue.dateEmpruntProperty().asString());
                
                
            }

            if (newValue != null) {
                labelTitre.textProperty().bind(newValue.titreLivreProperty());
                labelIdPersonne.textProperty().bind(newValue.idPersonneProperty());
                labelDate.textProperty().bind(newValue.dateEmpruntProperty().asString());
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
        confirmationSuppression.setContentText("Voulez-vous vraiment supprimer cet emprunt?");
        confirmationSuppression.showAndWait();
        
        if (confirmationSuppression.getResult()== ButtonType.OK){
            final int idx = listeDesEmprunts.getSelectionModel().getSelectedIndex();
            if(idx!=-1){
                getLeModeleEmprunt().getLesEmprunts().remove(idx);
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ludotheque/ihm/PageAjouterEmprunt.fxml"));
        Parent root = loader.load();
        Stage ajouterLivreStage = new Stage();
        ajouterLivreStage.setScene(new Scene(root));
        ajouterLivreStage.showAndWait();
        
        Emprunt newEmprunt = ((PageAjouterEmpruntController) loader.getController()).ajouter();
        if(newEmprunt==null){
                    
            Alert erreurSuppression = new Alert(Alert.AlertType.ERROR);            
            erreurSuppression.setTitle("Problème ... ");
            erreurSuppression.setContentText("Veuillez entrer un titre de livre existant ou une personne inscrite");
            erreurSuppression.showAndWait();
           
        }
        else{
        getLeModeleEmprunt().getLesEmprunts().add(newEmprunt);
        }
    }

}
