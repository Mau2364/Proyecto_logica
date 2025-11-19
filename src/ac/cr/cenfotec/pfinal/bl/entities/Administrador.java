package ac.cr.cenfotec.pfinal.bl.entities;

public class Administrador extends Usuario{ //herencia

    /**
     * Constructor por defecto.
     * Llama al constructor vacío de {@link Usuario}.
     */
    public Administrador() {
        super();
    }


    /**
     * Constructor que permite crear un administrador con todos los datos requeridos.
     *
     * @param nombre   Nombre administrador.
     * @param correo   Correo electrónico del administrador (único).
     * @param hash     Contraseña ya encriptada (hash).
     * @param sal      Sal usada para generar el hash.
     * @param telefono Teléfono de contacto.
     */
    public Administrador (String nombre, String correo, String hash, String sal, String telefono) {
        super(nombre, correo, hash, sal, telefono, "Administrador");
    }
}
