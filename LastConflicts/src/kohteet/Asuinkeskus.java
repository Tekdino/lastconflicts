package kohteet;

import java.util.Random;

/**
 * Kaupungin pääkaupunki, sisältää asukkaat, 16 vuotias asuinkeskus alkaa tuottaa
 * uusia asukkaita. Asuinkeskuksen nimi on kaupungin nimi ja se näytetään kartalla
 * kaikilla zoom-tasoilla
 */
public class Asuinkeskus extends Rakennus {
    Random arpoja = new Random();
    public int ika; //kuinka monta vuotta vanha rakennus on
    public int happituholaskuri; //kuinka monta tuntia ennenkuin kaikki kuolee (-1 = off, 0 = kaikki kuolee)
    public int vesituholaskuri; //kuinka monta tuntia ennenkuin kaikki kuolee (-1 = off, 0 = kaikki kuolee)
    public int ruokatuholaskuri; //kuinka monta tuntia ennenkuin kaikki kuolee (-1 = off, 0 = kaikki kuolee)
    public int laaketuholaskuri; //kuinka monta tuntia ennenkuin kaikki haavottuneet kuolee (-1 = off, 0 = kaikki kuolee)
    public String tuhoviesti; //viesti joka näytetään kun tuholaskuri päällä
    public String vuosiviesti; //viesti näytetään kun vuosi vaihtuu
    public int iloisuus; //kuinka iloisia ovat
    
    /**
     * Asuinkeskusta ei voi luoda ilman parametreja
     * @param nimitys uuden kaupungin nimi
     * @param maa valtio joka kaupungin rakentaa
     * @param pit koordinaattipituus
     * @param lev koordinaattileveys
     * @param pitm ruudun sisältä pituusmetri
     * @param levm ruudun sisältä leveysmetri
     */
    Asuinkeskus(String nimitys, ihmiset.Valtio maa, int pit, int lev, int pitm, int levm) {
        ika = 0;
        //tuholaskurit pois päältä
        happituholaskuri = -1;
        vesituholaskuri = -1;
        ruokatuholaskuri = -1;
        laaketuholaskuri = -1;
        tuhoviesti ="Everything is running normally"; //tän ei pitäis näkyä missää mut just in case
        //ilosuus nollille koska laskettaessa heitetää tunnin välei nollalle ja lasketaa sen päälle luku
        iloisuus = 0;
        
        //Kohde-kentät
        tyyppiNumero = 1;
        tyyppiNimi = "Living dome";
        kuvaus = "Dome including living quarters and life support of the people. A city's center.";
        tehdaspaino = 36000;
        tehdasmetalli = 32000;
        tehdassuojaus = 200;
        tehdasmiehitys = 300;
        
        lastconflicts.Kirjanpito.idBufferi++; //idBufferille uusi arvo
        id = lastconflicts.Kirjanpito.idBufferi; //tuo arvo tämän asuinkeskuksen nimeksi
        nimi = nimitys;
        valtio = maa;
        suojaus = tehdassuojaus*valtio.kemia*valtio.puolustus*valtio.rakennustaito*valtio.taktiikka;
        miehityskapasiteetti = tehdasmiehitys*valtio.sosiaalisuus;
        
        
        korkeus = 50*valtio.rakennustaito;
        pituutta = pit;
        leveytta = lev;
        pituusmetrit = pitm;
        leveysmetrit = levm;
        kunto = 100;
        kokemus = 0;
        miehitys = 0;
        tekeeJotain = true;
        tehtava = 1;
        
        //Rakennus-kentät
        
        //välttämättömät tuotteet
        metallikulutus = 0;
        ilmakulutus = miehitys*0.03;
        vesikulutus = miehitys*0.16;
    
        //ruoka kulutetaan niin että ensin käytetään luksusruoka, sitten normaali ja halpis
        halpisruokakulutus = miehitys*0.025;
        normaaliruokakulutus = miehitys*0.036;
        luksusruokakulutus = miehitys*0.038;
    
        //sekundäärituotteet
        alkoholikulutus = (miehitys*0.004)*valtio.alkoholikulutus;
        laakekulutus = haavoittuneita*0.016;
        siemenkulutus = 0;
    
        //tilaan liittyvät
        aktiivinen = true;
    }

