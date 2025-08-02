package app.service;

import app.entity.Autor;
import org.springframework.stereotype.Service;

@Service
public class AutorService {

    public String save(Autor autor){
        return "Autor salvo com sucesso!";

    }
}
