package com.catalogo.proveedores.utils;

public class InputValidator {

    private static final String[] SQL_INJECTION_KEYWORDS = {
            "select", "insert", "update", "delete", "drop", "alter", "create", "truncate", "exec", "execute", "grant",
            "revoke", "union", "all", "distinct", "from", "where", "group by", "order by", "having", "limit",
            "--", ";",  "xp_", "sp_", "or", "and", "not", "like", "between", "exists", "in", "is", "null",
            "true", "false", "outer", "inner", "join", "cast", "convert", "declare", "set", "varchar", "nvarchar",
            "char", "nchar", "int", "decimal", "money", "float", "double", "binary", "blob", "text"
    };

    // Método para sanitizar entradas
    public static String sanitizeInput(String input) {
        if (input != null) {
            // Elimina caracteres no permitidos
            for (String keyword : SQL_INJECTION_KEYWORDS) {
                input = input.replaceAll("(?i)" + keyword, "");
            }
            input = input.replaceAll("[^\\w\\s]", ""); // Elimina cualquier caracter no alfanumérico excepto espacios
        }
        return input;
    }

    // Método para validar campos individuales
    public static boolean validateField(String field, int maxLength) {
        if (field == null || field.trim().isEmpty()) {
            return false;
        }
        // Verifica si el campo excede la longitud máxima permitida
        if (field.length() > maxLength) {
            return false;
        }
        // Sanitiza el campo y compara con el original
        return field.equals(sanitizeInput(field));
    }


}
