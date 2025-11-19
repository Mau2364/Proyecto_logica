package ac.cr.cenfotec.pfinal.bl.entities;

/**
 * Representa un usuario del sistema con rol de estudiante.
 * <p>
 * Esta clase hereda de {@link Usuario} y únicamente establece el rol
 * correspondiente para diferenciarlo de otros tipos de usuarios en el sistema,
 * como funcionarios o administradores.
 * </p>
 */

/**
 * Constructor vacío utilizado por procesos de inicialización,
 */
public class Estudiante extends Usuario {

    public Estudiante() {
        super();
    }

    /**
     * Constructor que crea un estudiante con sus datos personales
     * y credenciales ya procesadas (hash + sal).
     *
     * @param nombre   nombre del estudiante
     * @param correo   correo institucional del estudiante
     * @param hash     contraseña en formato hash
     * @param sal      sal utilizada para generar el hash
     * @param telefono número telefónico del estudiante
     */

    public Estudiante(String nombre, String correo, String hash, String sal, String telefono) {
        super(nombre, correo, hash, sal, telefono, "estudiante"); {
        }
    }
}
