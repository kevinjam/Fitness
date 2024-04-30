package com.thinkdevs.msfitnessPlan.config;

import com.thinkdevs.msfitnessPlan.external.meal.TheMealDBApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitConfig {

    @Bean
    public Retrofit retrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://www.themealdb.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Bean
    public TheMealDBApi theMealDBApi(Retrofit retrofit) {
        return retrofit.create(TheMealDBApi.class);
    }
}
