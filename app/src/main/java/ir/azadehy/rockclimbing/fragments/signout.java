package ir.azadehy.rockclimbing.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import ir.azadehy.rockclimbing.MainActivity;
import ir.azadehy.rockclimbing.R;
import ir.azadehy.rockclimbing.classes.mySharedPrefrences;
import ir.azadehy.rockclimbing.data.RetrofitClient;
import ir.azadehy.rockclimbing.models.LoginModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class signout extends Fragment {


    public signout() {
        // Required empty public constructor
    }
    public Button btnout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_signout, container, false);
         String name=v.findViewById(R.id.signout_name).toString();
        String cell=v.findViewById(R.id.signout_cell).toString();
        String email=v.findViewById(R.id.signout_email).toString();
        String pass=v.findViewById(R.id.signout_pass).toString();
        btnout=v.findViewById(R.id.signin_register);

        btnout.setOnClickListener(i->
        {
            RetrofitClient.getInstance().getApi().
                    register(name,cell,email,pass).enqueue(new Callback<LoginModel>() {
                @Override
                public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
                    if(response.isSuccessful())
                    {
                        mySharedPrefrences.getInstance(getActivity()).setLogin();
                        mySharedPrefrences.getInstance(getActivity()).setuser(cell);
                        startActivity(new Intent(getContext(), MainActivity.class));
                        getActivity().finish();
                    }
                    else {
                        switch (response.code())
                        {
                            case 400:
                                Toast.makeText(getContext(), "خطا! لطفا مجدد تلاش کنید.", Toast.LENGTH_LONG).show();
                                break;
                        }
                    }
                }

                @Override
                public void onFailure(Call<LoginModel> call, Throwable t) {

                }
            });

        });


        return v;
    }

}
