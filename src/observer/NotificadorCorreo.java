/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package observer;

/**
 *
 * @author PC
 */
public class NotificadorCorreo implements Observer {
    public void notificar(String mensaje) {
        System.out.println("[Notificacion] " + mensaje);
    }
}

