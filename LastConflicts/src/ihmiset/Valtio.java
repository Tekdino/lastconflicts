package ihmiset;

/**
 * Jokainen kohde kuuluu jollekin valtiolle
 */
public class Valtio {
    public int valtioID; //numero jolla valtio tunnistetaan
    public int valtioNimi; //valtion nimi
    public int valtionKuvaus; //valtion bonukset ja miinukset?
    public int muuttovirta; //montako kansalaista muuttaa kerralla
    public int hyotykuorma; //paljonko tavaraa maasta voidaan tuoda kerralla
    public int[] suhteet; //kuinka paljon tykkää tai ei tykkää muista valtioista (-100...100)
    
    //valtion bonukset ja miinukset, arvot väliltä 0.85...1.15
    public double rakennustaito;
    public double ilmakehateknologia;
    public double vesiteknologia;
    public double halpisruokataito;
    public double normaaliruokataito;
    public double luksusruokataito;
    public double alkoholitaito;
    public double farmasia;
    public double energiateknologia;
    public double aseteknologia;
    public double maanviljelyteknologia;
    public double elektroniikka;
    public double mekaniikka;
    public double kemia;
    public double biologia;
    public double fysiikka;
    public double ohjelmointi;
    public double taktiikka;
    public double hyokkaus;
    public double puolustus;
    public double diplomatia;
    public double talous;
    public double ihmisoikeudet;
    
    //nimistö
    public String[] kaupunginNimetAlku; //kaupungin nimen alku otetaan tästä ja
    public String[] kaupunginNimetLoppu; //loppu tästä
    public String[] aluksenNimet;
    public String[] etunimet;
    public String[] nimikirjain = {"A","B","E","G","H","I","J","K","L","M","N","O","P","R","S","T","U","V"};
    public String[] sukunimet;
}
