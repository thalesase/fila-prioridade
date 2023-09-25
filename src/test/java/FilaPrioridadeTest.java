import comparator.CalculadoraPontos;
import comparator.PontuacaoRegra;
import comparator.dependentes.Pontuacao1Ou2Dependentes;
import comparator.dependentes.Pontuacao3OuMaisDependentes;
import comparator.renda.PontuacaoRendaAte900;
import comparator.renda.PontuacaoRendaAte901a1500;
import entidade.Familia;
import entidade.Membro;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilaPrioridadeTest {

    @Test
    void TestRegraAte900(){
        List<Membro> membros = new ArrayList<>();
        membros.add(new Membro(LocalDate.of(2000, 1,1), 500));
        membros.add(new Membro(LocalDate.of(2000, 1,1), 200));
        Familia familia = new Familia("1", membros);


        PontuacaoRegra regra = new PontuacaoRendaAte900();
        assertEquals(5, regra.calcularPontuacao(familia));
    }

    @Test
    void TestRegraAte901a1500(){
        List<Membro> membros = new ArrayList<>();
        membros.add(new Membro(LocalDate.of(2000, 1,1), 500));
        membros.add(new Membro(LocalDate.of(2000, 1,1), 500));
        Familia familia = new Familia("1", membros);


        PontuacaoRegra regra = new PontuacaoRendaAte901a1500();
        assertEquals(3, regra.calcularPontuacao(familia));
    }

    @Test
    void TestRegra1ou2Dependentes(){
        List<Membro> membros = new ArrayList<>();
        membros.add(new Membro(LocalDate.of(2010, 1,1), 500));
        membros.add(new Membro(LocalDate.of(2010, 1,1), 500));
        Familia familia = new Familia("1", membros);


        PontuacaoRegra regra = new Pontuacao1Ou2Dependentes();
        assertEquals(2, regra.calcularPontuacao(familia));
    }

    @Test
    void TestRegra3ouMaisDependentes(){
        List<Membro> membros = new ArrayList<>();
        membros.add(new Membro(LocalDate.of(2010, 1,1), 500));
        membros.add(new Membro(LocalDate.of(2010, 1,1), 500));
        membros.add(new Membro(LocalDate.of(2010, 1,1), 500));
        Familia familia = new Familia("1", membros);


        PontuacaoRegra regra = new Pontuacao3OuMaisDependentes();
        assertEquals(3, regra.calcularPontuacao(familia));
    }

    @Test
    void TestRegrasCombinadas(){
        List<Membro> membros = new ArrayList<>();
        membros.add(new Membro(LocalDate.of(2010, 1,1), 500));
        membros.add(new Membro(LocalDate.of(2010, 1,1), 200));
        membros.add(new Membro(LocalDate.of(2010, 1,1), 0));
        Familia familia = new Familia("1", membros);


        List<PontuacaoRegra> regras = List.of(
                new PontuacaoRendaAte900(),
                new PontuacaoRendaAte901a1500(),
                new Pontuacao1Ou2Dependentes(),
                new Pontuacao3OuMaisDependentes()
        );

        assertEquals(8, familia.calcularPontuacao(regras));
    }

    @Test
    void TestOrdenacaoFamilia(){
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
        Familia familia3 = new Familia("3", membros2);




        List<PontuacaoRegra> regras = List.of(
                new PontuacaoRendaAte900(),
                new PontuacaoRendaAte901a1500(),
                new Pontuacao1Ou2Dependentes(),
                new Pontuacao3OuMaisDependentes()
        );

        List<Familia> resposta = new CalculadoraPontos().ordenarFamiliasPorPontuacao(List.of(familia1, familia2, familia3));
        assertEquals("1", resposta.get(0).getNisIdentificador());
        assertEquals("3", resposta.get(1).getNisIdentificador());
        assertEquals("2", resposta.get(2).getNisIdentificador());

    }

}
