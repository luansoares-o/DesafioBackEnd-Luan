/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica.Control;

import clinica.Model.Medicamento;
import clinica.repository.MedicamentoRepository;
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
@RequestMapping("/medicamento")
public class MedicamentoController {

    @Autowired
    private MedicamentoRepository mr;

    @ResponseStatus(HttpStatus.OK) //Por padrão responde com o status code 200 success
    @RequestMapping(value = "/{medicamentoID}",
            //Mapeia as requisições GET para localhost:8080/medicamento/
            //recebendo um ID como @PathVariable
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    // Produz JSON como retorno
    public Medicamento get(@PathVariable(value = "medicamentoID") long medicamentoID) {
        return mr.findOne(medicamentoID);
    }

    @ResponseStatus(HttpStatus.OK)
    //Por padrão responde com o status code 200 success
    @RequestMapping(value = "/findAll",
            //Mapeia as requisições GET para localhost:8080/medicamento/findAll
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    // Produz JSON como retorno
    public List<Medicamento> findAll() {
        return mr.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    //Por padrão responde com o status code 200 success
    @RequestMapping(method = RequestMethod.POST,
            //Mapeia as requisições POST para localhost:8080/medicamento/
            consumes = MediaType.APPLICATION_JSON_VALUE,
            // Consome JSON enviado no corpo da requisição
            produces = MediaType.APPLICATION_JSON_VALUE)
    // Produz JSON como retorno
    public Medicamento create(@RequestBody @Valid Medicamento medicamento) {
        return mr.save(medicamento);
    }

    @ResponseStatus(HttpStatus.OK)
    //Por padrão responde com o status code 200 success
    @RequestMapping(value = "/{medicamentoID}",
            method = RequestMethod.DELETE)
    //Mapeia as requisições DELETE para localhost:8080/medicamento/ 
    //recebendo um ID como @PathVariable
    public void delete(@PathVariable(value = "medicamentoID") Long medicamentoID) {
        mr.delete(medicamentoID);
    }
}
