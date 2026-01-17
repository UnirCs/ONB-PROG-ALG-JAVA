/**
 * Usuario tipo Estudiante: máximo 3 libros, 14 días de préstamo.
 */
public class Estudiante extends Usuario {

    private static final int MAX_LIBROS = 3;
    private static final int DIAS_PRESTAMO = 14;

    public Estudiante(String id, String nombre) {
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
        return "Estudiante";
    }
}

