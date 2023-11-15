package br.com.dermocosmeticos.appDermocosmeticos.Configuration.result;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResultUtilTransactional {
    private final String MSG_USUARIO = "Operação realizada com sucesso";

    public ResultUtilTransactional() {
    }

    public ResponseEntity<EntidadeResult> resultSucesso(HttpStatus httpStatus) {
        return this.resultSucesso(httpStatus, "Operação realizada com sucesso", (Object) null);
    }

    public ResponseEntity<EntidadeResult> resultSucesso(HttpStatus httpStatus, Object dados) {
        return this.resultSucesso(httpStatus, "Operação realizada com sucesso", dados);
    }

    public ResponseEntity<EntidadeResult> resultSucesso(HttpStatus httpStatus, String msgUsuario, Object dados) {
        return ResponseEntity.status(httpStatus).body(this.entidadeResult(httpStatus.value(), (String) null, msgUsuario, dados));
    }

    public ResponseEntity<EntidadeResult> resultErro(HttpStatus httpStatus, String msgTecnica, String msgUsuario) {
        return ResponseEntity.status(httpStatus).body(this.entidadeResult(httpStatus.value(), msgTecnica, msgUsuario, (Object) null));
    }

    private EntidadeResult entidadeResult(int cdRetorno, String msgTecnica, String msgUsuario, Object dados) {
        ResultTransactional result = new ResultTransactional();
        result.setCdRetorno(cdRetorno);
        if (msgUsuario != null) {
            result.setMsgUsuario(msgUsuario);
        }

        if (msgTecnica != null) {
            result.setMsgTecnica(msgTecnica);
        }

        return new EntidadeResult(result);
    }
}
