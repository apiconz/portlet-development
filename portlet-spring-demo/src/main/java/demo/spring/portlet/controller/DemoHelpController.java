package demo.spring.portlet.controller;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

@Controller("demoHelpController")
@RequestMapping("HELP")
public class DemoHelpController 
{
	public static final String HELP_VIEW = "demo_help";
	
	@RenderMapping
	public String mostrarVista(RenderRequest request, RenderResponse response, Model model)
	{
		return HELP_VIEW;
	}
}