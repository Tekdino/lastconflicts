package kohteet;

/**
 * Kaupungin pääkaupunki, sisältää asukkaat, 16 vuotias asuinkeskus alkaa tuottaa
 * uusia asukkaita. Asuinkeskuksen nimi on kaupungin nimi ja se näytetään kartalla
 * kaikilla zoom-tasoilla
 */
public class Asuinkeskus extends Rakennus {
    public int ika; //kuinka monta vuotta vanha rakennus on
    
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
        aktiivinen = true;
        //ei vaikuta koska asuinkeskusta ei voi deaktivoida, sen voi toki tyhjentää
        //ihmisist jolloi se ei kuluta mitää
    }

    public void raportoi() {
        if (haavoittuneita > 0) {
        raportti = "Population: " + miehitys + "\nAge of city: " + ika;
        }
        else {
            raportti = "Population: " + miehitys + "\nInjured: " + haavoittuneita + "\nAge of city: " + ika;
        }
    }

    public void inventaario() {
        inventaario = ""; //TODO inventaarioo joku järkevä listaus joka näyttää myös paljon jäljel
    }

    public void sekunti(int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void tunti(int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void vuorokausi(int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
