package ac.cr.cenfotec.pfinal.dl;

import ac.cr.cenfotec.pfinal.bl.entities.*;
import java.util.ArrayList;

/**
 * Clase que representa la capa de acceso a datos (Data Layer) del sistema.
 * <p>
 * Administra todas las estructuras de almacenamiento en memoria que utiliza
 * la aplicación, incluyendo listas de usuarios, departamentos, tickets y los
 * diccionarios emocional y técnico.
 * </p>
 * <p>
 * Esta clase funciona como una "base de datos temporal"
 * </p>
 */

public class Data {

    /** Lista de usuarios registrados en el sistema. */
    private ArrayList<Usuario> usuarios = new ArrayList<>();

    /** Lista de departamentos disponibles. */
    private ArrayList<Departamento> departamentos = new ArrayList<>();

    /** Lista de tickets creados. */
    private ArrayList<Ticket> tickets = new ArrayList<>();

    /** Diccionario de palabras emocionales. */
    private ArrayList<Diccionario> diccionarioEmocional = new ArrayList<>();
    /** Diccionario de palabras técnicas. */
    private ArrayList<Diccionario> diccionarioTecnico = new ArrayList<>();

    /**
     * Obtiene la lista de usuarios registrados.
     *
     * @return lista de usuarios
     */
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
    /**
     * Obtiene la lista de departamentos existentes.
     *
     * @return lista de departamentos
     */
    public ArrayList<Departamento> getDepartamentos() {
        return departamentos;
    }
    /**
     * Obtiene la lista de tickets registrados.
     *
     * @return lista de tickets
     */
    public ArrayList<Ticket> getTickets() {
        return tickets;
    }
    /**
     * Obtiene el diccionario emocional.
     *
     * @return lista de entradas emocionales
     */
    public ArrayList<Diccionario> getDiccionarioEmocional() {
        return diccionarioEmocional;
    }
    /**
     * Obtiene el diccionario técnico.
     *
     * @return lista de entradas técnicas
     */
    public ArrayList<Diccionario> getDiccionarioTecnico() {
        return diccionarioTecnico;
    }

    //metodos de busqueda
    /**
     * Busca un usuario por su correo electrónico.
     *
     * @param correo correo del usuario a buscar
     * @return el usuario encontrado o null si no existe
     */
    public Usuario buscarUsuarioPorCorreo(String correo) {
        for (Usuario u : usuarios) {
            if (u.getCorreo().equalsIgnoreCase(correo)) {
                return u;
            }
        }
        return null;
    }
    /**
     * Busca un departamento por su nombre.
     *
     * @param nombre nombre del departamento
     * @return el departamento encontrado o null si no existe
     */
    public Departamento buscarDepartamentoPorNombre(String nombre) {
        for (Departamento d : departamentos) {
            if (d.getNombre().equalsIgnoreCase(nombre)) {
                return d;
            }
        }
        return null;
    }
    /**
     * Busca un ticket por su ID único.
     *
     * @param id identificador del ticket
     * @return ticket encontrado o null si no existe
     */
    public Ticket buscarTicketPorId(int id) {
        for (Ticket t : tickets) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }
}

