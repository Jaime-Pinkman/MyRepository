package ru.kpfu.itis.isangulov.semestr;

public class Analyser {

    public boolean analyse(String s) {
        char element = 0;
        int state = 0;
        for (int i = 0; i < s.length(); i++) {
            element = s.charAt(i);
            switch (state) {
                case 0:
                    if (element <= 'Z' && element >= 'A') {
                        state = 1;
                        break;
                    }
                    throw new SyntaxException();
                case 1:
                    if (element - '0' <= 9 && element - '0' >= 1) {
                        state = 1;
                        break;
                    }
                    if (element == ';') {
                        state = 2;
                        break;
                    }
                    if (element == ':') {
                        state = 3;
                        break;
                    }
                    if (element == '+' || element == '-' || element == '*' || element == '/') {
                        state = 5;
                        break;
                    }
                    throw new SyntaxException();
                case 2:
                    if (element <= 'Z' && element >= 'A') {
                        state = 1;
                        break;
                    }
                    throw new SyntaxException();
                case 3:
                    if (element == '=') {
                        state = 4;
                        break;
                    }
                    throw new SyntaxException();
                case 4:
                    if (element <= 'Z' && element >= 'A') {
                        state = 1;
                        break;
                    }
                    if (element - '0' <= 9 && element - '0' >= 1) {
                        state = 1;
                        break;
                    }
                    throw new SyntaxException();
                case 5:
                    if (element <= 'Z' && element >= 'A') {
                        state = 1;
                        break;
                    }
                    if (element - '0' <= 9 && element - '0' >= 1) {
                        state = 1;
                        break;
                    }
                    throw new SyntaxException();
            }
        }
        if (element == ';') {
            return true;
        }
        return false;
    }
}
