package com.UTN.APIRest.services;

import com.UTN.APIRest.entities.Domicilio;
import com.UTN.APIRest.repositories.BaseRepository;
import com.UTN.APIRest.repositories.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomicilioServiceImpl extends BaseServiceImpl<Domicilio,Long> implements DomicilioService {

    @Autowired
    private DomicilioRepository domicilioRepository;

    public DomicilioServiceImpl(BaseRepository<Domicilio, Long> baseRepository, DomicilioRepository domicilioRepository) {
        super(baseRepository);
        this.domicilioRepository = domicilioRepository;
    }

    @Override
    public List<Domicilio> search(String filtro) throws Exception {
        try {
            List<Domicilio> domicilios = domicilioRepository.searchNativo(filtro);
            return domicilios;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Page<Domicilio> search(String filtro, Pageable pageable) throws Exception {
        try {
            Page<Domicilio> domicilios = domicilioRepository.searchNativo(filtro, pageable);
            return domicilios;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
