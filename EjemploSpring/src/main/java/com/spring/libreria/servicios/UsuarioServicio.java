package com.spring.libreria.servicios;

import com.spring.libreria.entidades.Usuario;
import com.spring.libreria.repositorios.UsuarioRepositorio;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*@Author Mellmdz*/
@Service
public class UsuarioServicio {

    @Autowired //para poder usar el metodo sin instanciar el objeto(new)
    private UsuarioRepositorio usuarioRepositorio;

    @Transactional //se usa en metodos que haran cambios
    public Usuario save(String mail, String nombre, String apellido) throws Exception {
        validator(mail, nombre, apellido);
        Usuario entidad = new Usuario();
        entidad.setMail(mail);
        entidad.setNombre(nombre);
        entidad.setApellido(apellido);
        return usuarioRepositorio.save(entidad);
    }

    @Transactional 
    public Usuario edit(String id, String nombre, String apellido) throws Exception {
       
        //Usuario u = usuarioRepositorio.buscarPorId(id);
        Optional<Usuario> respuesta = usuarioRepositorio.findById(id); //findById es una funcion de Optional
        if(respuesta.isPresent()){
            validator(id, nombre, apellido);
            Usuario u = respuesta.get();
            u.setId(id);
            u.setNombre(nombre);
            u.setApellido(apellido);
            return usuarioRepositorio.save(u);
        }else {
            return null;
        }        
    }
    
    @Transactional 
    public void delete(String id){
        usuarioRepositorio.deleteById(id);
    }

    @Transactional//(readOnly = true)
    public List<Usuario> findAll(){
        return usuarioRepositorio.findAll();
    }   
    
    @Transactional 
    public Usuario getOne(String id){
        return usuarioRepositorio.getOne(id);
    }
    
//    @Transactional 
//    public Usuario findByMail(String mail){
//        return usuarioRepositorio.findById(mail);
//    }
    
    @Transactional 
    public void validator(String mail, String nombre, String apellido) throws Exception {

        if (mail == null || mail.isEmpty()) {
            throw new Exception("mail vacio");
        } //aca pregunto si es null

        Usuario u = usuarioRepositorio.buscarPorId(mail);
        if (u != null) {
            throw new Exception("Este mail ya existe en la base de datos");
        }//aca pregunto si ya existe

        if (nombre == null || nombre.isEmpty()) {
            throw new Exception("nombre vacio");
        }

        if (apellido == null || apellido.isEmpty()) {
            throw new Exception("apellido vacio");
        }

    }
}
