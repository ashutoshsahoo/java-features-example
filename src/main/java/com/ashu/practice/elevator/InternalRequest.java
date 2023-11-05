package com.ashu.practice.elevator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class InternalRequest {
    private int destinationFloor;

    @Override
    public String toString() {
        return "The destinationFloor is - " + destinationFloor;
    }
}
