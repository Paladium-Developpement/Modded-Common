package fr.modded.api.request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static fr.modded.api.util.ObjectUtil.checkNotNull;

public class Headers {
    private final Map<String, String> properties;

    public Headers(Builder builder) {
        this.properties = builder.properties;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public static class Builder {
        private final Map<String, String> properties = new HashMap<>();

        public Builder set(String name, String value) {
            checkNameAndValue(name, value);
            this.properties.put(name, value);
            return this;
        }

        private void checkNameAndValue(String name, String value) {
            checkNotNull(name, "name == null");
            if (name.isEmpty())
                throw new IllegalArgumentException("name is empty");
            checkNotNull(value, "value for name " + name + " == null");
        }
    }
}
