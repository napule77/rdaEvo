package com.amalfi.rdaevo.service;

import com.amalfi.rdaevo.repository.LivelliRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivelliService extends BaseControllerService{

    @Autowired
    LivelliRepository livelliRepo;

    @Autowired
    UtenzeService utenzeService;


}
