package com.javarush.task.task20.task2025;


import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class Testing {
    // 1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407,
    // 1634, 8208, 9474, 54 748, 92 727, 93 084,
    // 548 834, 1 741 725, 4 210 818, 9 800 817, 9 926 315,
    // 24 678 050, 24 678 051, 88 593 477,
    // 146 511 208, 472 335 975, 534 494 836, 912 985 153,
    // 4 679 307 774.
 @Test
    public void test100() {
        assertArrayEquals(Solution.getNumbers(7), new long[]{1L, 2L, 3L, 4L, 5L, 6L});
        assertArrayEquals(Solution.getNumbers(100), new long[]{1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L});
        assertArrayEquals(Solution.getNumbers(407), new long[]{1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 153L, 370L, 371L});
        assertArrayEquals(Solution.getNumbers(1000), new long[]{1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 153L, 370L, 371L, 407L});
        assertArrayEquals(Solution.getNumbers(100000), new long[]{1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 153L, 370L, 371L, 407L,
                1634L, 8208L, 9474L, 54748L, 92727L, 93084L});
        assertArrayEquals(Solution.getNumbers(100000000), new long[]{1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 153L, 370L, 371L, 407L,
                1634L, 8208L, 9474L, 54748L, 92727L, 93084L, 548834L, 1741725L, 4210818L, 9800817L, 9926315L,
                24678050L, 24678051L, 88593477L});

    }


}