    public void asetaTehtava(int i) {
        if (i == 1) {
            tehtava = 1;
            // TODO sallii lisääntymisen
        }
        else if (i == 2) {
            tehtava = 2;
            // TODO ei salli lisääntymistä
        }
    }

    public void idlaa() {
        tekeeJotain = false;
        //ei vaikuta mihinkään
    }

    public void aktivoi() {
        aktiivinen = true;
        //ei vaikuta mihinkää
    }

    public void deaktivoi() {
        aktiivinen = false;
        //ei vaikuta koska asuinkeskusta ei voi deaktivoida, sen voi toki tyhjentää
        //ihmisist jolloi se ei kuluta mitää
    }

    public void raportoi() {
        if (haavoittuneita == 0) {
        raportti = "Population: " + miehitys + "\nAge of city: " + ika;
        }
        else if (haavoittuneita > 0 && laakareita == 0) {
            raportti = "Population: " + miehitys + "\nInjured: " + haavoittuneita + " (doctor needed!)" + "\nAge of city: " + ika;
        }
        else if (haavoittuneita > 0 && laakareita > 0) {
            raportti = "Population: " + miehitys + "\nInjured:" + haavoittuneita + " being healed by " + laakareita + " doctors" +
                    "\nAge of city: " + ika;
        }
    }

    public void inventaario() {
        inventaario = "Vital resources: \n" +
                ilmoitaRiittoisuus("Oxygen", ilma, ilmakulutus) + "\n" +
                ilmoitaRiittoisuus("Water", vesi, vesikulutus) + "\n" +
                ilmoitaRiittoisuus("Cheap food", halpisruoka, halpisruokakulutus) + "\n" +
                ilmoitaRiittoisuus("Normal food", normaaliruoka, normaaliruokakulutus) + "\n" +
                ilmoitaRiittoisuus("Luxury food", luksusruoka, luksusruokakulutus) + "\n" +
                "Other resources: \n" +
                ilmoitaRiittoisuus("Alcohol", alkoholi, alkoholikulutus) + "\n" +
                ilmoitaRiittoisuus("Medical supplies", laake, laakekulutus) + "\n";
    }
    
    /**
     * Työkalumetodi laskemaan kuinka pitkäksi aikaa jotain resurssia riittää
     * @param nimi resurssin nimi
     * @param varasto paljonko resurssia on varastossa
     * @param kulutus paljonko resurssia käytetään tunnissa
     * @return kuinka moneksi tunniksi resurssi riittää
     */
    public String ilmoitaRiittoisuus(String nimi, double varasto, double kulutus) {
        if (varasto > 0 && kulutus > 0) {
            double vuorokausia = varasto/(kulutus*24);
            return  nimi + ":" +
                    "\n Supply: " + varasto +
                    "\n Consumption: " + kulutus*24 + "/day" +
                    "\n Lasts for: " + vuorokausia + " Earth days";
                    // TODO Ois varmaa loogisempaa jos tää ilmottais maailma.kalenteri.akselikierroksen
                    // mukaa päiviä planeetalla, eikä "Earth days". Muutettava vai ei?
        }
        else if (varasto > 0 && kulutus == 0) {
            return nimi + ":" +
                    "\n Supply: " + varasto +
                    "\n Consumption: not used";
        }
        else if (varasto == 0) {
            return nimi + ":" +
                    "\n Supply: no supply!" + 
                    "\n Needed: " + kulutus*24 + "/day"; // TODO tähän kans maailma.kalenteri.akselikierros
        }
        else return "";
    }
    
