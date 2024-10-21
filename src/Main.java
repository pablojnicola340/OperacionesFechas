import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.time.DayOfWeek;
import java.time.Period;

public class Main {
    public static void main(String[] args) {
        // 1. Obtener la fecha y hora actual
        // --------------------------------
        // Usamos LocalDate para obtener solo la fecha actual
        LocalDate fechaActual = LocalDate.now();
        System.out.println("Fecha actual: " + fechaActual);

        // Usamos LocalDateTime para obtener la fecha y hora actuales
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        System.out.println("Fecha y hora actual: " + fechaHoraActual);

        // 2. Sumar y restar días, meses o años
        // -------------------------------------
        LocalDate fecha = LocalDate.of(2024, 10, 21);

        // Sumar 10 días
        LocalDate nuevaFecha = fecha.plusDays(10);
        System.out.println("Fecha después de sumar 10 días: " + nuevaFecha);

        // Restar 2 meses
        nuevaFecha = fecha.minusMonths(2);
        System.out.println("Fecha después de restar 2 meses: " + nuevaFecha);

        // 3. Comparar fechas
        // -------------------
        LocalDate fecha1 = LocalDate.of(2024, 10, 21);
        LocalDate fecha2 = LocalDate.of(2024, 12, 31);

        if (fecha1.isBefore(fecha2)) {
            System.out.println("Fecha1 es anterior a Fecha2");
        } else if (fecha1.isAfter(fecha2)) {
            System.out.println("Fecha1 es posterior a Fecha2");
        } else {
            System.out.println("Fecha1 es igual a Fecha2");
        }

        // 4. Calcular la diferencia entre dos fechas
        // -------------------------------------------
        LocalDate fechaInicio = LocalDate.of(2023, 1, 1);
        LocalDate fechaFin = LocalDate.of(2024, 10, 21);

        Period periodo = Period.between(fechaInicio, fechaFin);
        System.out.println("Diferencia entre las fechas:");
        System.out.println("Años: " + periodo.getYears());
        System.out.println("Meses: " + periodo.getMonths());
        System.out.println("Días: " + periodo.getDays());

        // 5. Formatear fechas
        // --------------------
        LocalDate fechaFormatear = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaFormateada = fechaFormatear.format(formatter);
        System.out.println("Fecha formateada: " + fechaFormateada);

        // 6. Parsear cadenas de texto a fechas
        // -------------------------------------
        String fechaTexto = "21/10/2024";
        LocalDate fechaParseada = LocalDate.parse(fechaTexto, formatter);
        System.out.println("Fecha parseada desde texto: " + fechaParseada);

        // 7. Trabajar con zonas horarias
        // -------------------------------
        ZonedDateTime fechaEnZona = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println("Fecha y hora en Nueva York: " + fechaEnZona);

        // 8. Calcular el fin de mes o el próximo lunes
        // ---------------------------------------------
        LocalDate fechaAjustes = LocalDate.now();

        // Obtener el último día del mes
        LocalDate finDeMes = fechaAjustes.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("Último día del mes: " + finDeMes);

        // Obtener el próximo lunes
        LocalDate proximoLunes = fechaAjustes.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        System.out.println("Próximo lunes: " + proximoLunes);

        // 9. Convertir entre LocalDateTime e Instant
        // -------------------------------------------
        LocalDateTime fechaHora = LocalDateTime.now();

        // Convertir LocalDateTime a Instant (UTC)
        Instant instant = fechaHora.toInstant(ZoneOffset.UTC);
        System.out.println("Instant en UTC: " + instant);

        // Convertir Instant de vuelta a LocalDateTime
        LocalDateTime fechaDesdeInstant = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
        System.out.println("Fecha y hora desde Instant: " + fechaDesdeInstant);
    }
}
