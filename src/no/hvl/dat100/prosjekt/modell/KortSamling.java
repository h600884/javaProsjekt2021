package no.hvl.dat100.prosjekt.modell;

import no.hvl.dat100.prosjekt.TODO;
import no.hvl.dat100.prosjekt.kontroll.dommer.Regler;
import java.lang.Object;

/**
 * Struktur for å lagre ei samling kort. Kan lagre hele kortstokken. Det finnes
 * en konstant i klassen Regler som angir antall kort i hver av de 4 fargene. Når
 * programmet er ferdig settes denne til 13, men under utvikling / testing kan
 * det være praktisk å ha denne mindre.
 * 
 */
public class KortSamling 
{

	private final int MAKS_KORT = 4 * Regler.MAKS_KORT_FARGE;

	private Kort[] samling;
	private int antall;

	/**
	 * Oppretter en tom Kortsamling med plass til MAKS_KORT (hele kortstokken).
	 */
	
	public KortSamling()
	{
		
		samling = new Kort[MAKS_KORT];
		antall = 0;
		
	}

	/**
	 * Returnerer en tabell med kortene i samlinga. Tabellen trenger ikke være
	 * full. Kortene ligger sammenhengende fra starten av tabellen. Kan få
	 * tilgang til antallet ved å bruke metoden getAntallKort(). Metoden er
	 * først og fremst ment å brukes i testklasser. Om man trenger
	 * kortene utenfor, anbefales metoden getAlleKort().
	 * 
	 * @return tabell av kort.
	 */
	public Kort[] getSamling() 
	{
		
		return samling; 
			
	}
	
	/**
	 * Antall kort i samlingen.
	 * 
	 * @return antall kort i samlinga.
	 */
	public int getAntalKort() 
	{
		
		return antall;
		
	}
	/**
	 * Sjekker om samlinga er tom.
	 * 
	 * @return true om samlinga er tom, false ellers.
	 */
	public boolean erTom() 
	{
		
		return antall == 0; 

	}		
	/**
	 * Legg et kort til samlinga.
	 * 
	 * @param kort
	 *            er kortet som skal leggast til.
	 */
	public void leggTil(Kort kort) 
	{
		
		if(antall != 52 && !har(kort))
		{
			samling[antall] = kort; 
			antall++;
			
		}	
}	
	/**
	 * Legger alle korta (hele kortstokken) til samlinga. Korta vil være sortert
	 * slik at de normalt må stokkes før bruk.
	 */
	public void leggTilAlle() 
	{
		
		for(int i = 0; i < samling.length; i++) {
			for(int j = 1; j <= Regler.MAKS_KORT_FARGE; j++) {
				if(i <=12) {
					leggTil(new Kort(Kortfarge.Hjerter, j));
					
					
				}else if(i <= 25) {
					leggTil(new Kort(Kortfarge.Ruter, j));
					
				}else if( i <= 38) {
					leggTil(new Kort(Kortfarge.Klover, j));
					
				}else {
					leggTil(new Kort(Kortfarge.Spar, j)); 
					 
				}
			}
		}
	}

	/**
	 * Fjerner alle korta fra samlinga slik at den blir tom.
	 */
	public void fjernAlle() 
	{
		
		antall= 0;
	}
	
	/**
	 * Ser på siste kortet i samlinga.
	 * 
	 * @return siste kortet i samlinga, men det blir ikke fjernet. Dersom samalinga er tom, returneres
	 *         null.
	 */
	public Kort seSiste() 
	{
		
		int k = 0;
		for(int i = 0; i < antall && samling[i] !=null; i++) 
		{
			k = i;
		}
		return samling[k];
		
	}

	/**
	 * Tek ut siste kort fra samlinga.
	 * 
	 * @return siste kortet i samlinga. Dersom samalinga er tom, returneres
	 *         null.
	 */
	public Kort taSiste() 
	{
	
		if( !erTom()) 
		{
			antall --;
			Kort kort = samling[antall];
			return kort;
		}
		return null;
	}
	
//	if( !erTom())
//	{
//		antall--;
//		samling[antall];
//		return samling[antall];
//	}
//	return null;
	/**
	 * Undersøker om et kort finst i samlinga.
	 * 
	 * @param kort.
	 * 
	 * @return true om kortet finst i samlinga, false ellers.
	 */
	public boolean har(Kort kort)
	{
		if(kort == null) {
			return false; 
			
		}
		
		for(int i = 0; i < antall; i++) {
			if(samling[i].getFarge().equals(kort.getFarge()) && samling[i].getVerdi() == (kort.getVerdi())) {
				return true; 
			}
		}
		return false; 
	}

	/**
	 * Fjernar et kort frå samlinga. Dersom kortet ikke finnest i samlinga,
	 * skjer ingenting med samilingen
	 * 
	 * @param kort
	 *            kortet som skal fjernast. Dersom kortet ikke finnes, skjer
	 *            ingenting.
	 * @return true om kortet blev fjernet fra samlinga, false ellers.
	 */
			 
	public boolean fjern(Kort kort) 
	{
		
		boolean funnet = false;
		if(har(kort) == true) 
		{
			for(int i = 0; i < antall; i++) 
			{
				if(samling[i].equals(kort) || funnet) 
				{
					funnet = true;
					samling[i] = samling[i+1];
				}
			}
			antall--;
			return true;
		} 
		return false;	
		
		
	}

	/**
	 * Gir kortene som en tabell av samme lengde som antall kort i samlingen
	 * 
	 * @return tabell av kort som er i samlingen, der kort skal ha samme rekkefølge
	 *         som i kortsamlinga.
	 */
	public Kort[] getAllekort()
	{
//	for(int i = 0; i < samling.length; i++) {

//	}
	Kort [] tabell = new Kort[antall];
	for(int i = 0; i < antall; i++) 
	{
		tabell[i] = samling[i];
	}
	return tabell;
	}
	
}
