package com.example.botondinamico;

import android.widget.Spinner;

public class modeloTipoBoton {
    String nombre;
    int posicionSpinner;
    String textSpinner;


    public modeloTipoBoton(String nombre, int posicionSpinner, String textSpinner) {
        this.nombre = nombre;
        this.posicionSpinner = posicionSpinner;
        this.textSpinner = textSpinner;
    }

    public String getTextSpinner() {
        return textSpinner;
    }

    public void setTextSpinner(String textSpinner) {
        this.textSpinner = textSpinner;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPosicionSpinner() {
        return posicionSpinner;
    }

    public void setPosicionSpinner(int posicionSpinner) {
        this.posicionSpinner = posicionSpinner;
    }


}
