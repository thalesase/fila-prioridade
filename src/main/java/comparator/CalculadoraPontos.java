package comparator;

import comparator.dependentes.Pontuacao1Ou2Dependentes;
import comparator.dependentes.Pontuacao3OuMaisDependentes;
import comparator.renda.PontuacaoRendaAte900;
import comparator.renda.PontuacaoRendaAte901a1500;
import entidade.Familia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CalculadoraPontos {
    List<PontuacaoRegra> regras = List.of(
            new PontuacaoRendaAte900(),
            new PontuacaoRendaAte901a1500(),
            new Pontuacao1Ou2Dependentes(),
            new Pontuacao3OuMaisDependentes()
    );


    public List<Familia> ordenarFamiliasPorPontuacao(List<Familia> familias) {
        List<Familia> familiasOrdenadas = new ArrayList<>(familias);
        familiasOrdenadas.sort(Comparator.comparingInt(familia -> familia.calcularPontuacao(regras)));
        Collections.reverse(familiasOrdenadas);

        return familiasOrdenadas;
    }
}
