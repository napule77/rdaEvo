package com.amalfi.rdaevo.service;

import com.amalfi.rdaevo.model.Utenze;
import com.amalfi.rdaevo.repository.UtenzeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtenzeService extends BaseControllerService{

    @Autowired
    UtenzeRepository utenzeRepo;

    public DTOServiceResult<List<Utenze>> findUtenzeByUtente(Integer idUtente){
        List<Utenze> utenze = utenzeRepo.findByIdUtente(idUtente);
        if(utenze.size()==0){
            return createServiceResult(utenze, DTOServiceResultMessage.Type.ERROR,"Errore: Utente registrato ma senza permessi!");
        }
        return createServiceResult(utenze);
    }

    private Boolean checkUtenza(Integer idUtente , Integer livello){
        Utenze u = utenzeRepo.findByIdUtenteAndLivello(idUtente, livello);
        if(u==null){
            return true;
        }
        return false;
    }

    public DTOServiceResult<Boolean> associaUtente(Integer idUtente, List<Utenze> utenze){
        for(Utenze ut : utenze){
            if(checkUtenza(idUtente,ut.getLivello())) {
                ut.setIdUtente(idUtente);
                utenzeRepo.save(ut);
            }
        }
        return createServiceResult(true);
    }
}
