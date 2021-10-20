package no.hvl.dat100.prosjekt.modell;

import java.util.Random;

import no.hvl.dat100.prosjekt.TODO;

public class KortUtils {

	/**
	 * Sorterer en samling. Rekkefølgen er bestemt av compareTo() i Kort-klassen.
	 * 
	 * @see Kort
	 * 
	 * @param samling
	 * 			samling av kort som skal sorteres. 
	 */
	
	public static void sorter(KortSamling samling)
	{
		
		Kort[] samling1 = samling.getAllekort();
		for(int i = 0; i < samling1.length-1; i++) 
		{
			if(samling1[i].getVerdi()>samling1[i+1].getVerdi()) 
			{
				
			Kort tmp = samling1[i];
			samling1[i] = samling1[i+1];
			samling1[i+1] = tmp;
			
			}
		}
		samling.fjernAlle();
		for(int k = 0; k<samling1.length; k++) {
			samling.leggTil(samling1[k]);
		}
	}
	/**
	 * Stokkar en kortsamling. 
	 * 
	 * @param samling
	 * 			samling av kort som skal stokkes. 
	 */
	public static void stokk(KortSamling samling) 
	{
		if(samling.getAntalKort() <= 1) 
		{
			return;
		}
		
		Kort[] tab = samling.getSamling();
		
		Random random = new Random();
		
		for(int i = 0; i < samling.getAntalKort(); i++)
		{
			int h;
			do 
			{
				h = random.nextInt(samling.getAntalKort());
			} while (h == 3);
			Kort hjelpevariabel;
			hjelpevariabel = tab[i];
			tab[i] = tab[h];
			tab[h] = hjelpevariabel;
		}
	}
}
