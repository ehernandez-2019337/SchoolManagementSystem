package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GestorAcademico implements ServiciosAcademicosI {

    // Listas para almacenar estudiantes y cursos
    private ArrayList<Estudiante> estudiantes = new ArrayList<>();
    private ArrayList<Curso> cursos = new ArrayList<>();

    // HashMap para mantener la lista de estudiantes inscritos en cada curso
    private HashMap<Integer, ArrayList<Estudiante>> estudiantesPorCurso = new HashMap<>();

    // Excepciones personalizadas definidas como clases internas
    public static class EstudianteYaMatriculadoException extends Exception {
        public EstudianteYaMatriculadoException(String mensaje) {
            super(mensaje);
        }
    }

    public static class CursoYaExistenteException extends Exception {
        public CursoYaExistenteException(String mensaje) {
            super(mensaje);
        }
    }

    public static class EstudianteYaInscritoException extends Exception {
        public EstudianteYaInscritoException(String mensaje) {
            super(mensaje);
        }
    }

    public static class EstudianteNoInscritoEnCursoException extends Exception {
        public EstudianteNoInscritoEnCursoException(String mensaje) {
            super(mensaje);
        }
    }

    public static class CursoNoEncontradoException extends Exception {
        public CursoNoEncontradoException(String mensaje) {
            super(mensaje);
        }
    }

    // Implementación de los métodos de la interfaz
    @Override
    public void matricularEstudiante(Estudiante estudiante) throws EstudianteYaMatriculadoException {
        for (Estudiante e : estudiantes) {
            if (e.getId() == estudiante.getId()) {
                throw new EstudianteYaMatriculadoException("El estudiante ya está matriculado.");
            }
        }
        estudiantes.add(estudiante);
    }

    @Override
    public void agregarCurso(Curso curso) throws CursoYaExistenteException {
        for (Curso c : cursos) {
            if (c.getId() == curso.getId()) {
                throw new CursoYaExistenteException("El curso ya existe.");
            }
        }
        cursos.add(curso);
    }

    @Override
    public void inscribirEstudianteCurso(Estudiante estudiante, int idCurso) throws EstudianteYaInscritoException, CursoNoEncontradoException {
        Curso curso = obtenerCursoPorId(idCurso);
        if (curso == null) {
            throw new CursoNoEncontradoException("El curso con ID " + idCurso + " no se encuentra.");
        }

        ArrayList<Estudiante> inscritos = estudiantesPorCurso.getOrDefault(idCurso, new ArrayList<>());
        for (Estudiante e : inscritos) {
            if (e.getId() == estudiante.getId()) {
                throw new EstudianteYaInscritoException("El estudiante ya está inscrito en el curso.");
            }
        }

        inscritos.add(estudiante);
        estudiantesPorCurso.put(idCurso, inscritos);
    }

    @Override
    public void desinscribirEstudianteCurso(int idEstudiante, int idCurso) throws EstudianteNoInscritoEnCursoException, CursoNoEncontradoException {
        Curso curso = obtenerCursoPorId(idCurso);
        if (curso == null) {
            throw new CursoNoEncontradoException("El curso con ID " + idCurso + " no se encuentra.");
        }

        ArrayList<Estudiante> inscritos = estudiantesPorCurso.get(idCurso);
        if (inscritos == null || inscritos.stream().noneMatch(e -> e.getId() == idEstudiante)) {
            throw new EstudianteNoInscritoEnCursoException("El estudiante no está inscrito en el curso o el ID del curso es inválido.");
        }

        inscritos.removeIf(e -> e.getId() == idEstudiante);
    }

    // Métodos adicionales de GestorAcademico...

    public void mostrarEstudiantes() {
        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiante);
        }
    }

    public void mostrarCursos() {
        for (Curso curso : cursos) {
            System.out.println(curso);
        }
    }

    private Curso obtenerCursoPorId(int id) {
        for (Curso curso : cursos) {
            if (curso.getId() == id) {
                return curso;
            }
        }
        return null;
    }
}
