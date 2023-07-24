package it.cudia.studio.android.pokedroid.model;

public class Pokemon {
    private long idPokemon;
    private String nome;
    private int tipo;
    private int forza;
    private int grinta;
    private int fortuna;
    private int difesa;
    private int astuzia;
    private int resistenza;
    private int velocita;

    public Pokemon(long idPokemon) { this.idPokemon = idPokemon; }

    public Pokemon(long idPokemon, String nome, int tipo, int forza, int grinta, int fortuna, int difesa, int astuzia, int resistenza, int velocita) {
        this.idPokemon = idPokemon;
        this.nome = nome;
        this.tipo = tipo;
        this.forza = forza;
        this.grinta = grinta;
        this.fortuna = fortuna;
        this.difesa = difesa;
        this.astuzia = astuzia;
        this.resistenza = resistenza;
        this.velocita = velocita;
    }

    public long getIdPokemon() {
        return idPokemon;
    }

    public void setIdPokemon(long idPokemon) {
        this.idPokemon = idPokemon;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getForza() {
        return forza;
    }

    public void setForza(int forza) {
        this.forza = forza;
    }

    public int getGrinta() {
        return grinta;
    }

    public void setGrinta(int grinta) {
        this.grinta = grinta;
    }

    public int getFortuna() {
        return fortuna;
    }

    public void setFortuna(int fortuna) {
        this.fortuna = fortuna;
    }

    public int getDifesa() {
        return difesa;
    }

    public void setDifesa(int difesa) {
        this.difesa = difesa;
    }

    public int getAstuzia() {
        return astuzia;
    }

    public void setAstuzia(int astuzia) {
        this.astuzia = astuzia;
    }

    public int getResistenza() {
        return resistenza;
    }

    public void setResistenza(int resistenza) {
        this.resistenza = resistenza;
    }

    public int getVelocita() {
        return velocita;
    }

    public void setVelocita(int velocita) {
        this.velocita = velocita;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "idPokemon=" + idPokemon +
                ", nome='" + nome + '\'' +
                ", tipo=" + tipo +
                ", forza=" + forza +
                ", grinta=" + grinta +
                ", fortuna=" + fortuna +
                ", difesa=" + difesa +
                ", astuzia=" + astuzia +
                ", resistenza=" + resistenza +
                ", velocita=" + velocita +
                '}';
    }
}
