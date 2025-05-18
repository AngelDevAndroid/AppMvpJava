package com.angandroid.appmvprxjava.network;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;

public interface IApiService {
    @GET("/posts")
    // Observable<PokemonResponse> getPokemonList();
    Single<List<Post>> getPokemonList();
}
