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
    public static int tehdasmetalli; //tyypin vaatima metalli ilman kuormaa ja lisäosia
    public static int tehdassuojaus; //tyypin kestävyys ilman kuormaa ja lisäosia
    public static int tehdasmiehitys; //montako ihmistä mahtuu ilman kuormaa ja lisäosia
    
    //Jokaisen yksittäisen kohteen omat tiedot
    public int id; //tunnusnumero jolla kohde tunnistetaan
    public String nimi; //tunnusnimi jolla kohde tunnetaan 
    public ihmiset.Valtio valtio; //valtio jolle kohde kuuluu
    public double suojaus; //kohteen kokonaissuojaus (tehdassuojaus + lisäosat)
    public double miehityskapasiteetti; //montako ihmistä mahtuu
            
    //Tilannetiedot
    public double korkeus; //korkeus (vaikuttaa suoraan tutkahavaintoihin)
    public int pituutta; //koordinaattipituus, negatiivinen W, positiivinen E
    public int leveytta; //koordinaattileveys, negatiivinen S, positiivinen N
    public int pituusmetrit; //sijainti ruudun sisällä metrin tarkkuudella
    public int leveysmetrit; //sijainti ruudun sisällä metrin tarkkuudella
    public int kunto; //kunto prosentteina, vaikuttaa toimintakykyyn
    public int kokemus; //kokemus vaikuttaa siihen kuinka tehokas kohde on työssään
    public int miehitys; //montako ihmistä sisällä tällä hetkellä
    public int haavoittuneita; //montako haavoittunutta (<=miehitys)
    public int laakareita; //montako lääkäriä sisällä tällä hetkellä
    public boolean tekeeJotain; //tekeekö jotain vai idlaako
    public int tehtava;
    public String raportti;
    public String inventaario;

    public abstract void sekunti(int i);
    
    public abstract void tunti(int i);
    
    public abstract void vuorokausi(int i);

}

/*
tyyppiNumero;
tyyppiNimi;
kuvaus;
tehdaspaino;
tehdasmetalli;
tehdassuojaus;
tehdasmiehitys;
    
    
id;
nimi;
valtio;
suojaus;
miehityskapasiteetti;
            
        
korkeus;
pituutta;
leveytta;
pituusmetrit;
leveysmetrit;
kunto;
kokemus;
miehitys;
haavoittuneita;
laakareita;
tekeeJotain;
tehtava;
raportti;
inventaario;
 * */