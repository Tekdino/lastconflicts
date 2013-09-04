package kohteet;

/**
 * Kohteiden aliluokka, kaikkien alusten yläluokka
 */
public abstract class Alus {
    public Moottori moottori; //mitä moottoria käytetään
    public int cruiseNopeus; //cruise-nopeus
    public Ase ase; //mitä asetta käytetään
    public int ohjuskapasiteetti; //montako ohjusta alukseen mahtuu
    public Ohjus[] ohjukset; //mitä ohjuksia alukseen on lastattu
    public int rcsnopeus; //kuinka nopeasti alus kääntyy
    
    //tilaan liittyvät
    public int nopeus; //nopeus tällä hetkellä
    public int suunta; //suunta piiruina, 0=pohjoinen, 90=itä, jne
    public int tukikohta; //mihin palaa tankkaamaa tai mihin tuo resurssit jne
    
    public abstract void asetaTehtava();
    
    public abstract void idlaa();
    
    public abstract void raportoi();
    
    public abstract void siirry(double pituus, double leveys);
    
    public abstract void siirry(String kaupunki);
}
