package it.unibo.mvc;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Simple controller.
 */
public final class SimpleController implements Controller {

    private final List<String> myAllStrings = new LinkedList<>();
    private String nextString;

    @Override
    public String getNexString() {
        return nextString;
    }

    @Override
    public List<String> getHistoryString() {
        return Collections.unmodifiableList(myAllStrings);
    }

    @Override
    public void printCurrentString() {
        if (nextString == null) {
            throw new IllegalStateException("String is null");
        }
        myAllStrings.add(this.nextString);
        System.out.println(this.nextString);
    }

    @Override
    public void setNextString(final String nextString) {
        this.nextString = Objects.requireNonNull(nextString, "This method does not accept null values.");
    }
}