    public void sekunti() {
        //Asuinkeskukselle ei tapahdu mitää
    }

    public void tunti() {
        //lasketaan iloisuus
        iloisuus = 0;
        if (ilma>0) { iloisuus+=1; }
        if (vesi>0) { iloisuus+=1; }
        if (halpisruoka>0) { iloisuus+=1; }
        if (normaaliruoka>0) { iloisuus+=1; }
        if (luksusruoka>0) { iloisuus+=2; }
        if (alkoholi>0) { iloisuus+=1; }
        if (haavoittuneita==0) { iloisuus+=1; }
        
        //hapenkäyttö
        
        ilma = ilma-ilmakulutus;
        
        if (ilma<0 && happituholaskuri==-1) { //happi lopussa ja laskuri ei päällä
            ilma = 0;
            happituholaskuri = 6;
            tuhoviesti = "The dome in city of " + nimi + " has run out of oxygen! Atleast " + miehitys +
                    "habitants are using emergency reserves. Requesting oxygen IMMEDIATLY!";
        }
        
        if (happituholaskuri<0) { //happituholaskuri pois päältä
            happituholaskuri=-1;
        }
        else if (happituholaskuri==0) { //aika loppuu
            if (ilma>0) {
                happituholaskuri = -1; //ilmaa on taas, kaikki selvis
            }
            else { //happee ei saatu, kaikki kuolee
            miehitys = 0;
            haavoittuneita = 0;
            laakareita = 0;
            happituholaskuri=-1;
            }
        }
        else if (happituholaskuri>0) { //tuholaskuri on päällä
            happituholaskuri--;
        }
        
        //veden käyttö
        
        vesi = vesi-vesikulutus;
        
        if (vesi<0 && vesituholaskuri==-1) { //vesi lopussa ja laskuri pois päältä
            vesi = 0;
            vesituholaskuri = 72;
            tuhoviesti = "The dome in city of " + nimi + " has run out of water! Atleast " + miehitys +
                    "habitants are without water supply! Requesting water!";
        }
        
        if (vesituholaskuri<0) { //vesituholaskuri pois päältä
            vesituholaskuri=-1;
        }
        else if (vesituholaskuri==0) { //aika loppuu
            if (vesi>0) {
                vesituholaskuri = -1; //vettä on taas, kaikki selvis
            }
            else { //vettä ei saatu, kaikki kuolee
            miehitys = 0;
            haavoittuneita = 0;
            laakareita = 0;
            vesituholaskuri=-1;
            }
        }
        else if (vesituholaskuri>0) { //tuholaskuri on päällä
            vesituholaskuri--;
        }
        
        //ruuan käyttö
        
        halpisruoka = halpisruoka-halpisruokakulutus;
        normaaliruoka = normaaliruoka-normaaliruokakulutus;
        luksusruoka = luksusruoka-luksusruokakulutus;
        
        if (halpisruoka<0 && normaaliruoka<0 && luksusruoka<0 && ruokatuholaskuri==-1) { //kaikki ruoka lopussa ja laskuri pois päältä
            halpisruoka = 0;
            normaaliruoka = 0;
            luksusruoka = 0;
            ruokatuholaskuri = 1200;
            tuhoviesti = "The dome in city of " + nimi + " has run out of food supplies! Atleast " + miehitys +
                    "habitants are facing famine! Requesting food aid!";
        }
        
        if (ruokatuholaskuri<0) { //ruokatuholaskuri pois päältä
            ruokatuholaskuri=-1;
        }
        else if (ruokatuholaskuri==0) { //aika loppuu
            if (halpisruoka>0 || normaaliruoka>0 || luksusruoka>0) {
                ruokatuholaskuri = -1; //ruokaa on taas, kaikki selvis
            }
            else { //ruokaa ei saatu, kaikki kuolee
            miehitys = 0;
            haavoittuneita = 0;
            laakareita = 0;
            ruokatuholaskuri=-1;
            }
        }
        else if (ruokatuholaskuri>0) { //tuholaskuri on päällä
            ruokatuholaskuri--;
        }
        
        //alkoholin käyttö
        
        alkoholi = alkoholi-alkoholikulutus;
        if (alkoholi < 0) { alkoholi = 0; }
        
        //lääkkeiden käyttö
        //HUOM lisäks kuolee vähän kerrastaa potilaita vuorokausien vaihtuessa
        
        laake = laake-laakekulutus;
        
        if (laake<0 && haavoittuneita >0 && laaketuholaskuri==-1) { //lääkkeet lopussa ja haavoittuneita jäljellä eikä laskuri päällä
            laake = 0;
            laaketuholaskuri = haavoittuneita*48;
            tuhoviesti = "The dome in city of " + nimi + " has run out of medical supplies! We have " + haavoittuneita +
                    "injured patients! Requesting medical supplies!";
        }
        
        if (laaketuholaskuri<0) { //laaketuholaskuri pois päältä
            laaketuholaskuri=-1;
        }
        else if (laaketuholaskuri==0 && haavoittuneita > 0) { //aika loppuu, haavottuneita jäljellä
            if (laake>0) {
                laaketuholaskuri = -1; //lääkkeitä on taas, loput selvis
            }
            else { //lääkkeitä ei saatu, haavottuneet kuolee
            haavoittuneita = 0;
            laaketuholaskuri=-1;
            }
        }
        else if (laaketuholaskuri>0) { //tuholaskuri on päällä
            laaketuholaskuri--;
        }
        else if (laaketuholaskuri>0 && haavoittuneita < 1) { //haavottuneet loppu, suljetaa laskuri
            laaketuholaskuri=-1;
        }
    }

