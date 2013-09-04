package kohteet;

/**
 *Kohteiden aliluokka, kaikkien rakennusten yläluokka. Rakennukset kuluttavat
 * tuotteita niin kauan kuin ovat aktiivisia, jos jokin päätuote loppuu, rakennus
 * sammuttaa itsensä. Sekundäärituotteiden loppuminen aiheuttaa muita muutoksia
 * mutta ei sammuta rakennusta
 */
public abstract class Rakennus extends Kohde {
    //välttämättömät tuotteet
    public double metallikulutus; //kuinka paljon metallia kuluu tunnissa
    public double ilmakulutus; //kuinka paljon ilmaa kuluu tunnissa
    public double vesikulutus; //kuinka paljon vettä kuluu tunnissa
    
        //ruoka kulutetaan niin että ensin käytetään luksusruoka, sitten normaali ja halpis
        public double halpisruokakulutus; //kuinka paljon halpisruokaa kuluu tunnissa
        public double normaaliruokakulutus; //kuinka paljon normaaliruokaa kuluu tunnissa
        public double luksusruokakulutus; //kuinka paljon luksusruokaa kuluu tunnissa
    
    //sekundäärituotteet
    public double alkoholikulutus; //kuinka paljon alkoholia kuluu tunnissa
    public double laakekulutus; //kuinka paljon lääkkeitä kuluu tunnissa
    public int siemenkulutus; //kuinka paljon siemeniä kuluu tunnissa
    
    //tilaan liittyvät
    public boolean aktiivinen; //onko rakennus aktiivinen vai ei
    
    public abstract void asetaTehtava(int i);
    
    public abstract void idlaa();
    
    public abstract void aktivoi();
    
    public abstract void deaktivoi();
    
    public abstract void raportoi();
    
    public abstract void inventaario();
}

/*
 
 //välttämättömät tuotteet
    metallikulutus;
    ilmakulutus;
    vesikulutus;
    
        //ruoka kulutetaan niin että ensin käytetään luksusruoka, sitten normaali ja halpis
        halpisruokakulutus;
        normaaliruokakulutus;
        luksusruokakulutus;
    
    //sekundäärituotteet
    alkoholikulutus;
    laakekulutus;
    siemenkulutus;
    
    //tilaan liittyvät
    aktiivinen;
 */