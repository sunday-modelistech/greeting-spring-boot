/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.example.restservice;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import net.bytebuddy.implementation.bind.annotation.Empty;

/**
 *
 * @author Developer
 */
@Entity
@Table(schema = "greeting", name = "message")
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_message", updatable = false, nullable = false)
    private Long idMessage;
    
    @Size(max = 2)
    @Column(name = "language")
    private String language;
    
    @Size(max = 200)
    @Column(name = "message")
    private String message;

    public Message() {

    }

    public Message(Long idMessage, String language, String message) {
        this.idMessage = idMessage;
        this.language = language;
        this.message = message;
    }

    public Long getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Long idMessage) {
        this.idMessage = idMessage;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
