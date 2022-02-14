package com.ashu.practice.dp.creational.prototype;

import com.ashu.practice.dp.creational.prototype.model.ModelType;
import com.ashu.practice.dp.creational.prototype.model.Show;
import com.ashu.practice.dp.creational.prototype.model.Album;
import com.ashu.practice.dp.creational.prototype.model.Movie;

import java.util.EnumMap;

public class PrototypeFactory {

    private static final EnumMap<ModelType, PrototypeCapable> map = new EnumMap<>(ModelType.class);

    static {
        map.put(ModelType.MOVIE, new Movie());
        map.put(ModelType.ALBUM, new Album());
        map.put(ModelType.SHOW, new Show());
    }

    private PrototypeFactory() {
        // no instantiation required
    }

    public static PrototypeCapable getInstance(ModelType type) throws CloneNotSupportedException {
        return map.get(type).clone();
    }

}
