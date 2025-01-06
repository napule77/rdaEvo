package com.amalfi.rdaevo.utils;


import com.amalfi.rdaevo.model.Utenze;

import java.util.List;
import java.util.stream.Collectors;

public class FilterUtenze {

    public static List<Utenze> filtraLista(List<Utenze> listaUtenza, int livello) {
        List<Utenze> lstUtenzeFiltrate = listaUtenza.stream()
                .filter(utenza -> utenza.getLivello() > 0)
                .collect(Collectors.toList());
        return lstUtenzeFiltrate;
    }

}
