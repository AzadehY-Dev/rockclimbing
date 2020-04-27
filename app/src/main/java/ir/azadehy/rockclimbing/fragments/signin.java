package ir.azadehy.rockclimbing.fragments;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ir.azadehy.rockclimbing.MainActivity;
import ir.azadehy.rockclimbing.R;
import ir.azadehy.rockclimbing.classes.mySharedPrefrences;
import ir.azadehy.rockclimbing.data.RetrofitClient;
import ir.azadehy.rockclimbing.models.LoginModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class signin extends Fragment {


    public signin() {
        // Required empty public constructor
    }

    public Button btnsignin;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v= inflater.inflate(R.layout.fragment_signin, container, false);
        String user=v.findViewById(R.id.signin_cell).toString();
        String pass=v.findViewById(R.id.signin_pass).toString();
        btnsignin=v.findViewById(R.id.signin_register);

        btnsignin.setOnClickListener(i->
        {
            RetrofitClient.getInstance().getApi().login(user,pass)
                    .enqueue(new Callback<LoginModel>() {
                        @Override
                        public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                            if(response.isSuccessful())
                            {
                                mySharedPrefrences.getInstance(getActivity()).setLogin();
                                mySharedPrefrences.getInstance(getActivity()).setuser(user);
                                startActivity(new Intent(getContext(), MainActivity.class));
                                getActivity().finish();
                               // Toast.makeText(getContext(), "موفق", Toast.LENGTH_LONG).show();

                            }
                            else
                            {
                                switch (response.code())
                                {
                                    case 400:
                                        Toast.makeText(getContext(), "خطا! لطفا مجدد تلاش کنید.", Toast.LENGTH_LONG).show();
                                        break;

                                    case 406:
                                        Toast.makeText(getContext(), "خطا! اطلاعات را درست وارد کنید.", Toast.LENGTH_LONG).show();
                                        break;

                                    case 418:
                                        Toast.makeText(getContext(), "خطا! رمز عبور اشتباه وارد شده است.", Toast.LENGTH_LONG).show();
                                        break;

                                        default:
                                            Toast.makeText(getContext(), "خطا!", Toast.LENGTH_LONG).show();

                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<LoginModel> call, Throwable t) {
                            Toast.makeText(getContext(), "خطا!", Toast.LENGTH_LONG).show();
                        }
                    });
        });


        // Inflate the layout for this fragment
        return v;
    }

}
