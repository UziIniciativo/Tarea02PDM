package com.example.tarea02;

import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_activity);
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
