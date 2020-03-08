package com.mygdx.helicopter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Helicopter {
/////////////////////////////////////////////////////////////////////////////////////
    //
    //ESTADO
    //
    /////////////////////////////////////////////////////////////////////////////////////

    //Posiciones en la pantalla. Float para movimientos suaves
    private final float posX;
    private float posY;

    //velocidad eje Y
    private float velY;

    //ancho y alto del sprite divido por 2 para colisiones
    private float anchoDiv2;
    private float altoDiv2;

   //sprite
    private final Texture img;
    private final String NOMBRE_SPRITE = "helicoptero.png";
    /////////////////////////////////////////////////////////////////////////////////////
    //
    //COMPORTAMIENTO
    //
    /////////////////////////////////////////////////////////////////////////////////////


    //CONSTRUCTORES
    public Helicopter() {
        posX = 0.0f;
        posY = 0.0f;
        velY = -2.0f;   //Para bajar, cuando veamos en la pantalla se decide mejor cuan poner
        img = null;
        anchoDiv2 = 0.0f;
        altoDiv2 = 0.0f;

    }
    //El string nombreImg puede que este mal
    public Helicopter(float nuevaPosX, float nuevaPosY, float nuevaVelY) {
        posX = nuevaPosX;
        posY = nuevaPosY;
        velY = nuevaVelY;
        img = new Texture(NOMBRE_SPRITE);
        anchoDiv2 = img.getWidth() / 2.0f;
        altoDiv2 = img.getHeight() / 2.0f;
    }


    //Resto de Comportamientos

    //Moverse por la pantalla
    public void moverse(Teclado et) {  //Da igual al principio o al final ya que se va a ejecutar igual

        if (et.pulsado()) {      //While para que haya que mantener pulsado
            posY -= velY;
        }
        else {
            posY += velY;              //Si no se pulsa se va pabajo
        }
    }




    public void pintarse(SpriteBatch miSB) {
        miSB.begin();
        miSB.draw(img, posX - anchoDiv2, posY - altoDiv2);
        miSB.end();
    }

    public void dispose() {
        if (img != null) {
            img.dispose();
        }
    }

    //Getters ahoramismo innecesarios, cuando ya nos metamos en colisiones pos ahi

    public float getPosX() {
        return posX;
    }

    public float getPosY() {
        return posY;
    }

    public float getAnchoDiv2() { return anchoDiv2; }

    public float getAltoDiv2() {
        return altoDiv2;
    }
}
