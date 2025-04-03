package gr.SpaceX.MarsOps.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ResourceStock {

        /**
         * Resource's id.
         */
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        /**
         * Resource name (e.g., Oxygen, Fuel, Water).
         */
        private String name;

        /**
         * Resource description.
         */
        private String description;

        /**
         * Quantity of the resource available.
         */
        private int quantity;

        /**
         * Default constructor.
         */
        public ResourceStock() {
        }

        /**
         * Core constructor.
         * 
         * @param name     The name of the resource
         * @param description The reource description
         * @param quantity The available quantity
         */
        public ResourceStock(String name, String description, int quantity) {
                this.name = name;
                this.description = description;
                this.quantity = quantity;
        }

        /**
         * Gets the id of the resource.
         * 
         * @return The resource id.
         */
        public Long getId() {
                return id;
        }

        /**
         * Sets the id of the resource.
         * 
         * @param id Resource id
         */
        public void setId(Long id) {
                this.id = id;
        }

        /**
         * Gets the resource name.
         * 
         * @return Resource name
         */
        public String getName() {
                return name;
        }

        /**
         * Sets the name of the resource.
         * 
         * @param name Resource name
         */
        public void setName(String name) {
                this.name = name;
        }

        /**
         * Gets the resource description.
         * 
         * @return Resource description
         */
        public String getDescription() {
                return description;
        }

        /**
         * Sets the description of the resource.
         * 
         * @param description Resource description
         */
        public void setDescription(String description) {
                this.description = description;
        }

        /**
         * Gets the available quantity of the resource.
         * 
         * @return Resource quantity
         */
        public int getQuantity() {
                return quantity;
        }

        /**
         * Sets the quantity of the resource.
         * 
         * @param quantity Resource quantity
         */
        public void setQuantity(int quantity) {
                this.quantity = quantity;
        }
}
