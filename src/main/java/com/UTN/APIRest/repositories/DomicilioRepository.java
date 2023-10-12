package com.UTN.APIRest.repositories;

import com.UTN.APIRest.entities.Domicilio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DomicilioRepository extends BaseRepository<Domicilio,Long>{

    List<Domicilio> findByCalleContaining(String calle);
    @Query(value = "SELECT Cal FROM Domicilio Cal WHERE Cal.calle LIKE %:filtro%")
    List<Domicilio> search(@Param("filtro") String filtro);

    @Query(
            value = "SELECT * FROM Domicilio WHERE Domicilio.calle LIKE %:filtro%",
            nativeQuery = true
    )
    List<Domicilio> searchNativo(@Param("filtro") String filtro);

    Page<Domicilio> findByCalleContaining(String calle, Pageable pageable);

    @Query(value = "SELECT Cal FROM Domicilio Cal WHERE Cal.calle LIKE %:filtro%")
    Page<Domicilio> search(@Param("filtro") String filtro, Pageable pageable);

    @Query(
            value = "SELECT * FROM Domicilio WHERE Domicilio.calle",
            countQuery = "SELECT count(*) FROM Domicilio",
            nativeQuery = true
    )
    Page<Domicilio> searchNativo(@Param("filtro") String filtro, Pageable pageable);

}
