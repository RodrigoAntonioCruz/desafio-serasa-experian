package br.com.desafio.serasaexperian.util;

public class Constants {

    /**
     * CONSTANTS_OTHERS
     */
    public static final String FIELD_USER = "Usuário";
    public static final String FIELD_NAME = "nome";
    public static final String FIELD_EMAIL = "e-mail";
    public static final String LENGTH_FIELD = "O tamanho deve ser entre 3 e 120 caracteres";
    public static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";

    /**
     * CONSTANTS_SWAGGER
     */
    public static final String HEADER = "header";
    public static final String USER_TAG_NAME = "Usuários";
    public static final String USER_TAG_DESCRIPTION = "Realiza o registro e autenticação de usuários na api";
    public static final String DESCRIPTION = "accessEverything";
    public static final String SCOPE = "global";
    public static final String FIELD_JWT = "JWT";
    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String API_RESPONSE_CREATED = "Cadastrado com sucesso!";
    public static final String API_RESPONSE_OK = "Login efetuado com sucesso!";
    public static final String API_RESPONSE_BAD_REQUEST = "Dados não processados devido a solicitação incorreta ou falta de informações.";
    public static final String API_RESPONSE_UNAUTHORIZED = "Acesso não autorizado!";
    public static final String API_RESPONSE_INTERNAL_ERROR_SERVER = "Sistema indisponível";

    /**
     * CONSTANTS_ERRORS
     */
    public static final String ERROR_NOT_FOUND = "Não encontrado";
    public static final String ERROR_INVALID_EMAIL = "O e-mail informado é inválido";
    public static final String ERROR_VALIDATION = "Erro de validação";
    public static final String ERROR_FORBIDDEN = "Acesso proibido";
    public static final String ERROR_UNAUTHORIZED = "Não autorizado";
    public static final String ERROR_DUPLICATED_EMAIL = "Conflito de e-mail";
    public static final String ERROR_INVALID_PROFILE = "Perfil inválido";
    public static final String ERROR_INVALID_PASSWORD = "Senha inválida";

    /**
     * CONSTANTS_MESSAGES
     */
    public static final String MESSAGE_FILL = "O preenchimento do campo ";
    public static final String MESSAGE_REQUIRE = " é obrigatório";
    public static final String MESSAGE_INVALID_CREDENTIALS = "Credenciais inválidas";
    public static final String MESSAGE_NOT_FOUND = "Não encontrado";
    public static final String MESSAGE_UNAUTHORIZED = "Você não possui credenciais válidas para acessar este recurso";
    public static final String MESSAGE_FORBIDDEN = "Você não possui permissão para acessar este recurso";
    public static final String MESSAGE_INVALID_PROFILE = "O tipo de perfil informado é inválido";
    public static final String MESSAGE_DUPLICATED_EMAIL = "O e-mail informado já está em uso";
    public static final String MESSAGE_INVALID_JWT_SIGNATURE = "Assinatura JWT inválida";
    public static final String MESSAGE_INVALID_JWT_TOKEN = "Token JWT inválido";
    public static final String MESSAGE_EXPIRED_JWT_TOKEN = "Token JWT expirou";
    public static final String MESSAGE_UNSUPPORTED_JWT_TOKEN = "Token JWT não suportado";
    public static final String MESSAGE_EMPTY_JWT_TOKEN = "String JWT está vazia";
    public static final String MESSAGE_INVALID_PASSWORD = "A senha deve conter pelo menos um caractere minúsculo um caractere maiúsculo um dígito um caractere especial e um comprimento entre 8 e 20";

}