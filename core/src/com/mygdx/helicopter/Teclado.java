package com.mygdx.helicopter;

import com.badlogic.gdx.Gdx;

//Version super inicial en la que con que simplemente se pulse la pantalla se active.
//Ya segun vayamos avanzando se cambia para meter boton de pausa,disparos,loquesea

public class Teclado {

    private boolean pulsado;


    public Teclado(){
        pulsado = false;

    }

    public void mePulsan(){
        byte i;
        if (Gdx.input.isTouched()){
            pulsado = true;
        }
        else{
            pulsado = false;
        }
    }


    public boolean pulsado(){
        return pulsado;
    }
}
