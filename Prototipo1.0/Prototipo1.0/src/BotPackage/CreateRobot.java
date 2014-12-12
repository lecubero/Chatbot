package BotPackage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * Sample Main.java class that tests the Pandorabots API.
 *
 * 1. Create a bot named alice2.
 * 2. Delete the bot (testing delete)
 * 3. Create the bot alice2 again.
 * 4. Upload some AIML files, a config file and an AIML Set file.
 * 5. Compile the bot
 * 6. Talk to the bot as "user123".
 *
 * Created by User on 6/26/2014.
 */

public class CreateRobot {
	 private PandorabotsAPI papi;
	 
	public static String botname = "ucmbot";
  
    public CreateRobot ()  {
        System.out.println("pb-java version "+ MagicParameters.version);
        MagicParameters.readParameters();
        
        papi   = new PandorabotsAPI(MagicParameters.hostname, MagicParameters.app_id, MagicParameters.user_key);
        System.out.println("Creating bot "+botname);
        papi.createBot(botname);
        System.out.println("Deleting bot "+botname);
     
       papi.deleteBot(botname);
      
        System.out.println("Creating bot "+botname);
        papi.createBot(botname);
        
        //////////////
      //  papi.uploadFile(botname, "C:/Users/Luis/Desktop/chatbox/Prototipo1.0/bot/bot/aparienciaFisica.aiml");
       // papi.uploadFile(botname, "C:/Users/Luis/Desktop/chatbox/Prototipo1.0/bot/bot/astrologia.aiml");
     //   papi.uploadFile(botname, "C:/Users/Luis/Desktop/chatbox/Prototipo1.0/bot/bot/atributosPsicologicos.aiml");
     //   papi.uploadFile(botname, "C:/Users/Luis/Desktop/chatbox/Prototipo1.0/bot/bot/conectores.aiml");
     //   papi.uploadFile(botname, "C:/Users/Luis/Desktop/chatbox/Prototipo1.0/bot/bot/edad.aiml");
     //   papi.uploadFile(botname, "C:/Users/Luis/Desktop/chatbox/Prototipo1.0/bot/bot/estadoAnimo.aiml");
     //   papi.uploadFile(botname, "C:/Users/Luis/Desktop/chatbox/Prototipo1.0/bot/bot/familia.aiml");
     //   papi.uploadFile(botname, "C:/Users/Luis/Desktop/chatbox/Prototipo1.0/bot/bot/galaia.aiml");
    //    papi.uploadFile(botname, "C:/Users/Luis/Desktop/chatbox/Prototipo1.0/bot/bot/genero.aiml");
    //    papi.uploadFile(botname, "C:/Users/Luis/Desktop/chatbox/Prototipo1.0/bot/bot/infoUsuario.aiml");
   //     papi.uploadFile(botname, "C:/Users/Luis/Desktop/chatbox/Prototipo1.0/bot/bot/insultos.aiml");
   //     papi.uploadFile(botname, "C:/Users/Luis/Desktop/chatbox/Prototipo1.0/bot/bot/nacionalidades.aiml");
   //     papi.uploadFile(botname, "C:/Users/Luis/Desktop/chatbox/Prototipo1.0/bot/bot/nombres.aiml");
        //papi.uploadFile(botname, "C:/Users/Luis/Desktop/chatbox/Prototipo1.0/bot/bot/profesiones.aiml");
  //      papi.uploadFile(botname, "C:/Users/Luis/Desktop/chatbox/Prototipo1.0/bot/bot/respuestaGenerales.aiml");
   //     papi.uploadFile(botname, "C:/Users/Luis/Desktop/chatbox/Prototipo1.0/bot/bot/saludos.aiml");
        papi.uploadFile(botname, "C:/Users/Luis/Desktop/chatbox/Prototipo1.0/bot/saludo.aiml");

        
        ////////////////////////////////////77
        
        
       // System.out.println("Upload file sexo to "+botname);
      // papi.uploadFile(botname, "bot/default.aiml");
    //  System.out.println("Upload file sexo to "+botname);
   //   papi.uploadFile(botname, "bot/sara.aiml");
     // System.out.println("Upload file sexo to "+botname);
   //   papi.uploadFile(botname, "bot/sexo.aiml");
     //   System.out.println("Compiling bot "+botname);
        papi.compileBot(botname);
        System.out.println("Talk to "+botname);
        
            
        
        
        
        /////////////////////////////////
        
   /*     System.out.println("Compiling bot "+botname);
        papi.compileBot(botname);
        System.out.println("Talk to "+botname);
        
        BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
        while (true) {
			
		
        String request=buffer.readLine();
        
        System.out.println("Human: "+request);
       
        String response = papi.talk(botname, "luis", request);
        System.out.println("Human: "+request);
        System.out.println("Robot: "+response);
        }
        /*for (int i = 0; i < inputs.length; i++) {
            String request = inputs[i];
            String response = papi.talk(botname, "user123", request);
            System.out.println("Human: "+request);
            System.out.println("Robot: "+response);
        }*/
       /* for (int i = 0; i < inputs.length; i++) {
            String request = inputs[i];
            String response = papi.debugBot(botname, request, false, true, false);
            System.out.println("Human: "+request);
            System.out.println("Robot: "+response);

        }*/
    }
    public PandorabotsAPI getPapi() {
	return papi;
	}
    
  
    public String Pregunta(String request) {
		
		// TODO Auto-generated method stub
		return papi.talk(botname, request);
	}

}