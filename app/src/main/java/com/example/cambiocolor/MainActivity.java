package com.example.cambiocolor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.graphics.Color;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView cambio; //es el textview grande para llamarlo
    TextView ventana; //es el textview pequeño
    int coloractual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    cambio = (TextView) findViewById(R.id.colorrs); //linea para espesificar que estooy modificando
    ventana =(TextView) findViewById(R.id.texto); //linea para espesificar que estooy modificando
    }

    private  void cambiodecolor(int color) {

        cambio.setBackgroundColor(color);//todo este private es para solo llamar al metodo cuando se ocupe
        ventana.setTextColor(color);
        coloractual = color;
    }

    @Override
    protected void onResume() {
        super.onResume();
        cambiodecolor(Color.rgb(0,191,255)); //especifico el color en este caso naranja
    }

    @Override
    protected void onPause() {
        super.onPause();
        cambiodecolor(Color.rgb(255, 165, 0));//especifico el color en este caso celeste
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    outState.putInt("coloractual",coloractual); //le digo que cuando ocurra este metodo ponga el color
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        coloractual = savedInstanceState.getInt("coloractual");
        cambio.setBackgroundColor(coloractual); //le digo que cuando ocurra este metodo ponga el color pero aqui que lo cambie
    }
}
