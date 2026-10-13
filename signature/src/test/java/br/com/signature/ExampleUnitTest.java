package br.com.signature;

import br.com.signature.utils.SvgBuilder;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void penColorIsWhiteInNightMode() {
        assertEquals(0xFFFFFFFF, SignaturePad.resolvePenColor(0xFF000000, true));
    }

    @Test
    public void configuredPenColorIsPreservedInDayMode() {
        assertEquals(0xFF123456, SignaturePad.resolvePenColor(0xFF123456, false));
    }

    @Test
    public void documentBitmapPenColorIsAlwaysBlack() {
        assertEquals(0xFF000000, SignaturePad.resolveDocumentPenColor());
    }

    @Test
    public void svgUsesTheResolvedPenColor() {
        assertTrue(new SvgBuilder().build(100, 100, 0xFFFFFFFF).contains("stroke=\"#FFFFFF\""));
    }
}