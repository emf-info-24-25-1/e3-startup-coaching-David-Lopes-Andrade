package models;

import utils.Util;

public class Startup {
    private final String nom;
    private Employe[] employes;
    private Projet[] projets;

    public Startup(String nom) {
        this.nom = nom;
        employes = new Employe[0];
        projets = new Projet[0];
    }

    public boolean ajouterEmploye(Employe employe) {
        boolean reussi = false;
        if (employe != null) {
            // creation tableau sans trou
            Employe[] sansTrou = new Employe[employes.length + 1];
            // copie des employes actuelle dans sans trou
            for (int i = 0; i < employes.length; i++) {
                sansTrou[i] = employes[i];
            }
            // le nouvel employe dans le dernier index de sans trou
            sansTrou[sansTrou.length - 1] = employe;
            // ecraser sans trou par employes
            employes = sansTrou;
            reussi = true;
        }
        return reussi;
    }

    public boolean retirerEmploye(Employe employe) {
        boolean reussi = false;
        if (employe != null) {
            // creation tableau sans trou
            Employe[] sansTrou = new Employe[employes.length - 1];
            // mettre l'index necessaire a null
            for (int i = 0; i < employes.length; i++) {
                if (employes[i] == employe) {
                    employes = null;
                }
            }
            // remplir sans trou avec employe du tableau employes
            int pos = 0;
            for (int i = 0; i < employes.length; i++) {
                if (employes[i] != null) {
                    sansTrou[pos++] = employes[i];
                }
            }
            // ecraser sans trou par employes
            employes = sansTrou;
            reussi = true;
        }
        return reussi;
    }

    public boolean ajouterProjet(Projet projet) {
        boolean reussi = false;
        if (projet != null) {
            // creation tableau sans trou
            Projet[] sansTrou = new Projet[projets.length + 1];
            // copie des projet actuelle dans sans trou
            for (int i = 0; i < projets.length; i++) {
                sansTrou[i] = projets[i];
            }
            // le nouveau projet dans le dernier index de sans trou
            sansTrou[sansTrou.length - 1] = projet;
            // ecraser sans trou par projets
            projets = sansTrou;
            reussi = true;
        }
        return reussi;
    }

    public boolean retirerProjet(Projet projet) {
        boolean reussi = false;
        if (projet != null) {
            // creation tableau sans trou
            Projet[] sansTrou = new Projet[projets.length - 1];
            // mettre l'index necessaire a null
            for (int i = 0; i < projets.length; i++) {
                if (projets[i] == projet) {
                    projets = null;
                }
            }
            // remplir sans trou avec projet du tableau projet
            int pos = 0;
            for (int i = 0; i < projets.length; i++) {
                if (employes[i] != null) {
                    sansTrou[pos++] = projets[i];
                }
            }
            // ecraser sans trou par projets
            projets = sansTrou;
            reussi = true;
        }
        return reussi;
    }

    public double calculerBudgetTotal() {
        double total = 0.0;
        for (int i = 0; i < projets.length; i++) {
            total += projets[i].getBudget();
            Util.formaterMontant(projets[i].getBudget());
        }
        return total;
    }

    public Employe[] listeEmployes() {
        return employes;

    }

    public boolean ajouterEmployeProjet(Employe employe, Projet projet) {
        boolean reussi = false;
        if (employe != null && projet != null) {
            boolean estDedans = false;
            for (int i = 0; i < employes.length; i++) {
                if (employe == employes[i]) {
                    estDedans = true;
                    break;

                }
            }
            if (estDedans == true) {
                for (int i = 0; i < projets.length; i++) {
                    if (projet == projets[i]) {
                        projets[i].ajouterEmploye(employe);
                        reussi = true;
                        break;
                    }
                }
            }
        }
        return reussi;
    }

    public boolean retirerEmployeProjet(Employe employe, Projet projet) {
        return false;
    }

    @Override
    public String toString() {
        String affichage;
        affichage = "Startup: " + nom + System.lineSeparator() + "Employes: ";
        for (int i = 0; i < employes.length; i++) {
            if (employes != null) {
                affichage += System.lineSeparator() + "- " + employes[i];
            }
        }
        affichage += System.lineSeparator() + "Projets: ";
        for (int i = 0; i < projets.length; i++) {
            if (projets != null) {
                affichage += projets[i];
            }
        }
        return affichage;
    }

}
