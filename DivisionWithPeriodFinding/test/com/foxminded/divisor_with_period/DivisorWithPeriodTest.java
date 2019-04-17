package com.foxminded.divisor_with_period;

import static org.junit.Assert.*;
import org.junit.Test;

public class DivisorWithPeriodTest {

    private DivisorWithPeriod divisor = new DivisorWithPeriod();
    
    @Test
    public void shouldHandle1000DividedBy3() {
        assertEquals(" _1000|3\n" +
                     "   9  |-------\n" +
                     "   -  |333.(3)\n" +
                     "  _10\n" +
                     "    9\n" +
                     "    -\n" +
                     "   _10\n" +
                     "     9\n" +
                     "     -\n" +
                     "    _10\n" +
                     "      9\n" +
                     "      -\n" + 
                     "      1\n" ,divisor.divide(1000,3));
    }

    @Test
    public void shouldHandle123DividedBy999() {
        assertEquals(" _123 |999\n" +
                     "   999|-------\n" +
                     "   ---|0.(123)\n" +
                     "  _2310\n" +
                     "   1998\n" +
                     "   ----\n" +
                     "   _3120\n" +
                     "    2997\n" +
                     "    ----\n" +
                     "     123\n" ,divisor.divide(123,999));
    }

    @Test
    public void shouldHandle7DividedBy12() {
        assertEquals(" _7 |12\n" +
                     "  60|-------\n" +
                     "  --|0.58(3)\n" +
                     " _100\n" +
                     "   96\n" +
                     "   --\n" +
                     "   _40\n" +
                     "    36\n" +
                     "    --\n" +
                     "     4\n" ,divisor.divide(7,12));
    }
    
    @Test
    public void shouldHandle25DividedBy39() {
        assertEquals(" _25 |39\n" +
                     "  234|----------\n" +
                     "  ---|0.(641025)\n" +
                     "  _160\n" +
                     "   156\n" +
                     "   ---\n" +
                     "    _40\n" +
                     "     39\n" +
                     "     --\n" +
                     "     _100\n" +
                     "       78\n" +
                     "       --\n" + 
                     "      _220\n" + 
                     "       195\n" +
                     "       ---\n" +
                     "        25\n",divisor.divide(25,39));
    }

    @Test
    public void shouldHandle78459DividedBy4() {
        assertEquals(" _78459|4\n" +
                     "  4    |--------\n" +
                     "  -    |19614.75\n" +
                     " _38\n" +
                     "  36\n" +
                     "  --\n" +
                     "  _24\n" +
                     "   24\n" +
                     "   --\n" +
                     "    _5\n" +
                     "     4\n" +
                     "     -\n" +
                     "    _19\n" +
                     "     16\n" +
                     "     --\n" +
                     "     _30\n" +
                     "      28\n" +
                     "      --\n" +
                     "      _20\n" +
                     "       20\n" +
                     "       --\n" +
                     "        0\n", divisor.divide(78459,4));
    }

    @Test
    public void shouldHandle945DividedBy6() {
        assertEquals(" _945|6\n" +
                     "  6  |-----\n" +
                     "  -  |157.5\n" +
                     " _34\n" +
                     "  30\n" +
                     "  --\n" +
                     "  _45\n" +
                     "   42\n" +
                     "   --\n" +
                     "   _30\n" +
                     "    30\n" +
                     "    --\n" +
                     "     0\n", divisor.divide(945,6));
    }

    @Test
    public void shouldHandle8420DividedBy4() {
        assertEquals(" _8420|4\n" +
                     "  8   |----\n" +
                     "  -   |2105\n" +
                     "  _4\n" +
                     "   4\n" +
                     "   -\n" +
                     "   _20\n" +
                     "    20\n" +
                     "    --\n" +
                     "     0\n", divisor.divide(8420,4));
    }

    @Test
    public void shouldHandle1003DividedBy999999() {
        assertEquals(" _1003   |999999\n" +
                     "   999999|----------\n" +
                     "   ------|0.(001003)\n" +
                     "    _3001000\n" +
                     "     2999997\n" +
                     "     -------\n" +
                     "        1003\n", divisor.divide(1003, 999999));
    }

    @Test
    public void shouldHandle963DividedBy17() {
        assertEquals(" _963|17\n" +
                     "  85 |-------------\n" +
                     "  -- |56.6470588235\n" +
                     " _113\n" +
                     "  102\n" +
                     "  ---\n" +
                     "  _110\n" +
                     "   102\n" +
                     "   ---\n" +
                     "    _80\n" +
                     "     68\n" +
                     "     --\n" + 
                     "    _120\n" + 
                     "     119\n" +
                     "     ---\n" +
                     "      _100\n" + 
                     "        85\n" + 
                     "        --\n" + 
                     "       _150\n" + 
                     "        136\n" +
                     "        ---\n" + 
                     "        _140\n" + 
                     "         136\n" + 
                     "         ---\n" + 
                     "          _40\n" + 
                     "           34\n" + 
                     "           --\n" +
                     "           _60\n" + 
                     "            51\n" + 
                     "            --\n" +
                     "            _90\n" + 
                     "             85\n" + 
                     "             --\n" + 
                     "             _50\n" + 
                     "              34\n" + 
                     "              --\n" + 
                     "              16\n" , divisor.divide(963,17));
    }
    
    @Test
    public void shouldHandle639DividedBy17() {
        assertEquals(" _639|17\n" +
                     "  51 |-------------\n" +
                     "  -- |37.5882352941\n" +
                     " _129\n" +
                     "  119\n" +
                     "  ---\n" +
                     "  _100\n" +
                     "    85\n" +
                     "    --\n" +
                     "   _150\n" +
                     "    136\n" +
                     "    ---\n" + 
                     "    _140\n" + 
                     "     136\n" +
                     "     ---\n" +
                     "      _40\n" + 
                     "       34\n" + 
                     "       --\n" + 
                     "       _60\n" + 
                     "        51\n" + 
                     "        --\n" +
                     "        _90\n" + 
                     "         85\n" + 
                     "         --\n" + 
                     "         _50\n" + 
                     "          34\n" + 
                     "          --\n" + 
                     "         _160\n" +
                     "          153\n" +
                     "          ---\n" +
                     "           _70\n" +
                     "            68\n" +
                     "            --\n" +
                     "            _20\n" +
                     "             17\n" +
                     "             --\n" +
                     "              3\n", divisor.divide(639,17));
    }
}
