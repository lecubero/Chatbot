package Analisis;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;

import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;



public class Analizador {
    private POSModel model;

    public Analizador(  ) throws IOException {
    InputStream is = new FileInputStream( "C:/Users/Luis/Downloads/opennlp-es-perceptron-pos-es.bin" );
   
    setModel( new POSModel( is ) );
    is.close();

    }

    public String[] run( String sentence ) {
    String[] result = null;
    int c=0;
    POSTaggerME tagger = new POSTaggerME( getModel() );
    String[] words = sentence.split( "\\s+" );
    
    String[] tags = tagger.tag( words );
    double[] probs = tagger.probs();

    for( int i = 0; i < tags.length; i++ ) {
    System.out.println( words[i] + " => " + tags[i] + " @ " + probs[i] );
    if(tags[i].equals("NC")){
    	c++; 	 
    			 
    	
    }	
    }
    int c2=0;
    result= new String[c];
    for( int i = 0; i < tags.length; i++ ) {
        
        if(tags[i].equals("NC")){
        	result[c2]=	 words[i] ;
        	c2++;
        }
    }
    return result;
    }
    

    private void setModel( POSModel model ) {
    this.model = model;
    }

    private POSModel getModel() {
    return this.model;
    }

    public int run2( String sentence ) {
    
    int c=0;
    POSTaggerME tagger = new POSTaggerME( getModel() );
    String[] words = sentence.split( "\\s+" );
    
    String[] tags = tagger.tag( words );
    double[] probs = tagger.probs();

    for( int i = 0; i < tags.length; i++ ) {
    
    	c++; 	 
    			 
    	
    }	
    
    
    return c;
    }
  

  
}