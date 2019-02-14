package nickzxing.order.web.handle;


import nickzxing.order.web.util.ValidationMessageUtils;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author NickZxing
 * @date 2018/11/28 10:47
 * 全局异常处理类
 */
@RestControllerAdvice
class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * HTTP异常
     *
     * @param ex
     * @param body
     * @param headers
     * @param status
     * @param request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {

        //方法级别验证器异常
        if (ex instanceof MethodArgumentNotValidException) {
            return ResponseEntity.status(status).body(methodArgumentNotValidExceptionHandler(ex));
        }

        return ResponseEntity.status(status).body(ex.getMessage());
    }

    /**
     * 类级别验证器异常
     */
    @ExceptionHandler(value = {ConstraintViolationException.class})
    ResponseEntity<Object> constraintViolationException(ConstraintViolationException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(constraintViolationExceptionHandler(ex));
    }

    /**
     * 全局异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(value = {Exception.class})
    ResponseEntity<Object> throwableHandler(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }

    /**
     * 方法级别验证异常信息处理
     *
     * @param ex
     * @return
     */
    private List<ValidationMessageUtils> methodArgumentNotValidExceptionHandler(Exception ex) {
        List<ValidationMessageUtils> messageList = new ArrayList<>();
        MethodArgumentNotValidException methodArgumentNotValidException = (MethodArgumentNotValidException) ex;
        BindingResult bindingResult = methodArgumentNotValidException.getBindingResult();
        if (bindingResult != null && bindingResult.hasErrors()) {
            List<ObjectError> errorList = bindingResult.getAllErrors();
            ValidationMessageUtils validationMessageUtils;
            int index = 0;
            for (ObjectError e : errorList) {
                DefaultMessageSourceResolvable d = (DefaultMessageSourceResolvable) e.getArguments()[0];
                String str = d.getCodes()[d.getCodes().length - 1];
                validationMessageUtils = new ValidationMessageUtils();
                validationMessageUtils.setArg(str);
                validationMessageUtils.setIndex(index);
                validationMessageUtils.setMessage(e.getDefaultMessage());
                messageList.add(validationMessageUtils);
                index++;
            }
        }
        return messageList;
    }

    /**
     * 类级别验证异常信息处理
     *
     * @param ex
     * @return
     */
    private List<ValidationMessageUtils> constraintViolationExceptionHandler(Exception ex) {
        List<ValidationMessageUtils> messageList = new ArrayList<>();
        {
            ConstraintViolationException constraintViolationException = (ConstraintViolationException) ex;
            Set<ConstraintViolation<?>> set = constraintViolationException.getConstraintViolations();
            if (set != null && set.size() > 0) {
                ValidationMessageUtils validationMessageUtils;
                int index = 0;
                for (ConstraintViolation<?> c : set) {
                    validationMessageUtils = new ValidationMessageUtils();
                    validationMessageUtils.setArg("arg" + index);
                    validationMessageUtils.setIndex(index);
                    validationMessageUtils.setMessage(c.getMessage());
                    messageList.add(validationMessageUtils);
                    index++;
                }
            }
        }
        return messageList;
    }
}