package comparator.dependentes;

import comparator.PontuacaoRegra;
import entidade.Familia;

public class Pontuacao1Ou2Dependentes implements PontuacaoRegra {
    @Override
    public int calcularPontuacao(Familia familia) {
        if (familia.getNumeroDependentes() == 1 || familia.getNumeroDependentes()==2) {
            return 2;
        }
        return 0;
    }
}
