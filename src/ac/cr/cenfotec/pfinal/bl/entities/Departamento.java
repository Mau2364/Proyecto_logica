package ac.cr.cenfotec.pfinal.bl.entities;

/**
 * Representa un departamento dentro de la mesa de ayuda universitaria.
 * Cada departamento tiene un nombre único, una descripción de sus funciones
 * y un medio de contacto. Los tickets deben estar asociados a un departamento.
 *
 * <p>Esta clase incluye implementación de {@code equals()} y {@code hashCode()},
 * considerando que los departamentos se identifican por su nombre.</p>
 *
 */


public class Departamento {
    /** Nombre único del departamento. */
    private String nombre;
    /** Descripción general de funciones o alcance del departamento. */
    private String descripcion;
    /** Información de contacto (correo o extensión telefónica). */
    private String contacto;

    /**
     * Constructor por defecto.
     */
    public Departamento() {
    }
    /**
     * Constructor para inicializar un departamento con todos sus datos.
     * @param nombre      Nombre único del departamento.
     * @param descripcion Descripción breve del departamento.
     * @param contacto    Medio de contacto (correo o extensión).
     */
    public Departamento(String nombre, String descripcion, String contacto) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.contacto = contacto;
    }

    public String getNombre() {
        return nombre;
    }  /** @return Nombre del departamento. */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    } /** @param nombre Nuevo nombre del departamento. */
    public String getDescripcion() {
        return descripcion;
    } /** @return Descripción del departamento. */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    } /** @param descripcion Nueva descripción del departamento. */
    public String getContacto() {
        return contacto;
    }  /** @return Información de contacto del departamento. */
    public void setContacto(String contacto) {
        this.contacto = contacto;
    } /** @param contacto Nuevo contacto del departamento. */


    /**
     * Compara dos departamentos basándose en su nombre.
     *
     * @param obj Objeto a comparar.
     * @return true si ambos departamentos tienen el mismo nombre.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Departamento otro = (Departamento) obj;
        return nombre != null && nombre.equalsIgnoreCase(otro.nombre);
    }

    /**
     * Genera un valor hash consistente con {@code equals()},
     * @return hash del nombre.
     */
    @Override
    public int hashCode() {
        return nombre == null ? 0 : nombre.toLowerCase().hashCode();
    }

    /**
     * Representación en texto del departamento, útil para listados.
     * @return String con los valores principales del departamento.
     */
    @Override
    public String toString() {
        return "Departamento{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", contacto='" + contacto + '\'' +
                '}';
    }
}
