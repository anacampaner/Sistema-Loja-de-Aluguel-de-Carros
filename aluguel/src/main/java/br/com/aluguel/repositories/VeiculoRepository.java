package br.com.aluguel.repositories;

//Importações
import br.com.aluguel.entities.VeiculoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository//Anotação do repositório

//Declaração da interface que estende o JpaRepository.
public interface VeiculoRepository extends JpaRepository<VeiculoEntity, Integer>
{
    //Consulta de acordo com o status.
    List<VeiculoEntity> findByStatusVeiculo(String statusVeiculo);

    //Consulta geral dos veículos.
    List<VeiculoEntity> findAll();

}
