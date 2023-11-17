package br.com.aluguel.entities;

//Importações
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

// Anotações Lombok para geração automática de getters e setters.
@Getter
@Setter

@Entity(name = "reserva")// Anotação indicando que esta classe é uma entidade e nome da tabela no banco de dados.

//Declaração da classe ReservaEntity.
public class ReservaEntity
{

    @Id// Identificador único gerado automaticamente pelo banco de dados.
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //Atributos da entidade Veiculo.
    private Integer idReserva;
    private String nomeCliente;
    private String cpfCliente;
    private String cnhCliente;
    private Integer dataInicio;
    private Integer dataFinal;

    // Chave estrangeira com a entidade VeiculoEntity e sua chave primária no banco de dados.
    @ManyToOne
    @JoinColumn(name = "idVeiculo")
    private  VeiculoEntity veiculo;

}
