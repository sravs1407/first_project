package com.example.keka;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuInflater;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    Home_Fragment homeFragment=new Home_Fragment();
    Inbox_Fragment inboxFragment=new Inbox_Fragment();
    Me_Fragment meFragment=new Me_Fragment();
    Myteam_Fragment myteamFragment=new Myteam_Fragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView=findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected( MenuItem item) {
                if (item.getItemId() == R.id.home) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
                    return true;
                } else if (item.getItemId() == R.id.inbox) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, inboxFragment).commit();
                    return true;
                } else if (item.getItemId() == R.id.me) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, meFragment).commit();
                    return true;
                } else if (item.getItemId() == R.id.my_team) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, myteamFragment).commit();
                    return true;
                } else {
                    return false;
                }
            }
        });
    }
}