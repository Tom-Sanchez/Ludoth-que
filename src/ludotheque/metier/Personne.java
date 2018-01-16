package ludotheque.metier;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author tosanchez
 */
public class Personne {
    
    private final StringProperty idPersonne = new SimpleStringProperty();

    /**
     *
     * @return
     */
    public String getIdPersonne() {return idPersonne.get();}

    /**
     *
     * @param idPersonne
     */
    public void setIdPersonne(String idPersonne) {this.idPersonne.set(idPersonne);}

    /**
     *
     * @return
     */
    public StringProperty idPersonneProperty(){return idPersonne;}
    
        
    private final StringProperty nomPersonne = new SimpleStringProperty();

    /**
     *
     * @return
     */
    public String getNomPersonne() {return nomPersonne.get();}

    /**
     *
     * @param NomPersonne
     */
    public void setNomPersonne(String NomPersonne) {this.nomPersonne.set(NomPersonne);}

    /**
     *
     * @return
     */
    public StringProperty NomPersonneProperty(){return nomPersonne;}
    
        
           
    private final StringProperty prenomPersonne = new SimpleStringProperty();

    /**
     *
     * @return
     */
    public String getPrenomPersonne() {return prenomPersonne.get();}

    /**
     *
     * @param PrenomPersonne
     */
    public void setPrenomPersonne(String PrenomPersonne) {this.prenomPersonne.set(PrenomPersonne);}

    /**
     *
     * @return
     */
    public StringProperty PrenomPersonneProperty(){return prenomPersonne;}
    
    /**
     *
     * @param id
     * @param nom
     * @param prenom
     */
    public Personne(String id, String nom, String prenom) {
        setIdPersonne(id);
        setNomPersonne(nom);
        setPrenomPersonne(prenom);
    }        
    
    @Override
    public String toString() {
        return this.getIdPersonne();
    }
}
