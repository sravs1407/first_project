package com.example.keka;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;

public class Home_Fragment extends Fragment implements NavigationView.OnNavigationItemSelectedListener {

    private CardView cardView;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home_, container, false);

        drawerLayout = rootView.findViewById(R.id.drawer_layout);
        navigationView = rootView.findViewById(R.id.nav_view);
        cardView = rootView.findViewById(R.id.user_logo);


        actionBarDrawerToggle = new ActionBarDrawerToggle(
                getActivity(),  // Use getActivity() instead of "this" in a Fragment
                drawerLayout,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        );

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!drawerLayout.isDrawerOpen(navigationView)) {
                    drawerLayout.openDrawer(navigationView);
                } else {
                    drawerLayout.closeDrawer(navigationView);
                }
            }
        });
        View headerView = LayoutInflater.from(getContext()).inflate(R.layout.nav_header, navigationView, false);
        navigationView.addHeaderView(headerView);


        navigationView.setNavigationItemSelectedListener(this);

        return rootView;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation item clicks here
        // You can add your logic based on the selected item
        return true;
    }
}
