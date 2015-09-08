package org.zalando.guild.api.json.fields.java.util;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * @author  Sean Patrick Floyd (sean.floyd@zalando.de)
 * @since   12.08.2015
 */
public final class Preconditions {

    private Preconditions() { }

    @Nonnull
    public static <T> T checkNotNull(@Nullable final T input, @Nullable final String message,
            @Nonnull final Object... params) {
        if (input == null) {
            throw new NullPointerException(message == null ? null : formatMessage(message, params));
        }

        return input;
    }

    public static void checkArgument(final boolean check, final String message, final Object... params) {
        if (!check) {
            throw new IllegalArgumentException(message == null ? null : formatMessage(message, params));
        }

    }

    private static String formatMessage(final String message, final Object[] params) {

        return params.length == 0 ? message : String.format(message, params);

    }
}
