/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica.Control;

import clinica.Model.Paciente;
import clinica.repository.PacienteRepository;
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
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteRepository pr;

    @ResponseStatus(HttpStatus.OK) //Por padrão responde com o status code 200 success
    @RequestMapping(value = "/{pacienteCPF}",
            //Mapeia as requisições GET para localhost:8080/paciente/
            //recebendo um CPF como @PathVariable
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    // Produz JSON como retorno
    public Paciente get(@PathVariable(value = "pacienteCPF") long pacienteCPF) {
        return pr.findOne(pacienteCPF);
    }

    @ResponseStatus(HttpStatus.OK)
    //Por padrão responde com o status code 200 success
    @RequestMapping(value = "/findAll",
            //Mapeia as requisições GET para localhost:8080/paciente/findAll
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    // Produz JSON como retorno
    public List<Paciente> findAll() {
        return pr.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    //Por padrão responde com o status code 200 success
    @RequestMapping(method = RequestMethod.POST,
            //Mapeia as requisições POST para localhost:8080/paciente/
            consumes = MediaType.APPLICATION_JSON_VALUE,
            // Consome JSON enviado no corpo da requisição
            produces = MediaType.APPLICATION_JSON_VALUE)
    // Produz JSON como retorno
    public Paciente create(@RequestBody @Valid Paciente paciente) {
        return pr.save(paciente);
    }

    @ResponseStatus(HttpStatus.OK)
    //Por padrão responde com o status code 200 success
    @RequestMapping(value = "/{pacienteCPF}",
            method = RequestMethod.DELETE)
    //Mapeia as requisições DELETE para localhost:8080/paciente/ 
    //recebendo um CPF como @PathVariable
    public void delete(@PathVariable(value = "pacienteCPF") Long pacienteCPF) {
        pr.delete(pacienteCPF);
    }

}
