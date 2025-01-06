package com.amalfi.rdaevo.service;

import com.amalfi.rdaevo.dto.LoginDTO;
import com.amalfi.rdaevo.dto.UserLoggedDTO;
import com.amalfi.rdaevo.dto.UserSaveDTO;
import com.amalfi.rdaevo.model.Utenti;
import com.amalfi.rdaevo.model.UtenzaView;
import com.amalfi.rdaevo.model.Utenze;
import com.amalfi.rdaevo.repository.UtentiRepository;
import com.amalfi.rdaevo.repository.UtenzeRepository;
import com.amalfi.rdaevo.utils.ToMD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class UtentiService extends BaseControllerService{

    @Autowired
    UtentiRepository utentirepo;

    @Autowired
    UtenzeRepository utenzeRepository;

    private static final DateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    public Utenti findUtenteById(Integer idUtente){
        return utentirepo.findById(idUtente).get();
    }

    public DTOServiceResult<UserLoggedDTO> login(LoginDTO loginDTO) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        Utenti utenti = utentirepo.findByEmailAndPasswordAndAbilitato(loginDTO.getEmail(), ToMD5.MD5(loginDTO.getPassword()),true);
        if(utenti==null){
            return createServiceResult(new UserLoggedDTO(), DTOServiceResultMessage.Type.ERROR,"Errore: Utente non registrato o password non corretta!");
        }
        UserLoggedDTO userLogged = new UserLoggedDTO();
        userLogged.setUtente(utenti);
        int id = utenti.getIdUtente();
        List<UtenzaView> listaLogin = utenzeRepository.findUtenzaExp(id);
        userLogged.setUtenzeLivelli(listaLogin);
        return createServiceResult(userLogged);
    }

    public DTOServiceResult<List<Utenti>> findByEmail(String email) {
        List<Utenti> lstUtenti = utentirepo.findByEmail(email);
        return createServiceResult(lstUtenti);
    }

    public DTOServiceResult<Utenti> save(UserSaveDTO userToSave) throws UnsupportedEncodingException, NoSuchAlgorithmException, ParseException {
        if(findByEmail(userToSave.getUtente().getEmail()).getData().size()==0){
            Utenti u = new Utenti();
            u.setAbilitato(true);
            u.setNome(userToSave.getUtente().getNome());
            u.setCognome(userToSave.getUtente().getCognome());
            u.setEmail(userToSave.getUtente().getEmail());
            String md5Pwd = ToMD5.MD5(userToSave.getUtente().getPassword());
            u.setPassword(md5Pwd);
            u.setDataInsert(sf.parse(sf.format(new Date())));
            u = utentirepo.save(u);

            for(Utenze utenze : userToSave.getUtenzeUtente()){
                Utenze ut = new Utenze();
                ut.setLivello(utenze.getLivello());
                ut.setIdUtente(u.getIdUtente());
                utenzeRepository.save(ut);
            }


            return createServiceResult(u);
        }else{
            return createServiceResult(new Utenti(), DTOServiceResultMessage.Type.ERROR,"Errore: Email già registrata!");
        }


    }

}
