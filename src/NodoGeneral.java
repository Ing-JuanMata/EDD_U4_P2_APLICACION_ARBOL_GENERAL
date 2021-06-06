/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ING-JUANMATA
 */
public class NodoGeneral {

    char dato;
    NodoHijo ini, fin;

    public NodoGeneral(char v) {
        dato = v;
        ini = fin = null;
    }

    public boolean enlazar(NodoGeneral hijo) {
        NodoHijo enlace = new NodoHijo(hijo);
        if (enlace == null) {
            return false;
        }

        if (ini == null && fin == null) {
            ini = fin = enlace;
            return true;
        }

        fin.sig = enlace;
        enlace.ant = fin;
        fin = enlace;
        return true;
    }

    public boolean esHoja() {
        return ini == null && fin == null;
    }

    public NodoGeneral obtenerHijo(char valorHijoBuscado) {
        if (esHoja()) {
            return null;
        }

        for (NodoHijo buscar = ini; buscar != null; buscar = buscar.sig) {
            if (buscar.direccionHijo.dato == valorHijoBuscado) {
                return buscar.direccionHijo;
            }
        }

        return null;
    }
}
