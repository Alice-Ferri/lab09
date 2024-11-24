package it.unibo.mvc;

import java.util.List;

/**
 * Simple interface of the controller.
 */
public interface Controller {
    /**
     * @param a is string to set next.
     * @throws IllegalStateException if the values are not acceptable
     */
    void setNextString(String a);

    /**
     * @return next string to print
     */
    String getNexString();

    /**
     * @return history of the printed strings
     */
    List<String> getHistoryString();

    /**
     * @throws IllegalStateException
     */
    void printCurrentString();
}
