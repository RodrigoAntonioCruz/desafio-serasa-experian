package br.com.desafio.serasaexperian.util;

public class Constants {

    /**
     * LOG_KEY
     */
    public static final String LOG_KEY_CLASS = "class={} ";
    public static final String LOG_KEY_METHOD = "method={} ";

    public static final String LOG_KEY_MESSAGE = "msg=\"{}\" ";
    public static final String LOG_KEY_CAUSE = "cause=\"{}\" ";

    public static final String LOG_KEY_ENTITY = "entity=\"{}\" ";

    public static final String LOG_KEY_ENTITY_ID = "entityId={} ";
    public static final String LOG_KEY_REGION = "region={} ";

    public static final String LOG_KEY_SCORE = "score={} ";

    public static final String LOG_METHOD_AUTHENTICATE = "authenticate";
    public static final String LOG_METHOD_REGISTER = "register";

    /**
     * LOG_CLASS
     */
    public static final String LOG_CLASS_AFFINITY_CONTROLLER = "AfinidadeController";
    public static final String LOG_CLASS_SCORE_CONTROLLER = "ScoreController";
    public static final String LOG_CLASS_PERSON_CONTROLLER = "PessoaController";
    public static final String LOG_CLASS_USER_CONTROLLER = "UsuarioController";

    public static final String LOG_CLASS_AFFINITY_SERVICE = "AfinidadeService";
    public static final String LOG_CLASS_SCORE_SERVICE = "ScoreService";
    public static final String LOG_CLASS_PERSON_SERVICE = "PessoaService";
    public static final String LOG_CLASS_USER_SERVICE = "UsuarioService";


    /**
     * LOG_METHOD
     */
    public static final String LOG_METHOD_FIND_ALL = "findAll";
    public static final String LOG_METHOD_FIND_BY_ID = "findById";
    public static final String LOG_METHOD_FIND_PRODUCTS = "findProducts";
    public static final String LOG_METHOD_FIND_STATE_REGION = "findStatesAffinityByRegion";
    public static final String LOG_METHOD_CREATE = "create";
    public static final String LOG_METHOD_GET_SCORE_DESCRIPTION = "getDescriptionScore";



    /**
     * LOG_MESSAGES
     */
    public static final String LOG_MSG_START_CREATE_AFFINITY = "In??cio do cadastro de uma afinidade ";
    public static final String LOG_MSG_END_CREATE_AFFINITY = "Fim do cadastro de uma afinidade ";

    public static final String LOG_MSG_START_CREATE_SCORE = "In??cio do cadastro de um score ";
    public static final String LOG_MSG_END_CREATE_SCORE = "Fim do cadastro de um score ";

    public static final String LOG_MSG_START_CREATE_PERSON = "In??cio do cadastro de uma pessoa ";
    public static final String LOG_MSG_END_CREATE_PERSON = "Fim do cadastro de uma pessoa ";

    public static final String LOG_MSG_FIND_ALL_PERSON = "Buscando todas as pessoas ";
    public static final String LOG_MSG_FIND_BY_ID_PERSON  = "Buscando uma pessoa por id: ";
    public static final String LOG_MSG_FIND_STATE_REGION = "Buscando estados de affindade por regi??o";
    public static final String LOG_MSG_GET_SCORE_DESCRIPTION = "Buscando a descri????o do score";

    public static final String LOG_MSG_START_AUTHENTICATE_USER = "Autenticando o usu??rio";
    public static final String LOG_MSG_START_REGISTER_USER = "Registrando um novo usu??rio";

    /**
     * CONSTANTS_FIELDS
     */
    public static final String FIELD_USER = "Usu??rio";
    public static final String FIELD_NAME = "nome";
    public static final String FIELD_EMAIL = "e-mail";
    public static final String FIELD_REGION = "regi??o";
    public static final String FIELD_STATES = "estados";
    public static final String FIELD_PHONE = "telefone";
    public static final String FIELD_AGE = "idade";
    public static final String FIELD_CITY = "cidade";
    public static final String FIELD_SCORE = "score";
    public static final String FIELD_SCORE_MIN = "in??cial";
    public static final String FIELD_SCORE_MAX = "final";

    /**
     * CONSTANTS_LENGTH
     */
    public static final String LENGTH_MIN_SCORE = "O valor m??nimo ?? de 0";
    public static final String LENGTH_MAX_SCORE = "O valor m??ximo ?? de 1000";
    public static final String LENGTH_AGE = "O tamanho deve ser entre 0 e 3 caracteres";
    public static final String LENGTH_FIELD = "O tamanho deve ser entre 3 e 120 caracteres";
    public static final String LENGTH_UF = "O tamanho deve ser de somente 2 caracteres";
    public static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()???[{}]:;',?/*~$^+=<>]).{8,20}$";
    public static final String POSITIVE_AGE = "O campo idade deve ser um valor positivo";


