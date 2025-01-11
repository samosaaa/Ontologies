package org.example;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.*;

import java.io.File;

public class OntologyLoader {
    public static void main(String[] args) {
        try {
            // Créer un gestionnaire d'ontologies
            OWLOntologyManager manager = OWLManager.createOWLOntologyManager();

            // Charger l'ontologie depuis un fichier
            File file = new File("chemin/vers/votre/ontologie.owl");
            OWLOntology ontology = manager.loadOntologyFromOntologyDocument(file);

            // Afficher les informations de base
            System.out.println("Ontologie chargée : " + ontology.getOntologyID());
            System.out.println("Nombre de classes : " + ontology.classesInSignature().count());
        } catch (OWLOntologyCreationException e) {
            e.printStackTrace();
        }
    }
}
