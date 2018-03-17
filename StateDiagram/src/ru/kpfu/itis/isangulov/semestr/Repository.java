package ru.kpfu.itis.isangulov.semestr;

import java.util.ArrayList;

public class Repository {
    private ArrayList<Variable> variables;
    private String[] strings = null;

    //проверяет, существовует ли объект с таким же именем
    private boolean contains(String name) {
        for (int i = 0; i < variables.size(); i++) {
            if (variables.get(i) != null) {
                if (variables.get(i).getName().equals(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    //сравнивает два арэйлиста
    public boolean equals(Object anObject) {
        for (int i = 0; i < Math.max(variables.size(), ((Variable[]) anObject).length); i++) {
            if (!(variables.get(i).equals(((Variable[]) anObject)[i]))) {
                return false;
            }
        }
        return true;
    }

    //получает на вход индекс, с которым производить действия, число и знак
    private void action(int i, int number, char s) {
        if (s == '=') {
            variables.get(i).setValue(number);
            return;
        }
        if (s == '+') {
            variables.get(i).setValueSummarize(number);
            return;
        }
        if (s == '-') {
            variables.get(i).setValueDeduct(number);
            return;
        }
        if (s == '*') {
            variables.get(i).setValueMultiply(number);
            return;
        }
        if (s == '/') {
            variables.get(i).setValueDivide(number);
            return;
        }
    }

    //по имени находит нужный объект и выдаёт его значение
    private int getValue(String name) {
        for (int k = 0; k < variables.size(); k++) {
            if (variables.get(k).getName().equals(name)) {
                return variables.get(k).getValue();
            }
        }
        throw new InitializeException();
    }

    //по имени находит нужный объект, выдаёт его индекс, если такого объекта нет, то выдаёт тот индекс, который мы ему дали
    private int getI(String name, int I) {
        for (int k = 0; k < variables.size(); k++) {
            if (variables.get(k).getName().equals(name)) {
                return k;
            }
        }
        return I;
    }

    //основной метод, проверяет в строке правильный порядок инициализации переменных, иначе выбрасывает ошибку инициализации
    //заполняет массив объектов, хранящих имя переменной и её значение
    public void process(String data) {
        strings = data.split(";");
        this.variables = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            int I = i;
            String name;
            String Rname;
            String numeric;
            char c;
            name = strings[i].charAt(0) + "" + strings[i].charAt(0 + 1);

            if (!contains(name)) {
                variables.add(new Variable(name));
            } else {
                I--;
            }
            for (int k = 4; k < strings[i].length(); k++) {
                char s;
                c = strings[i].charAt(k);
                if (Character.isDigit(c)) {
                    s = strings[i].charAt(k - 1);
                    numeric = c + "";
                    while (Character.isDigit(c) && k < strings[i].length() - 1) {
                        k++;
                        c = strings[i].charAt(k);
                        if (Character.isDigit(c)) {
                            numeric = numeric + c + "";
                        }
                    }
                    int number = Integer.parseInt(numeric);
                    //даем индекс данного имени, если оно уже есть, то получим его айди, иначе даем нынешний индекс
                    //даем значение числа и знак
                    //в данном случае он получит имя слева от равно
                    action(getI(name, I), number, s);
                }
                if (c <= 'Z' && c >= 'A') {
                    s = strings[i].charAt(k - 1);
                    Rname = strings[i].charAt(k) + "" + strings[i].charAt(k + 1);
                    k++;
                    //в данном случае он получит имя справа от равно, найдёт его индекс, если такоё имя было
                    //он отправит методу getValue() собранное справа имя, и если его не будет, то он должен выбрсить ошибку
                    //
                    action(getI(name, I), getValue(Rname), s);
                }
            }
        }
    }
}
