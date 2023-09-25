package comparator.renda;

import comparator.PontuacaoRegra;
import entidade.Familia;

public class PontuacaoRendaAte901a1500 implements PontuacaoRegra {
    @Override
    public int calcularPontuacao(Familia familia) {
        if (familia.getRendaFamilia() >= 901 && familia.getRendaFamilia() <= 1500) {
            return 3;
        }
        return 0;
    }
}
