package com.example.portfolio.service.categories;

import com.example.portfolio.model.Categories;
import com.example.portfolio.model.Outcomes;
import com.example.portfolio.repository.ICategoryRepository;
import com.example.portfolio.repository.IOutcomesRepository;
import com.example.portfolio.service.outcomes.IOutComesService;
import com.example.portfolio.service.outcomes.OutComesService;
import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class CategoryServiceTest {
    private ICategoryRepository categoryRepository = Mockito.mock(ICategoryRepository.class);
    private ICategoryService categoryService = new CategoryService(categoryRepository);

    private IOutcomesRepository outcomesRepository = Mockito.mock(IOutcomesRepository.class);
    private IOutComesService outComesService = new OutComesService(outcomesRepository);

    @BeforeEach
    void init(){
        Outcomes outcomes = new Outcomes();
        outcomes.setTitle("PHẦN 1: KIẾN THỨC VÀ KỸ NĂNG LẬP TRÌNH");
        doReturn(Optional.of(outcomes)).when(outcomesRepository).findById(1L);
        List<Outcomes> outcomesIterable = Arrays.asList(outcomes);
        doReturn(outcomesIterable).when(outcomesRepository).findAll();

        Categories category = new Categories();
        category.setCategoryId("1.1");
        category.setName("Lập trình cơ bản");
        category.setOutComes(outcomes);
        doReturn(Optional.of(category)).when(categoryRepository).findById(1L);
        doReturn(Optional.of(category)).when(categoryRepository).findByName("Lập trình cơ bản");
        List<Categories> categoriesList = Arrays.asList(category);
        doReturn(categoriesList).when(categoryRepository).findAll();
    }

    @Test
    @DisplayName("findAll can return list is not null")
    public void whenFindAllNotNull() {
        assertThat(categoryService.findAll()).isNotNull();
    }

    @Test
    @DisplayName("findAll can return a list has 1 element")
    public void whenfindAll_thenReturnListHasOneElement() {
        Iterable<Categories> categories = categoryService.findAll();
        assertThat(categories).hasSize(1);
    }

    @Test
    @DisplayName("findbyID return category name Lap trinh co ban")
    public void whenfindById_thenReturnCategory() {
        String name = "Lập trình cơ bản";
        Optional<Categories> categories = categoryService.findById(1L);
        assertThat(categories.get().getName()).isEqualTo(name);
    }

    @Test
    @DisplayName("findbyID 2L return isPresent")
    public void whenfindById_thenReturnCategoryisPresent() {
        Optional<Categories> categories = categoryService.findById(2L);
        assertThat(categories.isPresent()).isFalse();
    }

    @Test
    @DisplayName("findbyName return category name Lap trinh co ban")
    public void whenfindByName_thenReturnCategory() {
        String name = "Lập trình cơ bản";
        Optional<Categories> categories = categoryService.findByName("Lập trình cơ bản");
        assertThat(categories.get().getName()).isEqualTo(name);
    }

    @Test
    @DisplayName("findbyID 2L return isPresent")
    public void whenfindByName_thenReturnCategoryisPresent() {
        Optional<Categories> categories = categoryService.findByName("Lập trinh nâng cao 1");
        assertThat(categories.isPresent()).isFalse();
    }

    @Test
    @DisplayName("findAll by OutCome return list not null")
    void findAllByOutComes() {
        Outcomes outcomes = outComesService.findById(1L).get();
        List<Categories> categories = (List<Categories>) categoryService.findAllByOutComes(outcomes);
        assertThat(categories).isNotNull();
    }

    @Test
    @DisplayName("save Categories use 1 categoryRepository.save")
    void save() {
        Categories categories = new Categories();
        categories.setCategoryId("1.2");
        categories.setName("Lập trình nâng cao");
        categoryService.save(categories);
        verify(categoryRepository, times(1)).save(categories);
    }

    @Test
    @DisplayName("delete")
    void remove() {
        categoryService.remove(1L);
        verify(categoryRepository, times(1)).deleteById(1L);
    }

}