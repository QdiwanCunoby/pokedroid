package it.cudia.studio.android.pokedroid.model;

public class Friend {

    private String Username;
    private Double CompletamentoPokedex;

    public Friend(String username, Double completamentoPokedex) {
        Username = username;
        CompletamentoPokedex = completamentoPokedex;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public Double getCompletamentoPokedex() {
        return CompletamentoPokedex;
    }

    public void setCompletamentoPokedex(Double completamentoPokedex) {
        CompletamentoPokedex = completamentoPokedex;
    }
}
