package models;

public class Employe {
    private final String initiales;
    private final String nom;
    private final String prenom;
    private final String poste;
    private final double salaire;

    public Employe(String initiales, String nom, String prenom, String poste, double salaire) {
        this.initiales = initiales;
        this.nom = nom;
        this.prenom = prenom;
        this.poste = poste;
        this.salaire = salaire;
    }

    public String getInitiales() {
        return initiales;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getPoste() {
        return poste;
    }

    public double getSalaire() {
        return salaire;
    }

    @Override
    public String toString() {
        return initiales.toUpperCase() + "/" + nom.toUpperCase() + prenom + "( " + poste + ")" + "[ " + salaire
                + "CHF ]";
    }

}
