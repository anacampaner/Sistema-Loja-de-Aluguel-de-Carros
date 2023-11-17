package br.com.aluguel.controllers;

//Importações
import br.com.aluguel.entities.ReservaEntity;
import br.com.aluguel.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reserva")
public class ReservaController
{
    @Autowired
    private ReservaService reservaService;

    // Cadastrar ou alterar uma reserva
    @PostMapping("/cadastrar-alterar")
    public ResponseEntity<String> cadastrarAlterarReserva(@RequestBody ReservaEntity reserva)
    {
        reservaService.cadastrarAlterarReserva(reserva);
        return ResponseEntity.status(HttpStatus.CREATED).body("Reserva cadastrada ou atualizada com sucesso.");
    }

    // Excluir uma reserva pelo id
    @DeleteMapping("/excluir")
    public ResponseEntity<String> excluirReserva(@PathVariable Integer idReserva)
    {
        reservaService.excluirReserva(idReserva);
        return ResponseEntity.ok("Reserva excluída com sucesso.");
    }

    // Consultar todas as reservas
    @GetMapping("/todas")
    public ResponseEntity<List<ReservaEntity>> consultarTodasReservas()
    {
        List<ReservaEntity> reservas = reservaService.consultarReservas();
        return ResponseEntity.ok(reservas);
    }

    // Consultar reservas pelo nome do cliente
    @GetMapping("/consultar-nome-cliente")
    public ResponseEntity<List<ReservaEntity>> consultarNomeCliente(@PathVariable String nomeCliente)
    {
        List<ReservaEntity> reservas = reservaService.consultarNomeCliente(nomeCliente);
        return ResponseEntity.ok(reservas);
    }

    // Consultar reservas pelo CPF do cliente
    @GetMapping("/consultar-cpf")
    public ResponseEntity<List<ReservaEntity>> consultarCpfCliente(@PathVariable String cpfCliente)
    {
        List<ReservaEntity> reservas = reservaService.consultarCpfCliente(cpfCliente);
        return ResponseEntity.ok(reservas);
    }

    // Consultar reservas por id do veículo
    @GetMapping("/consultar-id-veiculo}")
    public ResponseEntity<List<ReservaEntity>> consultarIdVeiculo(@PathVariable Integer idVeiculo)
    {
        List<ReservaEntity> reservas = reservaService.consultarIdVeiculo(idVeiculo);
        return ResponseEntity.ok(reservas);
    }

    // Consultar reserva por id
    @GetMapping("/consultar-id")
    public ResponseEntity<ReservaEntity> consultarPorId(@PathVariable Integer idReserva)
    {
        Optional<ReservaEntity> reserva = reservaService.consultarId(idReserva);
        return reserva.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
