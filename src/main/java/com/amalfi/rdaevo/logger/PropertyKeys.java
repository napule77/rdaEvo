package com.amalfi.rdaevo.logger;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PropertyKeys {

    // GENERIC
    public static final String CORS_ENABLED = "crif.spring.cors.enabled";
    public static final String CRIFPAY_APPLICATION_ID = "crif.crifpay.application-id";
    public static final String CRIFPAY_PAYMENT_ALLOWED_METHODS = "crif.crifpay.payment.allowed-methods";
    public static final String LOG_LEVEL = "logging.level.root";

    public static final String DAYS_PASSWORD_VALID = "days.password.valid";
    public static final String CONTROLLER_TEST_ENABLED = "crif.controller.test.enabled";
    // LOG
    public static final String LOG_WARN_WHEN_EXECUTION_TIME_BIGGER_THEN = "crif.log.warn.rest.execution-time-bigger-then-ms";
    public static final String LOG_REST_API = "crif.log.warn.rest";

    public static final String MAIL_FROM = "crif.mail.from";
    public static final String MAIL_DESTINATION_CRA= "crif.mail.dst.cra";
    public static final String MAIL_DESTINATION_BOOM= "crif.mail.dst.boom";
    public static final String MAIL_DEST_ENABLE_ADMIN="crif.mail.dst.adminReq";

    // JWT
    public static final String JWT_SECRET = "jwt.secret";
    public static final String JWT_EXPIRATION_TIME_MS = "jwt.expiration-milliseconds";
    public static final String CAPTCHA_VALIDITY_SECONDS = "crif.captcha.validity-seconds";

    public static final String INFOPUBB_SID_REP = "crif.soap.remote.infopubb.sid.rep";
    public static final String INFOPUBB_PID_REP = "crif.soap.remote.infopubb.pid.rep";
    public static final String INFOPUBB_PNS_REP = "crif.soap.remote.infopubb.pns.rep";

    public static final String INFOPUBB_SID_CREATION = "crif.soap.remote.infopubb.sid.creation";
    public static final String INFOPUBB_PID_CREATION = "crif.soap.remote.infopubb.pid.creation";
    public static final String INFOPUBB_PNS_CREATION = "crif.soap.remote.infopubb.pns.creation";

    public static final String INFOPUBB_SID_PDF = "crif.soap.remote.infopubb.sid.pdf";
    public static final String INFOPUBB_PID_PDF = "crif.soap.remote.infopubb.pid.pdf";
    public static final String INFOPUBB_PNS_PDF = "crif.soap.remote.infopubb.pns.pdf";


    // Business Information Search (Infocamere)

    public static final String BUSINESS_INFORMATION_SEARCH_AUTH_GRANT_TYPE = "crif.rest.remote.business-information.search.auth.grant-type";
    public static final String BUSINESS_INFORMATION_SEARCH_AUTH_USERNAME = "crif.rest.remote.business-information.search.auth.username";
    public static final String BUSINESS_INFORMATION_SEARCH_AUTH_PASSWORD = "crif.rest.remote.business-information.search.auth.password";
    public static final String BUSINESS_INFORMATION_SEARCH_AUTH_TOKEN_USERNAME = "crif.rest.remote.business-information.search.auth.token.username";
    public static final String BUSINESS_INFORMATION_SEARCH_AUTH_TOKEN_PASSWORD = "crif.rest.remote.business-information.search.auth.token.password";

    // Business Information Domains (Infocamere)
    public static final String BUSINESS_INFORMATION_DOMAINS_AUTH_GRANT_TYPE = "crif.rest.remote.business-information.domains.auth.grant-type";
    public static final String BUSINESS_INFORMATION_DOMAINS_AUTH_USERNAME = "crif.rest.remote.business-information.domains.auth.username";
    public static final String BUSINESS_INFORMATION_DOMAINS_AUTH_PASSWORD = "crif.rest.remote.business-information.domains.auth.password";
    public static final String BUSINESS_INFORMATION_DOMAINS_AUTH_TOKEN_USERNAME = "crif.rest.remote.business-information.domains.auth.token.username";
    public static final String BUSINESS_INFORMATION_DOMAINS_AUTH_TOKEN_PASSWORD = "crif.rest.remote.business-information.domains.auth.token.password";

    // Business Information Announcements (Finanza Agevolata)
    public static final String BUSINESS_INFORMATION_ANNOUNCEMENTS_AUTH_GRANT_TYPE = "crif.rest.remote.business-information.announcements.auth.grant-type";
    public static final String BUSINESS_INFORMATION_ANNOUNCEMENTS_AUTH_USERNAME = "crif.rest.remote.business-information.announcements.auth.username";
    public static final String BUSINESS_INFORMATION_ANNOUNCEMENTS_AUTH_PASSWORD = "crif.rest.remote.business-information.announcements.auth.password";
    public static final String BUSINESS_INFORMATION_ANNOUNCEMENTS_AUTH_TOKEN_USERNAME = "crif.rest.remote.business-information.announcements.auth.token.username";
    public static final String BUSINESS_INFORMATION_ANNOUNCEMENTS_AUTH_TOKEN_PASSWORD = "crif.rest.remote.business-information.announcements.auth.token.password";
    public static final String BUSINESS_INFORMATION_ANNOUNCEMENTS_AUTH_TIMEOUT_READ = "crif.rest.remote.business-information.announcements.timeout.connect";
    public static final String BUSINESS_INFORMATION_ANNOUNCEMENTS_AUTH_TIMEOUT_CONNECT = "crif.rest.remote.business-information.announcements.timeout.read";

    // PROPERTIES
    public static final String PROPERTIES_DEFAULT_DELIMITER = "crif.default.properties.delimiter";
    public static final String PROPERTIES_DEFAULT_MAP_ENTRY_DELIMITER = "crif.default.properties.map.entry.delimiter";

    // MESSAGES //
    
    
    
    // BUTTON ID ESG //
    
    public static final String REPORT_ESG_BUTTON_ID = "reportesg.button";
    public static final String PILLS_BUTTON_ID = "pillole.button";
    public static final String FINANCE_BUTTON_ID = "finanza.button";

    // LOG
    public static final String MESSAGE_LOG_METHOD_EXECUTION_TIME = "crif.log.message.performance.method.time-track";

    // WARNING/ERRORS
    public static final String MESSAGE_USER_NOT_FOUND = "crif.message.warning.auth.user-not-found";
    public static final String MESSAGE_INVALID_CREDENTIALS = "crif.message.warning.auth.invalid-credentials";
    public static final String MESSAGE_USER_NOT_ENABLED = "crif.message.warning.auth.user-not-enabled";
    public static final String MESSAGE_TOKEN_NOT_FOUND = "crif.message.warning.auth.token-not-found";
    public static final String MESSAGE_PARTITA_IVA_ALREADY_REGISTERED = "crif.message.warning.auth.partita-iva-already-registered";
    public static final String MESSAGE_EMAIL_ALREADY_REGISTERED = "crif.message.warning.auth.email-already-registered";
    public static final String MESSAGE_ERROR_CAPTCHA_CREATION = "crif.message.error.captcha.error-during-creation";
    public static final String MESSAGE_PASSWORD_EXPIRED = "crif.message.warning.auth.password.expired";
    public static final String MESSAGE_ABI_NOT_SYNESGY = "crif.message.warning.auth.abi-not-synesgy";
    public static final String MESSAGE_ACCOUNT_RESET_NEW_PASSWORD_EQUAL_OLD = "crif.message.warning.auth.password-reset.new-equal-old";

    // REST VALIDATION
    public static final String VALIDATION_PARTITA_IVA_INVALID = "crif.rest.validation.message.partita-iva-invalid";
    public static final String VALIDATION_RAGIONE_SOCIALE_INVALID = "crif.rest.validation.message.ragione-sociale-invalid";
    public static final String VALIDATION_EMAIL_INVALID = "crif.rest.validation.message.email-invalid";
    public static final String VALIDATION_PASSWORD_INVALID = "crif.rest.validation.message.password-invalid";
    public static final String VALIDATION_TOKEN_INVALID = "crif.rest.validation.message.token-invalid";
    public static final String VALIDATION_ABI_INVALID = "crif.rest.validation.message.abi-invalid";

    // PATHS
    public static final String URL_BASE_APPLICATION = "application.base.url";
    public static final String URL_PATH_CRIFPAY_PAYMENT_CALLBACK = "application.path.crifpay-payment-callback";

    // REST //
    public static final String HTTP_REST_PATHS_ANONYMOUS_ALLOWED_GET = "http.rest.path.anonymous.allowed.get";
    public static final String HTTP_REST_PATHS_ANONYMOUS_ALLOWED_POST = "http.rest.path.anonymous.allowed.post";

    // REMOTE APIs
    public static final String REST_REMOTE_API_SYNESGY_URL = "crif.rest.remote.synesgy.url";
    public static final String REST_API_CRIF_BASE = "crif.rest.remote.base-api.url";
    public static final String REST_REMOTE_BUSINESS_INFORMATION_SEARCH_URL = "crif.rest.remote.business-information.search.url";
    public static final String REST_REMOTE_BUSINESS_INFORMATION_DOMAINS_URL = "crif.rest.remote.business-information.domains.url";
    public static final String REST_REMOTE_BUSINESS_INFORMATION_ANNOUNCEMENTS_URL = "crif.rest.remote.business-information.announcements.url";
    public static final String REST_REMOTE_API_CRIFPAY_URL = "crif.rest.remote.crifpay.url";
    public static final String SOAP_REMOTE_INFOPUBB_URL = "crif.soap.remote.infopubb.url";
    public static final String FINANZA_AGEVOLATA_PNRR_MILLIONS_AVAILABLE = "crif.finanza-agevolata.money-available-in-millions";
    public static final String MAIL_DESINATION_CRIBIS = "crif.mail.dst.cribis";

    public static final String SOAP_REMOTE_SAP_ENABLED = "crif.soap.remote.sap.enabled";

    public static final String SOAP_REMOTE_SAP_CUSTOMER_URL = "crif.soap.remote.sap.customer.url";
    public static final String SOAP_REMOTE_SAP_ORDER_URL = "crif.soap.remote.sap.order.url";

    public static final String SOAP_REMOTE_SAP_USER = "crif.soap.remote.sap.user";
    public static final String SOAP_REMOTE_SAP_PASSWORD = "crif.soap.remote.sap.password";
    public static final String SOAP_REMOTE_SAP_WSDL_HOSTS_OVERRIDE = "crif.soap.remote.sap.host.override.url";
}