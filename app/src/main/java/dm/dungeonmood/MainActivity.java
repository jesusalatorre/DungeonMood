package dm.dungeonmood;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import dm.dungeonmood.Fragments.AddMusic;
import dm.dungeonmood.Fragments.HomebrewManager;
import dm.dungeonmood.Fragments.MusicSelector;
import dm.dungeonmood.Fragments.SpellSelector;
import dm.dungeonmood.Fragments.ToolsFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        MusicSelector.OnFragmentInteractionListener,
        AddMusic.OnFragmentInteractionListener,
        SpellSelector.OnFragmentInteractionListener,
        HomebrewManager.OnFragmentInteractionListener,
        ToolsFragment.OnFragmentInteractionListener{

        int contextCode;

    public void onFragmentInteraction(){

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fragmentSwitch(new MusicSelector());
        contextCode=1;

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ///add a fragment for adding things depending on selected tab
                handleAddition();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setCheckedItem(R.id.nav_ambience);

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
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_ambience) {
            fragmentSwitch(new MusicSelector());
            contextCode=1;
        } else if (id == R.id.nav_spells) {
            fragmentSwitch(new SpellSelector());
            contextCode=2;
        } else if (id == R.id.nav_homebrew) {
            fragmentSwitch(new HomebrewManager());
            contextCode=3;
        } else if (id == R.id.nav_manage) {
            fragmentSwitch(new ToolsFragment());
            contextCode=4;
        } else if (id == R.id.nav_send) {
            handleSend();
        }

        logContextCode();
        handleFAB();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void handleAddition(){

        switch (contextCode){
            case 1:
                fragmentSwitch(new AddMusic());
                contextCode=11;
                break;
            case 4:
                contextCode=41;
                break;
        }
        handleFAB();
    }

    public void fragmentSwitch(Fragment f){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.fragment_container, f);
        ft.commit();
    }


    public void handleSend(){
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        String message;

        switch (contextCode){
            case 1:
                message = "Hello from music";
                sendIntent.putExtra(Intent.EXTRA_TEXT, message);
                break;
            case 2:
                message = "Hello from spells";
                sendIntent.putExtra(Intent.EXTRA_TEXT, message);
                break;
            case 3:
                message = "Hello from homebrew";
                sendIntent.putExtra(Intent.EXTRA_TEXT, message);
                break;
            case 4:
                message = "Hello from tools";
                sendIntent.putExtra(Intent.EXTRA_TEXT, message);
                break;
            case 11:
                message = "Hello from a specific song";
                sendIntent.putExtra(Intent.EXTRA_TEXT, message);
                break;
        }
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }

    public void handleFAB(){
        FloatingActionButton fab = findViewById(R.id.fab);
        switch (contextCode){
            case 1:
                fab.show();
                break;
            case 2:
                fab.hide();
                break;
            case 3:
                fab.hide();
                break;
            case 4:
                fab.show();
                break;
            case 11:
                fab.hide();
                break;
        }
    }

    public void logContextCode(){
        Log.d("eh", String.valueOf(contextCode));
    }
}
