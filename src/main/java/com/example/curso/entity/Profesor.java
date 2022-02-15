package com.example.curso.entity;

import javax.persistence.Entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="profesores")
public class Profesor implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    //Ejemplo si tuviera otro nombre, si es el mismo no sería necesario
    @Column(name="nombre")
    private String nombre;

    @Column(length=60, unique=true)
    private String email;

    private String password;

    @Column (length = 2000)
    private String foto;

    @Column(name = "create_at")
    @Temporal(TemporalType.DATE)
    private Date createAt;

    // Relación 1 to N para Clase curso
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "profesor_id", referencedColumnName ="id")
    private List<Curso> curso= new ArrayList<>();


    @PrePersist
    public void prePersist() {
        createAt = new Date();
    }


    // SETTER Y GETTER


    public Profesor() {
    }

    public Profesor(String nombre, String email, String password, String foto, Date createAt) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.foto = foto;
        this.createAt = createAt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public List<Curso> getCurso() {
        return curso;
    }

    public void setCurso(List<Curso> curso) {
        this.curso = curso;
    }

    private static final long serialVersionUID = 1L;
}
