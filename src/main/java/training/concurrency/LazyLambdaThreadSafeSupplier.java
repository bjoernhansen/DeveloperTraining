package training.concurrency;

import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;


class LazyLambdaThreadSafeSupplier<T>
{
    // https://www.baeldung.com/java-lambda-lazy-field-initialization
    
    private final Supplier<T> expensiveData;
    private final AtomicReference<T> data;
    
    LazyLambdaThreadSafeSupplier(Supplier<T> expensiveData)
    {
        this.expensiveData = expensiveData;
        data = new AtomicReference<>();
    }
    
    T getData()
    {
        if(data.get() == null)
        {
            synchronized(data)
            {
                if(data.get() == null)
                {
                    data.set(expensiveData.get());
                }
            }
        }
        return data.get();
    }
}
