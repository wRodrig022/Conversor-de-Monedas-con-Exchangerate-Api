import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura  = new Scanner(System.in);
        int opcionElegida = 0;

        // Esta instancia se utilizará para realizar consultas de conversiones de moneda.
        ConsultaConversion consulta = new ConsultaConversion();

        /* La razón de pasarle como parámetro una instancia de 'ConsultaConversion' al constructor
        de 'Calculos' es porque la clase 'Calculos' necesita tener acceso a una instancia de
        ConsultaConversion para poder realizar las conversiones de moneda. */
        Calculos calculos = new Calculos(consulta);

        List<String> respuestas = new ArrayList<>();

        String menu = """
                \n***************************************************
                Sea bievenido/a al Conversor de Moneda
                
                1) Dolar =>> Peso Argentino
                2) Peso Argentino =>> Dolar
                3) Dolar =>> Real Brasilero
                4) Real Brasilero =>> Dolar
                5) Dolar =>> Sol Peruano
                6) Sol Peruano =>> Dolar
                7) Salir
                ***************************************************
                Elija Una Opcion Valida:
                """;
        while (opcionElegida != 7){
            try{
                System.out.println(menu);
                opcionElegida = Integer.parseInt(lectura.nextLine());

                // obtener la marca del tiempo actual
                LocalDateTime myDateObj = LocalDateTime.now();
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                String formatteDate = myDateObj.format(myFormatObj);

                switch (opcionElegida){
                    case 1:
                        calculos.almancenarValores("USD","ARS");
                        calculos.obtenerMensajeRespuesta();
                        break;
                    case 2:
                        calculos.almancenarValores("ARS","USD");
                        calculos.obtenerMensajeRespuesta();
                        break;
                    case 3:
                        calculos.almancenarValores("USD","BRL");
                        calculos.obtenerMensajeRespuesta();
                        break;
                    case 4:
                        calculos.almancenarValores("BRL","USD");
                        calculos.obtenerMensajeRespuesta();
                        break;
                    case 5:
                        calculos.almancenarValores("USD","PEN");
                        calculos.obtenerMensajeRespuesta();
                        break;
                    case 6:
                        calculos.almancenarValores("PEN","USD");
                        calculos.obtenerMensajeRespuesta();
                        break;
                    case 7:
                        break;
                    default:
                        System.out.println("Ingrese una opcion Valida!");

                }
            } catch (NumberFormatException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Finalizo el programa");
    }
}
