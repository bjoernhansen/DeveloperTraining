package com.observing.listener;

import java.util.EventListener;

public interface BirthdayListener extends EventListener
{
    void gifting(BirthdayEvent e);
}
