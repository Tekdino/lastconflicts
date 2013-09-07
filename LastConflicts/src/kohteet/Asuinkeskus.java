package kohteet;

/**
 * Kaupungin pääkaupunki, sisältää asukkaat, 16 vuotias asuinkeskus alkaa tuottaa
 * uusia asukkaita. Asuinkeskuksen nimi on kaupungin nimi ja se näytetään kartalla
 * kaikilla zoom-tasoilla
 */
public class Asuinkeskus extends Rakennus {
    public int ika; //kuinka monta vuotta vanha rakennus on
    public int tuholaskuri; //kuinka monta päivää ennenkuin kaikki kuolee (-1 = off)
    public String tuhoviesti; //viesti joka näytetään kun tuholaskuri päällä
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
        //Kohde-kentät
        tyyppiNumero = 1;
        tyyppiNimi = "Living dome";
        kuvaus = "City center, home of people";
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void vuorokausi() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
