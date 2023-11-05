package com.ashu.practice.elevator;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
//@NoArgsConstructor
public class ExternalRequest {
    private Direction directionToGo;
    private int sourceFloor;

    @Override
    public String toString() {
        return " The Elevator has been requested on floor - " + sourceFloor + " and the person wants go in the - "
                + directionToGo;
    }
}
