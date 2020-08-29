package com.lucases;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.lucases.ui.main.ComboFragment.ComboNavMenuPrincipal;
import com.lucases.ui.main.RecyclerView.RecyclerViewFragment;

import java.util.Objects;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav_header);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new RecyclerViewFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_charTech);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent i;
        switch (item.getItemId()) {
            case R.id.nav_charTech:
                findViewById(R.id.actionSearch).setVisibility(View.VISIBLE);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new RecyclerViewFragment()).commit();
                break;
            case R.id.nav_combos:
                findViewById(R.id.actionSearch).setVisibility(View.INVISIBLE);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ComboNavMenuPrincipal()).commit();
                break;
            case R.id.nav_tutorial:
                Toast.makeText(this, "Work in progress!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_respureceFile:
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://docs.google.com/spreadsheets/d/1lCVfUxWdrXDzIJBMYjvxPhJQ4FI0w-owyZkFcIPjUFE/edit#gid=390033085"));
                startActivity(i);
                break;
            case R.id.nav_discord:
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://discord.gg/Y5fjHed"));
                startActivity(i);
                break;
            case R.id.nav_donate:
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("https://paypal.me/dacrenzio"));
                startActivity(i);

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START);
        else if (Objects.requireNonNull(navigationView.getCheckedItem()).getItemId() != R.id.nav_charTech) {
            findViewById(R.id.actionSearch).setVisibility(View.VISIBLE);
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new RecyclerViewFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_charTech);
        } else
            super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.research_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.actionSearch);
        final SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchView.setIconifiedByDefault(false);

        searchItem.setOnActionExpandListener(new MenuItem.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem menuItem) {
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem menuItem) {
                RecyclerViewFragment.adapter.getFilter().filter("");
                return true;
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                RecyclerViewFragment.adapter.getFilter().filter(s);
                return false;
            }
        });
        return true;
    }
}