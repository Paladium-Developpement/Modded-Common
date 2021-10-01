package fr.modded.api.util.gson;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ModdedGson {
    static ExclusionStrategy strategy = new ExclusionStrategy() {
        @Override
        public boolean shouldSkipClass(Class<?> clazz) {
            return false;
        }

        @Override
        public boolean shouldSkipField(FieldAttributes field) {
            return (field.getAnnotation(Exclude.class) != null);
        }
    };

    public static final Gson GSON = new GsonBuilder()
            .addSerializationExclusionStrategy(strategy)
            .create();

    public static final Gson PRETTY_GSON = new GsonBuilder()
            .setPrettyPrinting()
            .addSerializationExclusionStrategy(strategy)
            .create();
}
