package ir.azadehy.rockclimbing.data;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static RetrofitClient instance;
    private Retrofit retrofit;



    public static RetrofitClient getInstance()
    {
        if(instance==null)
            instance=new RetrofitClient();

        return instance;
    }


    private RetrofitClient()
    {
        retrofit=new Retrofit.Builder().baseUrl("").
                addConverterFactory(GsonConverterFactory.create()).
                build();
    }
    public API getApi()
    {
        return retrofit.create(API.class);
    }

}
