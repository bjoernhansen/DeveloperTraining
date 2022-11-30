package training.concurrency.rmi.gumball.machine.state;

import java.util.List;
import java.util.function.Supplier;

public enum StateType implements StateFactory
{
    NO_QUARTER(NoQuarterState::new),
    HAS_QUARTER(HasQuarterState::new),
    SOLD(SoldState::new),
    SOLD_OUT(SoldOutState::new);
    
    private static final List<StateType>
        VALUES = List.of(values());
    
    private final Supplier<State>
        stateSupplier;
    
    public static List<StateType> getValues()
    {
        return VALUES;
    }
    
    StateType(Supplier<State> stateSupplier)
    {
        this.stateSupplier = stateSupplier;
    }
    
    @Override
    public State makeInstance()
    {
        return stateSupplier.get();
    }
}
