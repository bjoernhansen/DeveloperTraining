package training.design_pattern.iterator;

import org.junit.jupiter.api.Test;

import java.util.StringJoiner;

import static org.assertj.core.api.Assertions.assertThat;

class LibraryOfStringsTest
{
    @Test
    void shouldWorkCorrectlyForNonEmptyLibrary()
    {
        LibraryOfStrings libraryOfStrings = new LibraryOfStrings();

        libraryOfStrings.push("1");
        libraryOfStrings.push("2");
        libraryOfStrings.push("3");
        libraryOfStrings.push("4");
        libraryOfStrings.pop();

        StringJoiner stringJoiner = new StringJoiner(" ");
        Iterator<String> iterator = libraryOfStrings.getIterator();
        while(iterator.hasNext())
        {
            iterator.next();
            stringJoiner.add(iterator.getCurrent());
        }

        assertThat(stringJoiner.toString()).isEqualTo("1 2 3");
    }

    @Test
    void shouldReturnEmptyStringForEmptyLibrary()
    {
        LibraryOfStrings libraryOfStrings = new LibraryOfStrings();

        libraryOfStrings.push("1");
        libraryOfStrings.pop();

        StringJoiner stringJoiner = new StringJoiner(" ");
        Iterator<String> iterator = libraryOfStrings.getIterator();
        while(iterator.hasNext())
        {
            iterator.next();
            stringJoiner.add(iterator.getCurrent());
        }

        assertThat(stringJoiner.toString()).isEmpty();
    }

    @Test
    void shouldReturnNullWhenIteratorMovedBeyondEnd()
    {
        LibraryOfStrings
            libraryOfStrings = new LibraryOfStrings();
        Iterator<String> iterator = libraryOfStrings.getIterator();

        iterator.next();

        assertThat(iterator.getCurrent()).isNull();
    }
}

