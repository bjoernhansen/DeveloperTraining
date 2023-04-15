package training.utilities.lombok;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Value;

@Value
@Getter(AccessLevel.NONE) // kein Zugriff auf Getter und Setter
public class ColorValueObject {
    int red;
    int green;
    int blue;
    
    public String getHexString() {
        return String.format("#%02X%02X%02X", red, green, blue);
    }
}
