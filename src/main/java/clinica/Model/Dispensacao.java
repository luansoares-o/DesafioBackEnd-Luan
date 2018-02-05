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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.Size;

/**
 *
 * @author Luan
 */
@Entity
@Table(name = "dispensacao")
public class Dispensacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pk_id_dispensacao")
    private long pkIdDispensacao;
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "data_dispensacao")
    private Date dataDispensacao;

    //A ideia aqui é ter medicamentos e prescrições sempre associados,
    //impedindo que um medicamento seja ligado a uma pescrição a qual não
    //pertence
    @OneToMany(targetEntity = DetalhesPrescricao.class)
    private List<DetalhesPrescricao> medicamentos;

    public Dispensacao() {
    }

    public Dispensacao(long pkIdDispensacao, Date dataDispensacao, List<DetalhesPrescricao> medicamentos) {
        this.pkIdDispensacao = pkIdDispensacao;
        this.dataDispensacao = dataDispensacao;
        this.medicamentos = medicamentos;
    }

    public long getPkIdDispensacao() {
        return pkIdDispensacao;
    }

    public void setPkIdDispensacao(long pkIdDispensacao) {
        this.pkIdDispensacao = pkIdDispensacao;
    }

    public Date getDataDispensacao() {
        return dataDispensacao;
    }

    public void setDataDispensacao(Date dataDispensacao) {
        this.dataDispensacao = dataDispensacao;
    }

    public List<DetalhesPrescricao> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<DetalhesPrescricao> medicamentos) {
        this.medicamentos = medicamentos;
    }

    
}
