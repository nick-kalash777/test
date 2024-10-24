package input;

import java.util.List;

public interface Loader<T> {
    List<T> loadFile(String filePath);
}
