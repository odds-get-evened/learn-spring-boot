package org.odds.learn.mentor_demo.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.PrintWriter;
import java.io.StringWriter;

@Controller
public class DefaultErrorController implements ErrorController {
	@RequestMapping("/error")
	public String handleError(HttpServletRequest req, Model model) {
		Object status = req.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		Object message = req.getAttribute(RequestDispatcher.ERROR_MESSAGE);
		Object exception = req.getAttribute(RequestDispatcher.ERROR_EXCEPTION);

		if(status != null) {
			int statusCode = Integer.parseInt(status.toString());
			model.addAttribute("status", statusCode);
			model.addAttribute("error", HttpStatus.valueOf(statusCode).getReasonPhrase());
		}

		if(message != null) {
			model.addAttribute("message", message.toString());
		}

		if(exception != null) {
			// model.put("exception", exception.toString());
			// write stack trace array in its entirety
			StringWriter stringWriter = new StringWriter();
			PrintWriter printWriter = new PrintWriter(stringWriter);
			((Exception) exception).printStackTrace(printWriter);
			model.addAttribute("trace", stringWriter.toString());
		}

		return "error";
	}
}
