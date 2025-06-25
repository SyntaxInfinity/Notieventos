/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package notieventos;

import adapter.AdaptadorAntiguo;
import adapter.SistemaAntiguo;
import bridge.Formato;
import bridge.FormatoSimple;
import bridge.Impresora;
import java.util.Scanner;
import model.Participante;
import model.ParticipanteCollection;
import model.ParticipanteIterator;
import observer.NotificadorCorreo;

/**
 *
 * @author PC
 */
public class Notieventos {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ParticipanteCollection lista = new ParticipanteCollection();   // Iterator
        NotificadorCorreo notificadorCorreo = new NotificadorCorreo(); // Observer

        // Formato fijo: Simple
        Formato formato = new FormatoSimple();                         // Bridge
        Impresora impresora = new Impresora(formato);                  // Bridge

        int opcion;
        do {
            System.out.println("\n--- Menu NotiEventos ---");
            System.out.println("1. Agregar participante nuevo");
            System.out.println("2. Mostrar todos los participantes");
            System.out.println("3. Agregar desde sistema antiguo");
            System.out.println("0. Salir");
            System.out.print("Escoja una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    String rut;
                    boolean valido;

                    do {
                        System.out.print("RUT (con digito verificador): ");
                        rut = sc.nextLine();
                        valido = true;

                        if (rut.length() != 9 && rut.length() != 10) {
                            System.out.println("El RUT debe tener 9 o 10 caracteres.");
                            valido = false;
                        }

                        char ultimo = rut.charAt(rut.length() - 1);
                        if (!Character.isDigit(ultimo) && Character.toUpperCase(ultimo) != 'K') {
                            System.out.println("El último carácter debe ser un número o K.");
                            valido = false;
                        }

                    } while (!valido);

                    System.out.print("Rol: ");
                    String rol = sc.nextLine();

                    Participante nuevo = new Participante(nombre, rut, rol);
                    lista.agregar(nuevo);
                    notificadorCorreo.notificar("Nuevo participante agregado: " + nombre);
                }
                case 2 -> {
                    ParticipanteIterator it = lista.getIterator();
                    while (it.hasNext()) {
                        Participante p = it.next();
                        impresora.imprimirCredencial(p);
                    }
                }
                case 3 -> {
                    SistemaAntiguo sistemaAntiguo = new SistemaAntiguo();
                    Participante adaptado = new AdaptadorAntiguo(sistemaAntiguo);
                    lista.agregar(adaptado);
                    notificadorCorreo.notificar("Participante agregado desde sistema antiguo.");
                }
                case 0 -> System.out.println("¡Hasta luego!");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }
}
