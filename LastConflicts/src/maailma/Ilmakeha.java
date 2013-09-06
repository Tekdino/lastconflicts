package maailma;

/**
 * Sisältää tiedot kaasukehän paineesta ja sisällöstä, sekä vuotuiset lämpötilanvaihtelut
 */
public class Ilmakeha {
    //planeetan ominaisuudet
    public int hiilidioksidi; //CO2 määrä millibaareina
    public int happi; //hapen määrä millibaareina
    public int typpi; //typen määrä millibaareina
    public int vesiaerosoli; //vesihöyryn määrä (millibaareina? prosentteina?)
    public double AU; //etäisyys auringosta AU:ina
    
    //laskettavat kentät
    public int ilmanpaine; //kaasukehän paine maanpinnalla
    public int vuorokaudenvaihtelu; //montako astetta lämpötila vaihtelee vuorokauden aikana
    public int vuodenkylmin; //vuoden lämpötilaminimi
    public int vuodenkuumin; //vuoden lämpötilamaksimi
}
