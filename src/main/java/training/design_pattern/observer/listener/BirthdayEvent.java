package training.design_pattern.observer.listener;

import java.util.EventObject;

class BirthdayEvent extends EventObject
{
    private final String present;

    BirthdayEvent(Object source, String present)
    {
        super(source);
        this.present = present;
    }

    String getPresent()
    {
        return this.present;
    }
}
