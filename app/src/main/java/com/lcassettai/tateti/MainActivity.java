package com.lcassettai.tateti;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText player1;
    EditText player2;
    CheckBox jugarSolo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        player1 = (EditText)findViewById(R.id.txtPlayer1);
        player2 = (EditText)findViewById(R.id.txtPlayer2);
        jugarSolo = (CheckBox)findViewById(R.id.cbxSolo);
    }

    public void btnClick(View view) {
        String jugador1 = String.valueOf(player1.getText());
        String jugador2 = String.valueOf(player2.getText());
        if(jugador1.isEmpty()){
            Toast.makeText(this, "Debe rellenar ambos campos", Toast.LENGTH_SHORT).show();
        }else{
            if(jugarSolo.isChecked()){
                Intent i = new Intent(this,Juego.class);
                i.putExtra("jugador1",jugador1);
                i.putExtra("jugador2","Maquina");
                i.putExtra("modo",jugarSolo.isChecked());
                startActivity(i);
            }else if(jugador2.isEmpty()){
                Toast.makeText(this, "Debe rellenar ambos campos", Toast.LENGTH_SHORT).show();
            }else{
                Intent i = new Intent(this,Juego.class);
                i.putExtra("jugador1",jugador1);
                i.putExtra("jugador2",jugador2);
                i.putExtra("modo",jugarSolo.isChecked());
                startActivity(i);
            }
        }

    }

    public void cbxClick(View view) {
        //Bloquear el ingreso del segundo nombre si juega solo
        if(jugarSolo.isChecked()){
            player2.setEnabled(false);
            player2.setText("Maquina");
        }else{
            player2.setEnabled(true);
            player2.setText("");
        }
    }

    public void btnSalir(View view) {
        finish();
    }
}
