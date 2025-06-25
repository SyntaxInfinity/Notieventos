/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bridge;

import model.Participante;

/**
 *
 * @author PC
 */
public class Impresora {

    private Formato formato;

    public Impresora(Formato formato) {
        this.formato = formato;
    }

    public void imprimirCredencial(Participante p) {
        formato.imprimir(p.getDatos());
        if (p.getRol().equalsIgnoreCase("Invitado")) {
            System.out.println("[INVITADO - ACCESO LIMITADO]");
        }
    }
}
