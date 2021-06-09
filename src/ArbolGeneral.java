/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ING-JUANMATA
 */
public class ArbolGeneral {

    NodoGeneral raiz;

    public ArbolGeneral() {
        raiz = null;
    }

    public boolean insertar(char dato, String path) {
        if (raiz == null) {
            raiz = new NodoGeneral(dato);
            return raiz != null;
        }

        if (path.isEmpty()) {
            return false;
        }

        NodoGeneral padre = buscarNodo(path);
        if (padre == null) {
            return false;
        }

        NodoGeneral hijoYaExiste = buscarNodo(path + "/" + dato);
        if (hijoYaExiste != null) {
            return false;
        }

        NodoGeneral nuevo = new NodoGeneral(dato);
        return padre.enlazar(nuevo);
    }

    private NodoGeneral buscarNodo(String path) {
        path = path.substring(1);
        String vector[] = path.split("/");
        if (vector[0].charAt(0) == raiz.dato) {
            if (vector.length == 1) {
                return raiz;
            }
            NodoGeneral padre = raiz;
            for (int i = 1; i < vector.length; i++) {
                padre = padre.obtenerHijo(vector[i].charAt(0));
                if (padre == null) {
                    return padre;
                }
            }
            return padre;
        }

        return null;
    }

    public NodoGeneral buscarNodoRecursivo(String path) {
        path = path.substring(1);
        if (path.split("/")[0].charAt(0) == raiz.dato && path.split("/").length == 1) {
            return raiz;
        }
        if (path.length() == 3) {
            return raiz.obtenerHijo(path.charAt(2));
        }
        return buscarNodoRecursivo(path.substring(4), raiz.obtenerHijo(path.charAt(2)));
    }

    private NodoGeneral buscarNodoRecursivo(String path, NodoGeneral actual) {
        if (actual == null) {
            return null;
        }
        return path.length() == 1 ? actual.obtenerHijo(path.charAt(0)) : buscarNodoRecursivo(path.substring(2), actual.obtenerHijo(path.charAt(0)));
    }
}
