package org.example;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.*;
import org.semanticweb.HermiT.Reasoner.ReasonerFactory;
import org.semanticweb.owlapi.reasoner.OWLReasoner;

public class OntologyReasoning {
    public static void main(String[] args) {
        try {
            OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
            OWLOntology ontology = manager.loadOntologyFromOntologyDocument(new File("chemin/vers/ontologie.owl"));

            // Créer un raisonneur
            ReasonerFactory reasonerFactory = new ReasonerFactory();
            OWLReasoner reasoner = reasonerFactory.createReasoner(ontology);

            // Afficher les sous-classes d'une classe donnée
            OWLDataFactory factory = manager.getOWLDataFactory();
            OWLClass parentClass = factory.getOWLClass(IRI.create("http://example.com#YourClass"));

            reasoner.getSubClasses(parentClass, true).forEach(subClass -> {
                System.out.println("Sous-classe : " + subClass);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
