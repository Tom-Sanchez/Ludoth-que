/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ludotheque.composants;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author tosanchez
 */
public class ImageViewWithUrl extends ImageView {

    private final StringProperty url = new SimpleStringProperty();

    /**
     *
     * @return
     */
    public String getUrl() {
        return url.get();
    }

    /**
     *
     * @param value
     */
    public void setUrl(String value) {
        url.set(value);
    }

    /**
     *
     * @return
     */
    public StringProperty urlProperty() {
        return url;
    }

    /**
     *
     */
    public ImageViewWithUrl() {
        url.addListener((obs,oldV,newV)->{
            setImage(new Image(newV));        
        });
    }
 }
