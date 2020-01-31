package hu.szte.vizz.model.product;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

/**
 * Represents a category.
 *
 * @author <a href="mailto:h748276@stud.u-szeged.hu">Tamas Berki</a>
 */
public class CategoryDTO {
    /**
     * Identifier of the category.
     */
    private UUID id;

    /**
     * Name of the category.
     */
    @NotNull
    @Size(min = 3, max = 32)
    private String name;

    /**
     * Returns the identifier of the category.
     *
     * @return {@link #id}
     */
    public UUID getId() {
        return id;
    }

    /**
     * Sets the identifier of the category.
     *
     * @param id Identifier of the category.
     * @return Current instance of {@link CategoryDTO}
     */
    public CategoryDTO setId(UUID id) {
        this.id = id;
        return this;
    }

    /**
     * Returns the name of the category.
     *
     * @return {@link #name}
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the category.
     *
     * @param name Name of the category.
     * @return Current instance of {@link CategoryDTO}
     */
    public CategoryDTO setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoryDTO that = (CategoryDTO) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + name.hashCode();
        return result;
    }
}
