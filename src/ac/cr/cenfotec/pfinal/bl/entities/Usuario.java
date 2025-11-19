package ac.cr.cenfotec.pfinal.bl.entities;
/**
 * Representa un usuario dentro del sistema.
 * <p>
 * Los usuarios pueden pertenecer a distintos roles dentro de la plataforma,
 * como estudiante, funcionario o administrador. Esta clase almacena la
 * información básica necesaria para autenticación y administración,
 * incluyendo correo, contraseña con sal y datos de contacto.
 * </p>
 */
import java.util.Objects;

public class Usuario {
    private String nombre;  /** Nombre del usuario. */
    private String correo; /** Correo electrónico único del usuario (identificador principal). */
    private String contrasenaHash;  /** Contraseña cifrada (hash). */
    private String sal;  /** Sal utilizada para generar el hash de la contraseña. */
    private String telefono; /** Número de teléfono del usuario. */
    private String rol;  /** Rol del usuario dentro del sistema (estudiante, funcionario, administrador). */

    /**
     * Constructor por defecto.
     */
    public Usuario(){
    }
    /**
     * Constructor principal que permite crear un usuario con todos sus atributos.
     *
     * @param nombre          nombre del usuario
     * @param correo          correo electrónico único
     * @param contrasenaHash  contraseña cifrada
     * @param sal             sal utilizada para hashing
     * @param telefono        número de teléfono
     * @param rol             rol del usuario dentro del sistema
     */
    public Usuario(String nombre, String correo, String contrasenaHash, String sal, String telefono, String rol) {
        this.nombre = nombre;
        this.correo = correo;
        this.contrasenaHash = contrasenaHash;
        this.sal = sal;
        this.telefono = telefono;
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }  /** @return nombre del usuario */
    /** @param nombre nuevo del usuario */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /** @return correo electrónico del usuario */
    public String getCorreo() {
        return correo;
    }
    /** @param correo nuevo del usuario */
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    /** @return hash de la contraseña */
    public String getContrasenaHash() {
        return contrasenaHash;
    }
    /** @param  contrasenaHash nuevo hash de contraseña */
    public void setContrasenaHash(String contrasenaHash) {
        this.contrasenaHash = contrasenaHash;
    }
    /** @return sal de la contraseña */
    public String getSal() {
        return sal;
    }
    /** @param sal nueva sal */
    public void setSal(String sal) {
        this.sal = sal;
    }
    /** @return número de teléfono */
    public String getTelefono() {
        return telefono;
    }
    /** @param telefono nuevo número de teléfono */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /** @return rol del usuario */
    public String getRol() {
        return rol;
    }
    /** @param rol nuevo rol del usuario */
    public void setRol(String rol) {
        this.rol = rol;
    }

    //Metodos sobreescritos
    /**
     * Retorna una representación textual del usuario.
     *
     * @return cadena con los datos relevantes del usuario
     */
    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", contrasenaHash='" + contrasenaHash + '\'' +
                ", sal='" + sal + '\'' +
                ", telefono='" + telefono + '\'' +
                ", rol='" + rol + '\'' +
                '}';
    }

    /**
     * Dos usuarios se consideran iguales si tienen el mismo correo electrónico.
     *
     * @param o objeto a comparar
     * @return true si ambos usuarios comparten el mismo correo (ignorando mayúsculas)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario otro = (Usuario) o;
        return correo != null && correo.equalsIgnoreCase(otro.correo);
    }
    /**
     * Genera un código hash basado únicamente en el correo electrónico.
     *
     * @return hash calculado a partir del correo
     */
    @Override
    public int hashCode() {
        return correo ==  null ? 0 : correo.toLowerCase().hashCode();
    }
}
