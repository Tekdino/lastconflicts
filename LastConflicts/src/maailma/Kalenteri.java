package maailma;

/**
 * Sisältää kentät pelin ajanhallintaan ja mahdollisesti laskureita ja/tai
 * vuodenaikojen vaihtelua jne
 */
public class Kalenteri {
    //Sovitut aikamääreet
    public int vuosi;
    public int vuorokausi;
    public int tunti;
    public int minuutti;
    public int sekunti;
    
    //Planeetan aikaan vaikuttavat ominaisuudet
    public int akselikierros; //montako tuntia yksi vuorokausi kestää
    public int kiertoratakierros; //montako vuorokautta yksi kierros tähden ympäri kestää
    
    /**
     * Luodaan uusi kalenteri joka sisältää tiedon päivämäärästä ja ajasta
     */
    Kalenteri() {
        vuosi = 1;
        vuorokausi = 1;
        tunti = 0;
        minuutti = 0;
        sekunti = 0;
    }
    
    /**
     * Luodaan uusi kalenteri niin että asetetaan tietty päivämäärä ja aika (esim ladattessa?)
     * @param v vuosi
     * @param d vuorokausi
     * @param h tunti
     * @param m minuutti
     * @param s sekunti
     */
    Kalenteri(int v, int d, int h, int m, int s) {
        vuosi = v;
        vuorokausi = d;
        tunti = h;
        minuutti = m;
        sekunti = s;
    }
    
    /**
     * Siirretään kelloa sekuntilla eteenpäin
     */
    public void liikuSekunti() {
        sekunti++;
        if (sekunti >59) {
            sekunti = 0;
            liikuMinuutti();
        }
    }
    
    /**
     * Siirretään kelloa minuutilla eteenpäin
     */
    public void liikuMinuutti() {
        minuutti++;
        if (minuutti >59) {
            minuutti = 0;
            liikuTunti();
        }
    }
    
    /**
     * Siirretään kelloa tunnilla eteenpäin
     */
    public void liikuTunti() {
        tunti++;
        if (tunti > akselikierros-1) {
            tunti = 0;
            liikuVuorokausi();
        }
    }
    
    /**
     * Siirretään kalenteria vuorokaudella eteenpäin
     */
    public void liikuVuorokausi() {
        vuorokausi++;
        if (vuorokausi > kiertoratakierros-1) {
            vuorokausi = 0;
            liikuVuosi();
        }
    }
    
    /**
     * Siirretään kalenteria vuodella eteenpäin
     */
    public void liikuVuosi() {
        vuosi++;
    }
}
