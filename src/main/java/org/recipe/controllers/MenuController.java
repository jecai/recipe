package org.recipe.controllers;

import org.recipe.models.Recipe;
import org.recipe.models.Menu;
import org.recipe.models.data.RecipeDao;
import org.recipe.models.data.MenuDao;
import org.recipe.models.forms.MenuForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "menu")
public class MenuController extends AbstractController {

    @Autowired
    private MenuDao menuDao;

    @Autowired
    private RecipeDao recipeDao;

    @RequestMapping(value = "")
    public String index(Model model, HttpServletRequest request){

        model.addAttribute("menus", menuDao.findAll());
        model.addAttribute("title", "Menus");
        model.addAttribute("sessionOn", isSessionActive(request.getSession()));

        return "menu/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayMenuForm(Model model, HttpServletRequest request){

        model.addAttribute(new Menu());
        model.addAttribute("title", "Add Menu");
        model.addAttribute("sessionOn", isSessionActive(request.getSession()));

        return "menu/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processMenuForm(Model model, @ModelAttribute @Valid
            Menu menu, Errors errors, HttpServletRequest request) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Menu");
            return "menu/add";
        }
        model.addAttribute("sessionOn", isSessionActive(request.getSession()));
        menuDao.save(menu);

        return "redirect:view/" + menu.getId();
    }

    @RequestMapping(value = "view/{menuId}", method = RequestMethod.GET)
    public String viewMenu(Model model, @PathVariable int menuId, HttpServletRequest request) {

        model.addAttribute("sessionOn", isSessionActive(request.getSession()));
        Menu menu = menuDao.findOne(menuId);
        model.addAttribute("menu", menu);

        return "menu/view";
    }

    @RequestMapping(value = "add-item/{menuId}", method = RequestMethod.GET)
    public String addItem(Model model, @PathVariable int menuId, HttpServletRequest request) {

        Menu menu = menuDao.findOne(menuId);
        MenuForm form = new MenuForm(
                recipeDao.findAll(), menu);
        model.addAttribute("sessionOn", isSessionActive(request.getSession()));
        model.addAttribute("title", "Add recipe to: " + menu.getName());
        model.addAttribute("form", form);

        return "menu/add-item";
    }

    @RequestMapping(value = "add-item", method = RequestMethod.POST)
    public String addItem(Model model,
                          @ModelAttribute @Valid MenuForm form,
                          Errors errors) {

        if (errors.hasErrors()) {
            model.addAttribute("form", form);
            return "menu/add-item";
        }

        Recipe theRecipe = recipeDao.findOne(form.getRecipeId());
        Menu theMenu = menuDao.findOne(form.getMenuId());
        theMenu.addItem(theRecipe);
        menuDao.save(theMenu);

        return "redirect:view/" + theMenu.getId();
    }

}
