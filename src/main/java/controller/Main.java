package controller;

import comparator.CalculadoraPontos;
import comparator.PontuacaoRegra;
import comparator.dependentes.Pontuacao1Ou2Dependentes;
import comparator.dependentes.Pontuacao3OuMaisDependentes;
import comparator.renda.PontuacaoRendaAte900;
import comparator.renda.PontuacaoRendaAte901a1500;
import entidade.Familia;
import entidade.Membro;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Membro> membros1 = new ArrayList<>();
        membros1.add(new Membro(LocalDate.of(2010, 1,1), 500));
        membros1.add(new Membro(LocalDate.of(2010, 1,1), 200));
        membros1.add(new Membro(LocalDate.of(2010, 1,1), 0));
        Familia familia1 = new Familia("1", membros1);

        List<Membro> membros2 = new ArrayList<>();
        membros2.add(new Membro(LocalDate.of(2000, 1,1), 1500));
        Familia familia2 = new Familia("2", membros2);

        List<Membro> membros3 = new ArrayList<>();
        membros3.add(new Membro(LocalDate.of(2010, 1,1), 500));
        membros3.add(new Membro(LocalDate.of(2010, 1,1), 200));
        Familia familia3 = new Familia("3", membros3);

        List<Familia> resposta = new CalculadoraPontos().ordenarFamiliasPorPontuacao(List.of(familia1, familia2, familia3));
        System.out.println(resposta);

    }
}