package ir.azadehy.rockclimbing.data;

import ir.azadehy.rockclimbing.models.LoginModel;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface API {

    @FormUrlEncoded
    @POST("Login.php")
    Call<LoginModel> login(@Field("username") String user,
                           @Field("password") String pass);


    @FormUrlEncoded
    @POST("reg.php")
    Call<LoginModel> register(@Field("name") String user,
                               @Field("cell") String cell,
                               @Field("email") String email,
                               @Field("password") String pass);
}
