package com.ashu.practice.dp.creational.prototype;

import com.ashu.practice.dp.creational.prototype.model.Album;
import com.ashu.practice.dp.creational.prototype.model.ModelType;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestPrototypePattern {
    public static void main(String[] args) {
        try {
            String moviePrototype = PrototypeFactory.getInstance(ModelType.MOVIE).toString();
            log.info(moviePrototype);

            Album album1 = (Album) PrototypeFactory.getInstance(ModelType.ALBUM);
            album1.setName("album1");
            log.info(album1.toString());

            Album album2 = (Album) PrototypeFactory.getInstance(ModelType.ALBUM);
            log.info(album2.toString());

            String showPrototype = PrototypeFactory.getInstance(ModelType.SHOW).toString();
            log.info(showPrototype);

        } catch (CloneNotSupportedException e) {
            log.error(e.getMessage(), e);
        }
    }
}

/*
04:59:20.117 [main] INFO  c.a.p.dp.prototype.model.Movie.clone(28) - Cloning Movie object
04:59:20.129 [main] INFO  c.a.p.d.p.TestPrototypePattern.main(12) - Movie{name='null'}
04:59:20.129 [main] INFO  c.a.p.dp.prototype.model.Album.clone(28) - Cloning Album object
04:59:20.130 [main] INFO  c.a.p.d.p.TestPrototypePattern.main(17) - Album{name='album1'}
04:59:20.130 [main] INFO  c.a.p.dp.prototype.model.Album.clone(28) - Cloning Album object
04:59:20.131 [main] INFO  c.a.p.d.p.TestPrototypePattern.main(22) - Album{name='null'}
04:59:20.131 [main] INFO  c.a.practice.dp.prototype.model.Show.clone(28) - Cloning Show object
04:59:20.132 [main] INFO  c.a.p.d.p.TestPrototypePattern.main(25) - Show{name='null'}
 */
