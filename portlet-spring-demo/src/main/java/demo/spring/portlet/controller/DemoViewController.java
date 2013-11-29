package demo.spring.portlet.controller;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

@Controller("demoViewController")
@RequestMapping("VIEW")
public class DemoViewController 
{
	public static final String VIEW = "demo_view";
	
	@RenderMapping
	public String mostrarVista(RenderRequest request, RenderResponse response, Model model)
	{
		return VIEW;
	}
}