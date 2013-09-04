package kohteet;

/**
 *Kohteiden aliluokka, kaikkien rakennusten yläluokka. Rakennukset kuluttavat
 * tuotteita niin kauan kuin ovat aktiivisia, jos jokin päätuote loppuu, rakennus
 * sammuttaa itsensä. Sekundäärituotteiden loppuminen aiheuttaa muita muutoksia
 * mutta ei sammuta rakennusta
 */
public abstract class Rakennus extends Kohde {
    //välttämättömät tuotteet
    public int metallikulutus; //kuinka paljon metallia kuluu tunnissa
    public int ilmakulutus; //kuinka paljon ilmaa kuluu tunnissa
    public int vesikulutus; //kuinka paljon vettä kuluu tunnissa
    
        //ruoka kulutetaan niin että ensin käytetään luksusruoka, sitten normaali ja halpis
        public int halpisruokakulutus; //kuinka paljon halpisruokaa kuluu tunnissa
        public int normaaliruokakulutus; //kuinka paljon normaaliruokaa kuluu tunnissa
        public int luksusruokakulutus; //kuinka paljon luksusruokaa kuluu tunnissa
    
    //sekundäärituotteet
    public int alkoholikulutus; //kuinka paljon alkoholia kuluu tunnissa
    public int laakekulutus; //kuinka paljon lääkkeitä kuluu tunnissa
    public int teho; //tällä lasketaan paljonko polttoainetta kuluu tunnissa
    public int siemenkulutus; //kuinka paljon siemeniä kuluu tunnissa
    
    //tilaan liittyvät
    public boolean aktiivinen; //onko rakennus aktiivinen vai ei
    
    public abstract void asetaTehtava();
    
    public abstract void idlaa();
    
    public abstract void aktivoi();
    
    public abstract void deaktivoi();
    
    public abstract void raportoi();
    
    public abstract void inventaario();
}
