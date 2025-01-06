package com.amalfi.rdaevo.dto;

import com.amalfi.rdaevo.model.Utenti;
import com.amalfi.rdaevo.model.UtenzaView;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserLoggedDTO {

    Utenti utente;
    List<UtenzaView> utenzeLivelli;
}
