package com.concurrency.rmi.gumball.state;

import com.concurrency.rmi.gumball.state.State;

interface StateFactory
{
    State makeInstance();
}
