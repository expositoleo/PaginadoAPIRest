package com.UTN.APIRest.repositories;

import com.UTN.APIRest.entities.Libro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends BaseRepository<Libro,Long>{
    List<Libro> findByTituloContaining(String titulo);
    @Query(value = "SELECT lib FROM Libro lib WHERE lib.titulo LIKE %:filtro%")
    List<Libro> search(@Param("filtro") String filtro);

    @Query(
            value = "SELECT * FROM libro WHERE libro.titulo LIKE %:filtro%",
            nativeQuery = true
    )
    List<Libro> searchNativo(@Param("filtro") String filtro);

    Page<Libro> findByTituloContaining(String titulo, Pageable pageable);

    @Query(value = "SELECT lib FROM Libro lib WHERE lib.titulo LIKE %:filtro%")
    Page<Libro> search(@Param("filtro") String filtro, Pageable pageable);

    @Query(
            value = "SELECT * FROM libro WHERE libro.titulo",
            countQuery = "SELECT count(*) FROM libro",
            nativeQuery = true
    )
    Page<Libro> searchNativo(@Param("filtro") String filtro, Pageable pageable);
}
