package ac.cr.cenfotec.pfinal.bl.entities;

/**
 * Representa un ticket de soporte dentro del sistema.
 * <p>
 * Cada ticket contiene información relacionada con un problema reportado por un
 * usuario, incluyendo el departamento correspondiente, el estado actual y una
 * descripción del incidente.
 * </p>
 *
 * <p>
 * El sistema asigna automáticamente un identificador único incremental mediante
 * un contador estático.
 * </p>
 */

public class Ticket {
    private static int contador = 1;  /** Contador estático para generar IDs únicos. */
    private int id; /** ID único del ticket. */
    private String asunto;  /** Breve resumen del problema reportado. */
    private String descripcion;  /** Descripción detallada del problema. */
    private String estado;  /** Estado del ticket (Nuevo, En Progreso, Resuelto). */
    private Usuario usuario; /** Usuario asociado que creó el ticket. */
    private Departamento departamento; /** Departamento encargado de resolver el ticket. */

    /**
     * Constructor por defecto.
     * <p>
     * Asigna automáticamente un ID único utilizando el contador estático.
     * </p>
     */
    public Ticket(){
        this.id = contador++;
    }
    /**
     * Constructor principal para crear un ticket con todos sus datos.
     *
     * @param asunto       asunto del ticket
     * @param descripcion  detalle del problema reportado
     * @param estado       estado inicial del ticket
     * @param usuario      usuario que reporta el incidente
     * @param departamento departamento asignado
     */
    public Ticket(String asunto, String descripcion, String estado, Usuario usuario, Departamento departamento){
        this.id = contador++;
        this.asunto = asunto;
        this.descripcion = descripcion;
        this.estado = estado;
        this.usuario = usuario;
        this.departamento = departamento;
    }
    public String getAsunto() { /** @return asunto del ticket */
        return asunto;
    }
    public void setAsunto(String asunto) {
        this.asunto = asunto;
    } /** @param asunto nuevo asunto del ticket */
    public String getDescripcion() {
        return descripcion;
    }   /** @return descripción del ticket */
    /** @param descripcion nueva descripción del ticket */
    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}
    /** @return contador global de tickets generados */
    public static int getContador() {
        return contador;
    }
    /**
     * Permite modificar el contador (no recomendado salvo en casos de carga de datos).
     * @param contador nuevo valor del contador
     */
    public static void setContador(int contador) {
        Ticket.contador = contador;
    }
    public int getId() {
        return id;
    } /** @return id único del ticket */
    public void setId(int id) {this.id = id;}  /** @param id nuevo identificador del ticket */
    public String getEstado() {
        return estado;
    }  /** @return estado actual del ticket */
    public void setEstado(String estado) {
        this.estado = estado;
    }  /** @param estado nuevo estado del ticket */
    public Usuario getUsuario() {
        return usuario;
    }  /** @return usuario que creó el ticket */
    public void setUsuario(Usuario usuario) {this.usuario = usuario;}/** @param usuario usuario asociado al ticket */
    public Departamento getDepartamento() {
        return departamento;
    }  /** @return departamento encargado */
    /** @param departamento nuevo departamento asociado */
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    /**
     * Dos tickets se consideran iguales si comparten el mismo ID.
     *
     * @param obj objeto a comparar
     * @return true si ambos tickets tienen el mismo id
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Ticket otro = (Ticket) obj;
        return this.id == otro.id;
    }
    /**
     * Genera un hash basado únicamente en el ID del ticket.
     *
     * @return hash generado
     */
    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    /**
     * Representación textual del ticket.
     *
     * @return cadena con los datos principales del ticket
     */
    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", asunto='" + asunto + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", estado='" + estado + '\'' +
                ", usuario=" + usuario.getCorreo() +
                ", departamento=" + departamento +
                '}';
    }
}
