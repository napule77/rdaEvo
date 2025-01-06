package com.amalfi.rdaevo.dto;

import com.amalfi.rdaevo.model.Utenti;
import com.amalfi.rdaevo.model.Utenze;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserSaveDTO {

    Utenti utente;
    List<Utenze> utenzeUtente;

}
