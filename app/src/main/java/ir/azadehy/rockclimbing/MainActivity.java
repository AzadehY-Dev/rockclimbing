package ir.azadehy.rockclimbing;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import ir.azadehy.rockclimbing.fragments.Home;
import ir.azadehy.rockclimbing.fragments.book;
import ir.azadehy.rockclimbing.fragments.shop;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bnv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bnv=findViewById(R.id.main_btnNaviView);

        bnv.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem menuItem) {

            }
        });

        bnv.setOnNavigationItemReselectedListener(new
                  BottomNavigationView.OnNavigationItemReselectedListener() {
              @Override
              public void onNavigationItemReselected(@NonNull MenuItem menuItem) {

                  switch (menuItem.getItemId())
                  {
                      case R.id.nv_home:
                          startActivity(new Intent(MainActivity.this, Main2Activity.class));
                         /* Home home=new Home();
                          getSupportFragmentManager().beginTransaction().replace(R.id.main_container,home).commit();*/
                          break;


                  }
              }
          }
        );
    }
}
