package com.tsyhanok;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEncoder {

    @Test
    public void testEncodeSuccessInputOne() {
        assertEquals("00 0 0 0 00 000 0 000", Encoder.encode("G"));
    }

    @Test
    public void testEncodeSuccessInputTwo() {
        assertEquals("00 0 0 0 00 000 0 0000 00 00 0 0000", Encoder.encode("GO"));
    }

    @Test
    public void testEncodeFailureEmptyInput() {
        assertEquals("Message isn't valid", Encoder.encode(""));
    }

    @Test
    public void estEncodeFailureBigInput() {
        assertEquals("Message isn't valid",
                Encoder.encode("g7wMp32okX7G6cdkvK8Dvo69Eorb6AL5n7UO3OB5PPaYZP1bfylnIT5lEdyPYxeJPE1rUQcR9Uy2lxWlyIRGNPOD6oYMggt1P06zj"));
    }

}
