package gui;


import javax.swing.JApplet;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

import java.awt.event.ActionListener;
import java.awt.TextArea;
import java.net.MalformedURLException;
import java.util.Iterator;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

import java.awt.SystemColor;

public class BuscadorDemo extends JApplet {
	private JTable table;
	

	/**
	 * Create the applet.
	 */
	public BuscadorDemo() {

		Object rowData[][] = null;
Object columnNames[] = { "PAth"};

final TableModel model = new DefaultTableModel(rowData, columnNames);
JTable table = new JTable(model);
table.setBounds(31, 131, 458, 254);
		getContentPane().setLayout(null);

		final JTextArea textArea = new JTextArea();
		textArea.setBounds(88, 26, 323, 22);
		getContentPane().add(textArea);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setBounds(205, 69, 97, 36);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int j = model.getRowCount()-1;
				System.out.println(j);
				for (int i=j; i >= 0; i--) {
					((DefaultTableModel) model).removeRow(i);
				}
				String url = "http://localhost:8080/solr/collection1";
				  DefaultHttpClient httpclient = new DefaultHttpClient();
				      httpclient.getCredentialsProvider().setCredentials(
				      AuthScope.ANY, new UsernamePasswordCredentials("admin", "admin"));
				  SolrServer solrServer = new HttpSolrServer(url, httpclient);
				  SolrQuery query = new SolrQuery();
				  String txt= textArea.getText();
				  query.setQuery(txt);
				  QueryResponse response;
				try {
					response = solrServer.query(query);
					SolrDocumentList documents = response.getResults();
				      Iterator<SolrDocument> itr = documents.iterator();
				      System.out.println("DOCUMENTS");
				      while(itr.hasNext()){
				          SolrDocument doc = itr.next();
				          System.out.println(doc.getFieldValue("id"));
				          ((DefaultTableModel) model).addRow(new Object[]{doc.getFieldValue("id")});
				          
				      }
					
				} catch (SolrServerException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				  

			}
		});
		
		
		getContentPane().add(btnNewButton);
		

		getContentPane().add(table);

		

	}

	
	  public static void main(String[] args) throws MalformedURLException, SolrServerException {
		  
		  new BuscadorDemo();
		  
	  }
	  }
	


