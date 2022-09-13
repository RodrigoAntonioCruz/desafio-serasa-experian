package br.com.desafio.serasaexperian.controller;

import br.com.desafio.serasaexperian.configuration.SwaggerConfiguration;
import br.com.desafio.serasaexperian.domain.dto.afinidade.AfinidadeDTO;
import br.com.desafio.serasaexperian.service.AfinidadeService;
import br.com.desafio.serasaexperian.util.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/afinidade")
@Api(tags = {SwaggerConfiguration.AFFINITY_TAG})
public class AfinidadeController {

    private final AfinidadeService afinidadeService;

    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(code = Constants.STATUS_CODE_OK, message = Constants.API_RESPONSE_OK),
            @ApiResponse(code = Constants.STATUS_CODE_BAD_REQUEST, message = Constants.API_RESPONSE_BAD_REQUEST),
            @ApiResponse(code = Constants.STATUS_CODE_UNAUTHORIZED, message = Constants.API_RESPONSE_UNAUTHORIZED),
            @ApiResponse(code = Constants.STATUS_CODE_INTERNAL_ERROR_SERVER, message = Constants.API_RESPONSE_INTERNAL_ERROR_SERVER)
    })
    @ApiOperation(value = "Cadastra uma afinidade")
    public ResponseEntity<AfinidadeDTO> create(@RequestBody AfinidadeDTO afinidadeDTO) {
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                .buildAndExpand(afinidadeDTO).toUri()).body(afinidadeService.create(afinidadeDTO));
    }
}
