package org.example;

public interface ServiciosAcademicosI {
    void matricularEstudiante(Estudiante estudiante) throws GestorAcademico.EstudianteYaMatriculadoException;
    void agregarCurso(Curso curso) throws GestorAcademico.CursoYaExistenteException;
    void inscribirEstudianteCurso(Estudiante estudiante, int idCurso) throws GestorAcademico.EstudianteYaInscritoException, GestorAcademico.CursoNoEncontradoException;
    void desinscribirEstudianteCurso(int idEstudiante, int idCurso) throws GestorAcademico.EstudianteNoInscritoEnCursoException, GestorAcademico.CursoNoEncontradoException;
}
