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
        return buscarNodoRecursivo(path.substring(2), raiz.ini);
    }

    private NodoGeneral buscarNodoRecursivo(String path, NodoHijo actual) {
        if (actual == null) {
            return null;
        }
        if (path.length() == 1) {
            return actual.direccionHijo.dato == path.charAt(0) ? actual.direccionHijo : buscarNodoRecursivo(path, actual.sig);
        }
        
        return actual.direccionHijo.dato == path.charAt(0) ? buscarNodoRecursivo(path.substring(2), actual.direccionHijo.ini) : buscarNodoRecursivo(path, actual.sig);
    }
}
