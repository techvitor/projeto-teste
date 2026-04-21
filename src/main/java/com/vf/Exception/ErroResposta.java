package com.vf.Exception;

public class ErroResposta {

    private String mensagem;

    private int status;

    private long timestamp;

    public ErroResposta(String mensagem, int status){
        this.mensagem = mensagem;
        this.status = status;
        this.timestamp = System.currentTimeMillis();
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
