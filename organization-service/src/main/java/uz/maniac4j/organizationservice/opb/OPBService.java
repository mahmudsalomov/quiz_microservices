package uz.maniac4j.organizationservice.opb;

import org.springframework.stereotype.Service;

@Service
public class OPBService {
    private final OPBRepository opbRepository;

    public OPBService(OPBRepository opbRepository) {
        this.opbRepository = opbRepository;
    }


}
