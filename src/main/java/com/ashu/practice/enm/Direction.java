package com.ashu.practice.enm;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public enum Direction {
    EAST(0, "east"), WEST(180, "west"), NORTH(90, "north"), SOUTH(270, "south");

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
10:16:59.390 [main] INFO  com.ashu.practice.enm.Direction.main(36) - Starting main method
10:16:59.390 [main] INFO  com.ashu.practice.enm.Direction.main(37) - Print EAST= Direction{angle=0, description='east'}
10:16:59.390 [main] INFO  com.ashu.practice.enm.Direction.main(38) - Print EAST angle= 0
*/

    public int getAngle() {
        return angle;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Direction{" +
                "angle=" + angle +
                ", description='" + description + '\'' +
                '}';
    }

}
