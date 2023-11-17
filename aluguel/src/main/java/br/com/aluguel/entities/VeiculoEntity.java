package br.com.aluguel.entities;

//Importações
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

// Anotações Lombok para geração automática de getters e setters.
@Getter
@Setter

@Entity(name = "veiculo") // Anotação indicando que esta classe é uma entidade e nome da tabela no banco de dados.


//Declaração da classe VeiculoEntity.
public class VeiculoEntity
{
    @Id// Identificador único gerado automaticamente pelo banco de dados.
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //Atributos da entidade Veiculo e seu respectivo nome no banco de dados.
    @Column(name = "idVeiculo")
    private Integer idVeiculo;
    @Column(name = "modelo")
    private String modelo;
    @Column(name = "marca")
    private String marca;
    @Column(name = "cor")
    private String cor;
    @Column(name = "anoFabricacao")
    private Integer anoFabricacao;
    @Column(name = "placa")
    private String placa;
    @Column(name = "statusVeiculo")
    private String statusVeiculo;
}
