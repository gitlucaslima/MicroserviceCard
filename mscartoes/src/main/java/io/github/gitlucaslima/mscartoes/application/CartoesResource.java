package io.github.gitlucaslima.mscartoes.application;

import io.github.gitlucaslima.mscartoes.application.representation.CartaoSaveRequest;
import io.github.gitlucaslima.mscartoes.application.representation.CartoesPorClienteResponse;
import io.github.gitlucaslima.mscartoes.domain.Cartao;
import io.github.gitlucaslima.mscartoes.domain.ClienteCartao;
import io.github.gitlucaslima.mscartoes.infra.repository.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("cartoes")
public class CartoesResource {

    @Autowired
    private CartaoService cartaoService;

    @Autowired
    private CartaoRepository cartaoRepository;

    @Autowired
    private ClienteCartaoService clienteCartaoService;

    @GetMapping
    public String status(){
        return "ok";
    }

    @PostMapping
    public ResponseEntity<Cartao> cadastra(@RequestBody CartaoSaveRequest body){
        Cartao cartao = body.toModel();
        cartaoService.save(cartao);
        return ResponseEntity.ok(cartao);
    }

    @GetMapping(params = "renda")
    public  ResponseEntity<List<Cartao>> geCartoesRendaAte(@RequestParam("renda") Long renda){
        List<Cartao> list = cartaoService.getCartoesRendaMenorIgual(renda);

        return  ResponseEntity.ok(list);
    }

    @GetMapping(params = "cpf")
    public  ResponseEntity<List<CartoesPorClienteResponse>> getCarteosDoCliente(@RequestParam("cpf") String cpf){
        List<ClienteCartao> list = clienteCartaoService.listCartosbyCpf(cpf);
        List<CartoesPorClienteResponse> resultList = list.stream().map(CartoesPorClienteResponse::fromModel).toList();
        return  ResponseEntity.ok(resultList);
    }

    @GetMapping(params = "uuid")
    public  ResponseEntity<Cartao> getbyid(@RequestParam("uuid") UUID uuid){
        return ResponseEntity.of(cartaoRepository.findById(uuid));
    }
}
