package com.github.jinahya.sexagenarycycle;

import org.junit.jupiter.params.aggregator.DefaultArgumentsAccessor;
import org.junit.jupiter.params.provider.Arguments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Stream;

import static java.util.Objects.requireNonNull;

final class EnumTestUtils {

    static <E extends Enum<E>, T> Stream<Arguments> appendEnumSetOfNone(
            final Class<E> enumClass, final Stream<? extends T> argumentsStream,
            final BiFunction<? super T, ? super EnumSet<E>, ? extends Arguments> argumentsMapper) {
        requireNonNull(enumClass, "enumClass is null");
        requireNonNull(argumentsStream, "argumentsStream is null");
        requireNonNull(argumentsMapper, "argumentsMapper is null");
        return argumentsStream
                .map(v -> argumentsMapper.apply(v, EnumSet.noneOf(enumClass)));
    }

    static <E extends Enum<E>, T> Stream<Arguments> appendEnumSetOfNone(
            final Class<E> enumClass, final Stream<? extends T> argumentsStream) {
        return appendEnumSetOfNone(
                enumClass,
                argumentsStream,
                (a, s) -> {
                    final List<Object> args = new DefaultArgumentsAccessor(a).toList();
                    args.add(EnumSet.noneOf(enumClass));
                    return Arguments.of(args.toArray());
                })
                ;
    }

    static <T, E extends Enum<E>> Stream<Arguments> appendEnumSetOfNoneX(
            final Stream<? extends T> argumentsStream, final Class<E> enumClass) {
        requireNonNull(enumClass, "enumClass is null");
        requireNonNull(argumentsStream, "argumentsStream is null");
        return argumentsStream
                .map(v -> {
                    if (v instanceof Arguments) {
                        final List<Object> args = new ArrayList<>(Arrays.asList(((Arguments) v).get()));
                        args.add(EnumSet.noneOf(enumClass));
                        return Arguments.of(args.toArray());
                    }
                    return Arguments.of(v, EnumSet.noneOf(enumClass));
                })
                ;
    }

    // -----------------------------------------------------------------------------------------------------------------
    static <E extends Enum<E>, T> Stream<Arguments> appendEnumSetOfAll(
            final Class<E> enumClass, final Stream<? extends T> argumentsStream,
            final BiFunction<? super T, ? super EnumSet<E>, ? extends Arguments> argumentsMapper) {
        requireNonNull(enumClass, "enumClass is null");
        requireNonNull(argumentsStream, "argumentsStream is null");
        return argumentsStream
                .map(v -> argumentsMapper.apply(v, EnumSet.allOf(enumClass)));
    }

    static <E extends Enum<E>> Stream<Arguments> appendEnumSetOfAll(
            final Class<E> enumClass, final Stream<Arguments> argumentsStream) {
        return appendEnumSetOfAll(enumClass, argumentsStream, (a, s) -> {
            final List<Object> args = new DefaultArgumentsAccessor(a).toList();
            args.add(EnumSet.allOf(enumClass));
            return Arguments.of(args.toArray());
        });
    }

    // -----------------------------------------------------------------------------------------------------------------
    private EnumTestUtils() {
        throw new AssertionError("instantiation is not allowed");
    }
}
