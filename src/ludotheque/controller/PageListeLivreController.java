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
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import ludotheque.composants.ImageViewWithUrl;
import ludotheque.metier.Livre;
import ludotheque.modele.ModeleLivre;

/**
 *
 * @author tosanchez
 */
public class PageListeLivreController {

    @FXML
    private ListView<Livre> listeDesLivres;

    @FXML
    private Label labelTitre;
    @FXML
    private Label labelIdLivre;
    @FXML
    private Label labelDateParution;
    @FXML
    private Label labelAuteur; 
    @FXML
    private ImageViewWithUrl imageViewImage;

    @FXML
    private TextArea detailLivre;
    @FXML
    private Button retour,ajouterButton;
    
    @FXML 
    private Rectangle rectangleEstEmprunter;

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
    
    private Color redColor = Color.RED;
    private Color greenColor = Color.GREEN;
    
    /**
     *
     */
    @FXML
    public void initialize() {
        listeDesLivres.itemsProperty().bind(leModeleLivre.get().lesLivresProperty());
        listeDesLivres.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue) -> {

            if (oldValue != null) {
                detailLivre.textProperty().unbindBidirectional(newValue.descriptionProperty());
                labelTitre.textProperty().unbindBidirectional(newValue.titreProperty());
                labelIdLivre.textProperty().unbindBidirectional(newValue.idLivreProperty().asString());
                labelDateParution.textProperty().unbindBidirectional(newValue.dateParutionProperty().asString());
                labelAuteur.textProperty().unbindBidirectional(newValue.auteurProperty());               
                imageViewImage.urlProperty().unbindBidirectional(newValue.urlImageProperty());
            }

            if (newValue != null) {
                detailLivre.textProperty().bind(newValue.descriptionProperty());
                labelTitre.textProperty().bind(newValue.titreProperty());
                labelIdLivre.textProperty().bind(newValue.idLivreProperty().asString());
                labelDateParution.textProperty().bind(newValue.dateParutionProperty().asString());
                labelAuteur.textProperty().bind(newValue.auteurProperty());
                imageViewImage.urlProperty().bind(newValue.urlImageProperty());              
            
                if(newValue.getEstEmprunter() == false){
                    rectangleEstEmprunter.setStroke(greenColor);
                    rectangleEstEmprunter.setFill(greenColor);
                }
                if(newValue.getEstEmprunter() == true){
                    rectangleEstEmprunter.setStroke(redColor);
                    rectangleEstEmprunter.setFill(redColor);
                }               
            }
            
            /*if(newValue==null || oldValue==null){
                System.err.println("yolo");
                detailLivre.setText("Sélectionner un livre");
                labelTitre.setText("Sélectionner un livre");
                labelIdLivre.setText("Sélectionner un livre");
                labelDateParution.setDisable(true);
                labelAuteur.setText("Sélectionner un livre");
                imageViewImage.setDisable(true);           
            }*/
        });
    }
    

    @FXML
    private void revenir() throws IOException {
        retour.getScene().getWindow().hide();
    }

    @FXML
    private void afficherPageAjouter() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ludotheque/ihm/PageAjouterLivre.fxml"));
        Parent root = loader.load();
        Stage ajouterLivreStage = new Stage();
        ajouterLivreStage.setScene(new Scene(root));
        ajouterLivreStage.showAndWait();
        
        Livre newLivre = ((PageAjouterLivreController) loader.getController()).ajouter();
        getLeModeleLivre().getLesLivres().add(newLivre);
    }

    @FXML
    private void afficherPageSupprimer() throws IOException {
        Alert confirmationSuppression = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationSuppression.setTitle("Attention!");
        confirmationSuppression.setContentText("Voulez-vous vraiment supprimer ce livre?");
        confirmationSuppression.showAndWait();
        
        if (confirmationSuppression.getResult()== ButtonType.OK){
            final int idx = listeDesLivres.getSelectionModel().getSelectedIndex();
            if(idx!=-1){
                getLeModeleLivre().getLesLivres().remove(idx);
                    
                listeDesLivres.getSelectionModel().selectFirst();
            }
            else {
                Alert erreurSuppression = new Alert(Alert.AlertType.ERROR);
                erreurSuppression.setTitle("Problème ... ");
                erreurSuppression.setContentText("Titre du livre incorrect ou déjà emprunter");
                erreurSuppression.showAndWait();
            }
            
        }
        
        if (confirmationSuppression.getResult()== ButtonType.CANCEL){           
        }
    }
    
}
