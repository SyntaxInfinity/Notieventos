/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class ParticipanteCollection {

    private List<Participante> lista = new ArrayList<>();

    public void agregar(Participante p) {
        lista.add(p);
    }

    public ParticipanteIterator getIterator() {
        return new ParticipanteIteratorImpl();
    }

    // Clase interna privada que implementa el Iterator
    private class ParticipanteIteratorImpl implements ParticipanteIterator {

        private int index = 0;

        public boolean hasNext() {
            return index < lista.size();
        }

        public Participante next() {
            return lista.get(index++);
        }
    }

    // Método opcional para obtener la lista completa
    public List<Participante> getTodos() {
        return lista;
    }
}
