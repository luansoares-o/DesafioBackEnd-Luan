/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Luan
 */
@Entity
@Table(name = "detalhes_prescricao")
public class DetalhesPrescricao implements Serializable {

    @Id
    @ManyToOne(targetEntity = Prescricao.class,
            cascade = {PERSIST, MERGE})
    @JoinColumn(name = "pk_id_prescricao")
    private Prescricao prescricao;
    
    @Id
    @ManyToOne( targetEntity = Medicamento.class)
    @JoinColumn(name = "pk_id_medicamento")
    private Medicamento medicamento;
    
    //Detalhes sobre como usar o medicamento
    private String descricao;

    public DetalhesPrescricao() {
    }

    public DetalhesPrescricao(Prescricao prescricao, Medicamento medicamento, String descricao) {
        this.prescricao = prescricao;
        this.medicamento = medicamento;
        this.descricao = descricao;
    }
    
    @JsonIgnore
    public Prescricao getPrescricao() {
        return prescricao;
    }

    public void setPrescricao(Prescricao prescricao) {
        this.prescricao = prescricao;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
 
    

}
