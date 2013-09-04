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
        tekeeJotain = false;
        
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void idlaa() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void aktivoi() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void deaktivoi() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void raportoi() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void inventaario() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
