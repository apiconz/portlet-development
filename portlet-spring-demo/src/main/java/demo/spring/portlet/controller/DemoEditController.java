package demo.spring.portlet.controller;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

@Controller("demoEditController")
@RequestMapping("EDIT")
public class DemoEditController 
{
	public static final String EDIT_VIEW = "demo_edit";
	
	@RenderMapping
	public String mostrarVista(RenderRequest request, RenderResponse response, Model model)
	{
		return EDIT_VIEW;
	}
}