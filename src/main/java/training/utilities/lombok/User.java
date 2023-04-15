package training.utilities.lombok;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;


@Getter
@Setter
// @NoArgsConstructor <-- nicht möglich, wenn finale Felder deklariert
@AllArgsConstructor
@RequiredArgsConstructor // final oder @NonNUll-Annotiert wird berücksichtigt
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode
public class User implements Serializable
{
    @Setter(AccessLevel.PACKAGE)
    private Long id; // will be set when persisting
    
    @ToString.Include
    @NonNull
    private String firstName;
    
    @ToString.Include
    private final String lastName;
    
    
    private int age;
    
}