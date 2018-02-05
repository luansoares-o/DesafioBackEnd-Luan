/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica.Model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.Size;

/**
 *
 * @author Luan
 */
@Entity
@Table(name="prescricao")
public class Prescricao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pkidprescricao")
    private long pkIdPrescricao;
    @Size(max = 45)
    @Column(name = "nome_medico")
    private String nomeMedico;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "data_prescricao")
    private Date dataPrescricao;
    @OneToMany(mappedBy = "prescricao", targetEntity = DetalhesPrescricao.class,
            fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @OrderColumn
    private List<DetalhesPrescricao> medicamentos;

    @ManyToOne( targetEntity = Paciente.class,
            cascade = {PERSIST, MERGE})
    @JoinColumn(name = "pk_cpf")
    private Paciente paciente;

    public Prescricao() {
    }

    public Prescricao(long pkIdPrescricao, String nomeMedico, Date dataPrescricao, List<DetalhesPrescricao> medicamentos, Paciente paciente) {
        this.pkIdPrescricao = pkIdPrescricao;
        this.nomeMedico = nomeMedico;
        this.dataPrescricao = dataPrescricao;
        this.medicamentos = medicamentos;
        this.paciente = paciente;
    }

    public long getPkIdPrescricao() {
        return pkIdPrescricao;
    }

    public void setPkIdPrescricao(long pkIdPrescricao) {
        this.pkIdPrescricao = pkIdPrescricao;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public Date getDataPrescricao() {
        return dataPrescricao;
    }

    public void setDataPrescricao(Date dataPrescricao) {
        this.dataPrescricao = dataPrescricao;
    }

    public List<DetalhesPrescricao> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<DetalhesPrescricao> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
    

}
