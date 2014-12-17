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
  public Iterator<SolrDocument> deleteDiggest(  SolrDocumentList E){
	 E.iterator();
	  
	//  while(E.hasNext()){
      //    SolrDocument doc = E.next();
          
         // String response= (String) doc.getFieldValue("id");
         
//	}
	  
	  return null;
	  
  }
 /* public Iterator<SolrDocument> solrquery2(String[] nombres) throws SolrServerException{
	  
		  
	  SolrQuery query = new SolrQuery();
	  SolrDocumentList documents=null;
	  QueryResponse response;
	  String q;
	  int c=nombres.length;
	  if (c==1){
		   q="id:*"+nombres[0]+"*";
		  query.setQuery(q);
		  response = solrServer.query(query);
		  documents = response.getResults();
		  if(documents.size()==1){return documents.iterator();}
		  else{
			  
			  q="content:*"+nombres[0]+"*";
			  query.setQuery(q);
			  response = solrServer.query(query);
			  documents = response.getResults();
			  if(documents.size()>=1 && documents.size()<=8 ){return documents.iterator();}
			  else if(documents.size()>8){return documents.iterator();}
			  else if(documents.size()==0){return null;}
			  }
			  
			  
			  
	}
	  
	  else if (c>1){
		  q="id:*"+nombres[0]+"* "+"AND id:*"+nombres[1]+"*";
		  query.setQuery(q);
		  response = solrServer.query(query);
		 
		  documents = response.getResults();
		  if(documents.size()>=1  && documents.size()<8){return documents.iterator();}
		  else{
			  q="id:*"+nombres[0]+"* "+"OR id:*"+nombres[1]+"*";  
			  query.setQuery(q);
			  response = solrServer.query(query);
			  documents = response.getResults();
			  if(documents.size()>=1 && documents.size()<8){return documents.iterator();}
			  else{
				  q="content:*"+nombres[0]+"* "+"AND content:*"+nombres[1]+"*";  
				  query.setQuery(q);
				  response = solrServer.query(query);
				  documents = response.getResults();
				  if(documents.size()>=1  && documents.size()<8){return documents.iterator();}
				  else{
					  q="content:*"+nombres[0]+"* "+"OR content:*"+nombres[1]+"*";  
					  query.setQuery(q);
					  response = solrServer.query(query);
					  documents = response.getResults();
					  if(documents.size()>=1  && documents.size()<8){return documents.iterator();}
					  else {return null;}
				  }
			  }
			  
			  
			  
			  
		  }
		  
			  
			  
			  
		  }
		  
	  
	  return documents.iterator();
  }
	  
*/
  public SolrDocumentList solrquery2(String[] nombres) throws SolrServerException{
	  
	  
	  SolrQuery query = new SolrQuery();
	  SolrDocumentList documents=null;
	  QueryResponse response;
	  String q;
	  int c=nombres.length;
	  if (c==1){
		   q="id:*"+nombres[0]+"*";
		  query.setQuery(q);
		  response = solrServer.query(query);
		  documents = response.getResults();
		  if(documents.size()==1){return documents;}
		  else{
			  
			  q="content:"+nombres[0];
			  query.setQuery(q);
			  response = solrServer.query(query);
			  documents = response.getResults();
			  
			  if(documents.size()>=1 && documents.size()<=8 ){return documents;}
			  else if(documents.size()>8){return documents;}
			  else if(documents.size()==0){return documents;}
			  }
			  
			  
			  
	}
	  
	  else if (c>1){
		  q="id:*"+nombres[0]+"* "+"AND id:*"+nombres[1]+"*";
		  query.setQuery(q);
		  response = solrServer.query(query);
		 
		  documents = response.getResults();
		  if(documents.size()>=1  && documents.size()<8){return documents;}
		  else{
			  q="id:*"+nombres[0]+"* "+"OR id:*"+nombres[1]+"*";  
			  query.setQuery(q);
			  response = solrServer.query(query);
			  documents = response.getResults();
			  if(documents.size()>=1 && documents.size()<8){return documents;}
			  else{
				  q="content:"+nombres[0]+"AND content:"+nombres[1];  
				  query.setQuery(q);
				  response = solrServer.query(query);
				  documents = response.getResults();
				  if(documents.size()>=1  && documents.size()<8){return documents;}
				  else{
					  q="content:"+nombres[0]+"OR content:"+nombres[1];  
					  query.setQuery(q);
					  response = solrServer.query(query);
					  documents = response.getResults();
					  if(documents.size()>=1  && documents.size()<8){return documents;}
					  else {return documents;}
				  }
			  }
			  
			  
			  
			  
		  }
		  
			  
			  
			  
		  }
		  
	  
	  return documents;
  }

  }
  
 