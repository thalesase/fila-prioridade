package entidade;

import java.time.LocalDate;
import java.time.Period;

public class Membro {
    private LocalDate dataNascimento;
    private double renda;

    public Membro(LocalDate dataNascimento, double renda) {
        this.dataNascimento = dataNascimento;
        this.renda = renda;
    }

    public int getIdade() {
        return Period.between(LocalDate.now(), dataNascimento).getYears();
    }

    public double getRenda(){
        return renda;
    }


}
