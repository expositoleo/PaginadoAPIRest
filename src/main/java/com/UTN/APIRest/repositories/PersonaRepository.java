package com.UTN.APIRest.repositories;

import com.UTN.APIRest.entities.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends BaseRepository<Persona,Long> {
    //Anotacions:Metodo Query (no utilizado frecuentemente/se usa jpql o Querynativo)
    List<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido);


    //boolean existsByDni(int dni);
//Query con JPQL parametros indexados//'%?1%' param indexado(1 es x cant params pasados)
    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro%")
    List<Persona> search(@Param("filtro") String filtro);

    //Query nativa
    @Query(
            value = "SELECT * FROM persona WHERE persona.nombre LIKE %:filtro% OR persona.apellido LIKE %:filtro%",
            nativeQuery = true
    )
    List<Persona> searchNativo(@Param("filtro") String filtro);

    //Querys paginada
    Page<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido, Pageable pageable);

    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %:filtro% OR p.apellido LIKE %:filtro%")
    Page<Persona> search(@Param("filtro") String filtro, Pageable pageable);

    @Query(
            value = "SELECT * FROM persona WHERE persona.nombre LIKE %:filtro% OR persona.apellido LIKE %:filtro%",
            countQuery = "SELECT count(*) FROM persona",//permite contar la cant de paginas
            nativeQuery = true//x defecto natQuery viene desactivado
    )
    Page<Persona> searchNativo(@Param("filtro") String filtro, Pageable pageable);
}
