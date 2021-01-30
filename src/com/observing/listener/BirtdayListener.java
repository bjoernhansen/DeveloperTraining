package com.observing.listener;

import java.util.EventListener;

public interface BirtdayListener extends EventListener
{
    void gifting(BirthdayEvent e);
}
