package br.com.aluguel.dtos;

//Importações
import lombok.Getter;
import lombok.Setter;

// Anotações Lombok para geração automática de getters e setters.
@Getter
@Setter

//Declaração da classe VeiculoDto
public class VeiculoDto
{
    //Atributos
    private Integer idVeiculo;
    private String modelo;
    private String marca;
    private String cor;
    private Integer anoFabricacao;
    private String placa;
    private String statusVeiculo;
}
