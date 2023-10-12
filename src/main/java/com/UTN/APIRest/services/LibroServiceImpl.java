package com.UTN.APIRest.services;

import com.UTN.APIRest.entities.Libro;
import com.UTN.APIRest.entities.Localidad;
import com.UTN.APIRest.repositories.BaseRepository;
import com.UTN.APIRest.repositories.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroServiceImpl extends BaseServiceImpl<Libro,Long> implements LibroService {

    @Autowired
    private LibroRepository libroRepository;

    public LibroServiceImpl(BaseRepository<Libro, Long> baseRepository, LibroRepository libroRepository) {
        super(baseRepository);
        this.libroRepository = libroRepository;
    }
    @Override
    public List<Libro> search(String filtro) throws Exception {
        try{
            List<Libro> libros = libroRepository.searchNativo(filtro);
            return libros;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Libro> search(String filtro, Pageable pageable) throws Exception {
        try{
            Page<Libro> libros= libroRepository.searchNativo(filtro, pageable);
            return libros;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
