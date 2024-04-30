package com.thinkdevs.msfitnessPlan.external.meal;

import com.thinkdevs.msfitnessPlan.external.response.MealResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TheMealDBApi {

    @GET("/api/json/v1/1/filter.php?i={ingredient}")
    Call<MealResponse> getMealsByIngredient(@Path("ingredient") String ingredient);

    @GET("/api/json/v1/1/search.php?s={name}")
    Call<MealResponse> searchMealsByName(@Path("name") String keyword);
}