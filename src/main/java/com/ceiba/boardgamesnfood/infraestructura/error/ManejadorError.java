package com.ceiba.boardgamesnfood.infraestructura.error;

import java.util.concurrent.ConcurrentHashMap;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ceiba.boardgamesnfood.dominio.excepcion.CantidadPersonasSuperadasException;
import com.ceiba.boardgamesnfood.dominio.excepcion.DominioException.ERRORES_DOMINIO;
import com.ceiba.boardgamesnfood.dominio.excepcion.EntityNoEncontradaException;
import com.ceiba.boardgamesnfood.dominio.excepcion.MesasDisponiblesNoEncontradasException;

@ControllerAdvice
public class ManejadorError extends ResponseEntityExceptionHandler {

    private static final String OCURRIO_UN_ERROR_FAVOR_CONTACTAR_AL_ADMINISTRADOR = "Ocurrió un error favor contactar al administrador.";
    private static final String MENSAJE_UNIQUE_KEY = "La entidad ya existe";

    private static final ConcurrentHashMap<String, Integer> CODIGOS_ESTADO = new ConcurrentHashMap<>();

    public ManejadorError() {
        CODIGOS_ESTADO.put(CantidadPersonasSuperadasException.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        CODIGOS_ESTADO.put(EntityNoEncontradaException.class.getSimpleName(), HttpStatus.NOT_FOUND.value());
        CODIGOS_ESTADO.put(MesasDisponiblesNoEncontradasException.class.getSimpleName(), HttpStatus.NOT_FOUND.value());
        CODIGOS_ESTADO.put(DataIntegrityViolationException.class.getSimpleName(), HttpStatus.UNPROCESSABLE_ENTITY.value());
        CODIGOS_ESTADO.put(ERRORES_DOMINIO.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        //en caso de tener otra excepcion matricularla aca
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Error> handleAllExceptions(Exception exception) {
        ResponseEntity<Error> resultado;

        String excepcionNombre = exception.getClass().getSimpleName();
        String mensaje = exception.getMessage();
        Integer codigo = CODIGOS_ESTADO.get(excepcionNombre);

        if (codigo != null) {
        	if (mensaje != null && mensaje.contains("UK")) {
        		mensaje = MENSAJE_UNIQUE_KEY;
			}
            Error error = new Error(excepcionNombre, mensaje);
            resultado = new ResponseEntity<>(error, HttpStatus.valueOf(codigo));
        } else {
            Error error = new Error(excepcionNombre, OCURRIO_UN_ERROR_FAVOR_CONTACTAR_AL_ADMINISTRADOR);
            resultado = new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return resultado;
    }
}
