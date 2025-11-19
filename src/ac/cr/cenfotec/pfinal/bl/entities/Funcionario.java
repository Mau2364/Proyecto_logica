package ac.cr.cenfotec.pfinal.bl.entities;
/**
 * Representa un usuario del sistema con rol de funcionario.
 * <p>
 * Un funcionario es el encargado de atender los tickets y puede estar
 * asociado a una especialidad determinada, como soporte técnico,
 * orientación, mantenimiento, entre otros.
 * </p>
 *
 * Esta clase extiende a {@link Usuario}, heredando la información básica
 * del usuario y asignando automáticamente el rol "funcionario".
 */

public class Funcionario extends Usuario{ //herencia

    /**
     * Área o especialidad del funcionario dentro del sistema.
     */

    private String especialidad;

    /**
     * Constructor vacío
     */
    public Funcionario() {
        super();
    }
    /**
     * Constructor que crea un funcionario con toda su información personal
     * y de autenticación, incluyendo la especialidad.
     *
     * @param nombre       nombre del funcionario
     * @param correo       correo institucional del funcionario
     * @param hash         contraseña almacenada como hash
     * @param sal          sal utilizada para generar el hash
     * @param telefono     número telefónico del funcionario
     * @param especialidad área de especialización del funcionario
     */
    public Funcionario(String nombre, String correo, String hash, String sal, String telefono,String especialidad) {
        super(nombre, correo, hash, sal, telefono, "funcionario");
        this.especialidad = especialidad;
    }

    /**
     * Obtiene la especialidad o área del funcionario.
     *
     * @return la especialidad del funcionario
     */
    public String getEspecialidad() {
        return especialidad;
    }
}
