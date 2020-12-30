package com.github.jinahya.sexagenarycycle;

import org.junit.jupiter.api.Test;

import static java.util.concurrent.ThreadLocalRandom.current;
import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings({"NonAsciiCharacters", "java:S3577"})
class 五行Test implements RollingEnumTest<五行> {

    @Test
    void assIgnorant() {
        assertThat(current().nextBoolean()).satisfiesAnyOf(v -> assertThat(v).isTrue(), v -> assertThat(v).isFalse());
    }
}