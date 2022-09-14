package br.com.desafio.serasaexperian.controller;

import br.com.desafio.serasaexperian.configuration.SwaggerConfiguration;
import br.com.desafio.serasaexperian.domain.dto.pessoa.PessoaDTO;
import br.com.desafio.serasaexperian.domain.dto.pessoa.PessoaGetAllDTO;
import br.com.desafio.serasaexperian.domain.dto.pessoa.PessoaGetByIdDTO;
import br.com.desafio.serasaexperian.service.PessoaService;
import br.com.desafio.serasaexperian.util.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/pessoa")
@Api(tags = {SwaggerConfiguration.PERSON_TAG})
public class PessoaController {

    private final PessoaService pessoaService;

    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(code = Constants.STATUS_CODE_CREATED, message = Constants.API_RESPONSE_CREATED),
            @ApiResponse(code = Constants.STATUS_CODE_UNPROCESSABLE_ENTITY, message = Constants.API_RESPONSE_UNPROCESSABLE_ENTITY),
            @ApiResponse(code = Constants.STATUS_CODE_UNAUTHORIZED, message = Constants.API_RESPONSE_UNAUTHORIZED),
            @ApiResponse(code = Constants.STATUS_CODE_INTERNAL_ERROR_SERVER, message = Constants.API_RESPONSE_INTERNAL_ERROR_SERVER)
    })
    @ApiOperation(value = "Cadastra uma nova pessoa")
    public ResponseEntity<PessoaDTO> create(@Valid @RequestBody PessoaDTO pessoaDTO) {
        log.info(Constants.LOG_KEY_MESSAGE + Constants.LOG_KEY_METHOD + Constants.LOG_KEY_ENTITY, Constants.LOG_MSG_START_CREATE_PERSON, Constants.LOG_METHOD_CREATE, pessoaDTO);

        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                .buildAndExpand(pessoaDTO).toUri()).body(pessoaService.create(pessoaDTO));

    }

    @GetMapping
    @ApiOperation("Lista todas as pessoas")
    @ApiResponses(value = {
            @ApiResponse(code = Constants.STATUS_CODE_OK, message = Constants.API_RESPONSE_OK),
            @ApiResponse(code = Constants.STATUS_CODE_UNPROCESSABLE_ENTITY, message = Constants.API_RESPONSE_UNPROCESSABLE_ENTITY),
            @ApiResponse(code = Constants.STATUS_CODE_UNAUTHORIZED, message = Constants.API_RESPONSE_UNAUTHORIZED),
            @ApiResponse(code = Constants.STATUS_CODE_INTERNAL_ERROR_SERVER, message = Constants.API_RESPONSE_INTERNAL_ERROR_SERVER)
    })
    public ResponseEntity<List<PessoaGetAllDTO>> findAll() {
        log.info(Constants.LOG_KEY_MESSAGE + Constants.LOG_KEY_METHOD, Constants.LOG_MSG_START_CREATE_PERSON, Constants.LOG_METHOD_FIND_ALL);

        return ResponseEntity.ok().body(pessoaService.findAll());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Lista uma pessoa por id")
    @ApiResponses(value = {
            @ApiResponse(code = Constants.STATUS_CODE_OK, message = Constants.API_RESPONSE_OK),
            @ApiResponse(code = Constants.STATUS_CODE_NO_CONTENT, message = Constants.API_RESPONSE_NO_CONTENT),
            @ApiResponse(code = Constants.STATUS_CODE_UNPROCESSABLE_ENTITY, message = Constants.API_RESPONSE_UNPROCESSABLE_ENTITY),
            @ApiResponse(code = Constants.STATUS_CODE_UNAUTHORIZED, message = Constants.API_RESPONSE_UNAUTHORIZED),
            @ApiResponse(code = Constants.STATUS_CODE_INTERNAL_ERROR_SERVER, message = Constants.API_RESPONSE_INTERNAL_ERROR_SERVER)
    })
    public ResponseEntity<PessoaGetByIdDTO> findById(@PathVariable Long id) {
        log.info(Constants.LOG_KEY_MESSAGE + Constants.LOG_KEY_METHOD, Constants.LOG_MSG_FIND_BY_ID_PERSON + id,  Constants.LOG_METHOD_FIND_BY_ID);

        return ResponseEntity.ok().body(pessoaService.findById(id));
    }
}
