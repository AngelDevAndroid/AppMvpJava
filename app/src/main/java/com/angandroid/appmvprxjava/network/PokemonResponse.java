package com.angandroid.appmvprxjava.network;

import java.util.List;

public class PokemonResponse {
    private int count;
    private List<Pokemon> results;

    public int getCount() { return count; }
    public List<Pokemon> getResults() { return results; }
}
