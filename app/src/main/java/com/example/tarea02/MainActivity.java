package com.example.tarea02;

import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_activity);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.abrir, R.string.cerrar);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_dinero) {
            Toast.makeText(this, "Dinero seleccionado", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_deportes) {
            Toast.makeText(this, "Deportes seleccionado", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_entretenimiento) {
            Toast.makeText(this, "Entretenimiento seleccionado", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_salud) {
            Toast.makeText(this, "Salud seleccionado", Toast.LENGTH_SHORT).show();
        }

        // Cerrar el Drawer después de la selección
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    //Inflar el menú
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options, menu);
        return true;
    }

    // Manejar las opciones seleccionadas
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_cancel_order) {
            Log.d("MenuAction", "Cancelar pedido");
            Toast.makeText(this, "Noticias Guardadas", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_resend_order) {
            Log.d("MenuAction", "Reenviar pedido");
            Toast.makeText(this, "Recargar noticas", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_modify_order) {
            Log.d("MenuAction", "Modificar pedido");
            Toast.makeText(this, "Escribir notica", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}
