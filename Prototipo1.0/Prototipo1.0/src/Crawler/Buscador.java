package Crawler;




import java.net.MalformedURLException;
import java.util.Iterator;

import org.apache.solr.client.solrj.SolrServerException;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.ModifiableSolrParams;



public class Buscador {
	private String url = "http://localhost:8080/solr/collection1";
	private DefaultHttpClient httpclient;
	private   SolrServer solrServer ;
	
  public Buscador() throws MalformedURLException, SolrServerException {


	  
	  httpclient = new DefaultHttpClient();
	   httpclient.getCredentialsProvider().setCredentials(
	      AuthScope.ANY, new UsernamePasswordCredentials("admin", "admin"));
	 solrServer = new HttpSolrServer(url, httpclient);
	  
  }
  public Iterator<SolrDocument> solrquery(String s) throws SolrServerException{
  
  
  SolrQuery query = new SolrQuery();
  query.setQuery(s);
  QueryResponse response = solrServer.query(query);
  SolrDocumentList documents = response.getResults();
  return  documents.iterator();


  }
} 