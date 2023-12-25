package com.infosys.authentication.aadhar.utilities;

import com.infosys.authentication.aadhar.exception.ExceptionConstants;
import com.infosys.authentication.aadhar.exception.ExternalServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Locale;

@ControllerAdvice
public class ExceptionControllerAdvice {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ClientErrors exceptionHandler(Exception ex) {
        logger.info(ex.getMessage(), ex);

        String errorCode = ExceptionConstants.SERVER_ERROR.toString();
        ClientErrors errors = new ClientErrors(errorCode, messageSource.getMessage(errorCode, null, Locale.ENGLISH));
        logger.debug("{}", errors);
        return errors;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ExternalServiceException.class)
    @ResponseBody
    public ClientErrors exceptionHandler(ExternalServiceException ex) {
        logger.info(ex.getMessage(), ex);
        ClientErrors errors = new ClientErrors(ex.getMessage(), messageSource.getMessage(ex.getMessage(), null, Locale.ENGLISH));
        logger.debug("{}", errors);
        return errors;
    }

    public ClientErrors handleBindingErrors(MissingServletRequestParameterException ex) {
        logger.info(ex.getMessage(), ex);
        String errorCode = ExceptionConstants.INPUT_PARM_MISSING.toString();
        String message = ex.getParameterName() + " " + messageSource.getMessage(errorCode, null, Locale.ENGLISH);
        ClientErrors errors = new ClientErrors(errorCode, message);
        logger.debug("{}", errors);
        return errors;
    }


}
