package org.example;

public class Estudiante extends Persona {
    private String estado; // matriculado, inactivo, graduado

    // Constructor
    public Estudiante(int id, String nombre, String apellido, String fechaDeNacimiento, String estado) {
        super(id, nombre, apellido, fechaDeNacimiento);
        this.estado = estado;
    }

    // Getters y Setters
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "id=" + getId() +
                ", nombre='" + getNombre() + '\'' +
                ", apellido='" + getApellido() + '\'' +
                ", fechaDeNacimiento='" + getFechaDeNacimiento() + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}