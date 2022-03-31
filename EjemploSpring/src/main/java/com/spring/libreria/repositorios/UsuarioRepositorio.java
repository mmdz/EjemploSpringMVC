
package com.spring.libreria.repositorios;

import com.spring.libreria.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, String>{
   //los DOM pasan a llamarse Repositorios
    
    @Query("SELECT c FROM Usuario c where c.mail =:mail")
    public Usuario buscarPorMail(@Param("mail") String mail);

    @Query("SELECT c FROM Usuario c WHERE c.id =: id")
    public Usuario buscarPorId(@Param("id") String id);
}