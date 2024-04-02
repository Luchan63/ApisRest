package com.example.app.rest.Model;
import jakarta.persistence.*;

@Entity
@Table(schema = "TasksCrud")
public class Task
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // es para que se auto incremente
    private long id;
    @Column // para grear una columna en la base de datos
    private String titulo;
    @Column
    private String descripcion;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
