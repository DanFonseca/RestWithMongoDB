package br.com.restwithmongodb.demo.Models.Exceptions;

public class ObjectNotFoundException extends RuntimeException {

    public ObjectNotFoundException(String msg) {
        super("Object not Found for ID: " + msg);
    }
}
