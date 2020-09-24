/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.example.restservice;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Developer
 */
@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    public Message findByLanguage(String language);

}
