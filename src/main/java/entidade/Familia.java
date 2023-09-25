package entidade;

import comparator.PontuacaoRegra;

import java.util.List;

public class Familia {
    private String nisIdentificador;

    private List<Membro> membros;

    public Familia(String nisIdentificador, List<Membro> membros) {
        this.nisIdentificador = nisIdentificador;
        this.membros = membros;
    }

    public double getRendaFamilia() {
        return membros.stream().mapToDouble(Membro::getRenda).sum();
    }

    public long getNumeroDependentes() {
        return membros.stream().filter(membro -> membro.getIdade()<18).count();
    }


    public String toString() {
        return "Familia: "+nisIdentificador;
    }

    public String getNisIdentificador() {
        return nisIdentificador;
    }

    public int calcularPontuacao(List<PontuacaoRegra> regras) {
        int pontuacaoTotal = 0;
        for (PontuacaoRegra regra : regras) {
            pontuacaoTotal += regra.calcularPontuacao(this);
        }
        return pontuacaoTotal;
    }
}
