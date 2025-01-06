package com.amalfi.rdaevo.service;

import com.amalfi.rdaevo.model.Rda;
import com.amalfi.rdaevo.repository.RdaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class RdaService extends  BaseControllerService {

    @Autowired
    RdaRepository rdaRepo;

    @Autowired
    ContatoreService contatoreService;

    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    SimpleDateFormat sfContatoreAnno = new SimpleDateFormat("yyyy");
    public DTOServiceResult<List<Rda>> findAll(){
        return createServiceResult(rdaRepo.findAll());
    }

    public DTOServiceResult<List<Rda>> findRdaByLivelloApp(int livello){
        return createServiceResult(rdaRepo.findByLivelloApp(livello));
    }

    public DTOServiceResult<List<Rda>> findAllMine(String email){
        return createServiceResult(rdaRepo.findByUserEmailRdaOrderByDataRdaDesc(email));
    }

    public DTOServiceResult<Rda> saveRda(Rda rda) throws ParseException {
        Rda rdaSaved = new Rda();
        rdaSaved.setDataRda(sf.parse(sf.format(new Date())));
        rdaSaved.setUserEmailRda(rda.getUserEmailRda());
        rdaSaved.setLivelloApp(rda.getLivelloApp());
        int cnt = contatoreService.getContatore();
        rdaSaved.setNumRda(cnt+ "/" + sfContatoreAnno.format(new Date()));
        rdaSaved = rdaRepo.save(rdaSaved);
        contatoreService.incrementaContatore();
        return createServiceResult(rdaSaved);
    }
}
