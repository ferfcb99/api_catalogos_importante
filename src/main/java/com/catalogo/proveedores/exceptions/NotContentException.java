package com.catalogo.proveedores.exceptions;

public class NotContentException extends RuntimeException {

    /**
     * serial
     */
    private static final long serialVersionUID = 1L;

    /**
     * Codigo de error
     */
    private final String codigo;

    /**
     * Descripcion del error
     */
    private final String descripcion;


    /**
     * Mensaje personalizado del error
     */
    private final String mensaje;


    /**
     * manejo del mensaje de error
     *
     * @param message
     */
    public NotContentException(final String message) {

        super(message);
        this.codigo = null;
        this.descripcion = message;
        this.mensaje = null;
    }

    /**
     * manejo del mensaje y codigo de error
     *
     * @param message
     * @param codigo
     */
    public NotContentException( final String codigo, final String message, final String mensaje) {

        super(message);
        this.codigo = codigo;
        this.descripcion = message;
        this.mensaje = mensaje;
    }

    /**
     * Manejo de Error
     *
     * @param message
     * @param throwable
     */
    public NotContentException(final String message, final Throwable throwable) {

        super(message, throwable);
        this.codigo = null;
        this.descripcion = null;
        this.mensaje = null;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getMensaje() {
        return mensaje;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ValidacionesException{" +
                "codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", mensaje='" + mensaje + '\'' +
                '}';
    }
}

