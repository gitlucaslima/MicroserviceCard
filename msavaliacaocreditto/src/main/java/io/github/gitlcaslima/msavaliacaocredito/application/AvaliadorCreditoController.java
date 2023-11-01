package io.github.gitlcaslima.msavaliacaocredito.application;

import io.github.gitlcaslima.msavaliacaocredito.domain.model.SituacaoCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("avaliacoes-credito")
public class AvaliadorCreditoController {

    @Autowired
    private AvaliadorCreditoService avaliadorCreditoService;

    @GetMapping
    public String hello(){
        return "Ola";
    }

    @GetMapping(value = "situacao-cliente", params = "cpf")
    public ResponseEntity<SituacaoCliente>  consultaSituacaoCliente(@RequestParam("cpf") String cpf){

        SituacaoCliente situacaoCliente = avaliadorCreditoService.obterSituacaoCliente(cpf);

        return ResponseEntity.ok(situacaoCliente);
    }

}
