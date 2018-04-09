package ca.wet.wetcdtsspringboot.controllers.section1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Home Controller.
 *
 * @author Andrew Pitt
 * @since 1.0.0
 */
@Controller
@RequestMapping(path = "/section1")
public class Section1Controller {

    /**
     * Get nav.
     *
     * @return <code>ModelAndView</code>
     */
    @RequestMapping(path = "/item1", method = RequestMethod.GET)
    public ModelAndView getNav() {
        return new ModelAndView("section1/item1");
    }

    /**
     * Post nav.
     *
     * @return <code>ModelAndView</code>
     */
    @RequestMapping(path = "/item2", method = RequestMethod.GET)
    public ModelAndView postNav() {
        return new ModelAndView("section1/item2");
    }
}
