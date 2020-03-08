package com.mygdx.helicopter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Controlador {

    /////////////////////////////////////////////////////////////////////////////////////
    //
    //ESTADO
    //
    /////////////////////////////////////////////////////////////////////////////////////

    //CONSTANTES
    static private final int PANTALLA_INICIO = 0;
    static private final int PANTALLA_JUEGO = 1;

    //RESTO DEL ESTADO

    //Variable para saber el estado en el que estamos:
    // 0 . Pantalla inicio
    // 1. Jugando
    int estadoJuego;

    //Fondo
    Fondo escena;

    //No se realmente por que hay que declararlo pero hay que hacerlo
    SpriteBatch batch;

    //Nuestra apache pepino
    Helicopter chopper;

    //El teclado
    Teclado et;
    public Controlador() {


        inicializarObjetos();   //Activar los objetos


        estadoJuego = PANTALLA_INICIO; //Ponerlo en el press to start clasicon
    }
    public void render() {

        //Primero el control de estado.
        this.controlEstado();

        //Vacia la ventana del juego
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (estadoJuego == 1) {     //Se ha pulsado la pantalla y empieza la partida
            //Escena de fondo
            escena.pintate(batch);  //Se pinta el fondo

            //renderizar imágenes
            chopper.pintarse(batch);//Y el helicopteraso

        } else {
            //Pantalla inicial
            dibujarPantallaInicial();//Press to start
        }

    }
    public void dispose() {
        //Pos eso, dispose para disposial

        //batch de dibujo
        if (batch != null) {
            batch.dispose();
        }
        //Nave principal
        chopper.dispose();
        //Fondo de pantalla
        escena.dispose();


    }
    private void controlEstado() {
        if (estadoJuego == 0) {              //Si esta pausado que haga sus vainas de juego pausado
            controlEstadoPantallaInicio();
        } else {
            controlEstadoJugando();          //Si no esta pausado que haga sus vainas de juego que no esta pausado
        }
    }
    private void controlEstadoJugando() {    //Vainas de juego que no esta pausado
        //Movemos la nave

        et.mePulsan();


        chopper.moverse(et);

    }
    private void controlEstadoPantallaInicio() {//Vainas de juego que esta pausado
        //Actualizo el teclado
        boolean recienTocado;

        recienTocado = Gdx.input.justTouched();
        if (recienTocado) {                     //Si me tocan me ensiendo
                estadoJuego = PANTALLA_JUEGO;
                inicializarObjetos();
            }
        }


    private void inicializarObjetos() {         //A crear to lo que nos va a hacer falta
        //Creamos el objeto batch para dibujar
        batch = new SpriteBatch();

        //fondo
        escena = new Fondo(0,0,Gdx.graphics.getHeight(),Gdx.graphics.getWidth(),"fondo.png");

        //Creo el teclado
        et = new Teclado();

        //Creo el helicoptero, esta de puta pena hecho y dudo que funcione
        chopper = new Helicopter(Gdx.graphics.getWidth() / 2,Gdx.graphics.getHeight() / 2,-2.00f);

    }
    private void dibujarPantallaInicial() {

        escena.pintate(batch);
        chopper.pintarse(batch);

    }
}
