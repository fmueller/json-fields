package org.zalando.guild.api.json.fields.java.util;

import javax.annotation.Nonnull;

/**
 * Backport of Guava / Java 8 Function interface.
 *
 * @author  Sean Patrick Floyd (sean.floyd@zalando.de)
 * @since   23.09.2015
 */
public interface Function<I, O> {
    @Nonnull
    O apply(@Nonnull I in);

}
