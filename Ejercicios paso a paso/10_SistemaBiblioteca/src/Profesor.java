/**
 * Usuario tipo Profesor: máximo 5 libros, 30 días de préstamo.
 */
public class Profesor extends Usuario {

    private static final int MAX_LIBROS = 5;
    private static final int DIAS_PRESTAMO = 30;

    public Profesor(String id, String nombre) {
        super(id, nombre);
    }

    @Override
    public int getMaxLibros() {
        return MAX_LIBROS;
    }

    @Override
    public int getDiasPrestamo() {
        return DIAS_PRESTAMO;
    }

    @Override
    public String getTipoUsuario() {
        return "Profesor";
    }
}

