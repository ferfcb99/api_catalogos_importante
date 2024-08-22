package com.catalogo.proveedores.exceptions;

import java.io.Serial;

/**
 * The type Validaciones exception.
 *
 * @author fernando.munguia
 */
public class NotContentException extends RuntimeException {

    /**
     * Serial
     */
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Code status exception
     */
    private final String code;

    /**
     * Description exception
     */
    private final String description;

    /**
     * Instantiates a new Validaciones exception.
     *
     * @param message the message
     */
    public NotContentException(final String message) {
        super(message);
        this.code = null;
        this.description = message;
    }

    /**
     * Instantiates a new Validaciones exception.
     *
     * @param code    the code
     * @param message the message
     */
    public NotContentException(final String code, final String message) {

        super(message);
        this.code = code;
        this.description = message;
    }

    /**
     * Instantiates a new Validaciones exception.
     *
     * @param message   the message
     * @param throwable the throwable
     */
    public NotContentException(final String message, final Throwable throwable) {

        super(message, throwable);
        this.code = null;
        this.description = null;
    }

    /**
     * Gets code.
     *
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "NotContentException{" +
                "code='" + code + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

