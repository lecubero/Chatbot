package Interfaz;

import javax.swing.JApplet;
import javax.swing.JPanel;
import java.awt.BorderLayout;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.DropMode;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

import Analisis.Analizador;
import BotPackage.CreateRobot;
import BotPackage.PandorabotsAPI;
import Crawler.Buscador;


import java.awt.TextArea;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Iterator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Principal extends JApplet {
	private CreateRobot robot;
	private String nombre;
	private Buscador buscador;
	private String robotName;
	private TextArea textArea;
	private JTextArea txtAreaUsr;
	private Analizador analizador;
//private PandorabotsAPI papi;	
	/**
	 * Create the applet.
	 */
	public Principal() {
		setForeground(Color.WHITE);
		getContentPane().setForeground(Color.WHITE);
		setBackground(Color.WHITE);
		this.setSize(10000, 10000);
		try {
			buscador= new Buscador();
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SolrServerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			analizador= new Analizador();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		nombre="Luis";
		robotName="robotV0";
		
			
				//robot= new CreateRobot();
			
				// TODO Auto-generated catch block
			
			

		getContentPane().setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 746, 299);
		getContentPane().add(panel);
		panel.setLayout(null);
		textArea = new TextArea();
		textArea.setBackground(Color.WHITE);
		textArea.setEditable(false);
		textArea.setBounds(34, 10, 679, 212);
		panel.add(textArea);
		
		txtAreaUsr = new JTextArea();
		txtAreaUsr.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					txtAreaUsr.setText("");			
			
		}				
			}
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					try {
						sendMsg();
					} catch (SolrServerException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}			
			
		}				
			}
		});

		txtAreaUsr.setBounds(34, 240, 559, 22);
		panel.add(txtAreaUsr);
		
		JButton btnSalir = new JButton("Enviar");
		btnSalir.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				
				try {
					sendMsg();
				} catch (SolrServerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				txtAreaUsr.setText("");
			}
			
		});
		btnSalir.setBounds(624, 241, 89, 23);
		panel.add(btnSalir);
		

	}
	private void sendMsg() throws SolrServerException{
		
		//pregunta de usuario
		String request=txtAreaUsr.getText();
		
		textArea.append(nombre+": "+request+"\n");
		txtAreaUsr.setText("");
		
		//txtAreaUsr.enable(false);
		//Re

		
		
			String response;
		//String response =robot.Pregunta(request);
			
		
		//textArea.append(robotName+": "+response+"\n");
			int n=analizador.run2(request);
			
			String[] sol=analizador.run(request);
		    for( int i = 0; i < sol.length; i++ ) {
		        System.out.println(sol[i] );
		    }
		    int num=sol.length;
		    
		    if(num!=0 || n==1 ){
		    
		    if (n==1){sol= new String[1];sol[0]=request;}
			SolrDocumentList solrDoc= buscador.solrquery2(sol);
			
			Iterator<SolrDocument> itr=solrDoc.iterator();
			//if(itr!=null && itr.hasNext()&& solrDoc.size()<=8){
			if( solrDoc.size()>=1 && solrDoc.size()<=8 ){
			
				
			textArea.append(robotName+": He realizado una busqueda, quiza te puede interesar alguna de estos resultados:\n");

			while(itr.hasNext()){
		          SolrDocument doc = itr.next();
		          response= (String) doc.getFieldValue("id");
		          System.out.println( (String) doc.getFieldValue("digest"));
		          
		          textArea.append(response+"\n");
			}
			
		}
		
	
			else if(solrDoc.size()==0){
				textArea.append(robotName+": "+"Lo siento. Pero lo importante es que pueda ayudarte respondiendo tus preguntas sobre la universidad."+"\n");
				}
			else{textArea.append(robotName+": "+"Podría especificar su búsqueda"+"\n");}
		}
		else{
				textArea.append(robotName+": "+"niuuuuuuuuuuuuuum nombreeeeeee"+"\n");
				}		
		
		
	}
	
	public static void main(String[] args){		
		Principal p = new Principal();
		
	}
}
