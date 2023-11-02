package edu.vikhani.springcloudwebinardemo.docgen.exception;

public class ClientInfoNotFound extends RuntimeException {
    public ClientInfoNotFound() {
        super();
    }

    public ClientInfoNotFound(String message) {
        super(message);
    }
}
