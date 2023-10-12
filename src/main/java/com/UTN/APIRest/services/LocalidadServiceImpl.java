package com.UTN.APIRest.services;

import com.UTN.APIRest.entities.Localidad;
import com.UTN.APIRest.repositories.BaseRepository;
import com.UTN.APIRest.repositories.LocalidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalidadServiceImpl extends BaseServiceImpl<Localidad,Long> implements LocalidadService {

    @Autowired
    private LocalidadRepository localidadRepository;

    public LocalidadServiceImpl(BaseRepository<Localidad, Long> baseRepository, LocalidadRepository localidadRepository) {
        super(baseRepository);
        this.localidadRepository = localidadRepository;
    }
    @Override
    public List<Localidad> search(String filtro) throws Exception {
        try{
            List<Localidad> localidades = localidadRepository.searchNativo(filtro);
            return localidades;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Localidad> search(String filtro, Pageable pageable) throws Exception {
        try{
            Page<Localidad> localidades= localidadRepository.searchNativo(filtro, pageable);
            return localidades;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
