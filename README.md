``
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
``
