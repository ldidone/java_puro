package com.kaitzen;

import java.text.*;
import java.util.Calendar;
import java.util.Date;

public class Fecha {
    private Date fecha;
    private DateFormat df = new SimpleDateFormat("yyyyy.MMMMM.dd GGG hh:mm aaa");
    Fecha(){
        fecha = new Date();
    }

    Fecha(String fecha){
        try {
            this.fecha = df.parse(fecha);
        } catch (ParseException pe) {
            System.out.println("ERROR - Formato de fecha inválido");
        }
    }

    public boolean esCorrecta(String fecha) {
        try {
            this.fecha = df.parse(fecha);
        } catch (ParseException pe) {
            System.out.println("ERROR - Formato de fecha inválido");
            return false;
        }
        System.out.println("Formato de fecha válido");
        return true;
    }

    public void pasarAlDiaSiguiente() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        cal.add(Calendar.DAY_OF_MONTH, 1);
        fecha = cal.getTime();
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String toString() {
    	Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        cal.add(Calendar.MONTH, 3);
        return String.format("La fecha actual es %1$s Dia %2$d Mes %3$d Año %4$d",
        		df.format(cal.getTime()), cal.get(Calendar.DAY_OF_MONTH),
        		cal.get(Calendar.MONTH), cal.get(Calendar.YEAR));
    }
}
