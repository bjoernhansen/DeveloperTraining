package training.design_pattern.mediator;

import java.util.ArrayList;
import java.util.List;

abstract class UIControl
{
    private final List<EventHandler>
        eventHandlers = new ArrayList<>();

    void addEventHandler(EventHandler eventHandler)
    {
        eventHandlers.add(eventHandler);
    }

    void notifyEventHandler()
    {
        eventHandlers.forEach(EventHandler::handle);
    }
}
