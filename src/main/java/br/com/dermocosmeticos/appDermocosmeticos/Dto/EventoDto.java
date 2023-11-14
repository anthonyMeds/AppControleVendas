package br.com.dermocosmeticos.appDermocosmeticos.Dto;


public enum EventoDto {;

    protected interface IdEvento {
        Long getIdEvento();
    }
    protected interface NomeEvento {
        String getNomeEvento();
    }

    protected interface DataDoEvento {
        String getDataDoEvento();
    }

    public enum Request {;

    }

    public enum Response {;

        public interface BuscaEvento {
            Long getIdEvento();
            String getNomeEvento();
            String getDataDoEvento();
        }
    }
}
