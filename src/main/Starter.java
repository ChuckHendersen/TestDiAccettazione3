package main;

import java.net.*;

public class Starter {

	public static void main(String[] args) throws Throwable {
		//Controlla cosa è presente nel classpath
		
		ClassLoader cl = ClassLoader.getSystemClassLoader();
        URL[] urls = ((URLClassLoader)cl).getURLs();
        for(URL url: urls){
        	System.out.println(url.getFile());
        }
        System.out.println("");
        Controllore c = new Controllore();
		if(c.testDiUnitaLabirintoBuilder()&&c.controlloMetodiBorsa()&&c.esisteLabirintoBuilder()){
        //terzo argomento: "C:/Users/giovi/workspace2/TestDiAccettazione/test/Features/"
		io.cucumber.core.cli.Main.main(new String[]{"-g", "classpath:"});
		}else{
			System.out.println("ATTENZIONE! uno o piu' dei controlli prima della consegna "
					+ "non e' andato a buon fine,\nsistemare gli errori prima di poter avviare "
					+ "i test di accettazione. Buon lavoro!");
		}
	} 
}
