package ru.kpfu.itis.isangulov.semestr;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProcessTest {
    Repository repository;
    String string;

    @Before
    public void setUp() {
        repository = new Repository();
    }

    @Test
    public void processTest1() {
        string = "X1:=2;V2:=X1+5+7;N3:=X1+V2+X1+100;";
        repository.process(string);
        Variable[] testVaribles = new Variable[]{new Variable("X1", 2), new Variable("V2", 14), new Variable("N3", 118)};
        boolean result = repository.equals(testVaribles);
        Assert.assertTrue(result);
    }

    @Test
    public void processTest2() {
        string = "X1:=10;Z3:=X1*8;K4:=Z3*4;";
        repository.process(string);
        Variable[] testVaribles = new Variable[]{new Variable("X1", 10), new Variable("Z3", 80), new Variable("K4", 320)};
        boolean result = repository.equals(testVaribles);
        Assert.assertTrue(result);
    }

    @Test
    public void processTest3() {
        string = "L9:=100;Z3:=L9-50;K4:=Z3-4;";
        repository.process(string);
        Variable[] testVaribles = new Variable[]{new Variable("L9", 100), new Variable("Z3", 50), new Variable("K4", 46)};
        boolean result = repository.equals(testVaribles);
        Assert.assertTrue(result);
    }

    @Test
    public void processTest4() {
        string = "L9:=100;Z3:=L9/50;K4:=Z3/2;";
        repository.process(string);
        Variable[] testVaribles = new Variable[]{new Variable("L9", 100), new Variable("Z3", 2), new Variable("K4", 1)};
        boolean result = repository.equals(testVaribles);
        Assert.assertTrue(result);
    }

    @Test
    public void processTest5() {
        string = "L9:=100;Z3:=L9-50;K4:=Z3-4;";
        repository.process(string);
        Variable[] testVaribles = new Variable[]{new Variable("L9", 100), new Variable("Z3", 564), new Variable("K4", 46)};
        boolean result = repository.equals(testVaribles);
        Assert.assertFalse(result);
    }

    @Test
    public void processTest6() {
        string = "L9:=100;Z3:=L9-10/9;K4:=Z3*2/20;";
        repository.process(string);
        Variable[] testVaribles = new Variable[]{new Variable("L9", 100), new Variable("Z3", 10), new Variable("K4", 1)};
        boolean result = repository.equals(testVaribles);
        Assert.assertTrue(result);
    }

    @Test
    public void processTest7() {
        string = "L9:=100;L9:=10;K4:=L9*2/20;";
        repository.process(string);
        Variable[] testVaribles = new Variable[]{new Variable("L9", 10), new Variable("K4", 1)};
        boolean result = repository.equals(testVaribles);
        Assert.assertTrue(result);
    }

    @Test
    public void processTest8() {
        string = "L9:=100;L9:=L9-10/9;K4:=L9*2/20;";
        repository.process(string);
        Variable[] testVaribles = new Variable[]{new Variable("L9", 10), new Variable("K4", 1)};
        boolean result = repository.equals(testVaribles);
        Assert.assertTrue(result);
    }

    @Test(expected = InitializeException.class)
    public void processTest9() {
        string = "L9:=100;L9:=L9-10/9;K4:=L8*2/20;";
        repository.process(string);
    }

    @Test(expected = InitializeException.class)
    public void processTest10() {
        string = "L9:=100;L9:=L9+J7-10/9;K4:=L9*2/20;";
        repository.process(string);
    }

}
