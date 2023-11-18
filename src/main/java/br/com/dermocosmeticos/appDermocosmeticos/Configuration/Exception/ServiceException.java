package br.com.dermocosmeticos.appDermocosmeticos.Configuration.Exception;

import java.io.Serial;
import java.io.Serializable;

public class ServiceException extends Exception implements Serializable {
    @Serial
    private static final long serialVersionUID = 7618482746784870599L;

    public ServiceException(String message) {
        super(message);
    }
}
