package com.example.practicacalificadaintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edt_nombre;
    CheckBox checkBox1,checkBox2,checkBox3,checkBox4,checkBox5;
    Button btn_enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_nombre = (EditText) findViewById(R.id.edt_nombre);
        checkBox1=(CheckBox)findViewById(R.id.checkBox1);
        checkBox2=(CheckBox)findViewById(R.id.checkBox2);
        checkBox3=(CheckBox)findViewById(R.id.checkBox3);
        checkBox4=(CheckBox)findViewById(R.id.checkBox4);
        checkBox5=(CheckBox)findViewById(R.id.checkBox5);
        btn_enviar=(Button)findViewById(R.id.btn_enviar);

        btn_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                String nombre = edt_nombre.getText().toString();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT,edt_nombre.getText().toString());

                if (checkBox1.isChecked()) {

                    Toast t = Toast.makeText(getApplicationContext(),"Pedido del cliente "+nombre+" agregado", Toast.LENGTH_SHORT);
                    t.show();
                    sendIntent.putExtra(Intent.EXTRA_TEXT,"Pedido del cliente: "+nombre+"\n"+checkBox1.getText().toString());
                }
                else if (checkBox2.isChecked())
                {
                    Toast t = Toast.makeText(getApplicationContext(),"Pedido del cliente "+nombre+" agregado", Toast.LENGTH_SHORT);
                    t.show();
                    sendIntent.putExtra(Intent.EXTRA_TEXT,"Pedido del cliente: "+nombre+"\n"+checkBox2.getText().toString());
                    //ckb_opcion2.setChecked(false);
                }
                else if (checkBox3.isChecked())
                {
                    Toast t = Toast.makeText(getApplicationContext(),"Pedido del cliente "+nombre+" agregado", Toast.LENGTH_SHORT);
                    t.show();
                    sendIntent.putExtra(Intent.EXTRA_TEXT,"Pedido del cliente: "+nombre+"\n"+checkBox3.getText().toString());
                }
                else if (checkBox4.isChecked())
                {
                    Toast t = Toast.makeText(getApplicationContext(),"Pedido del cliente "+nombre+" agregado", Toast.LENGTH_SHORT);
                    t.show();
                    sendIntent.putExtra(Intent.EXTRA_TEXT,"Pedido del cliente: "+nombre+"\n"+checkBox4.getText().toString());
                }
                else if (checkBox5.isChecked())
                {
                    Toast t = Toast.makeText(getApplicationContext(),"Pedido del cliente "+nombre+" agregado", Toast.LENGTH_SHORT);
                    t.show();
                    sendIntent.putExtra(Intent.EXTRA_TEXT,"Pedido del cliente: "+nombre+"\n"+checkBox5.getText().toString());
                }

                sendIntent.setType("text/plain");
                if(null !=sendIntent.resolveActivity(getPackageManager())){
                    startActivity(Intent.createChooser(sendIntent,getResources().getText(R.string.send_to)));
                }
            }
        });
    }
}
