package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import it.polito.tdp.anagrammi.db.AnagrammaDAO;

public class Model {
	
	Map<String,Boolean> anag;
	AnagrammaDAO dao = new AnagrammaDAO();
	
	public Map<String,Boolean> anagramma(String s) {
		anag = new LinkedHashMap<String,Boolean>();
		anagramma_ricorsiva("", 0, s);
		return anag;
	}
	
	public void anagramma_ricorsiva(String parziale, int livello, String rimanenti) {
		if(rimanenti.length()==0) { /* caso terminale*/
			boolean c = dao.isCorrect(parziale);
			anag.put(new String(parziale), c);
		}
		else {
			/* caso normale*/
			// es: parziale="AC", livello=2, rimanenti="BD"
			for(int pos=0;pos<rimanenti.length();pos++) {
				anagramma_ricorsiva(parziale+rimanenti.charAt(pos),livello+1,rimanenti.substring(0, pos)+rimanenti.substring(pos+1));
			}
		}
	}
}
