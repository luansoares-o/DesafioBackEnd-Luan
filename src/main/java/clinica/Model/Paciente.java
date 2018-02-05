/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica.Model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Luan
 */
@Entity
@Table(name = "paciente")
public class Paciente implements Serializable{
    //private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "pk_cpf")
    private long pkCpf;
    @Size(max = 45)
    @Column(name = "nome_aciente")
    private String nomePaciente;
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "data_nascimento")
    private Date nascimento;

    public Paciente() {
    }

    public Paciente(long pkCpf, String nomePaciente, Date nascimento) {
        this.pkCpf = pkCpf;
        this.nomePaciente = nomePaciente;
        this.nascimento = nascimento;
    }

    
    
    public long getPkCpf() {
        return pkCpf;
    }

    public void setPkCpf(long pkCpf) {
        this.pkCpf = pkCpf;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    

    
    @Override
    public String toString() {
        return "Model.Paciente[ pkCpf=" + pkCpf + " ]";
    }

}
