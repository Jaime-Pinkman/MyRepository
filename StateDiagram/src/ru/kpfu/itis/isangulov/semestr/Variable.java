package ru.kpfu.itis.isangulov.semestr;

public class Variable {
    private String name;
    private int value;

    public String getName() {
        return name;
    }

    public void setValueSummarize(int value) {
        this.value += value;
    }

    public void setValueDivide(int value) {
        this.value /= value;
    }

    public void setValueMultiply(int value) {
        this.value *= value;
    }

    public void setValueDeduct(int value) {
        this.value -= value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean equals(Object anObject) {
        String s1 = ((Variable) anObject).getName();
        int s2 = ((Variable) anObject).getValue();
        if (name.equals(s1) && value == s2) {
            return true;
        }
        return false;

    }

    public Variable(String name) {
        this.name = name;
        this.value = 0;
    }

    public Variable(String name, int value) {
        this.name = name;
        this.value = value;
    }
}
