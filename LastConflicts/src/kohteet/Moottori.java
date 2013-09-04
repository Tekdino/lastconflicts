package kohteet;

/**
 * Moottori on alusten ja ohjusten liikkumiseen käytetty laite
 */
public abstract class Moottori {
    public int tyyppiNumero; //moottorityypin identifioiva numero
    public String tyyppiNimi; //moottorityypin nimi
    public String tyyppiKuvaus; //moottorityypin kuvaus
    public Polttoaine polttoaine; //käytettävä polttoaine
    public int teho; //moottorin teho
    
    public abstract void starttaa();
    
    public abstract void sammuta();
}

/*
    tyyppiNumero;
    tyyppiNimi;
    tyyppiKuvaus;
    polttoaine;
    teho;
 */