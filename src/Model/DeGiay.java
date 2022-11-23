/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.UUID;

/**
 *
 * @author Phan Loc
 */
public class DeGiay {
    private UUID id;
    private String Made;
    private String chatLieu;
    private int doCao;

    public DeGiay() {
    }

    public DeGiay(UUID id, String Made, String chatLieu, int doCao) {
        this.id = id;
        this.Made = Made;
        this.chatLieu = chatLieu;
        this.doCao = doCao;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMade() {
        return Made;
    }

    public void setMade(String Made) {
        this.Made = Made;
    }

    public String getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(String chatLieu) {
        this.chatLieu = chatLieu;
    }

    public int getDoCao() {
        return doCao;
    }

    public void setDoCao(int doCao) {
        this.doCao = doCao;
    }
}
