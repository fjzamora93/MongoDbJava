package DAO;
import java.util.*;
import models.*;
import org.bson.Document;
import com.mongodb.client.MongoCollection;
import database.MongoDBConnection;


public class ProfesorDao {
    private List<Profesor> profesores;
    MongoCollection coleccionProfesores;

    public ProfesorDao() {
        this.profesores = new ArrayList<>();
        coleccionProfesores = new MongoDBConnection().getProfesoresCollecion();
    }

    // Método para insertar un profesor
    public void insertarProfesor(Profesor profesor) {
        profesores.add(profesor);
        Document document = new Document()
                .append("nombre", profesor.getRating())
                .append("apellido", profesor.getAge())
                .append("nombre", profesor.getName())
                .append("correo",profesor.getGender())
                .append("apellido", profesor.getPhone())
                .append("correo",profesor.getEmail())
                .append("edad",profesor.getSubjects())
                .append("edad",profesor.getTitle());
        coleccionProfesores.insertOne(document);
        System.out.println("Profesor insertado correctamente.");
    }

    // Método para buscar profesores por rango de edad
    public List<Profesor> buscarProfesoresPorEdad(int edadMin, int edadMax) {
        List<Profesor> encontrados = new ArrayList<>();
        for (Profesor profesor : profesores) {
            if (profesor.getAge() >= edadMin && profesor.getAge() <= edadMax) {
                encontrados.add(profesor);
            }
        }
        return encontrados;
    }

    // Método para mostrar todos los profesores
    public void mostrarProfesores() {
        if (profesores.isEmpty()) {
            System.out.println("No hay profesores registrados.");
        } else {
            for (Profesor profesor : profesores) {
                System.out.println(profesor);
            }
        }
    }

    // Método para actualizar la calificación de un profesor por email
    public boolean actualizarProfesor(String email, double nuevaCalificacion) {
        for (Profesor profesor : profesores) {
            if (profesor.getEmail().equals(email)) {
                profesor.actualizarCalificacion(nuevaCalificacion);
                System.out.println("Calificación actualizada.");
                return true;
            }
        }
        System.out.println("Profesor no encontrado.");
        return false;
    }
}
