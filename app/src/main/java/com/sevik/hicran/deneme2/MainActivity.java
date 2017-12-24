package com.sevik.hicran.deneme2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fab;
    //Toolbar toolbar;
    TabHost tab;
    TabHost.TabSpec sayfa1,sayfa2;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    setTitle("Profilim");
                    Profil fragment=new Profil();
                    FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.content,fragment,"FragmentName");
                    transaction.commit();
                    fab.show();
                    //Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);


                    return true;
                case R.id.navigation_dashboard:
                    setTitle("Besin");
                    Besin fragment2=new Besin();
                    FragmentTransaction transaction2=getSupportFragmentManager().beginTransaction();
                    transaction2.replace(R.id.content,fragment2,"FragmentName");
                    fab.hide();
                    transaction2.commit();

                    return true;
                case R.id.navigation_notifications:
                    setTitle("Adım Sayacı");
                    Adimsayaci fragment3=new Adimsayaci();
                    FragmentTransaction transaction3=getSupportFragmentManager().beginTransaction();
                    transaction3.replace(R.id.content,fragment3,"FragmentName");
                    transaction3.commit();
                    fab.hide();
                    return true;
                case R.id.egzersiz:
                    setTitle("Egzersizler");
                    Egzersizler fragment4=new Egzersizler();
                    FragmentTransaction transaction4=getSupportFragmentManager().beginTransaction();
                    transaction4.replace(R.id.content,fragment4,"FragmentName");
                    transaction4.commit();
                    fab.hide();
                    return true;
            }
            return false;
        }

    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);




        fab= (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Kisiselbilgiler.class));
            }
        });

        setTitle("Profilim");
        Profil fragment=new Profil();
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content,fragment,"FragmentName");
        transaction.commit();
        //getSupportActionBar().hide();

       // Toolbar toolbar=(Toolbar) findViewById(R.id.app_bar);
        //setSupportActionBar(toolbar);





    }
}