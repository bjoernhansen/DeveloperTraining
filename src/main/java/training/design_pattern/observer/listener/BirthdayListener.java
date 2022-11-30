package training.design_pattern.observer.listener;

import java.util.EventListener;

public interface BirthdayListener extends EventListener
{
    void gifting(BirthdayEvent e);
}
