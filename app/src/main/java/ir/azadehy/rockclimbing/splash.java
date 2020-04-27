package ir.azadehy.rockclimbing;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.widget.ImageView;

import ir.azadehy.rockclimbing.fragments.firstpage;

public class splash extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        firstpage fg=new firstpage();
        getSupportFragmentManager().beginTransaction().
                add(R.id.main_container,fg).commit();
    }

}
