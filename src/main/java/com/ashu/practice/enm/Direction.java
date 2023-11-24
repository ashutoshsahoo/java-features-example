package com.ashu.practice.enm;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@ToString
public enum Direction {
    EAST(0, "east"),
    NORTH(90, "north"),
    WEST(180, "west"),
    SOUTH(270, "south");

    // internal state
    private final int angle;

    private final String description;

    Direction(int angle, String description) {
        this.angle = angle;
        this.description = description;
    }

    public static void main(String[] args) {
        log.info("Starting main method");
        log.info("Print EAST= {}", Direction.EAST);
        log.info("Print EAST angle= {}", Direction.EAST.getAngle());
    }

/* Output
09:48:12.007 [main] INFO  com.ashu.practice.enm.Direction.main(24) - Starting main method
09:48:12.012 [main] INFO  com.ashu.practice.enm.Direction.main(25) - Print EAST= Direction.EAST(angle=0, description=east)
09:48:12.027 [main] INFO  com.ashu.practice.enm.Direction.main(26) - Print EAST angle= 0
*/

}
