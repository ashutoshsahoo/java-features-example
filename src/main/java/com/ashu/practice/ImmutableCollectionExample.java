package com.ashu.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ImmutableCollectionExample {
    public static void main(String[] args) {
        int[] objects = new int[]{1, 3, 7, 8, 0};
        System.out.println(Arrays.toString(objects));
        List<Integer> list = List.of(1, 2, 3, 5, 6, 5);
        System.out.println(list);
        Set<Integer> integerSet = Set.of(1, 3, 5);
        System.out.println(integerSet);
        Map<Integer, Integer> integerMap = Map.of(1, 12, 2, 25, 3, 35);
        System.out.println(integerMap);
    }
/*
[1, 3, 7, 8, 0]
[1, 2, 3, 5, 6, 5]
[1, 5, 3]
{1=12, 3=35, 2=25}
 */

    public static class TextBlockExample {
        public static void main(String[] args) {
            String logXml = """
                    <configuration>                               
                        <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
                            <!-- encoders are assigned the type
                                 ch.qos.logback.classic.encoder.PatternLayoutEncoder by default -->
                            <encoder>
                                <pattern>%d{hh:mm:ss.SSS} [%thread] %highlight(%-5level) %logger{36}.%M\\(%line\\) - %msg%n</pattern>
                            </encoder>
                        </appender>
                                    
                        <logger name="com.ashu.practice" level="DEBUG"/>
                        <root level="INFO">
                            <appender-ref ref="STDOUT"/>
                        </root>
                    </configuration>
                    """;
            System.out.println(logXml);
        }
    /* O/P
    <configuration>
        <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
            <!-- encoders are assigned the type
                 ch.qos.logback.classic.encoder.PatternLayoutEncoder by default -->
            <encoder>
                <pattern>%d{hh:mm:ss.SSS} [%thread] %highlight(%-5level) %logger{36}.%M\(%line\) - %msg%n</pattern>
            </encoder>
        </appender>

        <logger name="com.ashu.practice" level="DEBUG"/>
        <root level="INFO">
            <appender-ref ref="STDOUT"/>
        </root>
    </configuration>
     */

    }
}
