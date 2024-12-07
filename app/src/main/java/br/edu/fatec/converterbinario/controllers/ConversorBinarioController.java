package br.edu.fatec.converterbinario.controllers;

public class ConversorBinarioController {
    private final StringBuilder sb;

    public ConversorBinarioController() {
        sb = new StringBuilder();
    }

    public String converter(int num) {
        if (num == 0) {
            return sb.toString();
        }

        int resto = num % 2;
        num = num/2;
        sb.insert(0, resto);

        return converter(num);
    }
}
