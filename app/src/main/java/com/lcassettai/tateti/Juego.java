package com.lcassettai.tateti;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class Juego extends AppCompatActivity {
    String nombreJugador1,nombreJugador2;
    int ActivePlayer = 1 ; // 1 - primer jugador, 2 - segundo jugador
    ArrayList<Integer>Player1 = new ArrayList<Integer>(); // Holdas Player one data
    ArrayList<Integer>Player2 = new ArrayList<Integer>(); // Holdas Player two data
    TextView lblPlayer;
    int contador = 0;
    boolean automatico  = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego);
        Bundle b = getIntent().getExtras();
        nombreJugador1 = b.getString("jugador1");
        nombreJugador2 = b.getString("jugador2");
        automatico = b.getBoolean("modo");
        lblPlayer = (TextView)findViewById(R.id.lblPlayer);
        lblPlayer.setText("Empieza: " +nombreJugador1);
    }


    public void buClick(View view) {
        Button buSelected =  (Button) view;

        int CellID = 0;
        switch((buSelected.getId())){
            case R.id.bu1:CellID = 1;
                break;
            case R.id.bu2:CellID = 2;
                break;
            case R.id.bu3:CellID = 3;
                break;
            case R.id.bu4:CellID = 4;
                break;
            case R.id.bu5:CellID = 5;
                break;
            case R.id.bu6:CellID = 6;
                break;
            case R.id.bu7:CellID = 7;
                break;
            case R.id.bu8:CellID = 8;
                break;
            case R.id.bu9:CellID = 9;
                break;
        }
        PlayGame(CellID,buSelected);

    }


    private void PlayGame(int CellID, Button buSelected){

        if(ActivePlayer == 1 ){
            lblPlayer.setText("Es el turno de : " +nombreJugador2);
            buSelected.setText("X");
            ActivePlayer = 2;
            //buSelected.setBackgroundColor(Color.RED);
            Player1.add(CellID);
            if(automatico){
                autoPlay();
            }
        }else if(ActivePlayer == 2){
            lblPlayer.setText("Es el turno de : " +nombreJugador1);
            buSelected.setText("O");
            ActivePlayer = 1;
            //buSelected.setBackgroundColor(Color.BLUE);
            Player2.add(CellID);
        }

        buSelected.setEnabled(false);
        contador++;
        VerificarGanador();
    }

    private void VerificarGanador(){
        int ganador = 0;

        //Ganador por filas
        if(Player1.contains(1) && Player1.contains(2) && Player1.contains(3)){
            ganador  = 1;
        }
        if(Player2.contains(1) && Player2.contains(2) && Player2.contains(3)){
            ganador  = 2;
        }


        if(Player1.contains(4) && Player1.contains(5) && Player1.contains(6)){
            ganador  = 1;
        }
        if(Player2.contains(4) && Player2.contains(5) && Player2.contains(6)){
            ganador  = 2;
        }


        if(Player1.contains(7) && Player1.contains(8) && Player1.contains(9)){
            ganador  = 1;
        }
        if(Player2.contains(7) && Player2.contains(8) && Player2.contains(9)){
            ganador  = 2;
        }



        //Ganador por columnas
        if(Player1.contains(1) && Player1.contains(4) && Player1.contains(7)){
            ganador  = 1;
        }
        if(Player2.contains(1) && Player2.contains(4) && Player2.contains(7)){
            ganador  = 2;
        }


        if(Player1.contains(2) && Player1.contains(5) && Player1.contains(8)){
            ganador  = 1;
        }
        if(Player2.contains(2) && Player2.contains(5) && Player2.contains(8)){
            ganador  = 2;
        }


        if(Player1.contains(3) && Player1.contains(6) && Player1.contains(9)){
            ganador  = 1;
        }
        if(Player2.contains(3) && Player2.contains(6) && Player2.contains(9)){
            ganador  = 2;
        }



        //Ganador Diagonales
        if(Player1.contains(1) && Player1.contains(5) && Player1.contains(9)){
            ganador  = 1;
        }
        if(Player2.contains(1) && Player2.contains(5) && Player2.contains(9)){
            ganador  = 2;
        }

        if(Player1.contains(3) && Player1.contains(5) && Player1.contains(7)){
            ganador  = 1;
        }
        if(Player2.contains(3) && Player2.contains(5) && Player2.contains(7)){
            ganador  = 2;
        }


        if(ganador == 0 && contador == 9) {
            //Empate
            Toast.makeText(this, "Empate", Toast.LENGTH_LONG).show();
            lblPlayer.setText("Empate!");
        }

        if(ganador == 1){
            //Ganador Player 1
            Toast.makeText(this, "El Ganador es " + nombreJugador1, Toast.LENGTH_SHORT).show();
            lblPlayer.setText(nombreJugador1 + " es el ganador!");
        }else if(ganador == 2){
            //Ganador player 2
            Toast.makeText(this, "El Ganador es " + nombreJugador2, Toast.LENGTH_SHORT).show();
            lblPlayer.setText(nombreJugador2 + " es el ganador!");
        }


    }

    private void autoPlay(){
        ArrayList<Integer> lugaresVacios= new ArrayList<Integer>();
        for (int cellID = 1 ; cellID < 10 ; cellID++){
            if(!Player1.contains(cellID) || Player2.contains(cellID)){
                lugaresVacios.add(cellID);
            }
        }

        Random r = new Random();
        int RandomIndex = r.nextInt(lugaresVacios.size() - 0) + 0;
        int CellID = lugaresVacios.get(RandomIndex);

        Button buSelected;
        switch(CellID){
            case 1:
                buSelected = (Button)findViewById(R.id.bu1);
                break;
            case 2:
                buSelected = (Button)findViewById(R.id.bu2);
                break;
            case 3:
                buSelected = (Button)findViewById(R.id.bu3);
                break;
            case 4:
                buSelected = (Button)findViewById(R.id.bu4);
                break;
            case 5:
                buSelected = (Button)findViewById(R.id.bu5);
                break;
            case 6:
                buSelected = (Button)findViewById(R.id.bu6);
                break;
            case 7:
                buSelected = (Button)findViewById(R.id.bu7);
                break;
            case 8:
                buSelected = (Button)findViewById(R.id.bu8);
                break;
            case 9:
                buSelected = (Button)findViewById(R.id.bu9);
                break;
            default:
                buSelected = (Button)findViewById(R.id.bu1);
                break;
        }

        PlayGame(CellID,buSelected);
    }

   
}
