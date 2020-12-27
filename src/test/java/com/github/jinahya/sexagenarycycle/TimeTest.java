package com.github.jinahya.sexagenarycycle;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalTime;

@Slf4j
class TimeTest {

    @Test
    void test() {
        {
            final LocalTime h23 = LocalTime.of(23, 0);
            log.debug("h23 + 2h: {}", h23.plus(Duration.ofHours(2L)));
        }
    }
}
