package kohteet;

/**
 * Ohjus "syntyy" vasta ammuttaessa ja lentää suborbitaalisesti kohteeseen ja räjähtää
 */
public abstract class Ohjus extends Kohde {
    public Moottori moottori; //mitä moottoria ohjus käyttää
    public int nopeus; //millä nopeudella ohjus lentää
    public int suunta; //suunta piiruina, 0= pohjoinen, 90=itä, jne
    public int tuhovoima; //tuho räjähdyksen keskuksessa
    public int tuholaajuus; //kuinka pitkälle räjähdyksen keskustasta vaikutukset yltävät
    
    public abstract void raportoi();
    
    public abstract void tuhoudu();
}
