package ir.azadehy.rockclimbing.fragments;


import android.animation.ObjectAnimator;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.button.MaterialButton;

import ir.azadehy.rockclimbing.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class firstpage extends Fragment {


    public firstpage() {
        // Required empty public constructor
    }
    ImageView b1,b2,b3,b4,b5,b6;
    MaterialButton signin,signouot;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_firstpage, container, false);
        b1=v.findViewById(R.id.b1);
        b2=v.findViewById(R.id.b2);
        b3=v.findViewById(R.id.b3);
        b4=v.findViewById(R.id.b4);
        b5=v.findViewById(R.id.b5);
        b6=v.findViewById(R.id.b6);
        signin=v.findViewById(R.id.login);
        signouot=v.findViewById(R.id.signout);

        logoanimation();

        signin.setOnClickListener(d->
        {
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_container,new signin()).addToBackStack(null).commit();

        });

        signouot.setOnClickListener(w->
        {
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_container,new signout()).addToBackStack(null).commit();
        });





        return v;
    }


    public void logoanimation() {
        ObjectAnimator rotate = ObjectAnimator.ofFloat(
                b1,
                "Rotation",
                0f, 10f, 30f, 60f, 100f, 150f, 210f, 280f, 360f);
        rotate.setDuration(3000);
        rotate.start();

        ObjectAnimator translationb2y = ObjectAnimator.ofFloat(
                b2,
                "TranslationY",
                -310f, -260f, -200f, -150f, -100f, -50f, 0f, 50f, 100f, 150f, 200f, 250f, 200f, 100f, 0f);
        translationb2y.setDuration(3000);
        translationb2y.start();

        ObjectAnimator translationb3y = ObjectAnimator.ofFloat(
                b3,
                "TranslationY",
                350f, 0f, -350f, 0f);
        translationb3y.setDuration(3000);
        translationb3y.start();


        ObjectAnimator translationb4y = ObjectAnimator.ofFloat(
                b4,
                "TranslationY",
                -250f, -200f, -150f, -100f, -50f, 0f, 50f, 100f, 150f, 200f, 100f, 50f, 0f);
        translationb4y.setDuration(3000);
        translationb4y.start();


        ObjectAnimator translationb5y = ObjectAnimator.ofFloat(
                b5,
                "TranslationY",
                350f, 150f, 0f, -150f, -350f, -150f, 0f);
        translationb5y.setDuration(3000);
        translationb5y.start();


        ObjectAnimator translationb6y = ObjectAnimator.ofFloat(
                b6,
                "TranslationY",
                -200f, -100f, -50f, 0f, 50f, 100f, 200f, 100f, 50f, 0f, -50f, -100f, -50f, 0f);
        translationb6y.setDuration(3000);
        translationb6y.start();


        ObjectAnimator alpha2 = ObjectAnimator.ofFloat(
                b2,
                "alpha",
                0f,0.2f,0.4f, 0.6f, 0.7f);
        alpha2.setDuration(3000);
        alpha2.start();

        ObjectAnimator alpha3 = ObjectAnimator.ofFloat(
                b3,
                "alpha",
                0f,0.2f,0.4f, 0.6f, 0.7f);
        alpha3.setDuration(3000);
        alpha3.start();

        ObjectAnimator alpha4 = ObjectAnimator.ofFloat(
                b4,
                "alpha",
                0f,0.2f,0.4f, 0.6f, 0.8f);
        alpha4.setDuration(3000);
        alpha4.start();

        ObjectAnimator alpha5 = ObjectAnimator.ofFloat(
                b5,
                "alpha",
                0f,0.2f,0.4f, 0.6f, 0.7f);
        alpha5.setDuration(3000);
        alpha5.start();

        ObjectAnimator alpha6 = ObjectAnimator.ofFloat(
                b6,
                "alpha",
                0f,0.2f,0.4f, 0.6f, 0.7f);
        alpha6.setDuration(3000);
        alpha6.start();
    }
}
