package io;

import models.Bus;
import models.Loadable;
import models.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public abstract class DataReader {
    public List<Loadable> readData (List<String> data) {
        List<Loadable> loadedData = new ArrayList<>();
        for (String line : data) {
            String[] parsedLine = line.split(",");
            Loader loader = LoaderFactory.getLoader(parsedLine[0]);
            loadedData.add(loader.load(parsedLine));
        }
        return loadedData;
    }

    private interface Loader {
        Loadable load (String[] data);
    }

    private static class LoaderFactory {
        private static final Map<String, Loader> loaders = new HashMap<>();

        static {
            loaders.put("@BUS", new BusLoader());
            loaders.put("@USER", new UserLoader());
        }

        public static Loader getLoader(String type) {
            return loaders.get(type);
        }
    }

    private static class UserLoader implements Loader {
        public Loadable load(String[] data) {
            return new User.UserBuilder().setName(data[1]).setPassword(data[2]).setEmail(data[3]).build();
        }
    }

    private static class BusLoader implements Loader {
        public Loadable load(String[] data) {
            return new Bus.Builder().setNumber(data[1]).setModel(data[2]).setMileage(Integer.parseInt(data[3])).build();
        }
    }
}
