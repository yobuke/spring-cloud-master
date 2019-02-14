package nickzxing.item.web.handle;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @author NickZxing
 * @date 2019/1/5 17:02
 * Error Controller
 * 目前可用于捕捉各类异常状态码，例如404
 */
@RestController
public class ErrorControllerHandler implements ErrorController {

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping("/error")
    public String error(HttpServletResponse response) {
        return HttpStatus.resolve(response.getStatus()).getReasonPhrase();
    }
}


