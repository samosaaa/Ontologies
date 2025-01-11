package org.example;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.*;

public class OntologyManipulator {
    public static void main(String[] args) {
        try {
            // Gestionnaire et générateur d'éléments OWL
            OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
            OWLDataFactory factory = manager.getOWLDataFactory();

            // Créer une nouvelle ontologie
            OWLOntology ontology = manager.createOntology();

            // Ajouter une classe
            IRI classIRI = IRI.create("http://example.com#NewClass");
            OWLClass newClass = factory.getOWLClass(classIRI);

            // Ajouter une déclaration à l'ontologie
            OWLAxiom classAxiom = factory.getOWLDeclarationAxiom(newClass);
            manager.addAxiom(ontology, classAxiom);

            System.out.println("Classe ajoutée : " + newClass);
        } catch (OWLOntologyCreationException e) {
            e.printStackTrace();
        }
    }
}
