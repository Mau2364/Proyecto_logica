package ac.cr.cenfotec.pfinal.bl.logic;

import java.util.ArrayList;

/**
 * Clase encargada de generar un modelo Bag of Words (BoW) a partir de un texto.
 * <p>
 * Un Bag of Words convierte el texto en una lista de palabras normalizadas,
 * removiendo símbolos especiales y dividiéndolo por espacios. Esta estructura
 * es utilizada por el sistema para análisis técnico y emocional mediante
 * coincidencias con los diccionarios configurados por el usuario.
 * </p>
 */

public class BagOfWords {
    private ArrayList<String> palabras;  /** Lista de palabras resultante del procesamiento del texto original. */

    /**
     * Construye un modelo Bag of Words a partir del texto recibido.
     *
     * @param texto texto original a procesar y convertir en lista de palabras
     */
    public BagOfWords(String texto) {
        this.palabras = generarBow(texto);
    }

    /**
     * Procesa el texto, aplicando:
     * <ul>
     *   <li>Normalización a minúsculas</li>
     *   <li>Eliminación de caracteres especiales (solo letras, números y tildes)</li>
     *   <li>Separación por espacios</li>
     *   <li>Remoción de espacios vacíos</li>
     * </ul>
     *
     * @param texto texto a procesar
     * @return lista de palabras limpias y normalizadas
     */
    private ArrayList<String> generarBow(String texto) {
        texto = texto.toLowerCase().replaceAll("[^a-z0-9áéíóú ]", "");
        String[] arr = texto.split(" ");
        ArrayList<String> bow = new ArrayList<>();

        for (String p : arr) {
            if (!p.trim().isEmpty()) {
                bow.add(p);
            }
        }
        return bow;
    }
    /**
     * Obtiene la lista de palabras generada por el Bag of Words.
     *
     * @return lista de palabras
     */
    public ArrayList<String> getPalabras() {
        return palabras;
    }
}