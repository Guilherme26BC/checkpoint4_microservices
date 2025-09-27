package br.com.fiap.checkpoint1.model;

public enum ConsultaStatus {
    AGENDADA("Essa consulta está MARCADA"),
    CANCELADA("Essa consulta foi CANCELADA"),
    REALIZADA("Essa consulta está FINALIZADA");


    ConsultaStatus(String mensagem) {
        this.mensagem = mensagem;
    }
    private String mensagem;

    public String getMensagem() {
        return mensagem;
    }
}
