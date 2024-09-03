package org.example;

public class Main {
    public static void main(String[] args) {
        // Crear instancias de Estudiante
        Estudiante estudiante1 = new Estudiante(1, "Juan", "Pérez", "2000-05-15", "matriculado");
        Estudiante estudiante2 = new Estudiante(2, "Ana", "García", "1999-08-22", "matriculado");

        // Crear instancias de Curso
        Curso curso1 = new Curso(101, "Matemáticas", "Curso de Matemáticas Básicas", 3, "1.0");
        Curso curso2 = new Curso(102, "Historia", "Curso de Historia Universal", 2, "1.0");

        // Instanciar GestorAcademico
        GestorAcademico gestor = new GestorAcademico();

        try {
            // Matricular estudiantes
            gestor.matricularEstudiante(estudiante1);
            gestor.matricularEstudiante(estudiante2);
            System.out.println("Estudiantes matriculados correctamente.");

            // Agregar cursos
            gestor.agregarCurso(curso1);
            gestor.agregarCurso(curso2);
            System.out.println("Cursos agregados correctamente.");

            // Inscribir estudiantes en cursos
            gestor.inscribirEstudianteCurso(estudiante1, 101);
            gestor.inscribirEstudianteCurso(estudiante2, 102);
            System.out.println("Estudiantes inscritos en cursos correctamente.");

            // Probar la desinscripción de un estudiante
            gestor.desinscribirEstudianteCurso(1, 101);
            System.out.println("Estudiante desinscrito correctamente.");

            // Mostrar los estudiantes matriculados
            System.out.println("\nEstudiantes matriculados:");
            gestor.mostrarEstudiantes();

            // Mostrar los cursos disponibles
            System.out.println("\nCursos disponibles:");
            gestor.mostrarCursos();

            // Intentar inscribir un estudiante ya inscrito en un curso
            gestor.inscribirEstudianteCurso(estudiante2, 102); // Esto debería lanzar una excepción
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
