package ump.PropertiesToYamlConverter.model;


import java.util.HashMap;
import java.util.Map;

public class ResultatConversion {
    private boolean succes;
    private String contenu;
    private String erreur;
    private Map<String,String> props ;

    public ResultatConversion(boolean succes, String contenu, String erreur, Map<String,String> props) {
        this.succes = succes;
        this.contenu = contenu;
        this.erreur = erreur;
        this.props = props;
    }

    public boolean isSucces() { return succes; }
    public String getContenu() { return contenu; }
    public String getErreur() { return erreur; }
    public Map<String,String> getProps(){ return props; }
}
