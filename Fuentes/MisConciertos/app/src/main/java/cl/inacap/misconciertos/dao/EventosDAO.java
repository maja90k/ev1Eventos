package cl.inacap.misconciertos.dao;

import java.util.ArrayList;
import java.util.List;

import cl.inacap.misconciertos.dto.Evento;

public interface EventosDAO {

    List<Evento> getAll();
    Evento save(Evento e);



}
