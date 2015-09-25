package org.zalando.guild.api.json.fields.java.util;

import javax.annotation.Nonnull;

/**
 * Backport of Guava / Java 8 Supplier interface.
 *
 * @author  Sean Patrick Floyd (sean.floyd@zalando.de)
 * @since   23.09.2015
 */
public interface Supplier<T> {
    @Nonnull
    T get();
}
