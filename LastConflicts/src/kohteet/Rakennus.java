package kohteet;

/**
 *Kohteiden aliluokka, kaikkien rakennusten yläluokka. Rakennukset kuluttavat
 * tuotteita niin kauan kuin ovat aktiivisia, jos jokin päätuote loppuu, rakennus
 * sammuttaa itsensä. Sekundäärituotteiden loppuminen aiheuttaa muita muutoksia
 * mutta ei sammuta rakennusta
 */
public abstract class Rakennus extends Kohde {
    //välttämättömät tuotteet
    public double metalli;
    public double metallikulutus; //kuinka paljon metallia kuluu tunnissa
    public double ilma;
    public double ilmakulutus; //kuinka paljon ilmaa kuluu tunnissa
    public double vesi;
    public double vesikulutus; //kuinka paljon vettä kuluu tunnissa
    
        //ruoka
        public double halpisruoka;
        public double halpisruokakulutus; //kuinka paljon halpisruokaa kuluu tunnissa
        public double normaaliruoka;
        public double normaaliruokakulutus; //kuinka paljon normaaliruokaa kuluu tunnissa
        public double luksusruoka;
        public double luksusruokakulutus; //kuinka paljon luksusruokaa kuluu tunnissa
    
    //sekundäärituotteet
    public double alkoholi;
    public double alkoholikulutus; //kuinka paljon alkoholia kuluu tunnissa
    public double laake;
    public double laakekulutus; //kuinka paljon lääkkeitä kuluu tunnissa
    public double siemen;
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
    metalli; 
    metallikulutus;
    ilma; 
    ilmakulutus;
    vesi; 
    vesikulutus;
    
        //ruoka kulutetaan niin että ensin käytetään luksusruoka, sitten normaali ja halpis
        halpisruoka;
        halpisruokakulutus;
        normaaliruoka;     
        normaaliruokakulutus;
        luksusruoka;     
        luksusruokakulutus;
    
    //sekundäärituotteet
    alkoholi;
    alkoholikulutus;
    laake;
    laakekulutus;
    siemen;
    siemenkulutus;
    
    //tilaan liittyvät
    aktiivinen;
 */