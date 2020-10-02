package cl.inacap.misconciertos.dao;

import java.util.ArrayList;
import java.util.List;

import cl.inacap.misconciertos.dto.Evento;


public class EventosDAOLista implements EventosDAO {

    private List<Evento> eventos = new ArrayList<>();
    private static EventosDAOLista instancia;

    private EventosDAOLista(){

    }

    public static EventosDAOLista getInstance(){
        if (instancia==null){
            instancia =new EventosDAOLista();
        }
        return instancia;
    }

    @Override
    public List<Evento> getAll() {
        return eventos;
    }

    @Override
    public Evento save(Evento e) {
        eventos.add(e);
        return null;
    }
}
