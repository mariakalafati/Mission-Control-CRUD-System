package gr.SpaceX.MarsOps;

import gr.SpaceX.MarsOps.model.ResourceStock;
import gr.SpaceX.MarsOps.repository.ResourceStockRepository;
import gr.SpaceX.MarsOps.controller.ResourceStockController;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class ResourceStockControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ResourceStockRepository resourceStockRepository;

    @InjectMocks
    private ResourceStockController resourceStockController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(resourceStockController).build();
    }

    @Test
    void testShowAddForm() throws Exception {
        mockMvc.perform(get("/resources/add"))
                .andExpect(status().isOk())
                .andExpect(view().name("add-resource"))
                .andExpect(model().attributeExists("resource"));
    }

    @Test
    void testAddResource() throws Exception {
        when(resourceStockRepository.save(any(ResourceStock.class)))
                .thenReturn(new ResourceStock("Oxygen Tanks", "Essential for breathing", 50));

        mockMvc.perform(post("/resources/add")
                .param("name", "Oxygen Tanks")
                .param("description", "Essential for breathing")
                .param("quantity", "50"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/resources"));
    }

    @Test
    void testShowEditForm() throws Exception {
        ResourceStock resource = new ResourceStock("Water", "Drinking supply", 100);
        resource.setId(1L);
        when(resourceStockRepository.findById(1L)).thenReturn(Optional.of(resource));

        mockMvc.perform(get("/resources/edit/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("edit-resource"))
                .andExpect(model().attributeExists("resource"));
    }

    @Test
    void testEditResource() throws Exception {
        ResourceStock resource = new ResourceStock("Water", "Drinking supply", 100);
        resource.setId(1L);
        when(resourceStockRepository.save(any(ResourceStock.class))).thenReturn(resource);

        mockMvc.perform(post("/resources/edit/1")
                .param("name", "Updated Water Supply")
                .param("description", "Filtered drinking water")
                .param("quantity", "120"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/resources"));
    }

    @Test
    void testDeleteResource() throws Exception {
        mockMvc.perform(get("/resources/delete/1"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/resources"));

        Mockito.verify(resourceStockRepository).deleteById(1L);
    }
}
