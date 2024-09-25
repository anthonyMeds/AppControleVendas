package br.com.dermocosmeticos.appDermocosmeticos.Model.Service.Impl;

import br.com.dermocosmeticos.appDermocosmeticos.Configuration.Exception.ServiceException;
import br.com.dermocosmeticos.appDermocosmeticos.Configuration.Paginacao.OrdenacaoPaginacaoUtil;
import br.com.dermocosmeticos.appDermocosmeticos.Configuration.Paginacao.Paginacao;
import br.com.dermocosmeticos.appDermocosmeticos.Configuration.result.EntidadeResult;
import br.com.dermocosmeticos.appDermocosmeticos.Configuration.result.Result;
import br.com.dermocosmeticos.appDermocosmeticos.Configuration.result.ResultUtil;
import br.com.dermocosmeticos.appDermocosmeticos.Configuration.result.ResultUtilTransactional;
import br.com.dermocosmeticos.appDermocosmeticos.Dto.EventoDto;
import br.com.dermocosmeticos.appDermocosmeticos.Dto.VendaDto;
import br.com.dermocosmeticos.appDermocosmeticos.Model.Entity.Venda;
import br.com.dermocosmeticos.appDermocosmeticos.Model.Repository.EventoRepository;
import br.com.dermocosmeticos.appDermocosmeticos.Model.Repository.VendaRepository;
import br.com.dermocosmeticos.appDermocosmeticos.Model.Service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class VendaServiceImpl implements VendaService {

    @Autowired
    private ResultUtil<Paginacao<VendaDto.Response.BuscaVenda>> resultUtilBuscarVenda;

    @Autowired
    private ResultUtilTransactional resultUtilTransactional;

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private OrdenacaoPaginacaoUtil ordenacaoPaginacaoUtil;

    @Override
    public ResponseEntity<Result<Paginacao<VendaDto.Response.BuscaVenda>>> buscarVenda(Integer pagina, Integer elementosPorPagina) {
        Page<VendaDto.Response.BuscaVenda> listaVendas = vendaRepository.buscarVendas(
                PageRequest.of(pagina, elementosPorPagina,
                        Sort.by(ordenacaoPaginacaoUtil.ordenarPaginacao("idVenda", "asc"))));

        if (listaVendas.getTotalElements() == 0) {
            return resultUtilBuscarVenda.resultSucesso(HttpStatus.OK, "Não foram encontradas vendas cadastradas.", new Paginacao<>(Page.empty()));
        }

        return resultUtilBuscarVenda.resultSucesso(HttpStatus.OK, new Paginacao<>(listaVendas));
    }

    @Override
    public ResponseEntity<EntidadeResult> cadastrarVenda(VendaDto.Request.Cadastro cadastro) {

        return null;
    }

    @Override
    public ResponseEntity<EntidadeResult> atualizarVenda(VendaDto.Request.Atualizacao atualizacao)  {

        return null;
    }

    @Override
    public ResponseEntity<EntidadeResult> excluirVenda(Long idVenda) {

        return null;
    }
}
