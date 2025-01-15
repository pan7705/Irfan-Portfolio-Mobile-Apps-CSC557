package com.example.irfanportfolio2;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.navigation.NavigationView;
import android.graphics.Color;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Set the title text color to white
        getSupportActionBar().setTitle("");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white, getTheme()));

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // Set the custom toggle style
        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));


        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home); // Highlight the corresponding item in the navigation drawer
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        String title = "";

        if (itemId == R.id.nav_home) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
            title = "Home";
        } else if (itemId == R.id.nav_about_me) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new AboutMeFragment()).commit();
            title = "About";
        } else if (itemId == R.id.nav_hobby) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HobbyFragment()).commit();
            title = "Hobby";
        } else if (itemId == R.id.nav_skills) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SkillsFragment()).commit();
            title = "Skills";
        } else if (itemId == R.id.nav_timetable) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new TimetableFragment()).commit();
            title = "Timetable";
        } else if (itemId == R.id.nav_uitm) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new UITMFragment()).commit();
            title = "UiTM";
        } else if (itemId == R.id.nav_student_portal) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new StudentPortalFragment()).commit();
            title = "Student Portal";
        } else if (itemId == R.id.nav_exit) {
            // Display exit dialog
            ExitDialogFragment exitDialogFragment = new ExitDialogFragment();
            exitDialogFragment.show(getSupportFragmentManager(), "exit_dialog");
            return true; // Prevent closing the drawer after displaying the exit dialog
        }

        getSupportActionBar().setTitle(title);
        drawerLayout.closeDrawers();
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
