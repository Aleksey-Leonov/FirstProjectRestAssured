package tests;

import api.Specifications;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pojo.pets.AvailablePets;
import pojo.pets.Category;
import pojo.pets.Tag;

import java.util.ArrayList;
import java.util.List;

public class PetTest extends BaseTest {

    private final String idPet = "11002";


    @Test
    public void checkStatus() {
        Specifications.installSpecification(properties.url(), 200);

        List<AvailablePets> availablePets = getList(AvailablePets.class, "pet"
                , "/findByStatus?status=available", ".");

        availablePets.forEach(x -> Assertions.assertEquals("available", x.getStatus()));
    }


    @Test
    public void checkAddedPets() {
        Specifications.installSpecification(properties.url(), 200);
        AvailablePets pets = petInit();
        AvailablePets addedPet = post(AvailablePets.class, pets, "pet");

        Assertions.assertEquals(addedPet.getId(), (long) findPetById(idPet).getId());
    }


    @Test
    public void checkPutPets() {
        Specifications.installSpecification(properties.url(), 200);
        AvailablePets pets = petInit();
        pets.setName("New Name");

        put(AvailablePets.class, pets, "pet");

        Assertions.assertEquals(pets.getName(), findPetById(idPet).getName());
    }

    @Test
    public void checkDeletePets() {
        Specifications.installSpecification(properties.url(), 200);
        deleteElement("pet/", idPet);
    }


    public AvailablePets findPetById(String id) {
        return get(AvailablePets.class, "pet/", id);
    }


    private AvailablePets petInit() {
        ArrayList<String> listPhotoUrls = new ArrayList<>();
        listPhotoUrls.add("photoUrl1");
        ArrayList<Tag> listTag = new ArrayList<>();
        listTag.add(new Tag(1L, "CatTag"));

        return AvailablePets.builder()
                .id(Long.valueOf(idPet))
                .category(new Category(Long.valueOf(idPet), "Cats"))
                .name("Tiger")
                .photoUrls(listPhotoUrls)
                .tags(listTag)
                .status("available").build();
    }
}
