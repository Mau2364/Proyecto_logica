package ac.cr.cenfotec.pfinal.bl.entities;

/**
 * Representa una entrada dentro de un diccionario técnico o emocional del sistema.
 * Cada entrada está compuesta por una palabra y la categoría a la que pertenece.
 *
 * <p>
 * Esta clase es utilizada por los módulos de análisis de texto (Bag of Words)
 * para detectar emociones o sugerir categorías técnicas basadas en la descripción
 * de los tickets.
 * </p>
 *
 * <p>
 * La identidad de cada entrada se define únicamente por la palabra, por lo que
 * el método {@code equals()} compara solo ese atributo para evitar duplicados.
 * </p>
 */

public class Diccionario {
    private String palabra;  /** Palabra clave asociada a una emoción o categoría técnica. */
    private String categoria; /** Categoría asignada a la palabra (ejemplo: "frustración", "impresoras"). */

    /**
     * Constructor vacío requerido para frameworks y procesos de inicialización.
     */
    public  Diccionario() {
    }
    /**
     * Constructor principal para crear una entrada del diccionario.
     *
     * @param palabra   palabra clave a registrar
     * @param categoria categoría asociada a la palabra
     */

    public  Diccionario(String palabra, String categoria) {
        this.palabra = palabra;
        this.categoria = categoria;
    }

    /**
     * Obtiene la palabra clave almacenada.
     *
     * @return palabra del diccionario
     */
    public String getPalabra() {
        return palabra;
    }
    /**
     * Modifica la palabra clave asociada a esta entrada.
     *
     * @param palabra nueva palabra
     */
    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }
    /**
     * Obtiene la categoría asociada a la palabra.
     *
     * @return categoría asignada
     */
    public String getCategoria() {
        return categoria;
    }
    /**
     * Modifica la categoría asignada a esta palabra.
     *
     * @param categoria nueva categoría
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * Compara esta entrada con otra basándose únicamente en la palabra.
     * <p>
     * Esto asegura que no existan palabras duplicadas en el diccionario.
     * </p>
     *
     * @param obj objeto a comparar
     * @return {@code true} si la palabra es la misma (ignorando mayúsculas/minúsculas)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Diccionario otro = (Diccionario) obj;
        return palabra != null && palabra.equalsIgnoreCase(otro.palabra);
    }

    /**
     * Calcula el código hash basado únicamente en la palabra, en minúsculas.
     *
     * @return valor hash de la palabra o 0 si es nula
     */
    @Override
    public int hashCode() {
        return palabra == null ? 0 : palabra.toLowerCase().hashCode();
    }

    /**
     * Representación en texto de la entrada del diccionario.
     *
     * @return cadena con la palabra y categoría
     */
    @Override
    public String toString() {
        return "Diccionario{" +
                "palabra='" + palabra + '\'' +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}
