/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinica.repository;

import clinica.Model.Prescricao;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Luan
 */
public interface PrescricaoRepository extends JpaRepository<Prescricao, Long>{
    
}
