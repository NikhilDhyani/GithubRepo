package com.example.nikhil.githubrepo.APIs;

import com.example.nikhil.githubrepo.Datas.Responsess;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by NIKHIL on 21-06-2018.
 */

public interface GithubClient {

    // Base url

    String base_url = "https://api.github.com/";


    //Note: Here instead of using hard coded user name so we will use path parameter.
    //@GET("users/NikhilDhyani/repos")

    @GET("users/{user_name}/repos")          // 2
    Call<List<Responsess>> reposForUder(@Path("user_name") String user); //1

    /*Note: How it is working?
    What ever you will pass here in "user" in line 2
    will get pass in "username" in line 1.

    */
}
