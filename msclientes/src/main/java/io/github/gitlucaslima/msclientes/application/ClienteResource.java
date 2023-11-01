package io.github.gitlucaslima.msclientes.application;

import io.github.gitlucaslima.msclientes.application.representation.ClienteSaveRequest;
import io.github.gitlucaslima.msclientes.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("clientes")
@RequiredArgsConstructor
@Slf4j
public class ClienteResource {


    private final ClienteService service;

    @GetMapping
    public String status() {
        log.info("Obtendo o status do microservice de clientes");
        return "ok";
    }

    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody ClienteSaveRequest clienteSaveRequest){
        var cliente = clienteSaveRequest.toModel();
        service.save(cliente);
        return ResponseEntity.ok(cliente);
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<Optional<Cliente>> dadosCliente(@RequestParam("cpf") String cpf){
        var cliente = service.getByCpf(cpf);

        if (cliente.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(cliente);
    }
}
