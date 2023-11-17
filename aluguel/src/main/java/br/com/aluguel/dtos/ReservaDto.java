package br.com.aluguel.dtos;

//Importações
import br.com.aluguel.entities.VeiculoEntity;
import lombok.Getter;
import lombok.Setter;

// Anotações Lombok para geração automática de getters e setters.
@Getter
@Setter

//Declaração da classe ReservaDto
public class ReservaDto
{

    //Atributos
    private Integer idReserva;
    private String nomeCliente;
    private String cpfCliente;
    private String cnhCliente;
    private Integer dataInicio;
    private Integer dataFinal;
    private VeiculoDto veiculo;
}
