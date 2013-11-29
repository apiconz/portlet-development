package pe.reapro.portletsapps.springportletsample;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.ModelAndView;

@Controller
public class ViewController {
	private static final String VIEW_PAGE = "SpringJSP";

	@RequestMapping("VIEW")
	public ModelAndView SpringJSP() {
		try {
			System.out.println("Calling SpringJSP");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView(VIEW_PAGE);
	}
}
