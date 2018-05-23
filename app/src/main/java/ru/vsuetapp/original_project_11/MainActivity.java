package ru.vsuetapp.original_project_11;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import ru.vsuetapp.original_project_11.Fragments_root.Fragment_fik;
import ru.vsuetapp.original_project_11.Fragments_root.Fragment_history;
import ru.vsuetapp.original_project_11.Fragments_root.Fragment_korp_and_obch;
import ru.vsuetapp.original_project_11.Fragments_root.Fragment_maps_univer;
import ru.vsuetapp.original_project_11.Fragments_root.Fragment_news;
import ru.vsuetapp.original_project_11.Fragments_root.Fragment_portfolio;
import ru.vsuetapp.original_project_11.Fragments_root.Fragment_raspisanie;
import ru.vsuetapp.original_project_11.Fragments_root.Fragment_reiting;
import ru.vsuetapp.original_project_11.Fragments_root.Fragment_settings;
import ru.vsuetapp.original_project_11.Fragments_root.Fragment_stipendia;
import ru.vsuetapp.original_project_11.Fragments_root.Fragment_stud_samo;
import ru.vsuetapp.original_project_11.Fragments_root.Fragment_terror;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private Fragment fnews = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        fnews = new Fragment_news();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.container,fnews);
        setTitle("Новости");
        ft.commit();


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Fragment fragment = null;
        Class fragmentClass = null;
        int id = item.getItemId();

        if (id == R.id.news) {
            fragmentClass = Fragment_news.class;
        } else if (id == R.id.fik) {
            fragmentClass = Fragment_fik.class;
        } else if (id == R.id.raspisanie) {
            fragmentClass = Fragment_raspisanie.class;
        } else if (id == R.id.maps_univer) {
            fragmentClass = Fragment_maps_univer.class;
        } else if (id == R.id.reiting) {
            fragmentClass = Fragment_reiting.class;
        } else if (id == R.id.stud_samo) {
            fragmentClass = Fragment_stud_samo.class;
        }
        else if (id == R.id.korp_and_obch) {
            fragmentClass = Fragment_korp_and_obch.class;
        }
        else if (id == R.id.stipendia) {
            fragmentClass = Fragment_stipendia.class;
        }
        else if (id == R.id.portfolio) {
            fragmentClass = Fragment_portfolio.class;
        }
        else if (id == R.id.history) {
            fragmentClass = Fragment_history.class;
        }
        else if (id == R.id.terror) {
            fragmentClass = Fragment_terror.class;
        }
        else if (id == R.id.settings) {
            fragmentClass = Fragment_settings.class;
        }
        else if (id == R.id.About_the_application) {

        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();

        item.setChecked(true);

        setTitle(item.getTitle());
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
