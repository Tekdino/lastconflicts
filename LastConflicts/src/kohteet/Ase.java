package kohteet;

/**
 * Alusten käyttämät aseet (ohjukset ovat kuitenkin oma luokkansa)
 */
public abstract class Ase {
    //tyyppitiedot
    public int tyyppiNumero; //asetyypin identifioiva numero
    public String tyyppiNimi; //asetyypin nimi
    public String tyyppiKuvaus; //asetyypin kuvaus
    
    //taistelutekniset tiedot
    public int ammuskapasiteetti; //paljonko ammuksia mahtuu
    public int ammuksia; //ammusten määrä
    public int ammuksenpaino; //yksittäisen ammuksen paino
    public int tuhovoima; //tuhovoima törmäyskohdassa
    public int tuholaajuus; //kuinka pitkälle iskun keskuksesta vaikutukset yltävät
    public int latausaika; //kuinka nopeasti voidaan ampua uudelleen
    public int kantomatka; //kuinka pitkälle ammukset lentävät
    public int ammusnopeus; //lentävän ammuksen nopeus
    
    public abstract void ammuSuuntaan(int piiru);
    
    public abstract void lopetaAmpuminen();
}

/*
 
    tyyppiNumero;
    tyyppiNimi;
    tyyppiKuvaus;
    
    
    ammuskapasiteetti;
    ammuksia;
    ammuksenpaino;
    tuhovoima;
    tuholaajuus;
    latausaika;
    kantomatka;
    ammusnopeus;
 
 */