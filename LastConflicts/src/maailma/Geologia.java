package maailma;
import java.util.Random;

/**
 * Sisältää tiedot planeetan pinnanmuodoista ja esiintymistä
 */
public class Geologia {
    //päiväntasajaan pituus 40 075km
    public short sivu = 3000; //montako ruutua on yhdellä sivulla
    public Ruutu[][] kartta = new Ruutu[sivu][sivu];
    public Random arpoja = new Random();
    
    public Geologia() {
        for (short i=0; i<kartta.length; i++) {
            for (short n=0; n<kartta[i].length; n++) {
                kartta[i][n] = new Ruutu();
            }
        }
    }
    
    /**
     * Simuloitu asteroidipommitusten vaikutus pinnanmuotoihin
     * @param maara montako asteroidia simuloidaan
     */
    public void asteroidiPommitus(int maara) {
        // TODO Tarvitaan kunnollisempi versio! Laajemmat kraaterit ja reunavallit mukaan!
        int iskettyX;
        int iskettyY;
        int iskettySyvyys;
        int etaisyys = 1;
        
        for (int i=0; i<maara; i++) {
            iskettyX = arpoja.nextInt(sivu);
            iskettyY = arpoja.nextInt(sivu);
            iskettySyvyys = arpoja.nextInt(200);
            kartta[iskettyX][iskettyY].korkeus -= iskettySyvyys;
            
            try {
                kartta[iskettyX-etaisyys][iskettyY].korkeus -= iskettySyvyys- arpoja.nextInt(10);
                kartta[iskettyX+etaisyys][iskettyY].korkeus -= iskettySyvyys - arpoja.nextInt(10);
                kartta[iskettyX][iskettyY-etaisyys].korkeus -= iskettySyvyys - arpoja.nextInt(10);
                kartta[iskettyX][iskettyY+etaisyys].korkeus -= iskettySyvyys - arpoja.nextInt(10);
                kartta[iskettyX-etaisyys][iskettyY-etaisyys].korkeus -= iskettySyvyys - arpoja.nextInt(10);
                kartta[iskettyX+etaisyys][iskettyY+etaisyys].korkeus -= iskettySyvyys - arpoja.nextInt(10);
                kartta[iskettyX+etaisyys][iskettyY-etaisyys].korkeus -= iskettySyvyys - arpoja.nextInt(10);
                kartta[iskettyX-etaisyys][iskettyY+etaisyys].korkeus -= iskettySyvyys - arpoja.nextInt(10);
            }
            
            catch (Exception e) {
                break;
            }
            
        }
    }
}
