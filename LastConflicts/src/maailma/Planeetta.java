package maailma;

/**
 * Kokoaa yhteen geologian, ilmakehän, kalenterin jne
 */
public class Planeetta {
    Planeetta() {
        Kalenteri kalenteri = new Kalenteri();
        Geologia geologia = new Geologia();
        Ilmakeha ilmakeha = new Ilmakeha();
    }
}
