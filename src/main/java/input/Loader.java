package input;

import java.io.IOException;
import java.util.List;

public interface Loader<T> {
    List<T> loadFile(String filePath) throws IllegalArgumentException, IOException;
}
