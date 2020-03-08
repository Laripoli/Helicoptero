package com.mygdx.helicopter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Fondo {
    /////////////////////////////////////////////////////////////////////////////////////
    //
    //ESTADO
    //
    /////////////////////////////////////////////////////////////////////////////////////
    private Texture imgFondo; //Nuestra imagen a pintar.

    //private int velocidadX; para cuando vayamos a animarlo
    //private int velocidadY;

    private int posX;
    private int posY;
    private int anchoVentana;
    private int altoVentana;
   //private int ancho; para el movimiento
   //private int alto;
    private static final String FILE_FONDO1 = "fondo.png"; //el sprite puto que he hecho

    /////////////////////////////////////////////////////////////////////////////////////
    //
    //COMPORTAMIENTOS
    //
    /////////////////////////////////////////////////////////////////////////////////////

    //CONSTRUCTOR/ES
    public Fondo(int posIniX, int posIniY, int anV, int alV, String FILE_FONDO1) {//int velImagenX, int velImagenY,

        //velocidadX = velImagenX;
        //velocidadY = velImagenY;
        posX = posIniX;
        posY = posIniY;

        altoVentana = alV;
        anchoVentana = anV;
        imgFondo = new Texture(FILE_FONDO1);
        //ancho = imgFondo.getWidth();
        //alto = imgFondo.getHeight();

    }
    public void pintate(SpriteBatch miSB) {
        TextureRegion ventana;

        ventana = new TextureRegion(imgFondo,posX,posY,altoVentana,anchoVentana);

        miSB.begin();
        miSB.draw(ventana, 0, 0);
        miSB.end();

    }
    public void dispose() {
        imgFondo.dispose();
    }


    public int getAltoFondo() {
        return (int)imgFondo.getHeight();
    }//Mas mielda pal movimiento

    public int getAnchoFondo() {
        return (int)imgFondo.getWidth();
    }
}
