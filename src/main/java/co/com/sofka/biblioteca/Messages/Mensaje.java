package co.com.sofka.biblioteca.Messages;

import java.util.Date;

public class Mensaje {
    private boolean isDisponible;
    private String mensaje;

    public Mensaje() {
    }

    public Mensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public boolean isDisponible() {
        return isDisponible;
    }

    public String getMensaje() {
        return mensaje;
    }

    public Mensaje imprimirMensajeDisponibilidad(Boolean disponibilidad, Date fechaPrestamo){
        if(disponibilidad){
            return new Mensaje("El recurso esta disponible");
        }
        return new Mensaje("El recurso fue prestado el: " + fechaPrestamo);
    }

    public Mensaje imprimirMensajePrestamo(Boolean disponibilidad, Date fechaPrestamo){
        if(disponibilidad){
            return new Mensaje("El recurso esta disponible y te fue prestado");
        }
        return new Mensaje("El recurso no esta disponible, fue prestado el: " + fechaPrestamo);
    }
}
