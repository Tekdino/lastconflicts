package kohteet;

/**
 * Maastossa olevien kohteiden yläluokka. Sisältää rakennukset, alukset, ohjukset jne
 * Kohteet näkyvät tutkassa ja ovat ihmiset rakentamia ja jollekin valtiolle kuuluvia
 */
public abstract class Kohde {
    //Jokaista tietyn tyyppista kohdetta yhdistävät tiedot
    public static int tyyppiNumero; //määrittää mikä kohde on kyseessä
    public static String tyyppiNimi; //tyypin nimi, esim "alustehdas"
    public static String kuvaus; //tyypin kuvaus, esim "valmistaa aluksia"
    public static int tehdaspaino; //tyypin alkupaino ilman kuormaa ja lisäosia
    public static int tehdashinta; //tyypin alkuhinta ilman kuormaa ja lisäosia
    public static int tehdasmetalli; //tyypin vaatima metalli ilman kuormaa ja lisäosia
    public static int tehdassuojaus; //tyypin kestävyys ilman kuormaa ja lisäosia
    public static int tehdasmiehitys; //montako ihmistä mahtuu ilman kuormaa ja lisäosia
    
    //Jokaisen yksittäisen kohteen omat tiedot
    public int id; //tunnusnumero jolla kohde tunnistetaan
    public String nimi; //tunnusnimi jolla kohde tunnetaan 
    public ihmiset.Valtio valtio; //valtio jolle kohde kuuluu
    public int suojaus; //kohteen kokonaissuojaus (tehdassuojaus + lisäosat)
    public int miehityskapasiteetti; //montako ihmistä mahtuu
            
    //Tilannetiedot
    public int korkeus; //korkeus (vaikuttaa suoraan tutkahavaintoihin)
    public double pituutta; //koordinaattipituus, negatiivinen W, positiivinen E
    public double leveytta; //koordinaattileveys, negatiivinen S, positiivinen N
    public int kunto; //kunto prosentteina, vaikuttaa toimintakykyyn
    public int kokemus; //kokemus vaikuttaa siihen kuinka tehokas kohde on työssään
    public int miehitys; //montako ihmistä sisällä tällä hetkellä
    public boolean tekeeJotain; //tekeekö jotain vai idlaako
}