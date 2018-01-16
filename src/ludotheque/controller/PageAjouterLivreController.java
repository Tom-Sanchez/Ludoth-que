/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ludotheque.controller;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Random;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import ludotheque.metier.Livre;

/**
 *
 * @author tosanchez
 */
public class PageAjouterLivreController {
        
    @FXML
    TextField textFieldTitre, textFieldAuteur, textFieldUrl;
    
    @FXML
    Label labelTitre, labelAuteur, labelDescription, labelDate;
    
    @FXML
    TextArea textAreaDescription;
    
    @FXML
    DatePicker datePickerDate;
    
    @FXML
    Button retourButton, ajouterButton, buttonParcourir; 
          
    
    private String titre, auteur, url, description , nomDialog="Sélectionner un fichier";
    private int id;
    private LocalDate date;
        
    private final StringProperty nomImage = new SimpleStringProperty();

    /**
     *
     * @return
     */
    public String getNomImage() {return nomImage.get();}

    /**
     *
     * @param nomImage
     */
    public void setNomImage(String nomImage) {this.nomImage.set(nomImage);}

    /**
     *
     * @return
     */
    public StringProperty nomImageProperty(){return nomImage;}
    
    
    @FXML
    private void parcourir() throws IOException{
        final FileChooser dialog = new FileChooser();
        dialog.setTitle(nomDialog);
        dialog.setInitialDirectory((new File("/home/etud/tosanchez/NetBeansProjects/LudoTheque/src/ludotheque/ressources")));
        final File image = dialog.showOpenDialog(buttonParcourir.getScene().getWindow());
        if (image.exists()){
            setNomImage(image.toURI().toString());
            textFieldUrl.textProperty().bind(nomImageProperty());
        }
        
    }
    
    @FXML
    private void revenir() throws IOException {
        ajouterButton.getScene().getWindow().hide();
    }
    
    /**
     *
     * @return
     * @throws IOException
     */
    @FXML
    public Livre ajouter() throws IOException{
       Random rdn = new Random(); 
       int maxValueId = 500;
        
       id=rdn.nextInt(maxValueId);
       titre=textFieldTitre.getText();
       auteur=textFieldAuteur.getText();
       description=textAreaDescription.getText();
       date=datePickerDate.getValue(); 
       url=textFieldUrl.getText();
       
       Livre newLivre = new Livre(id,titre, date, auteur, description, url, false);
        
       return newLivre;
    }
   
}
