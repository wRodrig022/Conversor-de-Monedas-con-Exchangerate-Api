import java.util.Scanner;

/* Es responsable de manejar la lógica relacionada con las conversiones de moneda. Sin embargo, necesita la
información de las tasas de cambio obtenidas a través de ConsultaConversion para realizar estas conversiones. */
public class Calculos {
    private String monedaBase;
    private String monedaObjetivo;
    private double cantidad;

    Scanner lectura = new Scanner(System.in);
    ConsultaConversion conversion;

    /* Toma una instancia de ConsultaConversion como parámetro y la asigna a una variable de instancia llamada
    conversion. De esta manera, cada objeto de Calculos tiene acceso a una instancia de ConsultaConversion, lo
    que le permite realizar consultas de conversiones de moneda cuando sea necesario. */
    public Calculos(ConsultaConversion conversion){
        this.conversion = conversion;
    }

    public String getMonedaBase() {
        return monedaBase;
    }

    public double getCantidad() {
        return cantidad;
    }

    public String getMonedaObjetivo() {
        return monedaObjetivo;
    }

    public void almancenarValores(String monedaBase, String monedaObjetivo){
        this.monedaBase= monedaBase;
        this.monedaObjetivo = monedaObjetivo;

        System.out.println("Ingrese el valor que desea convertir: ");
         this.cantidad = Double.parseDouble(lectura.nextLine());
    }
    public String obtenerMensajeRespuesta(){
        String mensaje = "El valor "+ getCantidad()+" ["+getMonedaBase()+"]"+" corresponde al valor final de =>>> "+
                conversion.buscaConversion(getMonedaBase(),getMonedaObjetivo(), getCantidad())+" ["+getMonedaObjetivo()+"]";
        System.out.println(mensaje);
        return mensaje;
    }


}
