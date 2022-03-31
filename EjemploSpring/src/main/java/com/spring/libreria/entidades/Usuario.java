package com.spring.libreria.entidades;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.annotations.GenericGenerator;

/*@Author Mellmdz*/
@Entity
public class Usuario {
    @Id 
    //uuid identificador unico universal
    @GeneratedValue(generator = "uuid")//esto genera una cadena de texto que no se va a repetir nunca
    @GenericGenerator(name = "uuid", strategy = "uiid2")
    private String id;
    
    private String nombre;
    private String apellido;
    
    @Column(unique  = true)//otra forma de validar
    private String mail;
    private String password;
    
    @OneToMany //cuando es MANY uso lista siempre
    private List<Mascota> mascota;

    public Usuario(String nombre, String apellido, String mail, String password, List<Mascota> mascota) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.password = password;
        this.mascota = mascota;
    }

    public Usuario(){
        
    }
    
    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", mail=" + mail + ", password=" + password + ", mascota=" + mascota + '}';
    }

    //getter y setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Mascota> getMascota() {
        return mascota;
    }

    public void setMascota(List<Mascota> mascota) {
        this.mascota = mascota;
    }
    
    
}
