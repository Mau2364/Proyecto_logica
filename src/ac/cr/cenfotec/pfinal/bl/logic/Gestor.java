package ac.cr.cenfotec.pfinal.bl.logic;

import ac.cr.cenfotec.pfinal.bl.entities.*;
import ac.cr.cenfotec.pfinal.dl.*;

import java.util.ArrayList;

/**
 * Clase que actúa como capa de lógica del negocio para el sistema de HelpDesk.
 * <p>
 * El Gestor coordina las operaciones principales del programa, como:
 * </p>
 * <ul>
 *     <li>Registro y autenticación de usuarios</li>
 *     <li>Manejo de departamentos</li>
 *     <li>Gestión de tickets</li>
 *     <li>Control de diccionarios técnicos y emocionales</li>
 * </ul>
 * <p>
 * Esta clase utiliza la capa Data como almacenamiento temporal.
 * </p>
 */

public class Gestor {
    /** Capa de acceso a datos que mantiene la información en memoria. */
    private Data data = new Data();
    /**
     * Registra un nuevo usuario aplicando hash y sal a su contraseña.
     *
     * @param nombre nombre completo del usuario
     * @param correo correo electrónico único del usuario
     * @param pass contraseña en texto plano (será encriptada)
     * @param tel teléfono de contacto
     * @param rol rol del usuario (estudiante, funcionario o administrador)
     */
    public void registrarUsuario(String nombre, String correo, String pass, String tel, String rol) {
        String sal = Hash.generarSal();
        String hash = Hash.HashConSal(pass, sal);
        Usuario u = new Usuario(nombre, correo, hash, sal, tel, rol);
        data.getUsuarios().add(u);
    }
    /**
     * Obtiene la lista de todos los usuarios registrados.
     *
     * @return lista de usuarios
     */
    public ArrayList<Usuario> obtenerUsuarios() {
        return data.getUsuarios();
    }

    /**
     * Registra un nuevo departamento en el sistema.
     *
     * @param nombre nombre del departamento
     * @param desc descripción breve
     * @param contacto correo o número de contacto
     */
    public void registrarDepartamento(String nombre, String desc, String contacto) {
        Departamento d = new Departamento(nombre, desc, contacto);
        data.getDepartamentos().add(d);
    }
    /**
     * Devuelve la lista de departamentos registrados.
     *
     * @return lista de departamentos
     */
    public ArrayList<Departamento> obtenerDepartamentos() {
        return data.getDepartamentos();
    }

    /**
     * Agrega una palabra al diccionario emocional.
     *
     * @param e entrada del diccionario emocional
     */
    public void agregarPalabraEmocional(Diccionario e) {
        data.getDiccionarioEmocional().add(e);
    }

    /**
     * Agrega una palabra al diccionario técnico sin validación.
     *
     * @param e entrada del diccionario técnico
     */

    public void agregarPalabraTecnica(Diccionario e) {
        data.getDiccionarioTecnico().add(e);
    }

    /**
     * Registra un ticket asociándolo a un usuario y un departamento.
     *
     * @param asunto asunto del ticket
     * @param descripcion descripción del problema
     * @param correo correo del usuario creador
     * @param dep nombre del departamento asociado
     * @throws RuntimeException si usuario o departamento no existen
     */
    public void registrarTicket(String asunto, String descripcion, String correo, String dep) {

        Usuario u = data.buscarUsuarioPorCorreo(correo);
        if (u == null) throw new RuntimeException("Usuario no existe");

        Departamento d = data.buscarDepartamentoPorNombre(dep);
        if (d == null) throw new RuntimeException("Departamento no existe");

        Ticket t = new Ticket(asunto, descripcion, "Nuevo", u, d);
        data.getTickets().add(t);
    }

    /**
     * Devuelve la lista de tickets registrados.
     *
     * @return lista de tickets
     */
    public ArrayList<Ticket> listarTickets() {
        return data.getTickets();
    }
    /**
     * Agrega una palabra al diccionario emocional, validando que no exista.
     *
     * @param palabra palabra detectada
     * @param categoria emoción asociada
     * @return mensaje de retroalimentación
     */
    public String registrarPalabraEmocional(String palabra, String categoria) {
        Diccionario nueva = new Diccionario(palabra, categoria);

        if (data.getDiccionarioEmocional().contains(nueva)) {
            return "La palabra ya existe en el diccionario emocional.";
        }
        data.getDiccionarioEmocional().add(nueva);
        return "Palabra agregada al diccionario emocional.";
    }

    /**
     * Obtiene el diccionario emocional.
     *
     * @return lista de palabras emocionales
     */
    public ArrayList<Diccionario> obtenerDiccionarioEmocional() {
        return data.getDiccionarioEmocional();
    }

    /**
     * Agrega una palabra al diccionario técnico, validando que no exista.
     *
     * @param palabra palabra técnica
     * @param categoria categoría técnica
     * @return mensaje de retroalimentación
     */
    public String registrarPalabraTecnica(String palabra, String categoria) {
        Diccionario nueva = new Diccionario(palabra, categoria);

        if (data.getDiccionarioTecnico().contains(nueva)) {
            return "La palabra ya existe en el diccionario técnico.";
        }
        data.getDiccionarioTecnico().add(nueva);
        return "Palabra agregada al diccionario técnico.";
    }

    /**
     * Obtiene el diccionario técnico.
     *
     * @return lista de palabras técnicas
     */
    public ArrayList<Diccionario> obtenerDiccionarioTecnico() {
        return data.getDiccionarioTecnico();
    }
    /**
     * Valida las credenciales de un usuario comparando el hash almacenado
     * con el hash generado a partir de la contraseña ingresada.
     *
     * @param correo correo ingresado por el usuario
     * @param pass contraseña ingresada en texto plano
     * @return true si las credenciales son correctas, false de lo contrario
     */
    public boolean validarCredenciales (String correo, String pass) {
        Usuario u = data.buscarUsuarioPorCorreo(correo);
        if (u == null) return false;

        String hashCalculado = Hash.HashConSal(pass, u.getSal());
        return hashCalculado.equals(u.getContrasenaHash());
    }
}