    public void vuorokausi() {
        if (laaketuholaskuri>0 && laakareita >0) { //lääkkeet loppu ja lääkäreitä paikalla
            int kuolee = arpoja.nextInt(haavoittuneita/3); //0-33% haavottuneista kuolee
            haavoittuneita-=kuolee;
            int parantuu = arpoja.nextInt(haavoittuneita/3); //0-33% haavottuneista parantuu
            miehitys+=parantuu;
            haavoittuneita-=parantuu;
        }
        else if (laaketuholaskuri>0 && laakareita==0) { //lääkkeet loppu eikä lääkäreitä
            int kuolee = arpoja.nextInt(haavoittuneita); //0-100% haavottuneista kuolee
            haavoittuneita-=kuolee;
        }
        else if (haavoittuneita>0 && laaketuholaskuri==-1 && laakareita>0) { //lääkkeitä ja lääkäreitä on
            int parantuu = arpoja.nextInt(haavoittuneita); //0-100% haavottuneista paranee
           miehitys+=parantuu;
           haavoittuneita-=parantuu;
           int kuolee = arpoja.nextInt(haavoittuneita/5); //0-20% kuolee
           haavoittuneita-=kuolee;
        }
        else if (haavoittuneita>0 && laaketuholaskuri==-1 && laakareita==0) { //lääkkeitä on mut ei lääkäreitä
            int parantuu = arpoja.nextInt(haavoittuneita/5); //0-20% paranee
            miehitys+=parantuu;
            haavoittuneita-=parantuu;
            int kuolee = arpoja.nextInt(haavoittuneita/3); //0-33% kuolee
            haavoittuneita-=kuolee;
        }
    }

    public void vuosi() {
        ika++;
        if (ika>15) {
            int syntyy = (int) ((miehitys*0.04)*valtio.sosiaalisuus);
            if (syntyy < 2) { syntyy = 2; } //vähintää kaks syntyy
            miehitys+=syntyy;
            vuosiviesti = "Happy " + ika + "th year of the city of " + nimi + "! " + syntyy +
                    " kids who were born here, have now come to age and are joining the crew!";
        }
    }
    
}
