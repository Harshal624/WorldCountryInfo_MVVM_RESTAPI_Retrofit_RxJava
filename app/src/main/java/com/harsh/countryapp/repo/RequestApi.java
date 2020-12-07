package com.harsh.countryapp.repo;


import com.harsh.countryapp.model.Country;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.GET;

public interface RequestApi {

  /*  @GET("posts")
    io.reactivex.Observable<List<Post>> getPosts();

    @GET("posts/{id}/comments")
    Observable<List<Comment>> getComments(
            @Path("id") int id
    );*/

  /*  @GET("all")
    Call<List<Country>> getAllCountries();*/

    @GET("all")
    Flowable<List<Country>> getAllCountries();
}
