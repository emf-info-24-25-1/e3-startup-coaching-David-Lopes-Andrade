package app;

import models.*;

public class Application {

        public static void main(String[] args) {
                Startup[] startup = new Startup[10];

                startup[0] = new Startup("InnoveateTech");
                startup[1] = new Startup("BananaTech");

                Employe employes = new Employe("FRI", "FRIEDLI", "paul", "Développeur", 50000.00);
                Employe employes1 = new Employe("RIF", "RIEDO", "Fanny", "CTO", 60000.00);
                Employe employes2 = new Employe("MAC", "MACKEY", "john", "CIO", 100000.00);
                Employe employes3 = new Employe("ROD", "RODUIT", "Mireille", "CEO", 100000.00);
                Employe employes4 = new Employe("PHY", "PHYO", "Jeff", "CFO", 60000.00);

                startup[0].ajouterEmploye(employes);
                startup[0].ajouterEmploye(employes1);

                startup[1].ajouterEmploye(employes2);
                startup[1].ajouterEmploye(employes3);
                startup[1].ajouterEmploye(employes4);

                Projet projet = new Projet("Projet Alpha", 150000.00, "31.12.2024");
                Projet projet2 = new Projet("Projet Beta", 100000.00, "30.11.2023");
                Projet projet3 = new Projet("Projet IA", 202000.00, "31.12.2024");

                startup[0].ajouterProjet(projet);
                startup[0].ajouterProjet(projet2);
                startup[1].ajouterProjet(projet3);

                projet.ajouterEmploye(employes);
                projet.ajouterEmploye(employes1);
                projet2.ajouterEmploye(employes1);
                projet3.ajouterEmploye(employes2);
                projet3.ajouterEmploye(employes3);
                projet3.ajouterEmploye(employes4);

                afficherDetails(startup[0]);
                afficherDetails(startup[1]);

        }

        static final Startup afficherDetails(Startup startup) {
                if (startup != null) {
                        System.out.println("---------------------------------");
                        System.out.println(startup);
                        Employe[] listeEmployes = startup.listeEmployes();

                        System.out.println("La startup a " + listeEmployes.length);
                        System.out.println(
                                        "Le budget total des projets est de " + startup.calculerBudgetTotal() + "CHF");
                        System.out.println("---------------------------------");
                }

                return startup;

        }

}
