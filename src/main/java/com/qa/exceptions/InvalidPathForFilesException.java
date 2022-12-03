package com.qa.exceptions;

public class InvalidPathForFilesException extends FrameworkExceptions{
    public InvalidPathForFilesException(String message) {
        super(message);
    }

    public InvalidPathForFilesException(String message, Throwable cause) {
        super(message, cause);
    }
}
