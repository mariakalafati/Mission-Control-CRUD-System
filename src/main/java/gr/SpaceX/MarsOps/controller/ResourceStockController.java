package gr.SpaceX.MarsOps.controller;

import gr.SpaceX.MarsOps.model.ResourceStock;
import gr.SpaceX.MarsOps.repository.ResourceStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/resources")
public class ResourceStockController {

        /**
         * Resource repository.
         */
        @Autowired
        private ResourceStockRepository resourceStockRepository;

        /**
         * Shows all resources.
         * 
         * @param model
         * @return resources view
         */
        @GetMapping
        public String showResources(Model model) {
                model.addAttribute("resources", resourceStockRepository.findAll());
                return "resources";
        }

        /**
         * Shows form to add a resource.
         * 
         * @param model
         * @return view containing the form for adding a resource
         */
        @GetMapping("/add")
        public String showAddForm(Model model) {
                model.addAttribute("resource", new ResourceStock());
                return "add-resource";
        }

        /**
         * Processes adding a resource.
         * 
         * @param resource
         * @return redirection after adding the resource.
         */
        @PostMapping("/add")
        public String addResource(@ModelAttribute ResourceStock resource) {
                resourceStockRepository.save(resource);
                return "redirect:/resources";
        }

        /**
         * Shows edit form to edit a resource.
         * 
         * @param id
         * @param model
         * @return view of the edit form for editing the resource.
         */
        @GetMapping("/edit/{id}")
        public String showEditForm(@PathVariable Long id, Model model) {
                ResourceStock resource = resourceStockRepository.findById(id)
                                .orElseThrow(() -> new IllegalArgumentException("Invalid resource ID"));
                model.addAttribute("resource", resource);
                return "edit-resource";
        }

        /**
         * Processes editing a resource.
         * 
         * @param id
         * @param resource
         * @return redirection after editing the resource.
         */
        @PostMapping("/edit/{id}")
        public String editResource(@PathVariable Long id, @ModelAttribute ResourceStock resource) {
                resource.setId(id);
                resourceStockRepository.save(resource);
                return "redirect:/resources";
        }

        /**
         * Deletes a resource.
         * 
         * @param id
         * @return redirection after deleting the resource.
         */
        @GetMapping("/delete/{id}")
        public String deleteResource(@PathVariable Long id) {
                resourceStockRepository.deleteById(id);
                return "redirect:/resources";
        }
}
