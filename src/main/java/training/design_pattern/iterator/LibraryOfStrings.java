package training.design_pattern.iterator;

import java.util.ArrayList;
import java.util.List;


public class LibraryOfStrings
{
    private final List<String>
        strings = new ArrayList<>();


    public void push(String string)
    {
        strings.add(string);
    }

    public String pop()
    {
        int lastIndex = strings.size() - 1;
        if(lastIndex >= 0)
        {
            String lastString = strings.get(lastIndex);
            strings.remove(lastIndex);
            return lastString;
        }
        return null;
    }

    Iterator<String> getIterator()
    {
        return new IteratorImplementation();
    }


    class IteratorImplementation implements Iterator<String>
    {
        private int index = -1;

        @Override
        public boolean hasNext()
        {
            return index + 1 < strings.size();
        }

        @Override
        public String getCurrent()
        {
            return hasCurrentElement() ? strings.get(index) : null;
        }

        private boolean hasCurrentElement()
        {
            return index > -1 && index < strings.size();
        }

        @Override
        public void next()
        {
            index++;
        }
    }
}
