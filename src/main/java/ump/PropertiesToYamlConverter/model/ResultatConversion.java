package ump.PropertiesToYamlConverter.model;


public class ResultatConversion {
    private boolean succes;
    private String contenu;
    private String erreur;

    public ResultatConversion(boolean succes, String contenu, String erreur) {
        this.succes = succes;
        this.contenu = contenu;
        this.erreur = erreur;
    }

    public boolean isSucces() { return succes; }
    public String getContenu() { return contenu; }
    public String getErreur() { return erreur; }
}
