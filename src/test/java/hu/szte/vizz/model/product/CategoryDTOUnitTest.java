package hu.szte.vizz.model.product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class CategoryDTOUnitTest {

    @Test
    public void When_getId_Expect_correctIdReturned() {
        UUID id = UUID.randomUUID();
        CategoryDTO category = new CategoryDTO()
                .setId(id);
        assertEquals(category.getId(), id);
    }

    @Test
    public void When_setId_Expect_correctIdSetted() {
        UUID id = UUID.randomUUID();
        CategoryDTO category = new CategoryDTO()
                .setId(UUID.randomUUID());
        assertNotEquals(category.getId(), id);
        category.setId(id);
        assertEquals(id, category.getId());
    }

    @Test
    public void When_getName_Expect_correctNameReturned() {
        CategoryDTO category = new CategoryDTO()
                .setName("Name");
        assertEquals("Name", category.getName());
    }

    @Test
    public void When_setName_Expect_correctNameSetted() {
        CategoryDTO category = new CategoryDTO()
                .setName("NotName");
        assertNotEquals("Name", category.getName());
        category.setName("Name");
        assertEquals("Name", category.getName());
    }

    @Test
    public void When_equalsSame_Expect_true() {
        CategoryDTO category = new CategoryDTO();
        assertEquals(category, category);
    }

    @Test
    public void When_equalsDifferentType_Expect_false() {
        CategoryDTO category = new CategoryDTO();
        assertNotEquals(category, "Hello");
    }

    @Test
    public void When_equalsWithNull_Expect_false() {
        CategoryDTO category = new CategoryDTO();
        assertNotEquals(category, null);
    }

    @Test
    public void When_equalsIdentical_Expect_true() {
        UUID id = UUID.randomUUID();
        CategoryDTO category1 = new CategoryDTO()
                .setId(id)
                .setName("Category");
        CategoryDTO category2 = new CategoryDTO()
                .setId(id)
                .setName("Category");
        assertEquals(category1, category2);
    }

    @Test
    public void When_equalsIdDifferent_Expect_false() {
        CategoryDTO category1 = new CategoryDTO()
                .setId(UUID.randomUUID())
                .setName("Category");
        CategoryDTO category2 = new CategoryDTO()
                .setId(UUID.randomUUID())
                .setName("Category");
        assertNotEquals(category1, category2);
    }

    @Test
    public void When_equalsNameDifferent_Expect_false() {
        UUID id = UUID.randomUUID();
        CategoryDTO category1 = new CategoryDTO()
                .setId(id)
                .setName("Category");
        CategoryDTO category2 = new CategoryDTO()
                .setId(id)
                .setName("Category2");
        assertNotEquals(category1, category2);
    }

    @Test
    public void When_equalsIdWithNull_Expect_false() {
        CategoryDTO category1 = new CategoryDTO()
                .setName("Category");
        CategoryDTO category2 = new CategoryDTO()
                .setId(UUID.randomUUID())
                .setName("Category");
        assertNotEquals(category1, category2);
    }

    @Test
    public void When_equalsIdWithNullBoth_Expect_true() {
        CategoryDTO category1 = new CategoryDTO()
                .setName("Category");
        CategoryDTO category2 = new CategoryDTO()
                .setName("Category");
        assertEquals(category1, category2);
    }

    @Test
    public void When_hashCodeIdentical_Expect_true() {
        UUID id = UUID.randomUUID();
        CategoryDTO category1 = new CategoryDTO()
                .setId(id)
                .setName("Category");
        CategoryDTO category2 = new CategoryDTO()
                .setId(id)
                .setName("Category");
        assertEquals(category1.hashCode(), category2.hashCode());
    }

    @Test
    public void When_hashCodeDifferent_Expect_false() {
        UUID id = UUID.randomUUID();
        CategoryDTO category1 = new CategoryDTO()
                .setId(id)
                .setName("Category");
        CategoryDTO category2 = new CategoryDTO()
                .setId(id)
                .setName("Category1");
        assertNotEquals(category1.hashCode(), category2.hashCode());
    }

    @Test
    public void When_hashCodeEqualNullId_Expect_false() {
        UUID id = UUID.randomUUID();
        CategoryDTO category1 = new CategoryDTO()
                .setName("Category");
        CategoryDTO category2 = new CategoryDTO()
                .setName("Category");
        assertEquals(category1.hashCode(), category2.hashCode());
    }
}