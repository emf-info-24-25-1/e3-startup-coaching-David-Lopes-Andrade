package models;

import utils.*;

public class Projet {
    private final String nom;
    private final double budget;
    private final String date_fin;
    private final Employe[] employes;

    public Projet(String nom, double budget, String date_fin) {
        this.nom = nom;
        this.budget = budget;
        this.date_fin = date_fin;
        employes = new Employe[5];
    }

    public String getNom() {
        return nom;
    }

    public double getBudget() {

        return budget;
    }

    public String getDate_fin() {
        return date_fin;
    }

    public Employe[] getEmployes() {
        return employes;
    }

    @Override
    public String toString() {

        String affichage = "Projet " + nom + ", Budget : " + Util.formaterMontant(budget) + " CHF, Date de fin: "
                + date_fin + ", Employes: ";

        boolean premier = true;
        for (int i = 0; i < employes.length; i++) {
            if (employes[i] != null) {
                if (!premier) {
                    affichage += ", ";
                }
                affichage += employes[i].getInitiales();
                premier = false;
            }
        }
        return affichage;
    }

    public boolean ajouterEmploye(Employe employe) {
        boolean reussi = false;
        if (employe != null) {
            for (int i = 0; i < employes.length; i++) {
                if (employes[i] == null) {
                    employes[i] = employe;
                    reussi = true;
                    break;
                }
            }
        }

        return reussi;

    }

    public boolean retirerEmploye(Employe employe) {
        boolean reussi = false;
        if (employe != null) {
            for (int i = 0; i < employes.length; i++) {
                if (employes[i] == employe) {
                    employes[i] = null;
                    reussi = true;
                    break;
                }
            }
        }
        return reussi;

    }

    public String obtenirListeEmployeInitiale() {
        String affichage = "";
        for (int i = 0; i < employes.length; i++) {
            affichage += employes[i].getInitiales();
            if (i < employes.length - 1) {
                affichage += ",";
            }

        }
        return affichage;
    }
}
