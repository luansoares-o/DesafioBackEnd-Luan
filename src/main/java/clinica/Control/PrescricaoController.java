/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica.Control;

import clinica.Model.Prescricao;
import clinica.repository.PrescricaoRepository;
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
@RequestMapping("/prescricao")
public class PrescricaoController {

    @Autowired
    private PrescricaoRepository pr;

    @ResponseStatus(HttpStatus.OK) //Por padrão responde com o status code 200 success
    @RequestMapping(value = "/{prescricaoID}",
            //Mapeia as requisições GET para localhost:8080/prescricao/
            //recebendo um ID como @PathVariable
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    // Produz JSON como retorno
    public Prescricao get(@PathVariable(value = "prescricaoID") long prescricaoID) {
        return pr.findOne(prescricaoID);
    }

    @ResponseStatus(HttpStatus.OK)
    //Por padrão responde com o status code 200 success
    @RequestMapping(value = "/findAll",
            //Mapeia as requisições GET para localhost:8080/prescricao/findAll
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    // Produz JSON como retorno
    public List<Prescricao> findAll() {
        /*for (Prescricao p : pr.findAll()) {
            System.out.println(p.getMedicamentos().get(0).getMedicamento().getNomeMedicamento());
        }*/
        return pr.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    //Por padrão responde com o status code 200 success
    @RequestMapping(method = RequestMethod.POST,
            //Mapeia as requisições POST para localhost:8080/prescricao/
            consumes = MediaType.APPLICATION_JSON_VALUE,
            // Consome JSON enviado no corpo da requisição
            produces = MediaType.APPLICATION_JSON_VALUE)
    // Produz JSON como retorno
    public Prescricao create(@RequestBody @Valid Prescricao prescricao) {
        return pr.saveAndFlush(prescricao);
    }

    @ResponseStatus(HttpStatus.OK)
    //Por padrão responde com o status code 200 success
    @RequestMapping(value = "/{prescricaoID}",
            method = RequestMethod.DELETE)
    //Mapeia as requisições DELETE para localhost:8080/prescricao/ 
    //recebendo um ID como @PathVariable
    public void delete(@PathVariable(value = "prescricaoID") Long prescricaoID) {
        pr.delete(prescricaoID);
    }

}
