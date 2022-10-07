package main;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Controllore {

	public boolean controlloMetodiBorsa() {
		String nomeAtteso = "it.uniroma3.diadia.giocatore.Borsa";

		try {
			Class<?> classeDaControllare = Class.forName(nomeAtteso);
			Method[] metodiDaControllare = classeDaControllare.getDeclaredMethods();
			Boolean trovatoGetContenutoOrdinatoPerPeso= false;
			Boolean trovatoGetContenutoOrdinatoPerNome= false;
			Boolean trovatoGetContenutoRaggruppatoPerPeso= false;
			Boolean trovatoSortedSetOrdinatoPerPeso = false;
			for(Method method : metodiDaControllare) {
				if(method.getName().equals("getContenutoOrdinatoPerPeso")) {
					trovatoGetContenutoOrdinatoPerPeso= true;
				}
				if(method.getName().equals("getContenutoOrdinatoPerNome")) {
					trovatoGetContenutoOrdinatoPerNome= true;
				}
				if(method.getName().equals("getContenutoRaggruppatoPerPeso")) { 
					trovatoGetContenutoRaggruppatoPerPeso= true;
				}
				if(method.getName().equals("getSortedSetOrdinatoPerPeso")) {
					trovatoSortedSetOrdinatoPerPeso= true;
				}
			}
			if(trovatoGetContenutoOrdinatoPerPeso) {
				System.out.println("Ok! Esiste getContenutoOrdinatoPerPeso");
			}
			else { 
				System.out.println("Attenzione! Non esiste  il metodo getContenutoOrdinatoPerPeso");
			}
			if(trovatoGetContenutoOrdinatoPerNome) {
				System.out.println("Ok! Esiste getContenutoOrdinatoPerNome");
			}
			else { 
				System.out.println("Attenzione! Non esiste  il metodo getContenutoOrdinatoPerNome");
			}
			if(trovatoGetContenutoRaggruppatoPerPeso) {
				System.out.println("Ok! Esiste getContenutoRaggruppatoPerPeso");
			}
			else { 
				System.out.println("Attenzione! Non esiste  il metodo getContenutoRaggruppatoPerPeso");
			}
			if(trovatoSortedSetOrdinatoPerPeso) {
				System.out.println("Ok! Esiste getSortedSetOrdinatoPerPeso");
			}
			else { 
				System.out.println("Attenzione! Non esiste  il metodo getSortedSetOrdinatoPerPeso");
			}
			return trovatoGetContenutoOrdinatoPerNome&&trovatoGetContenutoOrdinatoPerPeso&&trovatoGetContenutoRaggruppatoPerPeso&&trovatoSortedSetOrdinatoPerPeso;
		} catch (ClassNotFoundException e) {
			System.out.println("Attenzione! la classe Borsa non esiste, e' stata chiamata diversamente o e' nel package sbagliato.\n");
			return false;
		}


	}

	public boolean esisteLabirintoBuilder() {
		String nomeAtteso = "it.uniroma3.diadia.ambienti.LabirintoBuilder";
		try {
			@SuppressWarnings("unused")
			Class<?> classeDaControllare = Class.forName(nomeAtteso);
			System.out.println("OK! Esiste la classe LabirintoBuilder");
			return true;
		} catch (ClassNotFoundException e) {
			System.out.println("Attenzione, la classe LabirintoBuilder non e' implementata, ha un nome diverso o e' nel paclage sbagliato!");
			return false;
		}	
	}

	
	//NON IMPLEMENTABILE CON RIFLESSIONE ???
	@SuppressWarnings("unused")
	public boolean testDiUnitaLabirintoBuilder() {
		Class<?> labBuilderClass = null;
		try {
			labBuilderClass=Class.forName("it.uniroma3.diadia.ambienti.LabirintoBuilder");
			Constructor<?> costruttoreLabBuilder = null;
			costruttoreLabBuilder = labBuilderClass.getConstructor();
			//Utilizziamo questa mappa per facilitare l'accesso ai metodi nei test
			Map<String,Method> mappaMetodi = new HashMap<>();
			Method addStanzaIniziale = labBuilderClass.getMethod("addStanzaIniziale",String.class);
			mappaMetodi.put("addStanzaIniziale", addStanzaIniziale);
			
 			Method addStanzaVincente = labBuilderClass.getMethod("addStanzaVincente",String.class);
 			mappaMetodi.put("addStanzaVincente", addStanzaVincente);
 			
			Method addStanza = labBuilderClass.getMethod("addStanza",String.class);
			mappaMetodi.put("addStanza", addStanza);
			
			Method addStanzaMagica = labBuilderClass.getMethod("addStanzaMagica", String.class,int.class);
			mappaMetodi.put("addStanzaMagica", addStanzaMagica);
			
			Method addStanzaBloccata = labBuilderClass.getMethod("addStanzaBloccata", String.class, String.class, String.class);
			mappaMetodi.put("addStanzaBloccata", addStanzaBloccata);
			
			Method addStanzaBuia = labBuilderClass.getMethod("addStanzaBuia", String.class, String.class);
			mappaMetodi.put("addStanzaBuia",addStanzaBuia);
			
			Method addAdiacenza = labBuilderClass.getMethod("addAdiacenza",String.class,String.class,String.class);
			mappaMetodi.put("addAdiacenza", addAdiacenza);
			
			Method addAttrezzo = labBuilderClass.getMethod("addAttrezzo",String.class,int.class);
			mappaMetodi.put("addAttrezzo", addAttrezzo);
			
			Method getLabirinto = labBuilderClass.getMethod("getLabirinto");
			mappaMetodi.put("getLabirinto", getLabirinto);
			//Si inseriscono i metodi in un array per facilitare l'utilizzo di essi in altri metodi
			//CONVERTIRE I TEST DI UNITA'
//			testMonolocale(costruttoreLabBuilder,mappaMetodi);
			
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
			System.out.println("Test di unità per LabirintoBuilder non superati con successo.");
			System.out.println("Assicurarsi dell'esistenza della classe LabirintoBuilder e che i suoi metodi siano chiamati appropriatamente.");
			return false;
		}
		return true;
	}
	
//	private void testMonolocale(Constructor<?> cnstrLabBuilder,Map<String,Method> metodiLabBuilder) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
//		Object labBuilderObj = null;
//		labBuilderObj = cnstrLabBuilder.newInstance();
//		metodiLabBuilder.get("addStanzaIniziale").invoke(labBuilderObj,"Stanza 1");
//	}
	
}

