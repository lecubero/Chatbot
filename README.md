Chatbot
=======

Se irán añadiendo los avances del proyecto:

Buscador:

Se ha realizado un Japplet en java muy sencillo en el que se ha indexado la pag web:http://informatica.ucm.es/

Con el crawler apache-nutch-1.4-bin , y se ha indexado la información con solr-4.10.1, y se esta utilizando el servlet tomcat 7.0

La palicacion java realiza una http request al servidor (localhost de  tomcat) y devuelve un conjunto de paginas web donde aparece la palabra buscada.

