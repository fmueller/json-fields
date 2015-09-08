package org.zalando.guild.api.json.fields.java.expression;

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.misc.ParseCancellationException;

import org.zalando.guild.api.json.fields.java.model.FieldPredicate;
import org.zalando.guild.api.json.fields.java.model.FieldPredicates;
import org.zalando.guild.api.json.fields.java.parser.JsonFieldsLexer;
import org.zalando.guild.api.json.fields.java.parser.JsonFieldsParser;

/**
 * @author  Sean Patrick Floyd (sean.floyd@zalando.de)
 * @since   07.09.2015
 */
public class ParserFramework {
    private ParserFramework() { }

    public static FieldPredicate parseFieldsExpression(final String fieldsExpression) {

        try {

            final JsonFieldsLexer lexer = new JsonFieldsLexer(new ANTLRInputStream(fieldsExpression));
            lexer.removeErrorListeners();

            final ANTLRErrorListener listener = new BaseErrorListener() {
                @Override
                public void syntaxError(final Recognizer<?, ?> recognizer, final Object offendingSymbol, final int line,
                        final int charPositionInLine, final String msg, final RecognitionException e) {
                    throw new ParseCancellationException(e);
                }

            };
            lexer.addErrorListener(listener);

            final JsonFieldsParser parser = new JsonFieldsParser(new CommonTokenStream(lexer));
            parser.removeErrorListeners();

            parser.addErrorListener(listener);
            parser.setErrorHandler(new BailErrorStrategy());
            return new FieldPredicateVisitor().visitJson_fields(parser.json_fields());
        } catch (ParseCancellationException e) {
            return FieldPredicates.alwaysFalse();
        }
    }
}
