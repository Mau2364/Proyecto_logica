package ac.cr.cenfotec.pfinal.bl.entities;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * Utilidad para la generación de contraseñas seguras mediante
 * el uso de sal (salt) y hashing con SHA-256.
 * <p>
 * Esta clase proporciona dos métodos estáticos:
 * <ul>
 *     <li>{@link #generarSal()} para generar valores aleatorios de sal.</li>
 *     <li>{@link #HashConSal(String, String)} para generar el hash seguro de una contraseña.</li>
 * </ul>
 * </p>
 *
 * El objetivo es que las contraseñas nunca se almacenen en texto plano,
 * sino como una combinación de:
 * <pre>
 * hash = SHA-256( sal + contraseña )
 * </pre>
 * Todo codificado en Base64 para facilitar su almacenamiento.
 */

public class Hash {

    /**
     * Genera una sal (salt) aleatoria de 16 bytes utilizando un
     * generador criptográficamente seguro.
     *
     * @return una cadena Base64 que representa la sal generada
     */
    public static String generarSal (){
        byte [] sal = new byte[16];
        new SecureRandom().nextBytes(sal);
        return Base64.getEncoder().encodeToString(sal);
    }
    /**
     * Genera un hash seguro basado en la contraseña recibida y una sal.
     * <p>
     * El proceso es:
     * <ol>
     *     <li>Decodificar la sal desde Base64.</li>
     *     <li>Aplicar SHA-256 usando la sal como entrada inicial.</li>
     *     <li>Agregar la contraseña y generar el hash final.</li>
     *     <li>Codificar el hash en Base64.</li>
     * </ol>
     * </p>
     *
     * @param contrasena contraseña en texto plano ingresada por el usuario
     * @param sal valor de sal en Base64 que fue generado al registrar el usuario
     * @return hash en Base64 de la combinación sal + contraseña
     * @throws RuntimeException si ocurre algún error durante el proceso de hashing
     */
    public static String HashConSal(String contrasena, String sal) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(Base64.getDecoder().decode(sal));
            byte[] hash = md.digest(contrasena.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (Exception e) {
            throw new RuntimeException("Error al encriptar",e);
        }
    }
}
