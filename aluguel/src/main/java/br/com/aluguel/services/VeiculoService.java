package br.com.aluguel.services;

//Importações
import br.com.aluguel.entities.VeiculoEntity;
import br.com.aluguel.repositories.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service //Anotação do serviço

//Declarando a classe VeiculoService
public class VeiculoService
{
    @Autowired
    private VeiculoRepository veiculoRepository;

    // Cadastrar/Alterar veículo
    public void cadastrarAlterarVeiculo(VeiculoEntity veiculo)
    {
        veiculoRepository.save(veiculo);
    }

    // Excluir veículo por id
    public void excluirVeiculo(Integer idVeiculo)
    {
        veiculoRepository.deleteById(idVeiculo);
    }

    // Consultar todos os veículos
    public List<VeiculoEntity> consultarVeiculos()
    {
        return veiculoRepository.findAll();
    }

    // Consultar veículos por status
    public List<VeiculoEntity> consultarVeiculosDisponiveis()
    {
        return veiculoRepository.findByStatusVeiculo("Disponivel");
    }
}
