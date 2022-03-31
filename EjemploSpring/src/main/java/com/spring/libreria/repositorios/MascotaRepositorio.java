package com.spring.libreria.repositorios;

import com.spring.libreria.entidades.Mascota;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/** @author MellMdz*/
@Repository
public interface MascotaRepositorio extends JpaRepository<Mascota, String>{
   //los DOM pasan a llamarse Repositorios
    
    @Query("SELECT c FROM Mascota c where c.usuario.id =:id")
    public List<Mascota> buscarMascotaPorUsuario(@Param("id") String id);

    @Query("SELECT c FROM Mascota c WHERE c.nombre =: nombre")
    public List<Mascota> buscarPorNombre(@Param("id") String nombre);
}

