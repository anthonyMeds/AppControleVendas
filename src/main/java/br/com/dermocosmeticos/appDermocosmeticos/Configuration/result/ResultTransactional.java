package br.com.dermocosmeticos.appDermocosmeticos.Configuration.result;


import java.util.HashMap;

public class ResultTransactional {
    private int cdRetorno;
    private String msgTecnica = "";
    private String msgUsuario = "";
    private Object dados = new HashMap();

    public int getCdRetorno() {
        return this.cdRetorno;
    }

    public String getMsgTecnica() {
        return this.msgTecnica;
    }

    public String getMsgUsuario() {
        return this.msgUsuario;
    }

    public Object getDados() {
        return this.dados;
    }

    public void setCdRetorno(final int cdRetorno) {
        this.cdRetorno = cdRetorno;
    }

    public void setMsgTecnica(final String msgTecnica) {
        this.msgTecnica = msgTecnica;
    }

    public void setMsgUsuario(final String msgUsuario) {
        this.msgUsuario = msgUsuario;
    }

    public void setDados(final Object dados) {
        this.dados = dados;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ResultTransactional)) {
            return false;
        } else {
            ResultTransactional other = (ResultTransactional)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getCdRetorno() != other.getCdRetorno()) {
                return false;
            } else {
                label49: {
                    Object this$msgTecnica = this.getMsgTecnica();
                    Object other$msgTecnica = other.getMsgTecnica();
                    if (this$msgTecnica == null) {
                        if (other$msgTecnica == null) {
                            break label49;
                        }
                    } else if (this$msgTecnica.equals(other$msgTecnica)) {
                        break label49;
                    }

                    return false;
                }

                Object this$msgUsuario = this.getMsgUsuario();
                Object other$msgUsuario = other.getMsgUsuario();
                if (this$msgUsuario == null) {
                    if (other$msgUsuario != null) {
                        return false;
                    }
                } else if (!this$msgUsuario.equals(other$msgUsuario)) {
                    return false;
                }

                Object this$dados = this.getDados();
                Object other$dados = other.getDados();
                if (this$dados == null) {
                    if (other$dados != null) {
                        return false;
                    }
                } else if (!this$dados.equals(other$dados)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ResultTransactional;
    }

    public int hashCode() {
        boolean PRIME = true;
        int result = 1;
        result = result * 59 + this.getCdRetorno();
        Object $msgTecnica = this.getMsgTecnica();
        result = result * 59 + ($msgTecnica == null ? 43 : $msgTecnica.hashCode());
        Object $msgUsuario = this.getMsgUsuario();
        result = result * 59 + ($msgUsuario == null ? 43 : $msgUsuario.hashCode());
        Object $dados = this.getDados();
        result = result * 59 + ($dados == null ? 43 : $dados.hashCode());
        return result;
    }

    public String toString() {
        return "ResultTransactional(cdRetorno=" + this.getCdRetorno() + ", msgTecnica=" + this.getMsgTecnica() + ", msgUsuario=" + this.getMsgUsuario() + ", dados=" + this.getDados() + ")";
    }

    public ResultTransactional() {
    }

    public ResultTransactional(final int cdRetorno, final String msgTecnica, final String msgUsuario, final Object dados) {
        this.cdRetorno = cdRetorno;
        this.msgTecnica = msgTecnica;
        this.msgUsuario = msgUsuario;
        this.dados = dados;
    }
}
