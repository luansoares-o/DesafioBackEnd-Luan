/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica.Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Luan
 */
@Entity
@Table(name = "medicamento")
public class Medicamento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_id_medicamento")
    private long pkIdMedicamento;
    @Size(max = 45)
    @Column(name = "nome_medicamento")
    private String nomeMedicamento;

    public Medicamento(){
        
    }
    
    public Medicamento(long pkIdMedicamento, String nomeMedicamento) {
        this.pkIdMedicamento = pkIdMedicamento;
        this.nomeMedicamento = nomeMedicamento;
    }

    public long getPkIdMedicamento() {
        return pkIdMedicamento;
    }

    public void setPkIdMedicamento(long pkIdMedicamento) {
        this.pkIdMedicamento = pkIdMedicamento;
    }

    public String getNomeMedicamento() {
        return nomeMedicamento;
    }

    public void setNomeMedicamento(String nomeMedicamento) {
        this.nomeMedicamento = nomeMedicamento;
    }
    
    
}
