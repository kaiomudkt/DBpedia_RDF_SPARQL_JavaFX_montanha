package dao;

import java.util.List;
import org.eclipse.rdf4j.model.vocabulary.FOAF;
import org.eclipse.rdf4j.model.vocabulary.RDF;
import org.eclipse.rdf4j.model.vocabulary.RDFS;
import org.eclipse.rdf4j.query.BindingSet;
import org.eclipse.rdf4j.query.QueryResults;
import org.eclipse.rdf4j.query.TupleQuery;
import org.eclipse.rdf4j.query.TupleQueryResult;
import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.eclipse.rdf4j.repository.sparql.SPARQLRepository;

public class ObjetoDeAcessoAosDados {

    /**
     * Essa consulta retorna uma lista contendo todas as montanhas e suas
     * determinadas: Área Localizada, Elevações, Ano de Ascensão.
     *
     * @return QueryResults.asList(result)
     */
    public List<BindingSet> consultaListaMontanhasDoMundo() {
        Repository repo = new SPARQLRepository("http://dbpedia.org/sparql");
        repo.init();
        try (RepositoryConnection conn = repo.getConnection()) {
            String queryString = getPrefixes();
            queryString += "SELECT ?Montanha ?Elevacao ?Area_Localizada ?Ano_Subida WHERE {";
            queryString += " ?Montanha rdf:type dbo:Mountain .";
            queryString += " ?Montanha dbo:firstAscentYear ?Ano_Subida .";
            queryString += " ?Montanha dbo:locatedInArea ?Area_Localizada .";
            queryString += " ?Montanha dbo:elevation ?Elevacao .";
            queryString += "}";
            TupleQuery query = conn.prepareTupleQuery(queryString);
            try (TupleQueryResult result = query.evaluate()) {
                return QueryResults.asList(result);
            }
        } finally {
            repo.shutDown();
        }
    }

    /**
     * Retorna string com lista de prefixos comuns.
     *
     * @return
     */
    private String getPrefixes() {
        String prefixes = "";
        prefixes += "PREFIX foaf: <" + FOAF.NAMESPACE + "> \n";
        prefixes += "PREFIX rdf: <" + RDF.NAMESPACE + "> \n";
        prefixes += "PREFIX rdfs: <" + RDFS.NAMESPACE + "> \n";
        prefixes += "PREFIX dbo: <http://dbpedia.org/ontology/> \n";
        prefixes += "PREFIX dbr: <http://dbpedia.org/resource/> \n";
        prefixes += "PREFIX dct: <http://purl.org/dc/terms/> \n";
        prefixes += "PREFIX dbc: <http://dbpedia.org/resource/Category:> \n";
        return prefixes;
    }

    /**
     * método receberá uma String pais, e pesquisara todas as montanhas deste
     * pais
     *
     * @param pais
     * @return
     */
    public List<BindingSet> buscaMontanhasDestePais(String linkPais) {
        Repository repo = new SPARQLRepository("http://dbpedia.org/sparql");
        repo.init();
        try (RepositoryConnection conn = repo.getConnection()) {
            String queryString = getPrefixes();
            queryString += "SELECT ?Montanha ?Elevacao ?Area_Localizada ?Ano_Subida ?Lugar WHERE {";
            queryString += " ?Montanha rdf:type dbo:Mountain .";
            queryString += " ?Montanha dbo:firstAscentYear ?Ano_Subida .";
            queryString += " ?Montanha dbo:locatedInArea ?Area_Localizada .";
            queryString += " ?Montanha dbo:elevation ?Elevacao .";
            queryString += " ?Montanha dbo:mountainRange ?Lugar .";
            //queryString += " ?Lugar  dbo:country <http://dbpedia.org/resource/"+pais+"> .";//static
            queryString += " ?Lugar  dbo:country <"+linkPais+"> .";//dinamico
            queryString += "}";
            TupleQuery query = conn.prepareTupleQuery(queryString);
            try (TupleQueryResult result = query.evaluate()) {
                return QueryResults.asList(result);
            }
        } finally {
            repo.shutDown();
        }
    }
    
    
    
    /**
     * cria uma lista de todas as montanhas de um continente
     * @return 
     */
    public List<BindingSet> consultaListaMontanhasDeDeterminadoContinente(String continente) {
        Repository repo = new SPARQLRepository("http://dbpedia.org/sparql");
        repo.init();
        try (RepositoryConnection conn = repo.getConnection()) {
            String queryString = getPrefixes();
            queryString += "SELECT ?Montanha ?Elevacao ?Pais ?Continente WHERE {";
            queryString += " ?Montanha rdf:type dbo:Mountain .";
            queryString += " ?Montanha dbo:elevation ?Elevacao .";
            queryString += " ?Montanha dbo:locatedInArea ?Pais.";
            queryString += " ?Continente skos:broader dbc:Countries_in_Asia.";
            queryString += " ?Pais rdfs:label  ?nome .";
            queryString += " FILTER(lang(?nome) = 'en')";
            queryString += "}";
            TupleQuery query = conn.prepareTupleQuery(queryString);
            try (TupleQueryResult result = query.evaluate()) {
                return QueryResults.asList(result);
            }
        } finally {
            repo.shutDown();
        }
    }
    
    
    
    
    /**
     * Lista todos os paises de um continente
     * essa consulta retorna todo os paises de um determinado continente
     * @param continente
     * @return 
     */
    public List<BindingSet> listaTodosPaisesDoContinente(String continente) {
        System.out.println("DAO, continente: "+continente);
        Repository repo = new SPARQLRepository("http://dbpedia.org/sparql");
        repo.init();
        try (RepositoryConnection conn = repo.getConnection()) {
            String queryString = getPrefixes();
            queryString += "select ?Pais where { ";        //NAO ESQUECER the_americas
            queryString += " ?Pais dct:subject  dbc:Countries_in_"+continente+" . ";
            queryString += " ?Pais rdf:type dbo:Country .";
            queryString += "}";
            TupleQuery query = conn.prepareTupleQuery(queryString);
            try (TupleQueryResult result = query.evaluate()) {
                return QueryResults.asList(result);
            }
        } finally {
            repo.shutDown();
        }
    }
    
    
}//fim 