    /**
     * CONSTANTS_STATUS_CODE_HTTP
     */
    public final static int STATUS_CODE_OK = 200;
    public final static int STATUS_CODE_CREATED = 201;
    public final static int STATUS_CODE_NO_CONTENT = 204;
    public final static int STATUS_CODE_BAD_REQUEST = 400;
    public final static int STATUS_CODE_UNAUTHORIZED = 401;
    public final static int STATUS_CODE_FORBIDDEN = 403;
    public final static int STATUS_CODE_NOT_FOUND = 404;
    public final static int STATUS_CODE_CONFLICT = 409;
    public final static int STATUS_CODE_UNPROCESSABLE_ENTITY = 422;
    public final static int STATUS_CODE_INTERNAL_ERROR_SERVER = 500;


    /**
     * CONSTANTS_SWAGGER
     */

    public static final String USER_TAG_DESCRIPTION = "Realiza o registro e autentica????o de usu??rios na api";
    public static final String PERSON_TAG_DESCRIPTION = "Realiza as opera????es referente a pessoas";
    public static final String SCORE_TAG_DESCRIPTION = "Realiza as opera????es referente ao score";
    public static final String AFFINITY_TAG_DESCRIPTION = "Realiza as opera????es referente a afinidade";
    public static final String USER_TAG_NAME = "Usu??rio";
    public static final String PERSON_TAG_NAME = "Pessoa";
    public static final String SCORE_TAG_NAME = "Score";
    public static final String AFFINITY_TAG_NAME = "Afinidade";
    public static final String HEADER = "header";
    public static final String DESCRIPTION = "accessEverything";
    public static final String SCOPE = "global";
    public static final String FIELD_JWT = "JWT";
    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String API_RESPONSE_CREATED = "Cadastrado com sucesso!";
    public static final String API_RESPONSE_OK = "Login efetuado com sucesso!";
    public static final String API_RESPONSE_BAD_REQUEST = "Dados n??o processados devido a solicita????o incorreta ou falta de informa????es.";

    public static final String API_RESPONSE_UNPROCESSABLE_ENTITY = "Os dados n??o podem ser processados devido a solicita????o incorreta.";
    public static final String API_RESPONSE_UNAUTHORIZED = "Acesso n??o autorizado!";
    public static final String API_RESPONSE_INTERNAL_ERROR_SERVER = "Sistema indispon??vel";
    public static final String API_RESPONSE_NO_CONTENT = "Sem conte??do";

    /**
     * CONSTANTS_ERRORS
     */
    public static final String ERROR_NOT_FOUND = "N??o encontrado";
    public static final String ERROR_INVALID_EMAIL = "O e-mail informado ?? inv??lido";
    public static final String ERROR_VALIDATION = "Erro de valida????o";
    public static final String ERROR_FORBIDDEN = "Acesso proibido";
    public static final String ERROR_UNAUTHORIZED = "N??o autorizado";
    public static final String ERROR_DUPLICATED_EMAIL = "Conflito, o e-mail informado j?? est?? em uso";
    public static final String ERROR_INVALID_PROFILE = "Perfil inv??lido";
    public static final String ERROR_INVALID_PASSWORD = "Senha inv??lida";
    public static final String ERROR_NO_CONTENT = "Sem conte??do";

    /**
     * CONSTANTS_MESSAGES
     */
    public static final String MESSAGE_FILL = "O preenchimento do campo ";
    public static final String MESSAGE_REQUIRE = " ?? obrigat??rio";
    public static final String MESSAGE_INVALID_CREDENTIALS = "Credenciais inv??lidas";
    public static final String MESSAGE_NOT_FOUND = "N??o encontrado";
    public static final String MESSAGE_NO_CONTENT = "Nenhum conte??do para ser visto";
    public static final String MESSAGE_UNAUTHORIZED = "Voc?? n??o possui credenciais v??lidas para acessar este recurso";
    public static final String MESSAGE_FORBIDDEN = "Voc?? n??o possui permiss??o para acessar este recurso";
    public static final String MESSAGE_INVALID_PROFILE = "O tipo de perfil informado ?? inv??lido";
    public static final String MESSAGE_DUPLICATED_EMAIL = "O e-mail informado j?? est?? em uso";
    public static final String MESSAGE_INVALID_JWT_SIGNATURE = "Assinatura JWT inv??lida";
    public static final String MESSAGE_INVALID_JWT_TOKEN = "Token JWT inv??lido";
    public static final String MESSAGE_EXPIRED_JWT_TOKEN = "Token JWT expirou";
    public static final String MESSAGE_UNSUPPORTED_JWT_TOKEN = "Token JWT n??o suportado";
    public static final String MESSAGE_EMPTY_JWT_TOKEN = "String JWT est?? vazia";
    public static final String MESSAGE_INVALID_DATA = "Dados n??o processados";
    public static final String MESSAGE_SCORE_UNDEFINED = "Score indefinido";
    public static final String MESSAGE_INVALID_PASSWORD = "A senha deve conter pelo menos um caractere min??sculo um caractere mai??sculo um d??gito um caractere especial e um comprimento entre 8 e 20";
    public static final String MESSAGE_NOT_FOUND_STATES_AFFINITY_BY_REGION = "Estados de affindade por regi??o n??o encontrados";
    public static final String MESSAGE_NOT_FOUND_SCORE_DESCRIPTION = "Score n??o encontrado";
}