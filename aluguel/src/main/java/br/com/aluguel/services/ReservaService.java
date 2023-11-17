package br.com.aluguel.services;

//Importações
import br.com.aluguel.entities.ReservaEntity;
import br.com.aluguel.repositories.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service//Anotação do serviço

//Declarando a classe ReservaService
public class ReservaService
{
    @Autowired
    private ReservaRepository reservaRepository;

    //Cadastrar/Alterar reserva
    public void cadastrarAlterarReserva(ReservaEntity reserva)
    {
        reservaRepository.save(reserva);
    }

    //Excluir reserva por id
    public void excluirReserva(Integer idReserva)
    {
        reservaRepository.deleteById(idReserva);
    }

    // Consultar todas as reservas
    public List<ReservaEntity> consultarReservas()
    {
        return reservaRepository.findAll();
    }

    // Consultar reserva por nome do cliente
    public List<ReservaEntity> consultarNomeCliente(String nomeCliente)
    {
        return reservaRepository.findByNomeCliente(nomeCliente);
    }

    // Consultar reserva por CPF do cliente
    public List<ReservaEntity> consultarCpfCliente(String cpfCliente)
    {
        return reservaRepository.findByCpfCliente(cpfCliente);
    }

    // Consultar reserva por id do veículo
    public List<ReservaEntity> consultarIdVeiculo(Integer idVeiculo)
    {
        return reservaRepository.findByIdVeiculo(idVeiculo);
    }

    // Consultar reserva por id
    public Optional<ReservaEntity> consultarId(Integer idReserva)
    {
        return reservaRepository.findById(idReserva);
    }
}