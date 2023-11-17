package br.com.aluguel.repositories;

//Importações
import br.com.aluguel.entities.ReservaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository////Anotação do repositório

//Declaração da interface que estende o JpaRepository.
public interface ReservaRepository extends JpaRepository<ReservaEntity, Integer>
{

    // Consulta pelo nome do cliente.
    List<ReservaEntity> findByNomeCliente(String nomeCliente);

    // Consulta pelo CPF do cliente.
    List<ReservaEntity> findByCpfCliente(String cpfCliente);

    // Consulta pelo Id do veículo.
    List<ReservaEntity> findByIdVeiculo(Integer idVeiculo);
}