/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica.Control;

import clinica.Model.Dispensacao;
import clinica.repository.DispensacaoRepository;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Luan
 */
@RestController
@RequestMapping("/dispensacao")
public class DispensacaoController {
    @Autowired
    private DispensacaoRepository dr;

    @ResponseStatus(HttpStatus.OK) //Por padrão responde com o status code 200 success
    @RequestMapping(value = "/{dispensacaoID}",
            //Mapeia as requisições GET para localhost:8080/dispensacao/
            //recebendo um ID como @PathVariable
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    // Produz JSON como retorno
    public Dispensacao get(@PathVariable(value = "dispensacaoID") long dispensacaoID) {
        return dr.findOne(dispensacaoID);
    }

    @ResponseStatus(HttpStatus.OK)
    //Por padrão responde com o status code 200 success
    @RequestMapping(value = "/findAll",
            //Mapeia as requisições GET para localhost:8080/dispensacao/findAll
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    // Produz JSON como retorno
    public List<Dispensacao> findAll() {
        return dr.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    //Por padrão responde com o status code 200 success
    @RequestMapping(method = RequestMethod.POST,
            //Mapeia as requisições POST para localhost:8080/dispensacao/
            consumes = MediaType.APPLICATION_JSON_VALUE,
            // Consome JSON enviado no corpo da requisição
            produces = MediaType.APPLICATION_JSON_VALUE)
    // Produz JSON como retorno
    public Dispensacao create(@RequestBody @Valid Dispensacao dispensacao) {
        return dr.saveAndFlush(dispensacao);
    }

    @ResponseStatus(HttpStatus.OK)
    //Por padrão responde com o status code 200 success
    @RequestMapping(value = "/{dispensacaoID}",
            method = RequestMethod.DELETE)
    //Mapeia as requisições DELETE para localhost:8080/dispensacao/ 
    //recebendo um ID como @PathVariable
    public void delete(@PathVariable(value = "dispensacaoID") Long dispensacaoID) {
        dr.delete(dispensacaoID);
    }
}
