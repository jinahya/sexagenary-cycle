package com.github.jinahya.sexagenarycycle;

import javax.validation.constraints.NotNull;

interface Rolling<T extends Rolling<T>> {

    /**
     * Returns the previous value of this value.
     *
     * @return the previous value of this value.
     */
    @NotNull
    T getPrevious();

    /**
     * Returns the next value of this value.
     *
     * @return the next value of this value.
     */
    @NotNull
    T getNext();
}
