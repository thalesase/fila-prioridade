package comparator.renda;

import comparator.PontuacaoRegra;
import entidade.Familia;

public class PontuacaoRendaAte900 implements PontuacaoRegra {
    @Override
    public int calcularPontuacao(Familia familia) {
        if (familia.getRendaFamilia() <= 900) {
            return 5;
        }
        return 0;
    }
}
