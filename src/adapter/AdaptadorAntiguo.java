/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adapter;

import model.Participante;

/**
 *
 * @author PC
 */
public class AdaptadorAntiguo extends Participante {

    public AdaptadorAntiguo(SistemaAntiguo antiguo) {
        super(antiguo.getNombreAntiguo(), "-", "Invitado");
    }
}
