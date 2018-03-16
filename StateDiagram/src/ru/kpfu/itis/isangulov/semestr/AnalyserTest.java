package ru.kpfu.itis.isangulov.semestr;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AnalyserTest {
    Analyser analyser;
    String input;
    @Before
    public void setUp() {
        analyser = new Analyser();
    }
    @Test
    public void analyserTest1() {
        input = "X1:=2;V2:=X1+5+7;N3:=4;";
        boolean result = analyser.analyse(input);
        Assert.assertTrue(result);
    }
    @Test
    public void analyserTest2() {
        input = "X1:=2;V2:=X1+5+7;N3:=4;";
        boolean result = analyser.analyse(input);
        Assert.assertTrue(result);
    }
    @Test
    public void analyserTest3() {
        String input = "X1:=2;V2:=X1+5+7;N3:=4;";
        boolean result = analyser.analyse(input);
        Assert.assertTrue(result);
    }
    @Test(expected = SyntaxException.class)
    public void analyserTest4() {
        input = "X1:=2;2V2=X11+5+7;N3:=4;";
        boolean result = analyser.analyse(input);
        Assert.assertTrue(result);
    }
    @Test(expected = SyntaxException.class)
    public void analyserTest5() {
        String input = "X1:=2;V2=X1++5+7;N3:=4;";
        boolean result = analyser.analyse(input);
        Assert.assertTrue(result);
    }
    @Test(expected = SyntaxException.class)
    public void analyserTest6() {
        input = "X1:32;V2=X1+5+7;N3:=4;";
        boolean result = analyser.analyse(input);
        Assert.assertTrue(result);
    }
}
