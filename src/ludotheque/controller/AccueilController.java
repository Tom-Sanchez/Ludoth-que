/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ludotheque.controller;

import java.io.IOException;
import java.time.LocalDate;
import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import ludotheque.modele.ModeleEmprunt;

/**
 *
 * @author tosanchez
 */
public class AccueilController {

    @FXML
    Button quitter1;
    @FXML
    Button ListerLivres, ListerEmprunt, ListerPersonne;

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
     * @throws IOException
     */
    @FXML
    public void tempsPasser() throws IOException {

        int tailleModele = getLeModeleEmprunt().getLesEmprunts().size();

        LocalDate now = LocalDate.now();
        int yearDateNow = now.getYear();
        int monthDateNow = now.getMonthValue();
        int monthDateNowElse = now.getMonthValue() + 12;

        for (int j = 0; j < tailleModele; j++) {
            LocalDate dateEmprunt = getLeModeleEmprunt().getLesEmprunts().get(j).dateEmpruntProperty().getValue();
            int yearDateEmprunt = dateEmprunt.getYear();
            int monthDateEmprunt = dateEmprunt.getMonthValue();

            if (yearDateEmprunt == yearDateNow) {

                if (monthDateNow - monthDateEmprunt > 2) {
                    Alert empruntEnRetard = new Alert(Alert.AlertType.INFORMATION);
                    empruntEnRetard.setTitle("Emprunt en retard !!");
                    empruntEnRetard.setContentText("L'emprunt du livre " + getLeModeleEmprunt().getLesEmprunts().get(j).titreLivreProperty().getValue() + " est en retard ");
                    empruntEnRetard.showAndWait();
                }
            } else {

                if (monthDateNowElse - monthDateEmprunt > 2) {
                    Alert empruntEnRetard2 = new Alert(Alert.AlertType.INFORMATION);
                    empruntEnRetard2.setTitle("Emprunt en retard !!");
                    empruntEnRetard2.setContentText("L'emprunt du livre " + getLeModeleEmprunt().getLesEmprunts().get(j).titreLivreProperty().getValue() + " est trés en retard !!!");
                    empruntEnRetard2.showAndWait();
                }
            }
        }
    }

    @FXML
    private void quit() throws IOException {

        Alert confirmationQuitter = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationQuitter.setTitle("Attention!");
        confirmationQuitter.setContentText("Voulez-vous vraiment quitter l'application?");
        confirmationQuitter.showAndWait();

        if (confirmationQuitter.getResult() == ButtonType.OK) {
            Platform.exit();
        }

        if (confirmationQuitter.getResult() == ButtonType.CANCEL) {
        }
    }

    @FXML
    private void listerLivre() throws IOException {
        Parent root2 = FXMLLoader.load(getClass().getResource("/ludotheque/ihm/PageListeLivre.fxml"));
        Stage quitStage2 = new Stage();
        quitStage2.setScene(new Scene(root2));
        quitStage2.show();
    }

    @FXML
    private void listerEmprunt() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/ludotheque/ihm/PageListeEmprunt.fxml"));
        Stage quitStage = new Stage();
        quitStage.setScene(new Scene(root));
        quitStage.show();
    }

    @FXML
    private void listerPersonnes() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/ludotheque/ihm/PageListePersonne.fxml"));
        Stage quitStage = new Stage();
        quitStage.setScene(new Scene(root));
        quitStage.show();
    }
}
