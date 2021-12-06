package com.example.myapplication;

import android.util.JsonReader;
import android.util.JsonWriter;

import com.google.gson.TypeAdapter;

import java.io.IOException;

class MyTypeAdapter<T> extends TypeAdapter<T> {
    public T read(JsonReader reader) throws IOException {
        return null;
    }

    public void write(JsonWriter writer, T obj) throws IOException {
        if (obj == null) {
            writer.nullValue();
            return;
        }
        writer.value(obj.toString());
    }

    @Override
    public void write(com.google.gson.stream.JsonWriter out, T value) throws IOException {

    }

    @Override
    public T read(com.google.gson.stream.JsonReader in) throws IOException {
        return null;
    }
}