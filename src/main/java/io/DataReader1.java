package io;

import java.util.List;

public interface DataReader1 <Loadable> {
    List<Loadable> readData (List<String> data);

}
