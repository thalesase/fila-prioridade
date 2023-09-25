package comparator.dependentes;

import comparator.PontuacaoRegra;
import entidade.Familia;

public class Pontuacao3OuMaisDependentes implements PontuacaoRegra {
    @Override
    public int calcularPontuacao(Familia familia) {
        if (familia.getNumeroDependentes() >= 3) {
            return 3;
        }
        return 0;
    }
}
