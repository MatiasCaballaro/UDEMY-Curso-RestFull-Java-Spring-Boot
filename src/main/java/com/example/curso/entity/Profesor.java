package com.example.curso.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

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

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonBackReference
    @JoinTable(name="profesores_lenguajes",
            joinColumns = @JoinColumn(name="profesor_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name="lenguaje_id", referencedColumnName="id"))
    private Set<Lenguaje> lenguajes = new HashSet<Lenguaje>();

    @PrePersist
    public void prePersist() {
        createAt = new Date();
    }


    // SETTER Y GETTER


    public Profesor() {
    }

    public Profesor(long id, String nombre, String email, String password, String foto, Date createAt, List<Curso> curso, Set<Lenguaje> lenguajes) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.foto = foto;
        this.createAt = createAt;
        this.curso = curso;
        this.lenguajes = lenguajes;
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


    public Set<Lenguaje> getLenguajes() {
        return lenguajes;
    }

    public void setLenguajes(Set<Lenguaje> lenguajes) {
        this.lenguajes = lenguajes;
    }


    public void addLenguaje (Lenguaje lenguaje) {
        this.lenguajes.add(lenguaje);
    }

    private static final long serialVersionUID = 1L;
}
