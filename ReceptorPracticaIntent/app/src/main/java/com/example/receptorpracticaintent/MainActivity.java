package com.example.receptorpracticaintent;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView texto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texto = (TextView) findViewById(R.id.Txt_Receptor);

        Intent intent = getIntent();
        String action = ((Intent) intent).getAction();
        String type = intent.getType();

        if(Intent.ACTION_SEND.equals(action) && type != null){
            if("text/plain".equals(type)){
                manipularText(intent);
            }
        }
    }

    private void manipularText(Intent intent)
    {
       /* if(texto != null)
        {
            texto.setText("Lista de Pedidos: " + "\n" + "\n" + " - " + texto);
            //Snackbar.make(findViewById(R.id.toolbar),texto, Snackbar.LENGTH_LONG).show(); //encontrar una vista
            //Toast.makeText(MainActivity.this,texto, Toast.LENGTH_LONG).show();
        }*/

        String sharedText = intent.getStringExtra(Intent.EXTRA_TEXT);
        if(sharedText != null){
            //Toast.makeText(MainActivity.this, sharedText, Toast.LENGTH_LONG).show();
            texto.setText(sharedText);

        }
    }
}
