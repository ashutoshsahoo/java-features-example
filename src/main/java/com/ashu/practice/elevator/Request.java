package com.ashu.practice.elevator;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Request implements Comparable<Request> {

    private InternalRequest internalRequest;

    private ExternalRequest externalRequest;

    @Override
    public int compareTo(Request request) {
        return Integer.compare(this.getInternalRequest().getDestinationFloor(), request.getInternalRequest().getDestinationFloor());
    }
}
