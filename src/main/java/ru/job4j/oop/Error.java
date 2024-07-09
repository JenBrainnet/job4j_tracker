package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Active: " + active);
        System.out.println("Status: " + status);
        System.out.println("Message: " + message);
    }

    public static void main(String[] args) {
        Error error = new Error();
        error.printInfo();
        Error auth = new Error(
                false,
                401,
                "Authentication failed: Invalid username or password."
        );
        auth.printInfo();
        Error access = new Error(
                false,
                403,
                "Access denied: Insufficient permission."
        );
        access.printInfo();
        Error resource = new Error(
                false,
                404,
                "Resource not found: The requested resource does not exist."
        );
        resource.printInfo();
    }

}
