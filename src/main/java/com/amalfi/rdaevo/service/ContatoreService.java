package com.amalfi.rdaevo.service;

import com.amalfi.rdaevo.model.Contatore;
import com.amalfi.rdaevo.repository.ContatoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Year;

@Service
public class ContatoreService extends  BaseControllerService{

    @Autowired
    ContatoreRepository contatoreRepository;

    public int getContatore() {
        int annoCorrente = Year.now().getValue();
        Contatore contatore = contatoreRepository.findByAnno(annoCorrente);
        if (contatore == null) {
            contatore = new Contatore();
            contatore.setAnno(annoCorrente);
            contatore.setValore(1);
            contatoreRepository.save(contatore);
        }
        return contatore.getValore();
    }

    public void incrementaContatore() {
        int annoCorrente = Year.now().getValue();
        Contatore contatore = contatoreRepository.findByAnno(annoCorrente);
        contatore.setValore(contatore.getValore() + 1);
        contatoreRepository.save(contatore);
    }


}
