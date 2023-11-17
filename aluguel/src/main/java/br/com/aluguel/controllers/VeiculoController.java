package br.com.aluguel.controllers;

//importações
import br.com.aluguel.dtos.VeiculoDto;
import br.com.aluguel.entities.VeiculoEntity;
import br.com.aluguel.services.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/veiculo")

public class VeiculoController
{
    @Autowired
    private VeiculoService veiculoService;

    @Autowired
    private  modelMapper;

    //Buscar todos os veículos.
    @GetMapping("/todos")
    public ResponseEntity<?> consultarVeiculos()
    {
        List<VeiculoEntity> veiculosEntities = veiculoService.consultarVeiculos();

        if (veiculosEntities.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Nenhum veículo registrado no sistema.");
        } else
        {
            List<VeiculoDto> veiculosDto = veiculosEntities.stream()
                    .map(entity -> modelMapper.map(entity, VeiculoDto.class))
                    .collect(Collectors.toList());
            return ResponseEntity.ok(veiculosDto);
        }
    }

    //Buscar veiculos por status.
    @GetMapping("/status")
    public ResponseEntity<?> consultarVeiculosStatus(@PathVariable String status)
    {
        List<VeiculoEntity> veiculosEntities = veiculoService.consultarVeiculosDisponiveis(status);

        if (veiculosEntities.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Nenhum veículo disponivel para reserva");
        }

        else
        {
            List<VeiculoDto> veiculosDto = veiculosEntities.stream()
                    .map(entity -> modelMapper.map(entity, VeiculoDto.class))
                    .collect(Collectors.toList());

            return ResponseEntity.ok(veiculosDto);
        }
    }

    //Cadastrar veiculo.
    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrarVeiculo(@RequestBody VeiculoDto veiculoDto)
    {
        VeiculoEntity veiculoEntity = modelMapper.map(veiculoDto, VeiculoEntity.class);
        veiculoService.cadastrarAlterarVeiculo(veiculoEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body("Veículo cadastrado com sucesso.");
    }

    //Alterar veículo.
    @PutMapping("/alterar")
    public ResponseEntity<String> alterarVeiculo(@PathVariable Integer id, @RequestBody VeiculoDto veiculoDto)
    {
        VeiculoEntity veiculoEntity = modelMapper.map(veiculoDto, VeiculoEntity.class);
        veiculoService.alterarVeiculo(id, veiculoEntity);
        return ResponseEntity.ok("Veículo altualizado com sucesso.");
    }

    //Excluir veículo.
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<String> excluirVeiculo(@PathVariable Integer id)
    {
        veiculoService.excluirVeiculo(id);
        return ResponseEntity.ok("Veículo excluído com sucesso.");
    }

}
